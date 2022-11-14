package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;


public class ProductosFrame extends JInternalFrame {
	
	/*
	 *	VARIABLES LOCALES 
	 */
	
	// Lista de productos en String
	JList<String> productosList;

	// Modelo de la lista de peliculas
	DefaultListModel<String> listModel;
	
	// Arreglo de productos (Donde se harán todas las operaciones)
	Integer[] integerProductosLista = new Integer[10];
	
	// Modelo de tabla de inventario
	JTable tablaProductos = new JTable();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @wbp.nonvisual location=186,489
	 */
	
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductosFrame frame = new ProductosFrame();
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
	public ProductosFrame() {
		tablaProductos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tablaProductos.setModel(new DefaultTableModel(
			new Object[][] {	// Todos los valores aparecen vacíos en su estado inicial
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"ID", "Cosa"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaProductos.getColumnModel().getColumn(0).setResizable(false);
		tablaProductos.getColumnModel().getColumn(1).setResizable(false);
		tablaProductos.setBounds(232, 80, 126, 160);
		
		// Modelo de la lista de peliculas
		listModel = new DefaultListModel<>();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Productos en inventario");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 492);
		
		//Panel para guardar todos los demás componentes
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.add(tablaProductos);
		
		JLabel lblNewLabel = new JLabel("PRODUCTOS CON LOS QUE SE CUENTA\t");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 29);
		panel.add(lblNewLabel);
		
		// Botón para imprimir el ID de los productos actuales
		JButton btnImprimirProductos = new JButton("Ver productos actuales");		
		btnImprimirProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (integerProductosLista.length > 0) {
					generarListaPeliculas();
				} else {
					JOptionPane.showMessageDialog(null, "Operación ya realizada");
				}
			}
		});
		btnImprimirProductos.setBounds(10, 312, 160, 23);
		panel.add(btnImprimirProductos);
		
		// Combobox para seleccionar el método de ordenamiento
		JComboBox<String> comboBoxSortKind = new JComboBox<>();
		comboBoxSortKind.setModel(new DefaultComboBoxModel<String>(new String[] {"Burbuja", "Inserción", "Selection"}));
		comboBoxSortKind.setBounds(298, 312, 126, 22);
		panel.add(comboBoxSortKind);
		
		// Label del combobox ed ordenamiento
		JLabel lblNewLabel_1 = new JLabel("Ordenar por:");
		lblNewLabel_1.setBounds(339, 294, 85, 14);
		panel.add(lblNewLabel_1);
		
