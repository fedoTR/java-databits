package cli;


public class Nodo {
	// Variable para imprimir
	String mostrarArbol;
	
	// Variable para mostrar todo el arbol en una linea
	StringBuilder arbolCompacto = new StringBuilder();
	
	int dato; 
	Nodo nodoIzquierdo;
	Nodo nodoDerecho;
	
	// Constructor
	public Nodo(int d) {
		this.dato = d;
		this.nodoDerecho = null;
		this.nodoIzquierdo = null;
	}
	
	// Método para imprimir los nodos del árbol
	public String toString() {
		mostrarArbol.concat(String.valueOf(dato) + " ");
		return mostrarArbol;
	}
	
}
