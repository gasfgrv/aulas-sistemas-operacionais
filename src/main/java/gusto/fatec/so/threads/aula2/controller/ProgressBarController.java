package gusto.fatec.so.threads.aula2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ProgressBarController implements ActionListener {
	private final JLabel lblNewLabel;
	private final JProgressBar progressBar;
	private final JButton btnIniciar;

	public ProgressBarController(JLabel lblNewLabel, JProgressBar progressBar, JButton btnIniciar) {
		this.lblNewLabel = lblNewLabel;
		this.progressBar = progressBar;
		this.btnIniciar = btnIniciar;
	}

	private void acaoBarra() {
		btnIniciar.setEnabled(false);
		Thread tBanner = new ThreadBanner(lblNewLabel, progressBar, btnIniciar);
		tBanner.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		acaoBarra();
	}

}