		// Desordenar películas
		JButton btnNewButton = new JButton("Desordenar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShuffleArray(integerProductosLista, integerProductosLista.length);
				actualizadorTabla();
				//listWatchDog();
			}
		});
		btnNewButton.setBounds(10, 356, 105, 23);
		panel.add(btnNewButton);
		
		// El scrollpane para guardar la JList
		JScrollPane scrollPanePeliculasList = new JScrollPane();
		scrollPanePeliculasList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPanePeliculasList.setBounds(53, 71, 62, 169);
		panel.add(scrollPanePeliculasList);
		productosList = new JList<>(listModel);
		productosList.setLayoutOrientation(JList.VERTICAL);	// La lista será vertical
		scrollPanePeliculasList.setViewportView(productosList);	
		
		// Boton de ordenar arreeglo
		JButton btnOrdenarPeliculas = new JButton("Ordenar");
		btnOrdenarPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBoxSortKind.getSelectedItem());
				int selection = comboBoxSortKind.getSelectedIndex();
				System.out.println(selection);
				switch (selection) {
					case 0:
						BubbleSort();
						actualizadorTabla();	// Siempre al final actualiza la tabla con los valores ordenados
					break;
					
					case 1:
						InsertionSort();
						actualizadorTabla();
					break;
					
					case 2:
						SelectionSort();
						actualizadorTabla();
					break;
					default:
						System.out.println("JA");
				}
			}
		});
		btnOrdenarPeliculas.setBounds(335, 356, 89, 23);
		panel.add(btnOrdenarPeliculas);
		
		JLabel lblNewLabel_2 = new JLabel("Id. Producto");
		lblNewLabel_2.setBounds(43, 48, 85, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Productos en tabla");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(232, 54, 126, 16);
		panel.add(lblNewLabel_3);
	}
	
	/* 
	 * METODOS
	 */
	
	// Genera la lista y la rellena
	public void generarListaPeliculas() {
		int auxiliarDeLista = 0;
		listModel.clear();
		for (int i = 0; i < integerProductosLista.length; i++) {
			integerProductosLista[i] = i;
			auxiliarDeLista = integerProductosLista[i];
			listModel.addElement(Integer.toString(auxiliarDeLista));
		}
		System.out.println(Arrays.toString(integerProductosLista));
		//tablaProductos.add(new Object[] {"0", "Manzana"});
	}
	
	// Desordena el arreglo	
	public void ShuffleArray(Integer[] peliculasLista, int a) {
		int auxiliarLista = 0;
		Random rd = new Random();
		listModel.clear();
		for (int i = a-1; i > 0; i--) {
			int j = rd.nextInt(i + 1);
			int temp = peliculasLista[i];
			peliculasLista[i] = peliculasLista[j];
			peliculasLista[j] = temp;
		}
		for (int i = 0; i < peliculasLista.length; i++) {
			auxiliarLista = peliculasLista[i];
			listModel.addElement(Integer.toString(auxiliarLista));
		}
		System.out.println(Arrays.toString(peliculasLista));
	}
	
	// Ordenamiento por burbuja
	public void BubbleSort() {
		int gnomo = 0;
		listModel.clear();
		int n = integerProductosLista.length;
		int temp = 0;
		for (int i = 0; i < (n-1); i++) {
			for (int j = 1; j < (n-i); j++) {
				// ORDENAMIENTO
				if (integerProductosLista[j-1] > integerProductosLista[j]) {
					temp = integerProductosLista[j-1];
					integerProductosLista[j-1] = integerProductosLista[j];
					integerProductosLista[j] = temp;
				}
				System.out.println(Arrays.toString(integerProductosLista));
			}		
		}
		for (int i = 0; i < integerProductosLista.length; i++) {
			gnomo = integerProductosLista[i];
			listModel.addElement(Integer.toString(gnomo));
		}
		System.out.println(Arrays.toString(integerProductosLista));
	}
	
	// Ordenamiento por inserción
	public void InsertionSort() {
		int auxiliarLista = 0;
		listModel.clear();
		for (int i = 1; i < integerProductosLista.length; i++) {
			int current = integerProductosLista[i];
			int j = i - 1;
			while (j >= 0 && current < integerProductosLista[j]) {
				integerProductosLista[j+1] = integerProductosLista[j];
				j--;
			}
			integerProductosLista[j+1] = current;
			System.out.println(Arrays.toString(integerProductosLista));
		}
		for (int i = 0; i < integerProductosLista.length; i++) {
			auxiliarLista = integerProductosLista[i];
			listModel.addElement(Integer.toString(auxiliarLista));
		}
		System.out.println(Arrays.toString(integerProductosLista));
		
	}
	
	// Ordenamiento por selección
	public void SelectionSort() {
		int auxiliarLista = 0;
		listModel.clear();
		for (int i = 0; i < integerProductosLista.length;i++){
			int min = integerProductosLista[i];
			int minId = i;
			for (int j = i+1; j < integerProductosLista.length; j++) {
				if (integerProductosLista[j] < min) {
					min = integerProductosLista[j];
					minId = j;
				}
			}
			// INTERCAMBIO
			int temp = integerProductosLista[i];
			integerProductosLista[i] = min;
			integerProductosLista[minId] = temp;
			System.out.println(Arrays.toString(integerProductosLista));
		}
		for (int i = 0; i < integerProductosLista.length; i++) {
			auxiliarLista = integerProductosLista[i];
			listModel.addElement(Integer.toString(auxiliarLista));
		}
		System.out.println(Arrays.toString(integerProductosLista));
	}
	
	// Método para actualizar la tabla después de ordenar
	public void actualizadorTabla() {
		borrarColumna();
		int j = 0;
		int auxiliarTabla = 0;
		for (int i = 0; i < integerProductosLista.length; i++) {
			System.out.println(integerProductosLista[i]);
			
			tablaProductos.setValueAt(integerProductosLista[i], j++, 0);
			if(j > integerProductosLista.length) {
				JOptionPane.showMessageDialog(null, "Alcanzado");
				break;
			}
		}
		for (int i = 0; i < integerProductosLista.length; i++) {
			auxiliarTabla = (int) tablaProductos.getValueAt(i, 0);
			switch(auxiliarTabla) {
			case 0:
				tablaProductos.setValueAt("Manzana", encuentraValor(auxiliarTabla), 1);
			break;
			case 1:
				tablaProductos.setValueAt("Sandía", encuentraValor(auxiliarTabla), 1);
			break;
			case 2:
				tablaProductos.setValueAt("Coco", encuentraValor(auxiliarTabla), 1);
			break;
			case 3:
				tablaProductos.setValueAt("Elote", encuentraValor(auxiliarTabla), 1);
			break;
			case 4:
				tablaProductos.setValueAt("Calabaza", encuentraValor(auxiliarTabla), 1);
			break;
			case 5:
				tablaProductos.setValueAt("Melón", encuentraValor(auxiliarTabla), 1);
			break;
			case 6:
				tablaProductos.setValueAt("Pepino", encuentraValor(auxiliarTabla), 1);
			break;
			case 7:
				tablaProductos.setValueAt("Brócoli", encuentraValor(auxiliarTabla), 1);
			break;
			case 8:
				tablaProductos.setValueAt("Rábanos", encuentraValor(auxiliarTabla), 1);
			break;
			case 9:
				tablaProductos.setValueAt("Ciruelas", encuentraValor(auxiliarTabla), 1);
			break;		
			default:
				JOptionPane.showMessageDialog(null, "Error inesperado");	
			}
		}		
	}
	
	// Método para encontrar un valor en el arreglo
	public int encuentraValor(Integer d) {
		for (int i = 0; i < tablaProductos.getRowCount(); i++) {
			for (int j = 0; j < tablaProductos.getColumnCount(); j++) {
				if (Objects.equals(d, tablaProductos.getValueAt(i, j))) {
					return i;
				}
			}
		}
		return -1;
	}
	
	// Método para limpiar la columna
	public void borrarColumna() {
		for (int i = 0; i < tablaProductos.getRowCount(); i++) {
			tablaProductos.setValueAt("", i, 1);
		}
	}
}

