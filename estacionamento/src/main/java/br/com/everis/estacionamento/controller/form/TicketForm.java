package br.com.everis.estacionamento.controller.form;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.everis.estacionamento.model.Ticket;

public class TicketForm {
	
	@NotNull @NotEmpty
	private String placa;
		
	@NotNull @NotEmpty
	private String modelo;
	
	@NotNull @NotEmpty
	private String marca;
	
	
	public TicketForm() {
	}

	public TicketForm(String placa, String modelo, String marca) {
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
	}


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


	public Ticket converter() {
		return new Ticket(this.placa,this.modelo,this.marca);
	}
	
	
	
}
