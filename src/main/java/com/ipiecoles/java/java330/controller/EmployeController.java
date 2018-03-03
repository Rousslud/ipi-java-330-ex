package com.ipiecoles.java.java330.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipiecoles.java.java330.model.Employe;
import com.ipiecoles.java.java330.service.EmployeService;

@Controller
@RequestMapping("/employes")
public class EmployeController {
	
	@Autowired
	private EmployeService employeService;
	
	@RequestMapping(
			value="/{id}",
			method=RequestMethod.GET)
	public String detailEmploye(@PathVariable(value="id") Long id , Map<String,Object> model) {
		Employe employe = employeService.findById(id);
		model.put("employe", employe);
		return "employes/detail";
	}
	
	 @RequestMapping (
			 value = "",
			 method = RequestMethod.GET
			 )
			 
	public String rechercheMatricule(@RequestParam("matricule") String matricule, Map<String,Object> model) {
		 Employe employe = employeService.findMyMatricule(matricule);
		 model.put("employe", employe);
		 return "employes/detail";
		}

}
