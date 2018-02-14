package com.ipiecoles.java.java320.controller;

import com.ipiecoles.java.java320.model.Commercial;
import com.ipiecoles.java.java320.model.Employe;
import com.ipiecoles.java.java320.model.Manager;
import com.ipiecoles.java.java320.model.Technicien;
import com.ipiecoles.java.java320.service.EmployeService;
import com.ipiecoles.java.java320.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityNotFoundException;
import java.util.Map;

@RequestMapping("/employes")
@Controller
public class EmployeController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private EmployeService employeService;

    @RequestMapping(value = "", params = "matricule", method = RequestMethod.GET)
    public RedirectView findByMatricule(@RequestParam(name = "matricule") String matricule) {
            Employe employe = this.employeService.findMyMatricule(matricule);
            return new RedirectView("/employes/" + employe.getId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable(name = "id") Long id, Map<String, Object> model) {
        Employe employe = this.employeService.findById(id);
        //Si l'employé est un manager, on récupère également son équipe
        //Si on n'utilise pas la méthode findOneWithEquipeById, on va avoir une LazyLoadingException lorsqu'on va
        //récupérer l'équipe.
        if(employe != null && employe instanceof Manager){
            employe = managerService.findOneWithEquipeById(id);
        }

        if(employe == null){
            throw new EntityNotFoundException("Impossible de trouver l'employé d'identifiant " + id);
        }
        model.put("model", employe);

        return "employes/detail";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public RedirectView deleteEmploye(@PathVariable(name = "id") Long id, Map<String, Object> model, RedirectAttributes attributes) {
        this.employeService.deleteEmploye(id);
        attributes.addAttribute("success", "Suppression de l'employée effectuée !");
        //Une fois supprimé, on redirige l'utilisateur sur la liste des employés
        return new RedirectView("/employes");
    }

    @RequestMapping(value = "/new/manager", method = RequestMethod.GET)
    public String createManager(Map<String, Object> model) {
        return createEmploye(model, new Manager());
    }

    @RequestMapping(value = "/new/commercial", method = RequestMethod.GET)
    public String createCommercial(Map<String, Object> model) {
        return createEmploye(model, new Commercial());
    }

    @RequestMapping(value = "/new/technicien", method = RequestMethod.GET)
    public String createTechnicien(Map<String, Object> model) {
        return createEmploye(model, new Technicien());
    }

    private String createEmploye(Map<String, Object> model, Employe employe){
        model.put("model", employe);
        return "employes/detail";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
            @RequestParam(value = "sortProperty", defaultValue = "matricule") String sortProperty,
            Map<String, Object> model){
        Page<Employe> pageEmploye = employeService.findAllEmployes(page, size, sortProperty, sortDirection);
        model.put("model",pageEmploye);
        model.put("size", size);
        model.put("sortDirection", sortDirection);
        model.put("sortProperty", sortProperty);
        model.put("page", page);
        model.put("pageAffichage", page + 1);
        model.put("nextPage", page + 1);
        model.put("previousPage", page - 1);
        model.put("start", (page) * size + 1);
        int end = (page + 1) * size;
        model.put("end", end > pageEmploye.getTotalElements() ? pageEmploye.getTotalElements() : end);
        return "employes/liste";
    }

}
