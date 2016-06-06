/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
            joueurCrud.findOneByDateArrivee(1l).setMarqueurMain(true);
            
            
    }
    
    public void jouerSuivant(){
        Joueur actuel = joueurCrud.findAllByMarqueurMainTrue().get(0);
        actuel.setMarqueurMain(false);
        joueurCrud.save(actuel);
        if(actuel.getDateArrivee()== joueurCrud.findAll().size()){
            Joueur premier = joueurCrud.findOneByDateArrivee(1);
            joueurCrud.save(premier);
        }
        else{
        Joueur suivant = joueurCrud.findOneByDateArrivee(actuel.getDateArrivee()+1);
        suivant.setMarqueurMain(true);
        joueurCrud.save(suivant);
        }
    }
}
