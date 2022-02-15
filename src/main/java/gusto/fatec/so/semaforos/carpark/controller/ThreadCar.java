package gusto.fatec.so.semaforos.carpark.controller;

import gusto.fatec.so.processos.controller.OpController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadCar extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadCar.class);

    private final int idCar;
    private final Semaphore semaforo;

    private static int posChegada;
    private static int posSaida;
    private Random random;

    public ThreadCar(int idCar, Semaphore semaforo) {
        this.idCar = idCar;
        this.semaforo = semaforo;
        this.random = new Random();
    }

    @Override
    public void run() {
        carroAndando();

        try {
            semaforo.acquire();
            carroParado();
            carroSaindo();
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        } finally {
            semaforo.release();
            Thread.currentThread().interrupt();
        }

    }

    private void carroParado() {
        String log = String.format("Carro: #%d Estacionou", idCar);
        LOGGER.info(log);

        int tempoParado = (random.nextInt(2000) + 1000);

        try {
            Thread.sleep(tempoParado);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private void carroAndando() {
        int distTotal = (random.nextInt(1001) + 2000);
        int distPecorrida = 0;
        int delocamento = 30;
        int tempo = 50;

        while (distPecorrida < distTotal) {
            distPecorrida += delocamento;

            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage());
                Thread.currentThread().interrupt();
            }

            String log = String.format("Carro: #%d andou %dm", idCar, distPecorrida);
            LOGGER.info(log);
        }

        setPosChegada();

        String log = String.format("Carro: #%d foi o %d° a chegar", idCar, posChegada);
        LOGGER.info(log);
    }

    private static void setPosChegada(){
        posChegada++;
    }

    private void carroSaindo() {
        setPosSaida();

        String log = String.format("Carro: #%d foi %d° a sair", idCar, posSaida);
        LOGGER.info(log);
    }

    private void setPosSaida() {
        posSaida++;
    }
}
