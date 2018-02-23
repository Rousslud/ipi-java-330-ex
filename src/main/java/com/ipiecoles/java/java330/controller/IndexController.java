package com.ipiecoles.java.java330.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipiecoles.java.java330.service.EmployeService;


// on utilise Controller et non RestController 
@Controller
public class IndexController {
	
	// permet d'utiliser le service employeService 
	@Autowired
	private EmployeService employeService; 
	
	@RequestMapping(
			value="/", 
			method=RequestMethod.GET
			)
	
	// on doit rajouter un paramètre dans la méthode pour pouvoir passer quelque chose à la vue 
	public String index(Map<String, Object> model) {
		Long nbEmployes = employeService.countAllEmploye();
		// permet d'envoyer dans la vue et donc dans la vue il faudrait utiliser ${nbEmployes} pour faire appel au nombre d'employes 
		model.put("nbEmployes", nbEmployes);
		// permet de retourner le index.jsp. Il rajoute automatiquement .jsp parce que dans le fichier de properties on a dit que les fichiers de vue sont en jsp automatiquement
		return "index";	
		
	}

}
