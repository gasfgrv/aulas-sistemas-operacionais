package gusto.fatec.so.processos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OpController.class);
	
	public void preencheString(){
		String palavra = "";
		double tempoInicial = System.nanoTime();

		for (int i = 0; i <= 32768; i++) {
			palavra += "a";
		}

		double tempoFinal = System.nanoTime();
		double tempoGasto = tempoFinal - tempoInicial;
		tempoGasto /= Math.pow(10, 9);

		String log = String.format("String --> %ss.", tempoGasto);
		LOGGER.info(log);
	}

	public void preencheBuffer(){
		StringBuffer buffer = new StringBuffer();
		double tempoInicial = System.nanoTime();

		for (int i = 0; i <= 32768; i++) {
			buffer.append("a");
		}

		double tempoFinal = System.nanoTime();
		double tempoGasto = tempoFinal - tempoInicial;
		tempoGasto /= Math.pow(10, 9);

		String log = String.format("Buffer --> %ss.", tempoGasto);
		LOGGER.info(log);
	}
	
	public void quebraFrase(String frase){
		String[] vetFrase = frase.split(" ");
		for (String palavra : vetFrase) {
			LOGGER.info(palavra);
		}
	}
}
