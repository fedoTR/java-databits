package cli;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Clientes {
	/* 
	 * Variables
	 * 
	 *  */
	// Instanica de ArrayList	(Arreglo)
	static ArrayList<Integer> controlFila = new ArrayList<>(); 
	static StringBuilder controlFilaString = new StringBuilder();
	static String controlFilaStringToLabel;

	/*
	 *	Métodos 
	 */
	
	// Genera el arreglo de control de fila
	
	public static String generarClientesFila() {
		if (controlFila.size() <= 0){
			// Limpia el StringBuilder
			controlFilaString.setLength(0);
			
			// Rellena la muestra de la fila
			for (int i = 0; i < 5; ++i) {
				controlFila.add(i);			
			}			
			System.out.println(controlFila);
			for (int i = 0; i < 5; ++i) {
				controlFilaString.append(controlFila.get(i) + " ");
			}
			System.out.println("FILA STRING: " + controlFilaString);
			controlFilaStringToLabel = controlFilaString.toString();
		} else {
			JOptionPane.showMessageDialog(null, "Primero atiende a los 5");
		}
		return controlFilaStringToLabel;		
	}
	
	public static String atenderClientesFila() {
			controlFila.remove(0);
			return controlFilaStringToLabel = controlFila.toString();	
		}		
}


