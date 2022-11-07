package cli;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Clientes {
	
	static Scanner sc = new Scanner(System.in);
	
	// Declare a Queue of clients, using Queue Interface
	static Queue<Integer> clientesCola =  new LinkedList<>();
	
	// Declare a Queue of ATTENDED clients
	static Queue<String> colaDulceria = new LinkedList<>();
	
	// Declare an ArrayList of Premium Clients
	static ArrayList<String> clientesPremium = new ArrayList<>();
	
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
	
	// Print clients on grocery store
	public static Queue<String> printClientesDulceria() {
		System.out.println("Clientes en dulceria: " + colaDulceria);
		return colaDulceria;
	}
	
	// Attend a client in grocery store queue
	public static void attendClienteDulceria() {
		String head = colaDulceria.peek();
		System.out.println("Añadir " + head + " al servicio premium?\n1-.Si\n2-.No");
		Integer ClienteDecision = sc.nextInt();
		if (ClienteDecision.equals(1)) {
			System.out.println(head + " ahora es premium!");
			clientesPremium.add(head);
		}
		else {			
			System.out.println("Cliente " + head + " atendido");
		}
		colaDulceria.remove(head);
	}
	
	// Print premium clients array
	public static void printClientesPremium() {
		System.out.println("Clientes premium: " + clientesPremium);
	}
	
}
