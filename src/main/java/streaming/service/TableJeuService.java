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
public class TableJeuService {
    @Autowired 
    TableJeuCrudService tableCrud;
    
    @Autowired 
    JoueurCrudService joueurCrud;
    
    @Autowired
    CarteCrudService carteCrud;
    
    @Autowired
    CarteService carteService;
    
    @Autowired
    JoueurService joueurService;
    
    public void commencerJeu(){
            List<Joueur> joueurs = joueurCrud.findAll();
            for(Joueur j : joueurs){
                for(int i=0; i<7; i++){
                    carteService.creerRandomCarte(j.getId());
                }
            }
            long l=1;
            Joueur j2=joueurCrud.findOneByDateArrivee(l);
                    j2.setMarqueurMain(true);
            joueurCrud.save(j2);
            
    }
    
    public void joueurSuivant(){
        //on cherche le joueur qui a la main et on lui enleve
        Joueur actuel = joueurCrud.findAllByMarqueurMainTrue().get(0);
        actuel.setMarqueurMain(false);
        joueurCrud.save(actuel);
        boolean elimine = true;
        Joueur suivant = new Joueur();
        //La boucle permet de passer au joueur suivant qui n est pas eliminé
        while(elimine){
            //premier cas si le joueur est le dernier a etre inscrit
            if(actuel.getDateArrivee()== joueurCrud.findAll().size()){
                suivant = joueurCrud.findOneByDateArrivee(1);
                //si le joueur suivant est eliminé on recommence la boucle
                if (suivant.isPerdu()){
                    actuel = suivant;
                }
                else {
                    //si le joueur n est pas eliminé on sort de la bouble et on lui donne la main
                    suivant.setMarqueurMain(true);
                    joueurCrud.save(suivant);
                    elimine = false;
                }
            }
            //idem pour les joueur qui ne sont pas derniers
            else{
                suivant = joueurCrud.findOneByDateArrivee(actuel.getDateArrivee()+1);
                 if (suivant.isPerdu()){
                    actuel = suivant;
                }
                 else {
                    suivant.setMarqueurMain(true);
                    joueurCrud.save(suivant);
                    elimine = false;
                }
            }
        }
    }
    
    public void eiliminer(){
        List<Joueur> joueurs = joueurCrud.findAll();
        for(Joueur j : joueurs){
            List<Carte> cartes = carteCrud.findAllByJoueurId(j.getId());
            if(cartes.size()==0){
                j.setPerdu(true);
                joueurCrud.save(j);
            }
        }
        
        List<Joueur> gagnants = joueurCrud.findAllByPerduFalse();
        if(gagnants.size()<2){
        }
        else{
            joueurSuivant();
        }
    }
    
    public List<String> listeSort(long idJoueur){
        List<String> sorts = new ArrayList<>();
        
        List<Carte> corne = carteCrud.findAllByJoueurIdAndTypecarte(idJoueur, Carte.Typecarte.CORNELICORNE);
        List<Carte> bave = carteCrud.findAllByJoueurIdAndTypecarte(idJoueur, Carte.Typecarte.BAVECRAPAUD);
        List<Carte> aile = carteCrud.findAllByJoueurIdAndTypecarte(idJoueur, Carte.Typecarte.AILESOURIS);
        List<Carte> lapis = carteCrud.findAllByJoueurIdAndTypecarte(idJoueur, Carte.Typecarte.LAPISLAZULIS);
        List<Carte> sang = carteCrud.findAllByJoueurIdAndTypecarte(idJoueur, Carte.Typecarte.SANGVIERGE);
        
        if(!corne.isEmpty() && !bave.isEmpty()){
            sorts.add("INVISIBLITE");
        }
        if(!corne.isEmpty() && !sang.isEmpty()){
            sorts.add("FILTRE D AMOUR");
        }
        if(!lapis.isEmpty() && !bave.isEmpty()){
            sorts.add("HYPNOSE");
        }
        if(!lapis.isEmpty() && !aile.isEmpty()){
            sorts.add("DIVINATION");
        }
        if(!sang.isEmpty() && !bave.isEmpty()){
            sorts.add("SOMMEIL PROFOND");
        }
       if(sorts.isEmpty()) {
           sorts.add("DOMMAGE");
        }
        
        
        return sorts;
    }
    
    
}


