package gusto.fatec.so.threads.aula1.controller;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Rectangle;

public class BolinhaThread extends Thread {
	private final JLabel lblBolinha;
	private final JButton btnIniciar;

	public BolinhaThread(JLabel lblBolinha, JButton btnIniciar) {
		this.lblBolinha = lblBolinha;
		this.btnIniciar = btnIniciar;
	}

	private void mexeBolinha() {
		btnIniciar.setEnabled(false);
		Rectangle posicao = lblBolinha.getBounds();
		lblBolinha.setBounds(posicao);
		int contadorDeMov = 0;

		while (contadorDeMov <= 12) {
			if (contadorDeMov <= 2) {
				posicao.y = posicao.y + 10;
			} else if (contadorDeMov > 2 && contadorDeMov <= 6) {
				posicao.x = posicao.x + 20;
			} else if (contadorDeMov > 6 && contadorDeMov <= 9) {
				posicao.y = posicao.y - 10;
			} else {
				posicao.x = posicao.x - 20;
			}

			lblBolinha.setBounds(posicao);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}

			contadorDeMov++;
		}
	}

	@Override
	public void run() {
		mexeBolinha();
	}
}
