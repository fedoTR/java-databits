package cli;

public class Arbol {
	public Nodo root;	// Nodo raíz, padre 
	
	// Constructor del árbol
	public Arbol() {
		root = null;
	}
	// Objeto público para poder guardar los nodos en un solo String
	public StringBuilder mostrarArbolCompacto = new StringBuilder();
	
	// Inserción de nodos
	public void insertarNodo(int d) {
		Nodo nuevo = new Nodo(d);
		// Revisa si hay un nodo en raíz
		if (root == null) {
			root = nuevo;
		} else {
			Nodo auxiliar = root;
			Nodo padre;
			while (true) {
				padre = auxiliar;
				if (d < auxiliar.dato) {
					auxiliar = auxiliar.nodoIzquierdo;
					if (auxiliar == null) {
						padre.nodoIzquierdo = nuevo;
						return;
					}
				} else {
					auxiliar = auxiliar.nodoDerecho;
					if (auxiliar == null) {
						padre.nodoDerecho = nuevo;
						return;
					}
				}
			}
		}
	}
	
	// Checa si el arbol está vacío
	public boolean arbolVacio() {
		return root == null;
	}
	
	// Recorre el árbol InOrden
	// r es root
	public void inOrder(Nodo r) {
		if(r != null) {
			inOrder(r.nodoIzquierdo);
			mostrarArbolCompacto.append(r.dato + " ");
			System.out.println(r.dato);
			inOrder(r.nodoDerecho);
		}
	}
	
	// Recorre el árbol PreOrden
	// r es root
	public void preOrder(Nodo r) {
		if(r != null) {
			System.out.println(r.dato);
			mostrarArbolCompacto.append(r.dato + " ");
			preOrder(r.nodoIzquierdo);
			preOrder(r.nodoDerecho);
		}
	}
	
	// Recorre el árbol PostOrden
	// r es root
	public void postOrder(Nodo r) {
		if(r != null) {
			postOrder(r.nodoIzquierdo);
			postOrder(r.nodoDerecho);
			System.out.println(r.dato);
			mostrarArbolCompacto.append(r.dato + " ");
		}
	}
	
	// Busca una estación (Nodo en el árbol)
	public Nodo buscarEstacion(int d) {
		Nodo aux = root;
		while (aux.dato != d) {
			if(d < aux.dato) {
				aux = aux.nodoIzquierdo;
			} else {
				aux = aux.nodoDerecho;
			}
			if (aux == null) {
				return null;
			}
		}
		return aux;
	}
}
