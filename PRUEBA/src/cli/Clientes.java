package cli;

import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.JOptionPane;

public class Clientes {
	/* 
	 * Variables
	 * 
	 *  */
	
	static Queue<Integer> clientesEnEspera = new PriorityQueue<>();
	// Almacena en un string modificable la cola
	static StringBuilder clientesCola = new StringBuilder();
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
			System.out.println(clientesEnEspera);
			System.out.println(clientesCola);
		} else {
			JOptionPane.showMessageDialog(null, "AÚN HAY CLIENTES ESPERANDO");;
		}
		return clientesCola.toString();
				
	}
	
	// Vaía uno por uno la fila y al imprime
	public String dequeueClientes() {
		if (clientesEnEspera.isEmpty() == false) {
			System.out.println(clientesEnEspera.poll());
			clientesCola.deleteCharAt(0);
			System.out.println(clientesEnEspera);
			System.out.println(clientesCola);
		} else {
			JOptionPane.showMessageDialog(null, "FAVOR DE RELLENAR FILA");;
		}
		return clientesCola.toString();
	}
	
}	// FIN


