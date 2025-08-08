package com.produit.produit.service;

import com.produit.produit.model.Produit;
import com.produit.produit.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ProduitService {
    @Autowired
    private  ProduitRepository produitRepository ;
// la liste des produit
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }
// creer un produit
    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

// recuperer un produit par id
    public Produit getProduitById(Long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if(optionalProduit.isEmpty()){
            throw new RuntimeException("Produit not found with id: " + id);
        }
        return optionalProduit.get();
    }

    //  supprimer un produit
    public String deleteProduit(Long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if(optionalProduit.isEmpty()){
            throw new RuntimeException("Produit not found with id: " + id);
        }
        produitRepository.deleteById(id);
        return "Produit with id " + id + " has been deleted successfully.";
    }
// mettre a jour un produit
    public Produit updateProduit(long id, Produit produit) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if(optionalProduit.isEmpty()){
            throw new RuntimeException("Produit not found with id: " + id);
        }
        Produit produitModifier = optionalProduit.get();
        produitModifier.setName(produit.getName());
        produitModifier.setPrice(produit.getPrice());
        produitModifier.setDescription(produit.getDescription());

        return produitRepository.save(produitModifier);
    }
}
