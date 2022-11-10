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
import javax.swing.JComboBox;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		EventQueue.invokeLater(new Runnable() {
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
		setMinimumSize(new Dimension(1080, 920));
		setLocationByPlatform(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\elyto\\Downloads\\V4CBMZ8eLJu6DQ6i4iHR--1--K3UNI.jpg"));
		setTitle("SIMULADOR DE CINE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 1064, 81);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel button_menu_container = new JPanel();
		button_menu_container.setBounds(12, 43, 1040, 26);
		panel.add(button_menu_container);
		button_menu_container.setLayout(new GridLayout(1, 0, 0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(112, 128, 144));
		desktopPane.setBounds(10, 93, 1042, 776);
		contentPane.add(desktopPane);
			
		JInternalFrame atencionCajaFrame = new JInternalFrame("Atención en caja");
		atencionCajaFrame.setBounds(451, 23, 420, 409);
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
		
		JPanel filaClientesAtendidos = new JPanel();
		filaClientesAtendidos.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Fila de atendidos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		filaClientesAtendidos.setBounds(12, 133, 224, 51);
		atencionCajaFrame.getContentPane().add(filaClientesAtendidos);
		
		JLabel lblClientesAtendidosPlaceholder = new JLabel("(Personas ya atendidas)");
		lblClientesAtendidosPlaceholder.setForeground(new Color(128, 128, 128));
		lblClientesAtendidosPlaceholder.setFont(new Font("Dialog", Font.ITALIC, 12));
		filaClientesAtendidos.add(lblClientesAtendidosPlaceholder);
		
		JPanel controlesAtencionCaja = new JPanel();
		controlesAtencionCaja.setBorder(new TitledBorder(null, "Controles de atenci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		controlesAtencionCaja.setBounds(12, 208, 386, 93);
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
		
		JLabel lblPedirPelicula = new JLabel("Pelicula para el cliente");
		lblPedirPelicula.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedirPelicula.setFont(new Font("Dialog", Font.PLAIN, 12));
		controlesAtencionCaja.add(lblPedirPelicula);
		
		JComboBox<String> peliculaCliente = new JComboBox<>();
		peliculaCliente.setToolTipText("(Seleccione la pelicula)");
		controlesAtencionCaja.add(peliculaCliente);
		
		// Decrementa la fila y actualiza el label
		JButton btnRegistrarAtencion = new JButton("Atender");
		btnRegistrarAtencion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				//clientes.dequeueClientes();
				lblFilaCrudaPlaceholder.setText(clientes.dequeueClientes());;
			}
		});
		btnRegistrarAtencion.setBounds(157, 338, 98, 26);
		atencionCajaFrame.getContentPane().add(btnRegistrarAtencion);
		
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
		
		JButton btnPasarAtendidosADulceria = new JButton("Pasarlos a dulcería");
		btnPasarAtendidosADulceria.setBounds(248, 146, 150, 38);
		atencionCajaFrame.getContentPane().add(btnPasarAtendidosADulceria);
		
		JInternalFrame atencionDulceriaFrame = new JInternalFrame("Atención en dulcería");
		atencionDulceriaFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		atencionDulceriaFrame.setBounds(36, 23, 347, 565);
		atencionDulceriaFrame.setIconifiable(true);
		atencionDulceriaFrame.setClosable(true);
		desktopPane.add(atencionDulceriaFrame);
		atencionDulceriaFrame.getContentPane().setLayout(null);
		
		JPanel filaClientesDulceria = new JPanel();
		filaClientesDulceria.setBorder(new TitledBorder(null, "Clientes en dulcer\u00EDa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		filaClientesDulceria.setBounds(12, 12, 313, 53);
		atencionDulceriaFrame.getContentPane().add(filaClientesDulceria);
		
		JPanel detallesClientesDulceria = new JPanel();
		detallesClientesDulceria.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Atendiendo a:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		detallesClientesDulceria.setBounds(12, 77, 313, 109);
		atencionDulceriaFrame.getContentPane().add(detallesClientesDulceria);
		detallesClientesDulceria.setLayout(new GridLayout(3, 2, 5, 5));
		
		JLabel lblDetallesLugar = new JLabel("Posicion:");
		detallesClientesDulceria.add(lblDetallesLugar);
		
		JLabel lblDetallesLugarPlaceholder = new JLabel("(Posicion cliente)");
		lblDetallesLugarPlaceholder.setForeground(new Color(128, 128, 128));
		lblDetallesLugarPlaceholder.setFont(new Font("Dialog", Font.ITALIC, 12));
		detallesClientesDulceria.add(lblDetallesLugarPlaceholder);
		
		JLabel lblDetallesNombre_1 = new JLabel("Nombre:");
		detallesClientesDulceria.add(lblDetallesNombre_1);
		
		JLabel lblDetallesNombrePlaceholder_1 = new JLabel("(Nombre cliente)");
		lblDetallesNombrePlaceholder_1.setForeground(new Color(128, 128, 128));
		lblDetallesNombrePlaceholder_1.setFont(new Font("Dialog", Font.ITALIC, 12));
		detallesClientesDulceria.add(lblDetallesNombrePlaceholder_1);
		
		JLabel lblDetallesCombo = new JLabel("Combo:");
		detallesClientesDulceria.add(lblDetallesCombo);
		
		JLabel lblDetallesComboPlaceholder = new JLabel("(Combo)");
		lblDetallesComboPlaceholder.setForeground(new Color(128, 128, 128));
		lblDetallesComboPlaceholder.setFont(new Font("Dialog", Font.ITALIC, 12));
		detallesClientesDulceria.add(lblDetallesComboPlaceholder);
		
		JPanel controlCombos = new JPanel();
		controlCombos.setBorder(new TitledBorder(null, "Combos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		controlCombos.setBounds(42, 218, 249, 119);
		atencionDulceriaFrame.getContentPane().add(controlCombos);
		controlCombos.setLayout(new GridLayout(0, 3, 5, 5));
		
		JButton btnCombo1 = new JButton("1");
		controlCombos.add(btnCombo1);
		
		JButton btnCombo2 = new JButton("2");
		controlCombos.add(btnCombo2);
		
		JButton btnCombo3 = new JButton("3");
		controlCombos.add(btnCombo3);
		
		JButton btnCombo4 = new JButton("4");
		controlCombos.add(btnCombo4);
		
		JButton btnCombo5 = new JButton("5");
		controlCombos.add(btnCombo5);
		
		JButton btnCombo6 = new JButton("6");
		controlCombos.add(btnCombo6);
		
		JButton btnCombo7 = new JButton("7");
		controlCombos.add(btnCombo7);
		
		JButton btnCombo8 = new JButton("8");
		controlCombos.add(btnCombo8);
		
		JButton btnCombo9 = new JButton("9");
		controlCombos.add(btnCombo9);
		
		JPanel controlCharolas = new JPanel();
		controlCharolas.setBounds(12, 394, 313, 68);
		atencionDulceriaFrame.getContentPane().add(controlCharolas);
		controlCharolas.setLayout(new GridLayout(0, 2, 5, 5));
		
		JPanel panel_2 = new JPanel();
		controlCharolas.add(panel_2);
		panel_2.setBorder(new TitledBorder(null, "Charolas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnRellenarCharolas = new JButton("Rellenar charolas");
		controlCharolas.add(btnRellenarCharolas);
		
		JButton btnAtenderClienteDulceria = new JButton("Atender y pasar a entrada");
		btnAtenderClienteDulceria.setBounds(12, 492, 313, 26);
		atencionDulceriaFrame.getContentPane().add(btnAtenderClienteDulceria);
		
		JButton btnAtencionCaja = new JButton("Atención Caja");
		btnAtencionCaja.addMouseListener(new MouseAdapter() {
			@Override
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
		
		JButton btnAtencionDulceria = new JButton("Atención Dulcería");
		btnAtencionDulceria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("DULCERIA");				
				if (atencionDulceriaFrame.isVisible() == true){
					JOptionPane.showMessageDialog(null, "Ya se encuentra abierto");
				} else {
					atencionDulceriaFrame.setVisible(true);
				}
			}
		});
		
		button_menu_container.add(btnAtencionDulceria);
		
		JButton btnVerCartelera = new JButton("Ver Cartelera");
		button_menu_container.add(btnVerCartelera);
		
		JButton btnAtencionEntradaSala = new JButton("Atención Entrada Sala");
		button_menu_container.add(btnAtencionEntradaSala);
		
		JLabel lblTitle = new JLabel("BIENVENID@ AL MENÚ");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitle.setBounds(12, 12, 1040, 19);
		panel.add(lblTitle);
		
	}
}
