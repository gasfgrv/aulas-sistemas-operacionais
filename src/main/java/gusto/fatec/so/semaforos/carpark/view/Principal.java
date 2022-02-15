package gusto.fatec.so.semaforos.carpark.view;

import java.util.concurrent.Semaphore;

import gusto.fatec.so.semaforos.carpark.controller.ThreadCar;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 3;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idCar = 0; idCar < 10; idCar++) {
			Thread tCar = new ThreadCar(idCar, semaforo);
			tCar.start();
		}
	}

}
