# Spring API REST - Gestion de Produits et Catégories

## 🌟 Description

Ce projet est une API REST développée en **Spring Boot 4** pour gérer des **produits** et leurs **catégories** (avec sous-catégories).  
Il propose :  
- Hiérarchie de catégories (catégories racines et sous-catégories)  
- Gestion des produits liés aux catégories  
- Contrôle des doublons lors de l’insertion  
- Base de données H2 en mémoire pour tests  

---

## 🛠️ Stack technique

- **Langage** : Java 21
- **Framework** : Spring Boot 4 
- **Modules Spring utilisés** :  
  - Spring Web  
  - Spring Data JPA   
- **Base de données** : H2 (en mémoire)  
- **Lombok** : pour getters/setters, constructeur  
- **Build Tool** : Maven  
- **API Testing** : Postman / curl  
- **JSON Mapping** : DTOs pour éviter les boucles infinies

