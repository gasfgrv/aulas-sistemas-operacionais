package gusto.fatec.so.semaforos.carpark.controller;

import java.util.concurrent.Semaphore;

public class ThreadCar extends Thread {

	private int idCar;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;

	public ThreadCar(int idCar, Semaphore semaforo) {
		this.idCar = idCar;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		carroAndando();
		try {
			semaforo.acquire();
			carroParado();
			carroSaindo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void carroParado() {
		System.out.println("Carro: #" + idCar + " Estacionou");
		int tempoParado = (int) ((Math.random() * 2000) + 1000);
		try {
			Thread.sleep(tempoParado);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void carroAndando() {
		int distTotal = (int) ((Math.random() * 1001) + 2000);
		int distPecorrida = 0;
		int delocamento = 30;
		int tempo = 50;
		while (distPecorrida < distTotal) {
			distPecorrida += delocamento;
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("Carro: #" + idCar + " andou " + distPecorrida + "m");
		}
		posChegada++;
		System.out.println("Carro: #" + idCar + " foi o " + posChegada + "� a chegar");
	}

	private void carroSaindo() {
		posSaida++;
		System.out.println("Carro: #" + idCar + " foi " + posSaida + "� a sair");
	}
}
