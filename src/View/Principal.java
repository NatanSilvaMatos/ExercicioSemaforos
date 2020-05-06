package View;

import java.util.concurrent.Semaphore;

import Controller.SemaforoController;

public class Principal {
	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		
		for(int idThread = 1;idThread <= 4;idThread++) {
			SemaforoController thread = new SemaforoController(idThread, semaforo);
		}
		
	}
}
