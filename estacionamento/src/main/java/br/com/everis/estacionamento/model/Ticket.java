package br.com.everis.estacionamento.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity	
public class Ticket {


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate dataEntrada;
	
	private LocalDate dataSaida;
	@NotNull 
	private String placa;
	
	@NotNull 
	private String modelo;
	
	@NotNull 
	private String marca;
	
	private Double pagar; 
	
	public Ticket() {
		dataEntrada = LocalDate.now();
	}

	public Ticket(String placa, String modelo, String marca) {
		dataEntrada = LocalDate.now();
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

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
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
	
	
	
}
