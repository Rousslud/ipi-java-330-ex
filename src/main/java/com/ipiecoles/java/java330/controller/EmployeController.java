package com.ipiecoles.java.java330.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
			value="/5",
			method=RequestMethod.GET)
	public String detailEmploye() {
		Employe employe = employeService.findById((long)5);
		return "employes/detail";
	}

}
