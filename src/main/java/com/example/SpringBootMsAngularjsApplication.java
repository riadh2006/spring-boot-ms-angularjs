package com.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.dao.ProduitRepository;
import com.example.entities.Produit;

@SpringBootApplication
public class SpringBootMsAngularjsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootMsAngularjsApplication.class, args);
		ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		produitRepository.save(new Produit("tomate", 10, 1));
		produitRepository.save(new Produit("potate", 12, 21));
		produitRepository.save(new Produit("chocolate", 8, 43));
		
		List<Produit> produits = produitRepository.findAll();
		// Loop with lambda expression 
		produits.forEach(pr -> System.out.println(pr.getDescription()));
	}
}
