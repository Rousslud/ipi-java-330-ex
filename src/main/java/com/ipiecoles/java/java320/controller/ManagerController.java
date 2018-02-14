package com.ipiecoles.java.java320.controller;

import com.ipiecoles.java.java320.model.Manager;
import com.ipiecoles.java.java320.service.EmployeService;
import com.ipiecoles.java.java320.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RequestMapping("/managers")
@Controller
public class ManagerController{

    @Autowired
    private ManagerService managerService;

    @Autowired
    private EmployeService employeService;


    @RequestMapping(value = "/{id}/techniciens/{idTech}/delete", method = RequestMethod.GET)
    public String deleteTechnicien(@PathVariable("id") Long id, @PathVariable("idTech") Long idTech, Map<String, Object> model){
        Manager manager = managerService.deleteTechniciens(id, idTech);
        model.put("model", manager);
        model.put("success", "Suppression du technicien dans l'équipe effectuée !");

        return "employes/detail";
    }

    @RequestMapping(value = "/{id}/techniciens/add", method = RequestMethod.GET)
    public String addTechnicien(@PathVariable("id") Long id, @RequestParam("matricule") String matricule, Map<String, Object> model){
        Manager manager = managerService.addTechniciens(id, matricule);
        model.put("model", employeService.findById(id));
        model.put("success", "Ajout du technicien " + matricule + " dans l'équipe effectuée !");

        return "employes/detail";
    }

    /**
     *
     * @param id
     * @param employe Dans le cas du media type application form urlencoded, on ne met pas l'annotation
     *                @RequestBody sur employe
     * @param model
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String save(@PathVariable(name = "id") Long id, Manager employe, Map<String, Object> model, RedirectAttributes attributes) {
        if(employe != null){
            employe = this.employeService.updateEmploye(employe);
        }
        model.put("model", employe);
        model.put("success", "Modifications enregistrées !");

        return "/employes/detail";
    }

    @PostMapping("/")
    public String saveNew(Manager employe, Map<String, Object> model, RedirectAttributes attributes) {
        employe = this.employeService.creerEmploye(employe);
        model.put("model", employe);
        model.put("success", "Création du manager enregistrée !");
        return "/employes/detail";
    }
}
