package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	ArrayList<Float> listaDeGanancias = new ArrayList<>();
	
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
				Float a;
				Float b;
				for (int i = 0; i < 20; i++) {
					a = (float) (Math.random()*(500-20+1)+20);
					b = (float) (Math.round(a*100.0) / 100.0);
					System.out.println(b);
					listaDeGanancias.add(b);
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
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Binaria"}));
		comboBox.setBounds(294, 325, 134, 25);
		getContentPane().add(comboBox);
		
		
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listaDeGanancias.get(0) > listaDeGanancias.get(1)) {
					JOptionPane.showMessageDialog(null, "No esta ordenada");
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

	}
}
