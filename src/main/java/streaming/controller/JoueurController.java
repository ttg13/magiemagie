/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    JoueurService joueurservice;
     
     @Autowired
    TableJeuService tableservice;
     
    @RequestMapping(value = "/lancersort", method = RequestMethod.GET)
    public String sortGET(Model model){
        
        model.addAttribute("listesort",tableservice.listeSort(joueurcrud.findAllByMarqueurMainTrue().get(0).getId()) );
        return "sort";
    }
    
    @RequestMapping(value = "/lancersort", method = RequestMethod.POST)
    public String sortPOST(Model model){
        
        return "sort";
    }
}
