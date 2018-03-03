package com.ipiecoles.java.java330.controller;

import com.ipiecoles.java.java330.model.Manager;
import com.ipiecoles.java.java330.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public RedirectView update(Map<String, Object> model, @PathVariable(value = "id") Long id, Manager employe,
                               RedirectAttributes attributes) {
        employe = this.managerService.updateEmploye(id, employe);
        model.put("employe", employe);
        attributes.addAttribute("success", "Modification du manager réussie");

        return new RedirectView("/employes/" + id);
    }
    
    @RequestMapping(
    		value="",
    		method=RequestMethod.POST,
    		consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    		)
    public RedirectView creer(Map<String, Object> model, RedirectAttributes attributes, Manager employe) {
    	employe = managerService.creerEmploye(employe);
    	model.put("employe", employe);
    	attributes.addAttribute("success", "Création d'un manager réussie");
    	return new RedirectView("/employes/" + employe.getId());
    	}


}