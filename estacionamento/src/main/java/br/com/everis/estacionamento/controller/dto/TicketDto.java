package br.com.everis.estacionamento.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.everis.estacionamento.model.Ticket;

public class TicketDto {
	

	private Long id;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private float tempoTotal;
	private String placa;
	private String modelo;
	private String marca;
	private float pagar; 
		
	
	public TicketDto(Ticket ticket) {
		this.id = ticket.getId();
		this.dataEntrada = ticket.getDataEntrada();
		this.dataSaida = ticket.getDataSaida();
		this.placa = ticket.getPlaca();
		this.modelo = ticket.getModelo();
		this.marca = ticket.getMarca();
		this.pagar = ticket.getPagar();
		this.tempoTotal = ticket.getTempoTotal();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
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

	public float getPagar() {
		return pagar;
	}

	public void setPagar(float pagar) {
		this.pagar = pagar;
	}
	

	public float getTempoTotal() {
		return tempoTotal;
	}

	public void setTempoTotal(float tempoTotal) {
		this.tempoTotal = tempoTotal;
	}

	public static List<TicketDto> convercao(List<Ticket> tickets){
		return tickets.stream().map(TicketDto::new).collect(Collectors.toList());
	}
	
}
