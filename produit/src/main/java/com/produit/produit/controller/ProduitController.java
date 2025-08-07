package com.produit.produit.controller;

import com.produit.produit.model.Produit;
import com.produit.produit.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produit")
@RequiredArgsConstructor
public class ProduitController {
    @Autowired
    private  ProduitService produitService ;

    @GetMapping("/hello")
    public String sayHello(){
       return "hello";
    }
    @GetMapping("/all")
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }
    @PostMapping
    public Produit createProduit(@RequestBody Produit produit){
        return produitService.createProduit(produit);
    }
}
