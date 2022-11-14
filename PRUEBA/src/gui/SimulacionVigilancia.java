package gui;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import cli.Arbol;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class SimulacionVigilancia extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Intancia de la clase Arbol
	Arbol arbolNuevo = new Arbol();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulacionVigilancia frame = new SimulacionVigilancia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimulacionVigilancia() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Patrullaje");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 202);
		getContentPane().setLayout(null);
		
		// Creación del panel que guarda todos los componentes
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Recorridos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(262, 33, 166, 130);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		// Botón para recorrer el árbol en PreOrder
		JButton btnRecorrerPreOrder = new JButton("Recorrer PreOrden");
		btnRecorrerPreOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!arbolNuevo.arbolVacio()) {
					arbolNuevo.preOrder(arbolNuevo.root);
					JOptionPane.showMessageDialog(null, "Orden de recorrido de estaciones PreOrder:\n" + arbolNuevo.mostrarArbolCompacto);
				} else {
					JOptionPane.showMessageDialog(null, "Ingresa un numero de estación primero");
				}
				arbolNuevo.mostrarArbolCompacto.setLength(0);
			}
		});
		panel.add(btnRecorrerPreOrder);
		
		// Botón para recorrer el árbol en InOrder
		JButton btnRecorrerInOrder = new JButton("Recorrer InOrden");
		btnRecorrerInOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!arbolNuevo.arbolVacio()) {
					arbolNuevo.inOrder(arbolNuevo.root);
					JOptionPane.showMessageDialog(null, "Orden de recorrido de estaciones InOrder:\n" + arbolNuevo.mostrarArbolCompacto);
				} else {
					JOptionPane.showMessageDialog(null, "Ingresa un numero de estación primero");
				}
				arbolNuevo.mostrarArbolCompacto.setLength(0);
			}
		});
		panel.add(btnRecorrerInOrder);
		
		// Botón para recorrer el árbol en PostOrder
		JButton btnNewButton = new JButton("Recorrer PostOrden\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!arbolNuevo.arbolVacio()) {
					arbolNuevo.postOrder(arbolNuevo.root);
					JOptionPane.showMessageDialog(null, "Orden de recorrido de estaciones PostOrder:\n" + arbolNuevo.mostrarArbolCompacto);
				} else {
					JOptionPane.showMessageDialog(null, "Ingresa un numero de estación primero");
				}
				arbolNuevo.mostrarArbolCompacto.setLength(0);
			}
		});
		panel.add(btnNewButton);
		
		// Panel para guardar los botones de control de arbol
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Control", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 66, 136, 91);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		// Botón para insertar nodos en el árbol
		JButton btnInsertarNodo = new JButton("Iniciar registro\n");
		panel_1.add(btnInsertarNodo);
		
		// Botón para buscar una estación (Nodo en el árbol)
		JButton btnBuscarEstacion = new JButton("Buscar Estación");
		btnBuscarEstacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!arbolNuevo.arbolVacio()) {	// Verifica si el árbol está vacío
					Integer element;
					element = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa un numero de estación para buscar"));
					arbolNuevo.buscarEstacion(element);
					if (arbolNuevo.buscarEstacion(element) == null) {
						JOptionPane.showMessageDialog(null, "No se encontró la estación " + element);
					} else {
						JOptionPane.showMessageDialog(null, "Si se encontró la estación " + element);
					}
				} else {
					JOptionPane.showMessageDialog(null, "No se encontró la estación");
				}
				arbolNuevo.mostrarArbolCompacto.setLength(0);	// Reinicia el stringbuilder
			}
		});
		panel_1.add(btnBuscarEstacion);
		
		// indica que el nodo 1 es la estación central
		JLabel lblNewLabel = new JLabel("1 = Estación Central");
		lblNewLabel.setBounds(10, 10, 157, 13);
		getContentPane().add(lblNewLabel);
		btnInsertarNodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer elemento;
					elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa un numero de estación"));
					arbolNuevo.insertarNodo(elemento);	// Inserta el valor indicado en el árbol
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Selecciona una opción o ingresa un campo válido");
				}
			}
		});
	}
}
