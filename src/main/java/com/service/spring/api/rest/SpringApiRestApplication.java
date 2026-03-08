package com.service.spring.api.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.service.spring.api.rest.entity.Category;
import com.service.spring.api.rest.entity.Product;
import com.service.spring.api.rest.repository.CategoryRepository;
import com.service.spring.api.rest.repository.ProductRepository;

@SpringBootApplication
public class SpringApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiRestApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CategoryRepository categorieRepository, ProductRepository produitRepository) {
		return args -> {
			// ===== Catégories =====
			Category electronique = categorieRepository.findByNom("Électronique")
					.orElseGet(() -> {
						Category c = new Category();
						c.setNom("Électronique");
						c.setDescription("Tous les produits électroniques");
						return categorieRepository.save(c);
					});

			Category vetements = categorieRepository.findByNom("Vêtements")
					.orElseGet(() -> {
						Category c = new Category();
						c.setNom("Vêtements");
						c.setDescription("Tous les vêtements");
						return categorieRepository.save(c);
					});

			// Sous-catégories
			Category smartphones = categorieRepository.findByNomAndParent("Smartphones", electronique)
					.orElseGet(() -> {
						Category c = new Category();
						c.setNom("Smartphones");
						c.setParent(electronique);
						return categorieRepository.save(c);
					});

			Category ordinateurs = categorieRepository.findByNomAndParent("Ordinateurs", electronique)
					.orElseGet(() -> {
						Category c = new Category();
						c.setNom("Ordinateurs");
						c.setParent(electronique);
						return categorieRepository.save(c);
					});

			// ===== Produits =====
			insertProduitSiAbsent(produitRepository, "iPhone 14", smartphones, 999.99, 50);
			insertProduitSiAbsent(produitRepository, "MacBook Pro", ordinateurs, 1999.99, 30);

			System.out.println("Données insérées avec contrôle des doublons !");
		};
	}

	// Méthode utilitaire pour les produits
	private void insertProduitSiAbsent(ProductRepository produitRepository,
			String nom, Category categorie, double prix, int stock) {
		boolean exists = produitRepository.existsByNomAndCategorie(nom, categorie);
		if (!exists) {
			Product produit = new Product();
			produit.setNom(nom);
			produit.setCategorie(categorie);
			produit.setPrix(prix);
			produit.setStock(stock);
			produitRepository.save(produit);
		}
	}
}
