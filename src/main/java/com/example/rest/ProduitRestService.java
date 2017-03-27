package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ProduitRepository;
import com.example.entities.Produit;

@RestController
public class ProduitRestService {
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@RequestMapping(value="/produits", method = RequestMethod.GET)
	public List<Produit> listeProduit(){
		return produitRepository.findAll(); 
	}
	
	@RequestMapping(value="/produits/{id}", method = RequestMethod.GET)
	public Produit getProduit(@PathVariable("id") Long id){
		return produitRepository.findOne(id); 
	}

}
