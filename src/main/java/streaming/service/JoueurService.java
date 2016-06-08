/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import streaming.entity.Carte;
import streaming.entity.Joueur;

/**
 *
 * @author ajc
 */
@Service
public class JoueurService {
     @Autowired 
    JoueurCrudService joueurCrud;
     
     @Autowired 
    CarteService carteServvice;
     
      @Autowired 
    CarteCrudService carteCrud;
     
    public Joueur creerJoueur(String login, long carte){
        Joueur j = new Joueur();
        j.setPseudo(login);
        long ordre = joueurCrud.findAll().size();
        j.setDateArrivee(ordre +1);
        j.setTypeSorciere(carte);
        j.setMarqueurMain(false);
        j.setPerdu(false);
        j.setAssome(false);
        j.setPasseTour(0);
        joueurCrud.save(j);
        return j;
    }
    
    public void invisiblite(long idJoueur){
        List<Joueur> joueurs = joueurCrud.findAll();
            for(Joueur j : joueurs){
               carteServvice.volerCarte(idJoueur,j.getId());
            }
            
        carteServvice.supprimerCarte(idJoueur, Carte.Typecarte.CORNELICORNE);
        carteServvice.supprimerCarte(idJoueur, Carte.Typecarte.BAVECRAPAUD);
    }
    public void filtreAmour(long idJoueur, String victime){
        long idVictime = joueurCrud.findOneByPseudo(victime).getId();
        long i = (carteCrud.findAllByJoueurId(idVictime).size()+1)/2;
        for(long j=0; j<i;j++){
            carteServvice.volerCarte(idJoueur, idVictime);
        }
        carteServvice.supprimerCarte(idJoueur, Carte.Typecarte.CORNELICORNE);
        carteServvice.supprimerCarte(idJoueur, Carte.Typecarte.SANGVIERGE);
    }
    
    public void hypnose(long idJoueur, String victime, String type){
        long idVictime = joueurCrud.findOneByPseudo(victime).getId();
        Carte carteDonne = carteServvice.trouverCarte(idJoueur, type);
       carteServvice.donnerCarte(idVictime, idJoueur, carteDonne.getTypecarte());
       carteServvice.volerCarte(idJoueur, idVictime);
       carteServvice.volerCarte(idJoueur, idVictime);
       carteServvice.volerCarte(idJoueur, idVictime);
       
       carteServvice.supprimerCarte(idJoueur, Carte.Typecarte.BAVECRAPAUD);
       carteServvice.supprimerCarte(idJoueur, Carte.Typecarte.LAPISLAZULIS);
    }
    
    public List<String> divination(long idJoueur){
        List<String> liste = new ArrayList<>();
         List<Joueur> joueurs = joueurCrud.findAll();
            for(Joueur j : joueurs){
                if(!j.equals(joueurCrud.findOne(idJoueur))){
                    liste.add(j.toString());
                    List<Carte> cartes = carteCrud.findAllByJoueurId(j.getId());
                    for(Carte c : cartes){
                        liste.add(c.toString());
                    }
                }
            }
        return liste;
    }
    
    public String divination2(long idJoueur){
        String liste = new String();
         List<Joueur> joueurs = joueurCrud.findAll();
            for(Joueur j : joueurs){
                if(!j.equals(joueurCrud.findOne(idJoueur))){
                    liste += " " +j.toString();
                    List<Carte> cartes = carteCrud.findAllByJoueurId(j.getId());
                    for(Carte c : cartes){
                        liste += " " +c.toString();
                    }
                }
            }
        return liste;
    }
    
     public void sommeil(String victime){
         Joueur j = joueurCrud.findOneByPseudo(victime);
         j.setAssome(true);
         j.setPasseTour(2);
         joueurCrud.save(j);
     }
     
}
