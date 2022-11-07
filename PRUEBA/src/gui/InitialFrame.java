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
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;


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
		atencionCajaFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		atencionCajaFrame.setEnabled(false);
		atencionCajaFrame.setIconifiable(true);
		atencionCajaFrame.setClosable(true);
		atencionCajaFrame.setBounds(12, 12, 420, 384);
		atencionCajaFrame.setVisible(false);
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
		
		JLabel lblShowFilaCruda = new JLabel("(Aqui aparecerá la fila con numeros)");
		lblShowFilaCruda.setForeground(new Color(128, 128, 128));
		lblShowFilaCruda.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblShowFilaCruda.setHorizontalTextPosition(SwingConstants.LEFT);
		lblShowFilaCruda.setHorizontalAlignment(SwingConstants.LEFT);
		filaClientes.add(lblShowFilaCruda);
		
		JPanel filaClientesAtendidos = new JPanel();
		filaClientesAtendidos.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Fila de atendidos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		filaClientesAtendidos.setBounds(12, 133, 386, 51);
		atencionCajaFrame.getContentPane().add(filaClientesAtendidos);
		
		JLabel lblNewLabel = new JLabel("(Aqui aparecerá la fila de personas ya atendidas)");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("Dialog", Font.ITALIC, 12));
		filaClientesAtendidos.add(lblNewLabel);
		
		JPanel controlesAtencionCaja = new JPanel();
		controlesAtencionCaja.setBorder(new TitledBorder(null, "Controles de atenci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		controlesAtencionCaja.setBounds(12, 208, 386, 82);
		atencionCajaFrame.getContentPane().add(controlesAtencionCaja);
		controlesAtencionCaja.setLayout(new GridLayout(2, 3, 0, 5));
		
		JLabel lblPedirNombreCliente = new JLabel("Nombre de cliente");
		lblPedirNombreCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPedirNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedirNombreCliente.setFont(new Font("Dialog", Font.PLAIN, 12));
		controlesAtencionCaja.add(lblPedirNombreCliente);
		
		nombreCliente = new JTextField();
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
		
		JButton btnRegistrarAtencion = new JButton("Atender");
		btnRegistrarAtencion.setBounds(158, 302, 98, 26);
		atencionCajaFrame.getContentPane().add(btnRegistrarAtencion);
		
		JButton btnRefillFilaCruda = new JButton("Pasar 5");
		btnRefillFilaCruda.setBounds(249, 75, 98, 26);
		atencionCajaFrame.getContentPane().add(btnRefillFilaCruda);
		
		JButton btnAtencionCaja = new JButton("Atención Caja");
		btnAtencionCaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("CAJA");
				atencionCajaFrame.setVisible(true);	
				
			}
		});
		btnAtencionCaja.setToolTipText("Atención de clientes");
		button_menu_container.add(btnAtencionCaja);
		
		JButton btnAtencionDulceria = new JButton("Atención Dulcería");
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
