package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;

import cli.Clientes;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;


public class InitialFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreCliente;
	private JInternalFrame atencionCajaFrame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialFrame frame = new InitialFrame();
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
	public InitialFrame() {
		
		ProductosFrame cartelera = new ProductosFrame();	
		cartelera.setLocation(563, 24);
		setMinimumSize(new Dimension(1500, 500));
		setLocationByPlatform(true);
		setLocation(0,0);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\elyto\\Downloads\\V4CBMZ8eLJu6DQ6i4iHR--1--K3UNI.jpg"));
		setTitle("SIMULADOR DE SUPERMERCADO");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 1474, 81);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel button_menu_container = new JPanel();
		button_menu_container.setBounds(12, 43, 1040, 26);
		panel.add(button_menu_container);
		button_menu_container.setLayout(new GridLayout(1, 0, 0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(112, 128, 144));
		desktopPane.setBounds(10, 93, 1464, 776);
		contentPane.add(desktopPane);
		desktopPane.add(cartelera);
			
		atencionCajaFrame = new JInternalFrame("Atención en caja");
		atencionCajaFrame.setBounds(89, 24, 420, 449);
		atencionCajaFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		atencionCajaFrame.setEnabled(false);
		atencionCajaFrame.setIconifiable(true);
		atencionCajaFrame.setClosable(true);
		atencionCajaFrame.setVisible(false);
		desktopPane.setLayout(null);
		desktopPane.add(atencionCajaFrame);	
		atencionCajaFrame.getContentPane().setLayout(null);
		
		JLabel lblAtencionCajaFrame = new JLabel("Recuerda que la fila de atención se rellena cada 5 personas");
		lblAtencionCajaFrame.setFont(new Font("Dialog", Font.BOLD, 13));
		lblAtencionCajaFrame.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtencionCajaFrame.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAtencionCajaFrame.setBounds(12, 12, 386, 24);
		atencionCajaFrame.getContentPane().add(lblAtencionCajaFrame);
		
		JPanel filaClientes = new JPanel();
		filaClientes.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Control de fila", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		filaClientes.setBounds(12, 62, 224, 51);
		atencionCajaFrame.getContentPane().add(filaClientes);
		
		JLabel lblFilaCrudaPlaceholder = new JLabel("(Aqui aparecerá la fila con numeros)");
		lblFilaCrudaPlaceholder.setForeground(new Color(128, 128, 128));
		lblFilaCrudaPlaceholder.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblFilaCrudaPlaceholder.setHorizontalTextPosition(SwingConstants.LEFT);
		lblFilaCrudaPlaceholder.setHorizontalAlignment(SwingConstants.LEFT);
		filaClientes.add(lblFilaCrudaPlaceholder);
		
		JPanel controlesAtencionCaja = new JPanel();
		controlesAtencionCaja.setBorder(new TitledBorder(null, "Controles de atenci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		controlesAtencionCaja.setBounds(12, 207, 386, 93);
		atencionCajaFrame.getContentPane().add(controlesAtencionCaja);
		controlesAtencionCaja.setLayout(new GridLayout(2, 3, 0, 5));
		
		JLabel lblPedirNombreCliente = new JLabel("Nombre de cliente");
		lblPedirNombreCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPedirNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedirNombreCliente.setFont(new Font("Dialog", Font.PLAIN, 12));
		controlesAtencionCaja.add(lblPedirNombreCliente);
		
		nombreCliente = new JTextField();
		nombreCliente.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		nombreCliente.setToolTipText("(Aqui va el nombre)");
		controlesAtencionCaja.add(nombreCliente);
		nombreCliente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Total a pagar:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		controlesAtencionCaja.add(lblNewLabel);
		
		textField = new JTextField();
		controlesAtencionCaja.add(textField);
		textField.setColumns(10);
		
		
		
		// Rellena la fila y actualiza el label
		JButton btnRefillFilaCruda = new JButton("Pasar 5");
		btnRefillFilaCruda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				lblFilaCrudaPlaceholder.setText(clientes.refillClientes());
			}
		});
		btnRefillFilaCruda.setBounds(249, 75, 98, 26);
		atencionCajaFrame.getContentPane().add(btnRefillFilaCruda);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Canastas disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 146, 224, 49);
		atencionCajaFrame.getContentPane().add(panel_1);
		
		// JLabel donde aparecen las canastas
		JLabel lblCanastasDisponibles = new JLabel("(Aqui aparecerán las canastas)");
		lblCanastasDisponibles.setForeground(Color.GRAY);
		lblCanastasDisponibles.setFont(new Font("Dialog", Font.ITALIC, 12));
		panel_1.add(lblCanastasDisponibles);
		
		// Botón para devolver o rellenar las canastas perdidas
		JButton btnRellenarCanastas = new JButton("Devolver canastas");
		btnRellenarCanastas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				lblCanastasDisponibles.setText(clientes.devolverCanastas());
			}
		});
		btnRellenarCanastas.setBounds(249, 162, 149, 26);
		atencionCajaFrame.getContentPane().add(btnRellenarCanastas);
		
		// Decrementa la fila y actualiza el label
				JButton btnRegistrarAtencion = new JButton("Atender");
				btnRegistrarAtencion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Clientes clientes = new Clientes();
						//clientes.dequeueClientes();
						lblFilaCrudaPlaceholder.setText(clientes.dequeueClientes());;
						lblCanastasDisponibles.setText(clientes.tomarCanasta());
					}
				});
				btnRegistrarAtencion.setBounds(158, 333, 98, 26);
				atencionCajaFrame.getContentPane().add(btnRegistrarAtencion);
		
		JButton btnAtencionCaja = new JButton("Atención en caja");
		btnAtencionCaja.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				System.out.println("CAJA");
				if (atencionCajaFrame.isVisible() == true) {
					JOptionPane.showMessageDialog(null, "Ya se encuentra abierto");
				} else {
					atencionCajaFrame.setVisible(true);	
				}							
			}
		});
		btnAtencionCaja.setToolTipText("Atención de clientes");
		button_menu_container.add(btnAtencionCaja);
		
		// Botón de ver cartelera
		JButton btnVerCartelera = new JButton("Revisión de producto");
		btnVerCartelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartelera.setVisible(true);
			}
		});
		button_menu_container.add(btnVerCartelera);
		
		JLabel lblTitle = new JLabel("BIENVENID@ AL MENÚ");
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setHorizontalTextPosition(SwingConstants.LEFT);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitle.setBounds(12, 12, 1040, 26);
		panel.add(lblTitle);
		
	}
	public JInternalFrame getAtencionCajaFrame() {
		return atencionCajaFrame;
		
	}
}
