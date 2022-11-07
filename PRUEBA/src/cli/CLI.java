package cli;

import java.util.Scanner;

public class CLI {
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// Attend in a step of 5
			for (int i = 0; i < 5; ++i) {
				Clientes.addToClientes(i);
			}
					
			Clientes.printClientes();
			System.out.println(Clientes.isClientesEmpty());
			
			for (int i = 0; i < 5; ++i) {
				System.out.println("Nombre del cliente " + Clientes.clientesCola.peek());
				String clientName = sc.nextLine();
				Clientes.attendCliente(clientName);
			}
			System.out.println("Clientes en dulcería (atendidos):" + Clientes.colaDulceria);
			Clientes.printClientes();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
}

