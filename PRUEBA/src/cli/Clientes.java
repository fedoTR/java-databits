package cli;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Clientes {
	/* 
	 * Variables
	 * 
	 *  */
	
	static Queue<Integer> clientesEnEspera = new PriorityQueue<>();
	// Almacena en un string modificable la cola
	static StringBuilder clientesCola = new StringBuilder();
	
	// Declara la pila de canastas
	static Stack<Integer> canastas = new Stack<>();
	
	// Almacena en un string modificable las canastas
	static StringBuilder canastasPila = new StringBuilder();
	

	/*
	 *	Métodos 
	 */
	
	// Rellena la fila la imprime la imprime y la pasa al label del Frame
	public String refillClientes() {
		if (clientesEnEspera.isEmpty() == true && clientesCola.isEmpty() == true) {
			for (int i = 0; i < 5; i++) {
				clientesEnEspera.offer(i);
				clientesCola.append(i);
			}
			System.out.println("Clientes en espera: "+ clientesEnEspera);
			System.out.println("Clientes en cola " + clientesCola);
		} else {
			JOptionPane.showMessageDialog(null, "AÚN HAY CLIENTES ESPERANDO");;
		}
		return clientesCola.toString();
				
	}
	
	// Vaía uno por uno la fila y al imprime
	public String dequeueClientes() {
		if (clientesEnEspera.isEmpty() == false && canastasPila.isEmpty() == false) {
			System.out.println("VALOR QUE YA NO EXISTE: " + clientesEnEspera.poll());
			clientesCola.deleteCharAt(0);
			System.out.println(clientesEnEspera);
			System.out.println(clientesCola);
		} else {
			JOptionPane.showMessageDialog(null, "FALTAN CLIENTES O CANASTAS");
		}
		return clientesCola.toString();
	}
	
	public String devolverCanastas() {
		int i = 0;
		do {
			if (canastas.size() > 9) {
				JOptionPane.showMessageDialog(null, "YA HAY CANASTAS");
				break;
			}
			canastas.push(i);
			canastasPila.append(i);
			i++;
			System.out.println(canastas.size());
		
		} while(canastas.size() < 10);
		return canastasPila.toString();
	}
	
	// Tomar canasta
	public String tomarCanasta() {
		
		if (canastas.isEmpty() == false && Clientes.clientesEnEspera.size() > 0) {
			System.out.println("Valor actual:" + canastas.peek());
			canastas.pop();
			canastasPila.deleteCharAt((canastas.size()));
		} else {
			System.out.println("CHECK");
		}
		return canastasPila.toString();	
	}
	
}	// FIN


