/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

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
    
}
