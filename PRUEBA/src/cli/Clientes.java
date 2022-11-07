package cli;

import java.util.LinkedList;
import java.util.Queue;


public class Clientes {
	
	// Declare a Queue of clients, using Queue Interface
	static Queue<Integer> clientesCola =  new LinkedList<>();
	
	// Declare a Queue of ATTENDED clients
	static Queue<String> colaDulceria = new LinkedList<>();
	
	// Add a client to the queue
	public static void addToClientes(int a) {
		clientesCola.add(a);
	}
	
	// Print queue of clients
	public static void printClientes() {
		System.out.println("Clientes: " + clientesCola);
	}
	
	// Check if the queue has been cleared
	public static boolean isClientesEmpty() {
		if (clientesCola.size() == 0){
			System.out.println("YA NO HAY CLIENTES");
			return true;
		}
		return false;
	}
	
	// Attend a client
	public static void attendCliente(String name) {
		int head = clientesCola.peek();
		clientesCola.remove(head);
		colaDulceria.add(name);
	}
	
}
