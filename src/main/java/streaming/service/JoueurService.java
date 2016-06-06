/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import streaming.entity.Joueur;

/**
 *
 * @author ajc
 */
@Service
public class JoueurService {
     @Autowired 
    JoueurCrudService joueurCrud;
     
    public void creerJoueur(String login, long carte){
        Joueur j = new Joueur();
        j.setPseudo(login);
       long ordre = joueurCrud.findAll().size();
        j.setDateArrivee(ordre +1);
        j.setTypeSorciere(carte);
        j.setMarqueurMain(false);
        joueurCrud.save(j);
    }
    
    
}
