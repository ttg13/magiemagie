/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ajc
 */
@Controller
public class RaffraichissementController {
    @RequestMapping(value = "/raffrai", method = RequestMethod.GET)
    public String raffraichissmentGET(Model model){
        
        return "sousdiv";
    }
    
}
