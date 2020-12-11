package br.com.everis.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.estacionamento.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	Ticket findByPlaca (String placaTicket);
}
