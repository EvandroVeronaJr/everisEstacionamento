package br.com.everis.estacionamento.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.everis.estacionamento.controller.dto.RelatoriosDto;
import br.com.everis.estacionamento.controller.dto.TicketDto;
import br.com.everis.estacionamento.controller.form.AtualizaTicketForm;
import br.com.everis.estacionamento.controller.form.TicketForm;
import br.com.everis.estacionamento.model.Ticket;
import br.com.everis.estacionamento.repository.TicketRepository;

@RestController
public class TicketController {

	@Autowired
	TicketRepository ticketRepository;

	
	@GetMapping("/popular")
	@Transactional
	public String popular() {		
		for(int i = 0; i<1000;i++) {
			Ticket tck = new Ticket("asd-1234", "Tesla", "Tesla");
			int dia =(int) (Math.random()*28) +1;
			int hora = (int) (Math.random()*11);
			int minuto = (int) (Math.random()*59);
			int horaSaida = (int) (Math.random()*11 + hora);
			int minutoSaida = (int) Math.random()*59;
			tck.setDataEntrada(LocalDateTime.of(2019, Month.NOVEMBER, dia, hora, minuto));
			tck.fixarSaida(LocalDateTime.of(2019, Month.NOVEMBER, dia, horaSaida, minutoSaida));
			ticketRepository.save(tck);			
		}
		
		for(int i = 0; i<1000;i++) {
			Ticket tck = new Ticket("AFH-6824", "fiat", "Uno");
			int dia =(int) (Math.random()*28) +1;
			int hora = (int) (Math.random()*11);
			int minuto = (int) (Math.random()*59);
			int horaSaida = (int) (Math.random()*11 + hora);
			int minutoSaida = (int) Math.random()*59;
			tck.setDataEntrada(LocalDateTime.of(2019, Month.DECEMBER, dia, hora, minuto));
			tck.fixarSaida(LocalDateTime.of(2019, Month.DECEMBER, dia, horaSaida, minutoSaida));
			ticketRepository.save(tck);			
		}
		
		for(int i = 0; i< 1000;i++) {
			Ticket tck = new Ticket("IHR-7821", "Ferrari", "Ferrari");
			int dia =(int) (Math.random()*28) +1;
			int hora = (int) Math.random()*11;
			int minuto = (int) Math.random()*59;
			int horaSaida = (int) (Math.random()*11 + hora);
			int minutoSaida = (int) Math.random()*59;
			tck.setDataEntrada(LocalDateTime.of(2020, Month.JANUARY, dia, hora, minuto));
			tck.fixarSaida(LocalDateTime.of(2020, Month.JANUARY, dia, horaSaida, minutoSaida));
			ticketRepository.save(tck);			
		}		
		return "populado";
	}
	
	@GetMapping("/ticket")
	public List<TicketDto> registros(String placa) {
		List<Ticket> tickets;
		if (placa == null) {
			tickets = ticketRepository.findAll();
		} else {
			tickets = ticketRepository.findByPlaca(placa);
		}
		return TicketDto.convercao(tickets);
	}
	
	@GetMapping("/ticket/{id}")
	public TicketDto registros(@PathVariable Long id) {
		Ticket ticket = ticketRepository.getOne(id);
		return new TicketDto(ticket);
	}

	@PostMapping("/ticket")
	public ResponseEntity<TicketDto> cadastro(@RequestBody TicketForm ticketF, UriComponentsBuilder uriBuilder) {
		Ticket ticket = ticketF.converter();
		ticketRepository.save(ticket);

		URI uri = uriBuilder.path("/ticket/{id}").buildAndExpand(ticket.getId()).toUri();
		return ResponseEntity.created(uri).body(new TicketDto(ticket));
	}
	
	@PutMapping("/ticket/{id}")
	@Transactional
	public ResponseEntity<TicketDto> atualizar(@PathVariable Long id,@RequestBody AtualizaTicketForm aTicketF){
		Ticket ticket =  aTicketF.atualizar(id, ticketRepository);		
		return ResponseEntity.ok(new TicketDto(ticket));
	}
	
	@PutMapping("/saida/{id}")
	@Transactional
	public ResponseEntity<TicketDto> fechamentoTicket(@PathVariable long id){
		Ticket ticket = ticketRepository.getOne(id);
		System.out.println(ticket.fixarSaida());
		return ResponseEntity.ok(new TicketDto(ticket));
	}
	
	@PutMapping("/saida")
	@Transactional
	public ResponseEntity<TicketDto> fechamentoPlaca(String placa){
		Ticket ticket = null;
		for (Ticket tct : ticketRepository.findByPlaca(placa)) {
			if(!tct.isCompleto()) {
				ticket = tct;
				break;
			}
		}
		if(ticket != null) {
			ticket.fixarSaida();
			return ResponseEntity.ok(new TicketDto(ticket));			
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
		}
	}
	
	
	@GetMapping("/relatorio")
	public ResponseEntity<RelatoriosDto> relatorios(@RequestBody RelatoriosDto relatorioDTO){
		relatorioDTO.gerarRelatorio(ticketRepository);		
		return ResponseEntity.ok(relatorioDTO);
	}
}
