package br.com.everis.estacionamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstacionamentoApplication {
// INSERT INTO TICKET (DATA_ENTRADA  	, DATA_SAIDA  ,MARCA ,MODELO  ,PLACA  	,TEMPO_TOTAL  ) VALUES ('2016-12-13 21:45:23' , '2016-12-13 23:00:00 ',  'Toyota','Uno','mng-2467',3)
	public static void main(String[] args) {
		SpringApplication.run(EstacionamentoApplication.class, args);
	}

}
