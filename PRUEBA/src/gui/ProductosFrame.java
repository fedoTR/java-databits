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
	
	// LOCAL VARIABLES
	
	// Lista de peliculas
	JList<String> peliculasList;

	// Modelo de la lista de peliculas
	DefaultListModel<String> listModel;
	
	// Lista de peliculas (CRUDO)
	Integer[] peliculasLista = new Integer[10];
	
	// Modelo de tabla de inventario
	JTable tablaProductos = new JTable();
	
	
	// DefaultTableModel table = (DefaultTableModel) tablaProductos.getModel(); 
	
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
			new Object[][] {
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
		setBounds(100, 100, 450, 449);
		
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.add(tablaProductos);
		
		JLabel lblNewLabel = new JLabel("PRODUCTOS CON LOS QUE SE CUENTA\t");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 29);
		panel.add(lblNewLabel);
		
		// Imprimir peliculas
		JButton btnImprimriPeliculas = new JButton("Ver productos actuales");		
		btnImprimriPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (peliculasLista.length > 0) {
					generarListaPeliculas();
				} else {
					JOptionPane.showMessageDialog(null, "Operación ya realizada");
				}
			}
		});

		btnImprimriPeliculas.setBounds(10, 312, 160, 23);
		panel.add(btnImprimriPeliculas);
		
		// Combobox para seleccionar el método de ordenamiento
		JComboBox<String> comboBoxSortKind = new JComboBox<>();
		comboBoxSortKind.setModel(new DefaultComboBoxModel<String>(new String[] {"Burbuja", "Inserción", "Selection"}));
		comboBoxSortKind.setBounds(298, 312, 126, 22);
		panel.add(comboBoxSortKind);
		
		// Label del combobox ed ordenamiento
		JLabel lblNewLabel_1 = new JLabel("Ordenar por:");
		lblNewLabel_1.setBounds(352, 294, 72, 14);
		panel.add(lblNewLabel_1);
		
		// Desordenar películas
		JButton btnNewButton = new JButton("Desordenar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShuffleArray(peliculasLista, peliculasLista.length);
				falseUpdater();
				//listWatchDog();
			}
		});
		btnNewButton.setBounds(10, 356, 105, 23);
		panel.add(btnNewButton);
		
		// El scrollpane para la jlist
		JScrollPane scrollPanePeliculasList = new JScrollPane();
		scrollPanePeliculasList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPanePeliculasList.setBounds(53, 71, 62, 169);
		panel.add(scrollPanePeliculasList);
		
		peliculasList = new JList<>(listModel);
		peliculasList.setLayoutOrientation(JList.VERTICAL);
		scrollPanePeliculasList.setViewportView(peliculasList);	
		
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
						falseUpdater();
					break;
					
					case 1:
						InsertionSort();
						falseUpdater();
					break;
					
					case 2:
						SelectionSort();
						falseUpdater();
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
		int gnomo = 0;
		listModel.clear();
		for (int i = 0; i < peliculasLista.length; i++) {
			peliculasLista[i] = i;
			gnomo = peliculasLista[i];
			listModel.addElement(Integer.toString(gnomo));
		}
		System.out.println(Arrays.toString(peliculasLista));
		//tablaProductos.add(new Object[] {"0", "Manzana"});
	}
	
	// Desordena el arreglo	
	public void ShuffleArray(Integer[] peliculasLista, int a) {
		int gnomo = 0;
		Random rd = new Random();
		listModel.clear();
		for (int i = a-1; i > 0; i--) {
			int j = rd.nextInt(i + 1);
			int temp = peliculasLista[i];
			peliculasLista[i] = peliculasLista[j];
			peliculasLista[j] = temp;
		}
		for (int i = 0; i < peliculasLista.length; i++) {
			gnomo = peliculasLista[i];
			listModel.addElement(Integer.toString(gnomo));
		}
		System.out.println(Arrays.toString(peliculasLista));
	}
	
	// Ordenamiento por burbuja
	public void BubbleSort() {
		int gnomo = 0;
		listModel.clear();
		int n = peliculasLista.length;
		int temp = 0;
		for (int i = 0; i < (n-1); i++) {
			for (int j = 1; j < (n-i); j++) {
				// ORDENAMIENTO
				if (peliculasLista[j-1] > peliculasLista[j]) {
					temp = peliculasLista[j-1];
					peliculasLista[j-1] = peliculasLista[j];
					peliculasLista[j] = temp;
				}
				System.out.println(Arrays.toString(peliculasLista));
			}		
		}
		for (int i = 0; i < peliculasLista.length; i++) {
			gnomo = peliculasLista[i];
			listModel.addElement(Integer.toString(gnomo));
		}
		System.out.println(Arrays.toString(peliculasLista));
	}
	
	// Ordenamiento por inserción
	public void InsertionSort() {
		int gnomo = 0;
		listModel.clear();
		for (int i = 1; i < peliculasLista.length; i++) {
			int current = peliculasLista[i];
			int j = i - 1;
			while (j >= 0 && current < peliculasLista[j]) {
				peliculasLista[j+1] = peliculasLista[j];
				j--;
			}
			peliculasLista[j+1] = current;
			System.out.println(Arrays.toString(peliculasLista));
		}
		for (int i = 0; i < peliculasLista.length; i++) {
			gnomo = peliculasLista[i];
			listModel.addElement(Integer.toString(gnomo));
		}
		System.out.println(Arrays.toString(peliculasLista));
		
	}
	
	// Ordenamiento por selección
	public void SelectionSort() {
		int gnomo = 0;
		listModel.clear();
		for (int i = 0; i < peliculasLista.length;i++){
			int min = peliculasLista[i];
			int minId = i;
			for (int j = i+1; j < peliculasLista.length; j++) {
				if (peliculasLista[j] < min) {
					min = peliculasLista[j];
					minId = j;
				}
			}
			// INTERCAMBIO
			int temp = peliculasLista[i];
			peliculasLista[i] = min;
			peliculasLista[minId] = temp;
			System.out.println(Arrays.toString(peliculasLista));
		}
		for (int i = 0; i < peliculasLista.length; i++) {
			gnomo = peliculasLista[i];
			listModel.addElement(Integer.toString(gnomo));
		}
		System.out.println(Arrays.toString(peliculasLista));
	}
	
	public void falseUpdater() {
		nukeColumn();
		int j = 0;
		int ayudanteGnomo = 0;
		for (int i = 0; i < peliculasLista.length; i++) {
			System.out.println(peliculasLista[i]);
			
			tablaProductos.setValueAt(peliculasLista[i], j++, 0);
			if(j > peliculasLista.length) {
				JOptionPane.showMessageDialog(null, "Alcanzado");
				break;
			}
		}
		for (int i = 0; i < peliculasLista.length; i++) {
			ayudanteGnomo = (int) tablaProductos.getValueAt(i, 0);
			switch(ayudanteGnomo) {
			case 0:
				tablaProductos.setValueAt("Manzana", encuentraFido(ayudanteGnomo), 1);
			break;
			case 1:
				tablaProductos.setValueAt("Sandía", encuentraFido(ayudanteGnomo), 1);
			break;
			case 2:
				tablaProductos.setValueAt("Coco", encuentraFido(ayudanteGnomo), 1);
			break;
			case 3:
				tablaProductos.setValueAt("Elote", encuentraFido(ayudanteGnomo), 1);
			break;
			case 4:
				tablaProductos.setValueAt("Calabaza", encuentraFido(ayudanteGnomo), 1);
			break;
			case 5:
				tablaProductos.setValueAt("Melón", encuentraFido(ayudanteGnomo), 1);
			break;
			case 6:
				tablaProductos.setValueAt("Pepino", encuentraFido(ayudanteGnomo), 1);
			break;
			case 7:
				tablaProductos.setValueAt("Brócoli", encuentraFido(ayudanteGnomo), 1);
			break;
			case 8:
				tablaProductos.setValueAt("Rábanos", encuentraFido(ayudanteGnomo), 1);
			break;
			case 9:
				tablaProductos.setValueAt("Ciruelas", encuentraFido(ayudanteGnomo), 1);
			break;
			
			default:
					
			}
		}
			
	}
	public int encuentraFido(Integer mike) {
		for (int i = 0; i < tablaProductos.getRowCount(); i++) {
			for (int j = 0; j < tablaProductos.getColumnCount(); j++) {
				if (Objects.equals(mike, tablaProductos.getValueAt(i, j))) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public void nukeColumn() {
		for (int i = 0; i < tablaProductos.getRowCount(); i++) {
			tablaProductos.setValueAt("", i, 1);
		}
	}
}

