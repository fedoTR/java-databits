package cli;

import java.util.Stack;

import javax.swing.JOptionPane;

public class Charolas {
	// Declara la pila de canastas
	static Stack<Integer> canastas = new Stack<>();
	
	// Almacena en un string modificable las canastas
	static StringBuilder canastasPila = new StringBuilder();
	
	// Clientes
	Clientes clienteCheck = new Clientes();
	
	// Devolver canastas
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
		
		if (canastas.isEmpty() == false && Clientes.clientesEnEspera.isEmpty() == false) {
			canastas.peek();
			canastas.pop();
			canastasPila.deleteCharAt((canastas.size()));
		} else {
			System.out.println("CHECK");
		}
		return canastasPila.toString();	
	}
}



