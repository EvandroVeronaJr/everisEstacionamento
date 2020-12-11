package br.com.everis.estacionamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ticket")
public class TicketController {
	
	@GetMapping
	@ResponseBody
	public String Testando() {
		return "agora foi";
	}
	
}
