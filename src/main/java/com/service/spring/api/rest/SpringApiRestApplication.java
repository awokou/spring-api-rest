package com.service.spring.api.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.service.spring.api.rest.entity.Categorie;
import com.service.spring.api.rest.entity.Produit;
import com.service.spring.api.rest.repository.CategorieRepository;
import com.service.spring.api.rest.repository.ProduitRepository;

@SpringBootApplication
public class SpringApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiRestApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CategorieRepository categorieRepository, ProduitRepository produitRepository) {
		return args -> {
			// ===== Catégories =====
			Categorie electronique = categorieRepository.findByNom("Électronique")
					.orElseGet(() -> {
						Categorie c = new Categorie();
						c.setNom("Électronique");
						c.setDescription("Tous les produits électroniques");
						return categorieRepository.save(c);
					});

			Categorie vetements = categorieRepository.findByNom("Vêtements")
					.orElseGet(() -> {
						Categorie c = new Categorie();
						c.setNom("Vêtements");
						c.setDescription("Tous les vêtements");
						return categorieRepository.save(c);
					});

			// Sous-catégories
			Categorie smartphones = categorieRepository.findByNomAndParent("Smartphones", electronique)
					.orElseGet(() -> {
						Categorie c = new Categorie();
						c.setNom("Smartphones");
						c.setParent(electronique);
						return categorieRepository.save(c);
					});

			Categorie ordinateurs = categorieRepository.findByNomAndParent("Ordinateurs", electronique)
					.orElseGet(() -> {
						Categorie c = new Categorie();
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
	private void insertProduitSiAbsent(ProduitRepository produitRepository,
			String nom, Categorie categorie, double prix, int stock) {
		boolean exists = produitRepository.existsByNomAndCategorie(nom, categorie);
		if (!exists) {
			Produit p = new Produit();
			p.setNom(nom);
			p.setCategorie(categorie);
			p.setPrix(prix);
			p.setStock(stock);
			produitRepository.save(p);
		}
	}
}
