package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controller.Logic_View_Patient;

import javax.swing.JComboBox;

public class View_Patient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JDateChooser date_nacimiento;
	public JTextField txt_ci;
	public JTextArea textArea_ant_personales;
	public JTextArea textArea_ant_familiares;
	public JTextArea textArea_ant_gineco_obs;
	public JTextArea textArea_telefono;
	public JButton btn_registro_paciente;
	public JTextField txt_nombres;
	public JTextField txt_apellidos;
	public JTextField txt_ocupacion;
	public JTextField txt_profesion;
	public JTextArea textArea_genero;
	public JButton btn_registro_visita;
	public JTextField textField;
	public JButton btnPrincipal;
	public JButton btnNuevoRegistro;
	public JButton btnNuevoPaciente;
	public JButton btnListado;
	public JButton btnSalir;

	private Logic_View_Patient lvp;
	public JDateChooser date_actual;
	public JTextField txt_lugar;
	public JComboBox<Character> cmb_genero;
	public JTextField txt_edad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Patient frame = new View_Patient();
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
	public View_Patient() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                View_Login vm = new View_Login();
                vm.setVisible(true);
            }
        });
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		setTitle("Registro de Pacientes");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Barra de navegación
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 82, 164));
		panel.setBounds(0, 0, 184, 600);
		getContentPane().add(panel);
		panel.setLayout(null);

		btnNuevoPaciente = new JButton("Nuevo Paciente");
		btnNuevoPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		btnNuevoPaciente.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		btnNuevoPaciente.setForeground(Color.WHITE);
		btnNuevoPaciente.setBackground(new Color(0, 82, 164));  
		btnNuevoPaciente.setBorderPainted(false);  
		btnNuevoPaciente.setFocusPainted(false);   
		btnNuevoPaciente.setBounds(46, 250, 138, 43);
		panel.add(btnNuevoPaciente);

		btnNuevoRegistro = new JButton("Nuevo Registro");
		btnNuevoRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		btnNuevoRegistro.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		btnNuevoRegistro.setForeground(Color.WHITE);
		btnNuevoRegistro.setBackground(new Color(0, 82, 164)); 
		btnNuevoRegistro.setBorderPainted(false);  
		btnNuevoRegistro.setFocusPainted(false);  
		btnNuevoRegistro.setBounds(46, 207, 138, 42);
		panel.add(btnNuevoRegistro);

		JLabel lblNewLabel_1 = new JLabel("__________________");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 77, 163, 35);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(View_Home.class.getResource("/resources/registro.png")));
		lblNewLabel_2.setBounds(10, 207, 32, 42);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(View_Home.class.getResource("/resources/nueva-cuenta.png")));
		lblNewLabel_3.setBounds(10, 250, 32, 43);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(View_Home.class.getResource("/resources/cerrar-sesion.png")));
		lblNewLabel_4.setBounds(10, 510, 49, 35);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(View_Home.class.getResource("/resources/casa.png")));
		lblNewLabel_5.setBounds(10, 166, 32, 39);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("DocuMed");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		lblNewLabel_6.setBounds(0, 59, 163, 42);
		panel.add(lblNewLabel_6);

		btnPrincipal = new JButton("Principal");
		btnPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		btnPrincipal.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		btnPrincipal.setForeground(Color.WHITE);
		btnPrincipal.setBackground(new Color(0, 82, 164));  
		btnPrincipal.setBorderPainted(false);  
		btnPrincipal.setFocusPainted(false);   
		btnPrincipal.setBounds(46, 166, 138, 43);
		panel.add(btnPrincipal);
		
		btnSalir = new JButton("Cerrar Sesión");
		btnSalir.setHorizontalAlignment(SwingConstants.CENTER);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		btnSalir.setFocusPainted(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setBackground(new Color(0, 82, 164));
		btnSalir.setBounds(46, 502, 138, 43);
		panel.add(btnSalir);
		
		btnListado = new JButton("Buscar Paciente");
		btnListado.setHorizontalAlignment(SwingConstants.CENTER);
		btnListado.setForeground(Color.WHITE);
		btnListado.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		btnListado.setFocusPainted(false);
		btnListado.setBorderPainted(false);
		btnListado.setBackground(new Color(0, 82, 164));
		btnListado.setBounds(46, 292, 138, 43);
		panel.add(btnListado);
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(View_Table_Register.class.getResource("/resources/buscar.png")));
		lblNewLabel_3_1.setBounds(10, 292, 32, 43);
		panel.add(lblNewLabel_3_1);

		//Título
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 255));
		panel_2.setBounds(183, 0, 803, 57);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel("Registro Nuevo Paciente");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(10, 21, 793, 25);
		panel_2.add(lblNewLabel_11);
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));

		//Body
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(183, 57, 803, 506);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel fecha_label = new JLabel("Antecedentes personales:");
		fecha_label.setForeground(Color.BLACK);
		fecha_label.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label.setBounds(470, 11, 213, 36);
		panel_1.add(fecha_label);

		//Se puede poner la hora con JCalendarDemo, revisar documentación eligir luego 

		date_nacimiento = new JDateChooser(new Date());
		date_nacimiento.setBounds(161, 213, 124, 25);
		panel_1.add(date_nacimiento);

		btn_registro_paciente = new JButton("Registrar");
		btn_registro_paciente.setBounds(292, 448, 232, 25);
		panel_1.add(btn_registro_paciente);

		JLabel fecha_label_1 = new JLabel("C.I.:");
		fecha_label_1.setForeground(Color.BLACK);
		fecha_label_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1.setBounds(27, 11, 138, 36);
		panel_1.add(fecha_label_1);

		txt_ci = new JTextField();
		txt_ci.setBounds(161, 22, 203, 20);
		txt_ci.setFocusable(true);
		txt_ci.setColumns(10);
		panel_1.add(txt_ci);
		SwingUtilities.invokeLater(() -> txt_ci.requestFocusInWindow());


		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

		textArea_ant_personales = new JTextArea();
		textArea_ant_personales.setRows(10);
		textArea_ant_personales.setForeground(new Color(0, 0, 0));
		textArea_ant_personales.setBounds(470, 45, 280, 48);
		textArea_ant_personales.setBorder(border);
		textArea_ant_personales.setLineWrap(true);
		textArea_ant_personales.setWrapStyleWord(true);
		textArea_ant_personales.setCaretPosition(0);
		panel_1.add(textArea_ant_personales);
		
		JScrollPane scrollPane = new JScrollPane(textArea_ant_personales);
        scrollPane.setBounds(470, 45, 280, 48);
        
        panel_1.add(scrollPane);
        
        textArea_ant_gineco_obs = new JTextArea();
        textArea_ant_gineco_obs.setRows(10);
        textArea_ant_gineco_obs.setForeground(new Color(0, 0, 0));
        textArea_ant_gineco_obs.setBounds(470, 250, 280, 48);
        textArea_ant_gineco_obs.setBorder(border);
        textArea_ant_gineco_obs.setLineWrap(true);
        textArea_ant_gineco_obs.setWrapStyleWord(true);
		panel_1.add(textArea_ant_gineco_obs);
		
		JScrollPane scrollPane1 = new JScrollPane(textArea_ant_gineco_obs);
        scrollPane1.setBounds(470, 250, 280, 48);
        
        panel_1.add(scrollPane1);
        
        textArea_ant_familiares = new JTextArea();
        textArea_ant_familiares.setRows(10);
        textArea_ant_familiares.setForeground(new Color(0, 0, 0));
        textArea_ant_familiares.setBounds(470, 150, 280, 48);
		textArea_ant_familiares.setBorder(border);
		textArea_ant_familiares.setLineWrap(true);
		textArea_ant_familiares.setWrapStyleWord(true);
		panel_1.add(textArea_ant_familiares);
		
		JScrollPane scrollPane2 = new JScrollPane(textArea_ant_familiares);
        scrollPane2.setBounds(470, 150, 280, 48);
        
        panel_1.add(scrollPane2);

		JLabel fecha_label_3 = new JLabel("Ocupación:");
		fecha_label_3.setForeground(Color.BLACK);
		fecha_label_3.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_3.setBounds(27, 132, 138, 36);
		panel_1.add(fecha_label_3);

		JLabel fecha_label_4 = new JLabel("Profesión:");
		fecha_label_4.setForeground(Color.BLACK);
		fecha_label_4.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_4.setBounds(27, 169, 138, 36);
		panel_1.add(fecha_label_4);

		JLabel fecha_label_5 = new JLabel("Fecha Nacimento:");
		fecha_label_5.setForeground(Color.BLACK);
		fecha_label_5.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_5.setBounds(27, 205, 138, 36);
		panel_1.add(fecha_label_5);

		JLabel fecha_label_7 = new JLabel("Fecha Actual:");
		fecha_label_7.setForeground(Color.BLACK);
		fecha_label_7.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_7.setBounds(27, 239, 138, 36);
		panel_1.add(fecha_label_7);

		JLabel fecha_label_8 = new JLabel("Teléfonos:");
		fecha_label_8.setForeground(Color.BLACK);
		fecha_label_8.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_8.setBounds(27, 274, 138, 36);
		panel_1.add(fecha_label_8);

		textArea_telefono = new JTextArea();
		textArea_telefono.setForeground(Color.BLACK);
		textArea_telefono.setBounds(161, 283, 203, 20);
		textArea_telefono.setBorder(border);
		panel_1.add(textArea_telefono);

		JLabel fecha_label_9 = new JLabel("Género:");
		fecha_label_9.setForeground(Color.BLACK);
		fecha_label_9.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_9.setBounds(27, 306, 138, 36);
		panel_1.add(fecha_label_9);
		
		JLabel fecha_label_2 = new JLabel("Nombres:");
		fecha_label_2.setForeground(Color.BLACK);
		fecha_label_2.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_2.setBounds(27, 53, 138, 36);
		panel_1.add(fecha_label_2);
		
		txt_nombres = new JTextField();
		txt_nombres.setColumns(10);
		txt_nombres.setBounds(161, 61, 203, 20);
		panel_1.add(txt_nombres);
		
		JLabel fecha_label_11 = new JLabel("Apellidos:");
		fecha_label_11.setForeground(Color.BLACK);
		fecha_label_11.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_11.setBounds(27, 92, 138, 36);
		panel_1.add(fecha_label_11);
		
		txt_apellidos = new JTextField();
		txt_apellidos.setColumns(10);
		txt_apellidos.setBounds(161, 101, 203, 20);
		panel_1.add(txt_apellidos);
		
		txt_ocupacion = new JTextField();
		txt_ocupacion.setColumns(10);
		txt_ocupacion.setBounds(161, 142, 203, 20);
		panel_1.add(txt_ocupacion);
		
		txt_profesion = new JTextField();
		txt_profesion.setColumns(10);
		txt_profesion.setBounds(161, 179, 203, 20);
		panel_1.add(txt_profesion);
		//label?
		date_actual = new JDateChooser(new Date());
		date_actual.setBounds(161, 250, 124, 25);
		panel_1.add(date_actual);
		
		cmb_genero = new JComboBox<>();
		cmb_genero.setBounds(161, 313, 124, 22);
		panel_1.add(cmb_genero);
		
		JLabel fecha_label_6 = new JLabel("Antecedentes familiares:");
		fecha_label_6.setForeground(Color.BLACK);
		fecha_label_6.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_6.setBounds(470, 114, 213, 36);

		panel_1.add(fecha_label_6);
		
		JLabel fecha_label_6_1 = new JLabel("Antecedentes gineco-obstétricos:");
		fecha_label_6_1.setForeground(Color.BLACK);
		fecha_label_6_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_6_1.setBounds(470, 216, 237, 36);
		panel_1.add(fecha_label_6_1);
		
		JLabel fecha_label_9_1 = new JLabel("Lugar Nacimiento:");
		fecha_label_9_1.setForeground(Color.BLACK);
		fecha_label_9_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_9_1.setBounds(27, 346, 138, 36);
		panel_1.add(fecha_label_9_1);
		
		txt_lugar = new JTextField();
		txt_lugar.setColumns(10);
		txt_lugar.setBounds(161, 356, 203, 20);
		panel_1.add(txt_lugar);
		
		JLabel label_edad = new JLabel("Edad:");
		label_edad.setForeground(Color.BLACK);
		label_edad.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		label_edad.setBounds(27, 393, 138, 36);
		panel_1.add(label_edad);
		
		txt_edad = new JTextField();
		txt_edad.setEnabled(false);
		txt_edad.setEditable(false);
		txt_edad.setColumns(10);
		txt_edad.setBounds(161, 403, 124, 20);
		panel_1.add(txt_edad);
		
		lvp = new Logic_View_Patient(this);
		
	}
}
