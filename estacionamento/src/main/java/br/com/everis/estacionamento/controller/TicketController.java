package br.com.everis.estacionamento.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.everis.estacionamento.controller.dto.TicketDto;
import br.com.everis.estacionamento.controller.form.TicketForm;
import br.com.everis.estacionamento.model.Ticket;
import br.com.everis.estacionamento.repository.TicketRepository;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@PutMapping
	public String creation() {
		Ticket tck = new Ticket("asd-1234","wv","sadf"); 
		Ticket tck1 = new Ticket("igd-6879","wv","sadf"); 
		Ticket tck2 = new Ticket("ogx-9534","ferrari","sadf"); 
		
		ticketRepository.save(tck);
		ticketRepository.save(tck1);
		ticketRepository.save(tck2);
		return "criado";
	}
	
	@GetMapping
	public List<TicketDto> registros() {
		List<Ticket> tickets = ticketRepository.findAll();
		
		return TicketDto.convercao(tickets);
	}
	
	@PostMapping
	public ResponseEntity<TicketDto> cadastro(@RequestBody TicketForm ticketF, UriComponentsBuilder uriBuilder) {
		Ticket ticket = ticketF.converter();
		ticketRepository.save(ticket);
		
		URI uri = uriBuilder.path("/ticket/{id}").buildAndExpand(ticket.getId()).toUri();
		return ResponseEntity.created(uri).body(new TicketDto(ticket));
	}
	
}
