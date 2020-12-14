package br.com.everis.estacionamento.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
public class Ticket {

	@Transient
	private static float PRECOFIXO = 5;
	@Transient
	private static float PRECOHORA = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime dataEntrada;

	private LocalDateTime dataSaida;

	private float tempoTotal;
	@NotNull
	@NotEmpty
	private String placa;

	@NotNull
	@NotEmpty
	private String modelo;

	@NotNull
	@NotEmpty
	private String marca;

	private float pagar;

	private boolean completo;

	public Ticket() {
		dataEntrada = LocalDateTime.now(ZoneId.of("GMT-3"));
		this.completo = false;
	}

	public Ticket(String placa, String modelo, String marca) {

		dataEntrada = LocalDateTime.now(ZoneId.of("GMT-3"));
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.completo = false;
	}

	public float getTempoTotal() {
		return tempoTotal;
	}

	public void setTempoTotal(float tempoTotal) {
		this.tempoTotal = tempoTotal;
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

	public float getPagar() {
		return pagar;
	}

	public void setPagar(float pagar) {
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

	public boolean isCompleto() {
		return completo;
	}

	public void setCompleto(boolean completo) {
		this.completo = completo;
	}

	public float fixarSaida() {
		this.dataSaida = LocalDateTime.now(ZoneId.of("GMT-3"));
		this.tempoTotal = ChronoUnit.HOURS.between(this.dataEntrada, this.dataSaida);
		this.completo = true;
		if (tempoTotal < 1) {
			pagar = PRECOFIXO;
		} else {
			float horas = tempoTotal - 1;
			pagar = (horas * PRECOHORA) + PRECOFIXO;
		}
		return pagar;
	}

	public float fixarSaida(LocalDateTime saida) {
		this.dataSaida = saida;
		this.tempoTotal = ChronoUnit.HOURS.between(this.dataEntrada, this.dataSaida);
		this.completo = true;
		if (tempoTotal < 1) {
			pagar = PRECOFIXO;
		} else {
			float horas = tempoTotal - 1;
			pagar = (horas * PRECOHORA) + PRECOFIXO;
		}
		return pagar;
	}

	public static float precoAPagar(Ticket ticket) {
		if (ticket.dataSaida == null) {
			LocalDateTime provisorio = LocalDateTime.now(ZoneId.of("GMT-3"));
			float horas = ChronoUnit.HOURS.between(ticket.dataEntrada, provisorio);
			if (horas < 1) {
				return Ticket.PRECOFIXO;
			} else {
				horas--;
				return (horas * PRECOFIXO) + PRECOHORA;
			}
		} else {
			float horas = ChronoUnit.HOURS.between(ticket.dataEntrada, ticket.dataSaida);
			if (horas < 1) {
				return 5;
			} else {
				horas--;
				return (horas * PRECOFIXO) + PRECOHORA;
			}
		}
	}

}
