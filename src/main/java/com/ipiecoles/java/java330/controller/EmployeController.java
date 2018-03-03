package com.ipiecoles.java.java330.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String detailEmploye(@PathVariable(value="id") Long id) {
		Employe employe = employeService.findById(id);
		return "employes/detail";
	}

}
