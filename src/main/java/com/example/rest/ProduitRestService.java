package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Produit save(@PathVariable("id") Long id){
		return produitRepository.findOne(id); 
	}
	
	
	@RequestMapping(value="/produits", method = RequestMethod.POST)
	public Produit save(@RequestBody Produit produit){
		return produitRepository.save(produit); 
	}

	@RequestMapping(value="/produits/{id}", method = RequestMethod.PUT)
	public Produit update(@RequestBody Produit produit, @PathVariable("id") Long id){
		produit.setId(id);
		return produitRepository.saveAndFlush(produit); 
	}

	@RequestMapping(value="/produits/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id){
		produitRepository.delete(id); 
	}

}
