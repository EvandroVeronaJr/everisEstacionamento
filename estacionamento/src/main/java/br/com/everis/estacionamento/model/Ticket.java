package br.com.everis.estacionamento.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity	
public class Ticket {


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dataEntrada;
	
	private LocalDateTime dataSaida;
	@NotNull 
	private String placa;
	
	@NotNull 
	private String modelo;
	
	@NotNull 
	private String marca;
	
	private Double pagar; 
	
	public Ticket() {
		dataEntrada = LocalDateTime.now(ZoneId.of("GMT-3"));
		
	}

	public Ticket(String placa, String modelo, String marca) {

		dataEntrada = LocalDateTime.now(ZoneId.of("GMT-3"));
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
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

	public Double getPagar() {
		return pagar;
	}

	public void setPagar(Double pagar) {
		this.pagar = pagar;
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
	
//	public static double precoAPagar(Ticket ticket) {
//		if(ticket.dataSaida==null) {
//			LocalDate provisorio = LocalDate.now(ZoneId.of("GMT-3"));
//			
//		}
//	}
	
}
