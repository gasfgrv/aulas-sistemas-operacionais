package gusto.fatec.so.threads.aula2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ThreadBanner extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadBanner.class);

    private final JLabel lblNewLabel;
    private final JProgressBar progressBar;
    private final JButton btnIniciar;

    public ThreadBanner(JLabel lblNewLabel, JProgressBar progressBar, JButton btnIniciar) {
        this.lblNewLabel = lblNewLabel;
        this.progressBar = progressBar;
        this.btnIniciar = btnIniciar;
    }

    private void geraBanner() {
        btnIniciar.setEnabled(false);
        Thread tBarra = new ThreadProgressBar(progressBar);
        tBarra.start();
        int contador = 1;
        String texto = "";

        while (tBarra.isAlive()) {
            switch (contador) {
                case 1:
                    texto = "Boa";
                    break;
                case 2:
                    texto = "Tarde";
                    break;
                case 3:
                    texto = "Galera";
                    break;
                default:
                    LOGGER.warn("Opção inválida");
            }

            lblNewLabel.setText(texto);
            contador++;

            if (contador == 4) {
                contador = 1;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        btnIniciar.setEnabled(true);
    }

    @Override
    public void run() {
        geraBanner();
    }
}
