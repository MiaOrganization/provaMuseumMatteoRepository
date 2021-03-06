package it.uniroma3.siw.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class MainController {
	
	@Autowired 
	public OperaService operaService;
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index(Model model) {
		
		List<Opera> delMese = this.operaService.opereDelMese();
		
		if(delMese.size()!=0)
			model.addAttribute("opere",delMese);
		
		return "index.html";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		return "admin/home.html";
	}
}