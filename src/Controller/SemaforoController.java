package Controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaforoController extends Thread {
	private int idThread;
	private Semaphore semaforo;
	private static int travessiaCarros;
	private String sentidoInicial[] = {"Norte","Sul","Leste","Oeste"};
	private Random random = new Random();
	
	public SemaforoController(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
		start();
	}
	
	
	public void run() {
		try {
			semaforo.acquire();
			atravessa();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally{
			semaforo.release();
			liberaProximo();
		}
	}
	
	public void atravessa() {
		try {
			sleep(300);
			int destinoFinal = 30;
			int distancia = random.nextInt(4) + 1;
			int distanciaPercorrida = 0;
			while(distanciaPercorrida < destinoFinal) {
				distanciaPercorrida = distanciaPercorrida + distancia;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			switch(travessiaCarros) {
			case 0: System.out.println("O carro # " +  idThread + " começou na posição " + sentidoInicial[0]  + " e atravessou no sentido sul!");
			break;
			case 1: System.out.println("\nO carro # " + idThread + " começou na posição " + sentidoInicial[1]  + " e atravessou no sentido norte!");
			break;
			case 2: System.out.println("\nO carro # " + idThread + " começou na posição " + sentidoInicial[2]  + " e atravessou no sentido oeste!");
			break;
			case 3: System.out.println("\nO carro # " + idThread + " começou na posição " + sentidoInicial[3]  + " e atravessou no sentido leste!");
			break;
			}
			travessiaCarros++;
	}
		
	
	public void liberaProximo() {
		System.out.println("Próximo carro está liberado para atravessar!");
	}
}
