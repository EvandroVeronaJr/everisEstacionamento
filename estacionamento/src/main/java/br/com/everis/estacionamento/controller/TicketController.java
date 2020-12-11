package br.com.everis.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.everis.estacionamento.repository.TicketRepository;

@Controller
@RequestMapping("/Ticket")
public class TicketController {
	
	@Autowired
	TicketRepository ticketRepository;
	
	
	
}
