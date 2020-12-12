package br.com.everis.estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.estacionamento.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	List<Ticket> findByPlaca (String placaTicket);
	
}
