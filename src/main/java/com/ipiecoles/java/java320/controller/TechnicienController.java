package com.ipiecoles.java.java320.controller;

import com.ipiecoles.java.java320.model.Manager;
import com.ipiecoles.java.java320.model.Technicien;
import com.ipiecoles.java.java320.service.EmployeService;
import com.ipiecoles.java.java320.service.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityNotFoundException;
import java.util.Map;

@RequestMapping("/techniciens")
@Controller
public class TechnicienController {

    @Autowired
    private TechnicienService technicienService;

    @Autowired
    private EmployeService employeService;

    /**
     *
     * @param id
     * @param employe Dans le cas du media type application form urlencoded, on ne met pas l'annotation
     *                @RequestBody sur employe
     * @param model
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String save(@PathVariable(name = "id") Long id, Technicien employe, Map<String, Object> model, RedirectAttributes attributes) {
        if(employe != null){
            employe = this.employeService.updateEmploye(employe);
        }
        model.put("model", employe);
        model.put("success", "Modifications enregistrées !");
        return "employes/detail";
    }

    /**
     *
     * @param employe Dans le cas du media type application form urlencoded, on ne met pas l'annotation
     *                @RequestBody sur employe
     * @param model
     * @param attributes
     * @return
     */
    @RequestMapping( value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveNew(Technicien employe, Map<String, Object> model, RedirectAttributes attributes) {
        employe = this.employeService.creerEmploye(employe);
        model.put("model", employe);
        model.put("success", "Création du technicien enregistrée !");
        return "/employes/detail";
    }

    @RequestMapping(value = "/{id}/manager/delete", method = RequestMethod.GET)
    public String removeManager(@PathVariable(name = "id") Long id, Map<String, Object> model){
        Technicien technicien = technicienService.deleteManager(id);
        model.put("model", technicien);
        model.put("success", "Suppression du manager effectuée !");
        return "/employes/detail";
    }

    @RequestMapping(value = "/{id}/manager/add", method = RequestMethod.GET)
    public String addManager(@PathVariable(name = "id") Long id, @RequestParam(name = "matricule") String matricule, Map<String, Object> model){
        Technicien technicien = this.technicienService.addManager(id, matricule);
        model.put("model", technicien);
        model.put("success", "Ajout du manager " + matricule + " effectué !");
        return "employes/detail";
    }
}
