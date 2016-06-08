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
import streaming.service.MessageService;
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
     
     @Autowired
    MessageService messageService;
     
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
       try{
        if(dto.getSort().equals("INVISIBILITE")){
            joueurservice.invisiblite(j.getId());
            String msg = "Le joueur "+ j.getPseudo() +" a lancé INVISIBILITE !";
            String msg2 ="Vous avez vole une ressource à chacun des autres joueurs !";
            messageService.messageGlodal(msg);
            messageService.messagePersonnel(msg2, j.getId());
        }
        if(dto.getSort().equals("HYPNOSE")){
            joueurservice.hypnose(j.getId(), dto.getJoueurCible(), dto.getCarteCible());
            String msg = "Le joueur "+ j.getPseudo() +" a lancé HYPNOSE sur "+ dto.getJoueurCible()+"!";
            String msg2 ="Vous avez vole deux ressources a "+dto.getJoueurCible() +"!";
            messageService.messageGlodal(msg);
            messageService.messagePersonnel(msg2, j.getId());
        }
        if(dto.getSort().equals("DIVINATION")){
            String msg = "Le joueur "+ j.getPseudo() +" a lancé DIVINATION !";
            messageService.messageGlodal(msg);
            messageService.messagePersonnel(joueurservice.divination2(j.getId()), j.getId());
           
        }
        if(dto.getSort().equals("FILTREAMOUR")){
            
            joueurservice.filtreAmour(j.getId(),dto.getJoueurCible());
            String msg = "Le joueur "+ j.getPseudo() +" a lancé FILTRE D AMOUR sur "+ dto.getJoueurCible()+"!";
            String msg2 ="Vous avez vole la moitie des ressources a "+dto.getJoueurCible() +"!";
            messageService.messageGlodal(msg);
            messageService.messagePersonnel(msg2, j.getId());
        }
        
         if(dto.getSort().equals("SOMMEILPROFOND")){
            
            joueurservice.sommeil(dto.getJoueurCible());
            String msg = "Le joueur "+ j.getPseudo() +" a lancé SOMMEIL PROFOND  sur "+ dto.getJoueurCible()+"!";
            String msg2 ="Vous avez assomé "+dto.getJoueurCible() +"!";
            messageService.messageGlodal(msg);
            messageService.messagePersonnel(msg2, j.getId());
        }
        
        
        
        model.addAttribute("affichageSort", false);
        tableservice.eliminer();
        tableservice.joueurSuivant();
        }
       catch(RuntimeException e){
           messageService.messagePersonnel("Tu n'as pas assez de ressources pour faire ça !", j.getId());
       }
        return "homepage";
        
    }
}
