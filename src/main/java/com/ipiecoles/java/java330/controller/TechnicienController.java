package com.ipiecoles.java.java330.controller;

import com.ipiecoles.java.java330.model.Manager;
import com.ipiecoles.java.java330.model.Technicien;
import com.ipiecoles.java.java330.service.EmployeService;
import com.ipiecoles.java.java330.service.TechnicienService;
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
@RequestMapping("/techniciens")
public class TechnicienController {

    @Autowired
    TechnicienService technicienService;
    EmployeService employeService;

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public RedirectView update(Map<String, Object> model, @PathVariable(value = "id") Long id, Technicien employe, RedirectAttributes attributes) {
        employe = this.technicienService.updateEmploye(id, employe);
        model.put("employe", employe);
        attributes.addAttribute("success", "Modification du technicien réussie");

        return new RedirectView("/employes/" + id);
    }
    
    @RequestMapping(
    		value="",
    		method=RequestMethod.POST,
    		consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    		)
    public RedirectView creer(Map<String, Object> model, RedirectAttributes attributes, Technicien employe) {
    	employe = technicienService.creerEmploye(employe);
    	model.put("employe", employe);
    	attributes.addAttribute("success", "Création d'un technicien réussie");
    	return new RedirectView("/employes/" + employe.getId());
    	}
    		
    @RequestMapping(
    		value = "/{idTechnicien}/manager/add")
    public String addManager(@PathVariable(name = "idTechnicien") Long id, @RequestParam(name = "matricule") String matricule, Map<String, Object> model) {
    	Technicien technicien = (Technicien) employeService.findById(id);
    	Manager manager = (Manager) employeService.findMyMatricule(matricule);
    	technicien.setManager(manager);
    	technicien = employeService.updateEmploye(id,technicien);
    	model.put("employe", technicien);
    	return "/employes/detail";
    		}
}