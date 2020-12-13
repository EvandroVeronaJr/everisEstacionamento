package br.com.everis.estacionamento.controller.dto;

import java.time.LocalDateTime;

public class RelatoriosDto {
	
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private double tempoDecorridoHoras;
	private double totalPago;
	private int totalImcompleto;
	private int totalCompleto;
	
	
	
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
	
	
	

}
