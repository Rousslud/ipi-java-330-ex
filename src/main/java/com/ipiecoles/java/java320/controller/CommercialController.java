package com.ipiecoles.java.java320.controller;

import com.ipiecoles.java.java320.model.Commercial;
import com.ipiecoles.java.java320.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RequestMapping("/commercials")
@Controller
public class CommercialController {

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
    public String save(@PathVariable(name = "id") Long id, Commercial employe, Map<String, Object> model, RedirectAttributes attributes) {
        if(employe != null){
            employe = this.employeService.updateEmploye(employe);
        }
        model.put("model", employe);
        model.put("success", "Modifications enregistrées !");

        return "/employes/detail";
    }

    /**
     *
     * @param employe Dans le cas du media type application form urlencoded, on ne met pas l'annotation
     *                @RequestBody sur employe
     * @param model
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, method = RequestMethod.POST)
    public String saveNew(Commercial employe, Map<String, Object> model, RedirectAttributes attributes) {
        employe = this.employeService.creerEmploye(employe);
        model.put("model", employe);
        model.put("success", "Création du commercial enregistrée !");
        return "/employes/detail";
    }
}
