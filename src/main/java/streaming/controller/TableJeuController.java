/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import streaming.entity.Joueur;
import streaming.service.JoueurCrudService;
import streaming.service.JoueurService;
import streaming.service.TableJeuService;

/**
 *
 * @author ajc
 */
@Controller
public class TableJeuController {
    
    @Autowired
    JoueurCrudService joueurcrud;
    
     @Autowired
    JoueurService joueurservice;
     
     @Autowired
     TableJeuService tablejeuservice;
    
     @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String homepageGET(Model model){
        
        return "homepage";
    }
    
     @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET( Model model){
        model.addAttribute("ajoutjoueur", new Joueur());
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(@ModelAttribute("ajoutjoueur") Joueur j){
        
        
        joueurservice.creerJoueur(j.getPseudo(), j.getTypeSorciere());
        
        return "redirect:/homepage";
    }
    
    //ce post permet de démarrer la partie
    @RequestMapping(value = "/launch", method = RequestMethod.POST)
    public String launchPOST(Model model){
        
        tablejeuservice.commencerJeu();
        
       return"redirect:/homepage"; 
    }
}
