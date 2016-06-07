/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import streaming.entity.Carte;

/**
 *
 * @author ajc
 */


  @Service
public class CarteService {
    @Autowired 
    CarteCrudService carteCrud;
    
    @Autowired 
    JoueurCrudService joueurCrud;
    
    
    public void creerRandomCarte(long idJoueur){
        Carte carte = new Carte();
        carte.setJoueur(joueurCrud.findOne(idJoueur));
        int i = ThreadLocalRandom.current().nextInt(1,6);
        switch(i){
            case 1 : carte.setTypecarte(Carte.Typecarte.AILESOURIS); break;
            case 2 : carte.setTypecarte(Carte.Typecarte.BAVECRAPAUD); break;
            case 3 : carte.setTypecarte(Carte.Typecarte.CORNELICORNE); break;
            case 4 : carte.setTypecarte(Carte.Typecarte.LAPISLAZULIS); break;
            case 5 : carte.setTypecarte(Carte.Typecarte.SANGVIERGE); break;
            default : throw new RuntimeException();
        }
        carteCrud.save(carte);
    }
    
     public void creerSpecifiqueCarte(long idJoueur, Carte.Typecarte type){
        Carte carte = new Carte();
        carte.setJoueur(joueurCrud.findOne(idJoueur));
           carte.setTypecarte(type);
        
        carteCrud.save(carte);
    }
     
     public void supprimerCarte(long idJoueur, Carte.Typecarte type){
         List<Carte> cartes = carteCrud.findAllByJoueurIdAndTypecarte(idJoueur, type);
         if(cartes.isEmpty()){
             throw new RuntimeException();
         }
         else{
            carteCrud.delete(cartes.get(0));
         }
     }
     
     public void volerCarte(long idVoleur, long idVictime){
         List<Carte> cartes = carteCrud.findAllByJoueurId(idVictime);
         int i = ThreadLocalRandom.current().nextInt(0,cartes.size());
         cartes.get(i).setJoueur(joueurCrud.findOne(idVoleur));
         carteCrud.save(cartes.get(i));
//         creerSpecifiqueCarte(idVoleur, cartes.get(i).getTypecarte());
//         carteCrud.delete(cartes.get(i));
     }
     
     public void donnerCarte(long idVoleur, long idVictime,Carte.Typecarte type){
         List<Carte> cartes = carteCrud.findAllByJoueurIdAndTypecarte(idVictime, type);
         if(!cartes.isEmpty()){
            cartes.get(0).setJoueur(joueurCrud.findOne(idVoleur));
            carteCrud.save(cartes.get(0));
         }
         else{
             throw new RuntimeException();
         }
     }
    
}
