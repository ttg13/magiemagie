/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class TableJeuController {

    @Autowired
    JoueurCrudService joueurcrud;

    @Autowired
    JoueurService joueurservice;

    @Autowired
    TableJeuService tablejeuservice;

    @Autowired
    CarteCrudService cartecrudservice;

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String homepageGET(Model model, HttpSession session) {

        return "homepage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(Model model) {
        model.addAttribute("ajoutjoueur", new Joueur());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(@ModelAttribute("ajoutjoueur") Joueur j, HttpSession session) {

        Joueur j2 = joueurservice.creerJoueur(j.getPseudo(), j.getTypeSorciere());

        session.setAttribute("joueur", j2);

        return "redirect:/homepage";
    }

    //met à jour les cartes possédées par le joueur
    @RequestMapping(value = "/ajax_partienondemarree_ou_plateau", method = RequestMethod.GET)
    public String ajaxPartienondemarreeOuPlateau(HttpSession session) {

        // Récup lister ts joueurs
        session.setAttribute("players", joueurcrud.findAll());
        
        // Récup j actuel
        Joueur j = (Joueur) session.getAttribute("joueur");

        //recuperation de l'attribut "partie lancée"
        if (joueurcrud.findAllByMarqueurMainTrue().get(0) != null) {
            session.setAttribute("partielancee", true);
        }
        
        
        
        //recup la liste des cartes dont on dispose
        session.setAttribute("sangcount", cartecrudservice.findAllByJoueurIdAndTypecarte(j.getId(), Carte.Typecarte.SANGVIERGE).size());
        session.setAttribute("souriscount", cartecrudservice.findAllByJoueurIdAndTypecarte(j.getId(), Carte.Typecarte.AILESOURIS).size());
        session.setAttribute("bavecount", cartecrudservice.findAllByJoueurIdAndTypecarte(j.getId(), Carte.Typecarte.BAVECRAPAUD).size());
        session.setAttribute("cornecount", cartecrudservice.findAllByJoueurIdAndTypecarte(j.getId(), Carte.Typecarte.CORNELICORNE).size());
        session.setAttribute("lapiscount", cartecrudservice.findAllByJoueurIdAndTypecarte(j.getId(), Carte.Typecarte.LAPISLAZULIS).size());
        session.setAttribute("joueur",joueurcrud.findOne(j.getId()));

        return "ajax_partienondemarree_ou_plateau";
    }

    //ce post permet de démarrer la partie
    @RequestMapping(value = "/launch", method = RequestMethod.GET)
    public String launchGET(Model model, HttpSession session) {

        Joueur j = (Joueur) session.getAttribute("joueur");

        tablejeuservice.commencerJeu();

        if (j.getDateArrivee() == 1) {
            j.setMarqueurMain(true);
        }

        if (joueurcrud.findAllByMarqueurMainTrue().get(0) != null) {
            session.setAttribute("partielancee", true);
        }

        session.setAttribute("joueur", j);

        return "redirect:/homepage";
    }

    @RequestMapping(value = "/passer", method = RequestMethod.GET)
    public String passerGET() {

        tablejeuservice.joueurSuivant();

        return "redirect:/homepage";
    }
}
