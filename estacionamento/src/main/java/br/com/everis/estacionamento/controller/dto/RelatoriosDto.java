package br.com.everis.estacionamento.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.everis.estacionamento.model.Ticket;
import br.com.everis.estacionamento.repository.TicketRepository;

public class RelatoriosDto {

	private LocalDateTime dataComeco;
	private LocalDateTime dataFinal;
	
	private double tempoDecorridoHoras = 0;
	private double totalPago = 0;
	private int totalIncompleto = 0;
	private int totalCompleto = 0;
	private List<Ticket> analizados = new ArrayList<Ticket>();
	
	public RelatoriosDto() {
	}

	public RelatoriosDto(LocalDateTime dataComeco, LocalDateTime dataFinal, TicketRepository ticketRepository) {
		this.dataComeco = dataComeco;
		this.dataFinal = dataFinal;

		for (Ticket ticket : ticketRepository.findAll()) {
			if (ticket.getDataEntrada().isAfter(dataComeco) && ticket.getDataEntrada().isAfter(dataFinal)) {
				analizados.add(ticket);			}
		}		
		
		for (Ticket ticket : analizados) {
			if(ticket.getDataSaida() != null) {
				tempoDecorridoHoras += ticket.getTempoTotal();
				totalPago += ticket.getPagar();
				totalCompleto++;
			}else {
				totalIncompleto++;
			}
		}
	}
	
	public void gerarRelatorio(TicketRepository ticketRepository) {
		
		for (Ticket ticket : ticketRepository.findAll()) {
			if (ticket.getDataEntrada().isAfter(dataComeco) && ticket.getDataEntrada().isBefore(dataFinal)) {
				analizados.add(ticket);			}
		}		
		
		for (Ticket ticket : analizados) {
			if(ticket.getDataSaida() != null) {
				tempoDecorridoHoras += ticket.getTempoTotal();
				totalPago += ticket.getPagar();
				totalCompleto++;
			}else {
				totalIncompleto++;
			}
		}
	}
	

	public LocalDateTime getDataComeco() {
		return dataComeco;
	}

	public void setDataComeco(LocalDateTime dataComeco) {
		this.dataComeco = dataComeco;
	}

	public LocalDateTime getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDateTime dataFinal) {
		this.dataFinal = dataFinal;
	}

	public double getTempoDecorridoHoras() {
		return tempoDecorridoHoras;
	}

	public void setTempoDecorridoHoras(double tempoDecorridoHoras) {
		this.tempoDecorridoHoras = tempoDecorridoHoras;
	}

	public double getTotalPago() {
		return totalPago;
	}

	public void setTotalPago(double totalPago) {
		this.totalPago = totalPago;
	}

	public int getTotalImcompleto() {
		return totalIncompleto;
	}

	public List<Ticket> getAnalizados() {
		return analizados;
	}

	public void setAnalizados(List<Ticket> analizados) {
		this.analizados = analizados;
	}

	public void setTotalImcompleto(int totalIncompleto) {
		this.totalIncompleto = totalIncompleto;
	}

	public int getTotalCompleto() {
		return totalCompleto;
	}

	public void setTotalCompleto(int totalCompleto) {
		this.totalCompleto = totalCompleto;
	}

}
