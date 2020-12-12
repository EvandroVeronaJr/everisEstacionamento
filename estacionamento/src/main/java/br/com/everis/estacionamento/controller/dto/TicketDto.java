package br.com.everis.estacionamento.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.everis.estacionamento.model.Ticket;

public class TicketDto {
	

	private Long id;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private String placa;
	private String modelo;
	private String marca;
	
		
	
	public TicketDto(Ticket ticket) {
		this.id = ticket.getId();
		this.dataEntrada = ticket.getDataEntrada();
		this.dataSaida = ticket.getDataSaida();
		this.placa = ticket.getPlaca();
		this.modelo = ticket.getModelo();
		this.marca = ticket.getMarca();
	}
	public Long getId() {
		return id;
	}
	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}
	public LocalDateTime getDataSaida() {
		return dataSaida;
	}
	public String getPlaca() {
		return placa;
	}
	public String getModelo() {
		return modelo;
	}
	public String getMarca() {
		return marca;
	}
	
	public static List<TicketDto> convercao(List<Ticket> tickets){
		return tickets.stream().map(TicketDto::new).collect(Collectors.toList());
	}
	
}
