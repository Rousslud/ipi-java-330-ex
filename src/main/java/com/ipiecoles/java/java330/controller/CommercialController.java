package com.ipiecoles.java.java330.controller;

import com.ipiecoles.java.java330.model.Commercial;
import com.ipiecoles.java.java330.service.CommercialService;
import com.ipiecoles.java.java330.service.EmployeService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/commercials")
public class CommercialController {

    @Autowired
    CommercialService commercialService;

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public RedirectView enregistre(@PathVariable("id") Long id, Commercial employe, Map<String, Object> model, RedirectAttributes attributes) {
    	employe = this.commercialService.updateEmploye(id, employe);
    	model.put("employe", employe);
    	return new RedirectView("/employes/" + id);
    }
    
    @RequestMapping(
    		value = "",
    		method = RequestMethod.POST,
    		consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    		)
    public RedirectView creation(Commercial employe, Map<String, Object> model, RedirectAttributes attributes){
    	employe = this.commercialService.creerEmploye(employe);
    	model.put("employe", employe);
    	attributes.addAttribute("success", "Création du commercial réussie");
    	return new RedirectView("/employes/" + employe.getId());
    		    }
   
}
