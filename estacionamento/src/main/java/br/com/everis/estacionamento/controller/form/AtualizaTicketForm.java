package br.com.everis.estacionamento.controller.form;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.everis.estacionamento.model.Ticket;
import br.com.everis.estacionamento.repository.TicketRepository;

public class AtualizaTicketForm {

	@NotNull @NotEmpty
	private String placa;
	
	@NotNull @NotEmpty
	private String modelo;
	
	@NotNull @NotEmpty
	private String marca;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Ticket atualizar(Long id, TicketRepository ticketRepository) {
		Ticket ticket = ticketRepository.getOne(id);
		
		ticket.setPlaca(this.placa);
		ticket.setModelo(this.modelo);
		ticket.setMarca(this.marca);
		return ticket;
	}
	
	
}
