package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class View_Home{

	public JFrame frame;
	LocalDateTime ahora = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd LLLL yyyy HH:mm:ss");
    String fechaActual = ahora.format(formatter);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Home window = new View_Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View_Home() {
		if (fechaActual != null && !fechaActual.isEmpty()) {
            fechaActual = Character.toUpperCase(fechaActual.charAt(0)) + fechaActual.substring(1);
        }
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 802, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				View_Login vm = new View_Login();
				vm.setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Home");
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 82, 164));
		panel.setBounds(0, 0, 163, 463);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuevo Paciente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(36, 247, 127, 42);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("__________________");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 77, 163, 35);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(View_Home.class.getResource("/resources/registro.png")));
		lblNewLabel_2.setBounds(10, 207, 32, 32);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(View_Home.class.getResource("/resources/nueva-cuenta.png")));
		lblNewLabel_3.setBounds(10, 250, 32, 32);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(View_Home.class.getResource("/resources/cerrar-sesion.png")));
		lblNewLabel_4.setBounds(10, 396, 49, 35);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(View_Home.class.getResource("/resources/casa.png")));
		lblNewLabel_5.setBounds(10, 157, 32, 32);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("DocuMed");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		lblNewLabel_6.setBounds(0, 59, 163, 42);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Principal");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));
		lblNewLabel_7.setBounds(36, 157, 127, 42);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nuevo Registro");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		lblNewLabel_8.setBounds(36, 200, 127, 42);
		panel.add(lblNewLabel_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 255));
		panel_1.setBounds(162, 46, 626, 116);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Sistema de Gestión de Pacientes");
		lblNewLabel_6_1_1.setBounds(20, 0, 295, 46);
		panel_1.add(lblNewLabel_6_1_1);
		lblNewLabel_6_1_1.setForeground(Color.BLACK);
		lblNewLabel_6_1_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		
		JLabel fecha_label = new JLabel(fechaActual);
		fecha_label.setForeground(Color.BLACK);
		fecha_label.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 18));
		fecha_label.setBounds(20, 37, 347, 68);
		panel_1.add(fecha_label);
		
		JLabel lblNewLabel_6_1 = new JLabel("Consultorios Médicos");
		lblNewLabel_6_1.setForeground(Color.BLACK);
		lblNewLabel_6_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblNewLabel_6_1.setBounds(173, 0, 215, 46);
		frame.getContentPane().add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(View_Home.class.getResource("/resources/su_salud2.png")));
		lblNewLabel_9.setBounds(550, 212, 228, 228);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lbl_inicio = new JLabel("¡Bienvenido/a!");
		lbl_inicio.setForeground(Color.BLACK);
		lbl_inicio.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		lbl_inicio.setBounds(172, 167, 347, 39);
		frame.getContentPane().add(lbl_inicio);
		
		JLabel lblNewLabel_6_1_2 = new JLabel("<html>Sistema de Gestión de Pacientes para Centro Médico<br>\r\n\"Su Salud\". Registro y revisión de antecedentes previos.</html>");
		lblNewLabel_6_1_2.setBounds(168, 212, 375, 39);
		frame.getContentPane().add(lblNewLabel_6_1_2);
		lblNewLabel_6_1_2.setForeground(Color.BLACK);
		lblNewLabel_6_1_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		
		JLabel lblNewLabel_6_1_2_1 = new JLabel("<html>Esta herramienta permite: <br>◇ Registro de una nueva visita al médico <br>◇ Registro de un nuevo paciente <br>◇ Búsqueda de antecedentes <br>◇ \"Generación de reporte\"</html>");
		lblNewLabel_6_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_6_1_2_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblNewLabel_6_1_2_1.setBounds(168, 262, 375, 105);
		frame.getContentPane().add(lblNewLabel_6_1_2_1);
		
	}
}
