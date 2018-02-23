package com.ipiecoles.java.java330.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


// on utilise Controller et non RestController 
@Controller
public class IndexController {
	
	@RequestMapping(
			value="/", 
			method=RequestMethod.GET
			)
	
	public String index() {
		// permet de retourner le index.jsp. Il rajoute automatiquement .jsp parce que dans le fichier de properties on a dit que les fichiers de vue sont en jsp automatiquement
		return "index";	
	}

}
