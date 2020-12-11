package br.com.everis.estacionamento.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Ticket {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String placa;
	
	private LocalDate dataEntrada;
	
	private LocalDate dataSaida;
	
	@NotBlank
	private String modelo;
	
	@NotBlank
	private String marca;
	
	private Float preco; 
	
	public Ticket() {
		dataEntrada = LocalDate.now();
	}
	

	public Ticket(@NotBlank String placa, @NotBlank String modelo, @NotBlank String marca, Float preco) {
		dataEntrada = LocalDate.now();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.preco = preco;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
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

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}
	
	
}
