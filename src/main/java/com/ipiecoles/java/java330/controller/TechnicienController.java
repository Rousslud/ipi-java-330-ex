package com.ipiecoles.java.java330.controller;

import com.ipiecoles.java.java330.model.Technicien;
import com.ipiecoles.java.java330.service.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/techniciens")
public class TechnicienController {

    @Autowired
    TechnicienService technicienService;

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String update(Map<String, Object> model, @PathVariable(value = "id") Long id, Technicien employe,
                         RedirectAttributes attributes) {
        employe = this.technicienService.updateEmploye(id, employe);
        model.put("employe", employe);
        attributes.addAttribute("success", "Modification sur technicien réussie");

        return "employes/detail";
    }
}