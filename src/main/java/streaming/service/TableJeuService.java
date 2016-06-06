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
    
    
    public void commencerJeu(){
//         final int qteFromage = ThreadLocalRandom.current().nextInt(2,4);
    }
    
}
