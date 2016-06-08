/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import streaming.dto.ListeSortDTO;
import streaming.entity.Carte;
import streaming.entity.Joueur;
import streaming.service.CarteCrudService;
import streaming.service.JoueurCrudService;
import streaming.service.JoueurService;
import streaming.service.TableJeuService;

/**
 *
 * @author ajc
 */
@Controller
public class JoueurController {
    
     
    @Autowired
    JoueurCrudService joueurcrud;
    
    @Autowired
    CarteCrudService cartecrud;
    
     @Autowired
    JoueurService joueurservice;
     
     @Autowired
    TableJeuService tableservice;
     
    @RequestMapping(value = "/lancersort", method = RequestMethod.GET)
    public String sortGET(Model model){
        
        model.addAttribute("mesSorts",new ListeSortDTO() );
        model.addAttribute("monJoueurCible",new Joueur() );
        model.addAttribute("joueurCible",joueurcrud.findAllByMarqueurMainFalse() );
        model.addAttribute("maCarte",new Carte() );
        model.addAttribute("carteCible",cartecrud.findAllByJoueurId(1) );
        model.addAttribute("affichageSort", true);
        return "homepage";
    }
    
    @RequestMapping(value = "/lancersort", method = RequestMethod.POST)
    public String sortPOST(HttpSession session,@ModelAttribute ListeSortDTO dto, Model model){
        Joueur j =(Joueur) session.getAttribute("joueur");
        if(dto.getSort().equals("INVISIBILITE")){
            joueurservice.invisiblite(j.getId());
        }
        if(dto.getSort().equals("HYPNOSE")){
            joueurservice.hypnose(j.getId(), dto.getJoueurCible(), dto.getCarteCible());
        }
        if(dto.getSort().equals("DIVINATION")){
           joueurservice.divination(j.getId());
        }
        if(dto.getSort().equals("FILTREAMOUR")){
            
            joueurservice.filtreAmour(j.getId(),dto.getJoueurCible());
        }
        tableservice.joueurSuivant();
        
        model.addAttribute("affichageSort", false);
        
        return "homepage";
    }
}
