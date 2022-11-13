package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class ClientesRecientes extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Variables
	 */
	
	// Lista de clientes
	JList<String> gananciasLista;
	
	// Modelo de la lista de clientes
	DefaultListModel<String> gananciasModel = new DefaultListModel<>();
	
	// Lista para añadir los nombres
	ArrayList<Integer> listaDeGanancias = new ArrayList<>();
	
	// Control de boton de buscar
	boolean buscarNo = false;
	
	// Boton de buscar
	JButton btnBuscar = new JButton("Buscar");
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientesRecientes frame = new ClientesRecientes();
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
	public ClientesRecientes() {
		setBounds(100, 100, 450, 443);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPaneClientesLista = new JScrollPane();
		scrollPaneClientesLista.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneClientesLista.setBounds(110, 52, 232, 152);
		getContentPane().add(scrollPaneClientesLista);
		
		// Modelo de la lista
	
		// Añade la lista con modelo al scrollpane
		gananciasLista = new JList<>(gananciasModel);
		gananciasLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gananciasLista.setLayoutOrientation(JList.VERTICAL);
		scrollPaneClientesLista.setViewportView(gananciasLista);
		
		JLabel lblNewLabel = new JLabel("Ganancias por ciclo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(110, 24, 232, 16);
		getContentPane().add(lblNewLabel);
		
		
		JButton btnAñadirGanancia = new JButton("Simular ganancias");
		btnAñadirGanancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer a;
				for (int i = 0; i < 20; i++) {
					a = (int) (Math.random()*(500-20+1)+20);
					System.out.println(a);
					listaDeGanancias.add(a);
				}
				for (int i = 0; i < listaDeGanancias.size(); i++) {
					gananciasModel.addElement(listaDeGanancias.get(i).toString());
				}
				btnBuscar.setEnabled(false);
			}
		});
		btnAñadirGanancia.setBounds(12, 256, 168, 26);
		getContentPane().add(btnAñadirGanancia);
		
		JButton btnOrdenarLista = new JButton("Ordenar de menor a mayor");
		btnOrdenarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gananciasModel.isEmpty() == false) {
					listaDeGanancias.sort(null);
					gananciasModel.clear();
					for (int i = 0; i < listaDeGanancias.size(); i++) {
						gananciasModel.addElement(listaDeGanancias.get(i).toString());
					}
					btnBuscar.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Nada que ordenar");
				}
				
			}
		});
		btnOrdenarLista.setBounds(233, 256, 195, 26);
		getContentPane().add(btnOrdenarLista);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Binaria", "Secuencial"}));
		comboBox.setBounds(294, 325, 134, 25);
		getContentPane().add(comboBox);
		
		
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int searchMethod = comboBox.getSelectedIndex();			
				switch (searchMethod) {
				case 0:
					try {
						BinarySearch();
					} catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Ingresa un valor válido");
					}
					break;
				case 1:
					try {
						SequencialSearch();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Ingresa un valor válido");
					}
					break;			
				default:
					System.out.println("No deberías estar aquí");
				}
			}
		});
		btnBuscar.setBounds(329, 362, 99, 26);
		getContentPane().add(btnBuscar);
		
		JButton btnNukeGanancias = new JButton("Limpiar");
		btnNukeGanancias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "¿Borrar la lista?", "Atención", JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION) {
					System.out.println("Copiado hermano");
					gananciasModel.clear();
					listaDeGanancias.clear();			
				} else {
					if (res == JOptionPane.NO_OPTION) {
						System.out.println("Entendido");
					} else {
						System.out.println("Eh?");
					}
				}
				btnBuscar.setEnabled(false);
			}
		});
		btnNukeGanancias.setBounds(12, 305, 99, 26);
		getContentPane().add(btnNukeGanancias);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona el algoritmo de búsqueda:");
		lblNewLabel_1.setBounds(208, 297, 220, 16);
		getContentPane().add(lblNewLabel_1);

	}
	
	public void BinarySearch() {
		String valorBuscar = JOptionPane.showInputDialog(null, "Ingresa el valor a buscar");
		Integer a = Integer.valueOf(valorBuscar);
		if (listaDeGanancias.contains(a) == true) {
			int index = Collections.binarySearch(listaDeGanancias, a);
			JOptionPane.showMessageDialog(null, "Encontrado el valor " + a + " en: " + Collections.binarySearch(listaDeGanancias, a));
			gananciasLista.setSelectedIndex(index);
		} else {
			JOptionPane.showMessageDialog(null, "No se encontró\nPrueba a escribir bien el valor e inténtalo de nuevo");
		}
	}
	
	public void SequencialSearch() {
		String valorBuscar = JOptionPane.showInputDialog(null, "Ingresa el valor a buscar");
		Integer a = Integer.valueOf(valorBuscar);
		if (listaDeGanancias.contains(a) == true) {
			for (int i = 0; i < listaDeGanancias.size(); i++) {
				if (listaDeGanancias.get(i) == a) {
					JOptionPane.showMessageDialog(null, "Encontrado el valor " + a + " en el index: " + i);
					gananciasLista.setSelectedIndex(i);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se encontró\nPrueba a escribir bien el valor e inténtalo de nuevo");
		}
	}
}
