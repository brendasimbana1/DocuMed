package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controller.Logic_View_Register;
import controller.Logic_View_Table;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class View_Table extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnPrincipal;
	public JButton btnNuevoRegistro;
	public JButton btnNuevoPaciente;
	public JTextField txt_ci;
	public JButton btn_buscar;
	public JPanel panel_content;
	public JButton btnSalir;
	public JButton btnListado;
	public JTextArea textArea_ant_personales;
	public JTextArea textArea_ant_familiares;
	public JTextArea textArea_ant_gineco_obs;
	private Logic_View_Table lvt;
	public JTextField txt_nombres;
	public JTextField txt_apellidos;
	public JTextField txt_ocupacion;
	public JTextField txt_profesion;
	public JTextField txt_fNacimiento;
	public JTextField txt_fRegistro;
	public JTextField txt_telefonos;
	public JTextField txt_genero;
	public JTextField txt_lugar;
	public JTextField txt_edad;
	public JButton btn_registros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Register frame = new View_Register();
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
	public View_Table() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setTitle("Registro de Pacientes");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				View_Login vm = new View_Login();
				vm.setVisible(true);
			}
		});
		setLocationRelativeTo(null);


		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Barra de navegación
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 82, 164));
		panel.setBounds(0, 0, 184, 563);
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
		lblNewLabel_3_1.setIcon(new ImageIcon(View_Table.class.getResource("/resources/buscar.png")));
		lblNewLabel_3_1.setBounds(10, 292, 32, 43);
		panel.add(lblNewLabel_3_1);

		//Body
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(183, 57, 801, 504);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel fecha_label_1 = new JLabel("C.I.:");
		fecha_label_1.setForeground(Color.BLACK);
		fecha_label_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1.setBounds(26, 10, 100, 36);
		panel_1.add(fecha_label_1);

		txt_ci = new JTextField();
		txt_ci.setFocusable(true);
		txt_ci.setColumns(10);
		txt_ci.setBounds(95, 21, 242, 20);
		panel_1.add(txt_ci);
		SwingUtilities.invokeLater(() -> txt_ci.requestFocusInWindow());

		SpinnerNumberModel model_peso = new SpinnerNumberModel(0.1, 0.1, 200.0, 0.1);

		SpinnerNumberModel model_altura = new SpinnerNumberModel(1,1,230,1);

		SpinnerNumberModel model_temperatura = new SpinnerNumberModel(0.01,0.01,50,0.01);

		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

		btn_buscar = new JButton("Buscar");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_buscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_buscar.setBounds(347, 19, 85, 21);
		panel_1.add(btn_buscar);

		panel_content = new JPanel();
		panel_content.setBackground(new Color(255, 255, 255));
		panel_content.setBounds(0, 51, 801, 453);
		panel_1.add(panel_content);
		panel_content.setLayout(null);
		
		JLabel fecha_label_1_1 = new JLabel("Nombres:");
		fecha_label_1_1.setForeground(Color.BLACK);
		fecha_label_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1_1.setBounds(24, 27, 100, 36);
		panel_content.add(fecha_label_1_1);
		
		JLabel fecha_label_1_1_1 = new JLabel("Apellidos:");
		fecha_label_1_1_1.setForeground(Color.BLACK);
		fecha_label_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1_1_1.setBounds(24, 65, 100, 36);
		panel_content.add(fecha_label_1_1_1);
		
		JLabel fecha_label_1_1_1_1 = new JLabel("Ocupación:");
		fecha_label_1_1_1_1.setForeground(Color.BLACK);
		fecha_label_1_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1_1_1_1.setBounds(24, 104, 100, 36);
		panel_content.add(fecha_label_1_1_1_1);
		
		JLabel fecha_label_1_1_1_1_1 = new JLabel("Profesión:");
		fecha_label_1_1_1_1_1.setForeground(Color.BLACK);
		fecha_label_1_1_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1_1_1_1_1.setBounds(24, 141, 100, 36);
		panel_content.add(fecha_label_1_1_1_1_1);
		
		JLabel fecha_label_1_1_1_1_1_1 = new JLabel("Fecha nacimiento:");
		fecha_label_1_1_1_1_1_1.setForeground(Color.BLACK);
		fecha_label_1_1_1_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1_1_1_1_1_1.setBounds(24, 177, 123, 36);
		panel_content.add(fecha_label_1_1_1_1_1_1);
		
		JLabel fecha_label_1_1_1_1_1_1_1 = new JLabel("Fecha registro:");
		fecha_label_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		fecha_label_1_1_1_1_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1_1_1_1_1_1_1.setBounds(24, 217, 123, 36);
		panel_content.add(fecha_label_1_1_1_1_1_1_1);
		
		JLabel fecha_label_1_1_1_1_1_1_1_1 = new JLabel("Teléfonos:");
		fecha_label_1_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		fecha_label_1_1_1_1_1_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1_1_1_1_1_1_1_1.setBounds(24, 256, 123, 36);
		panel_content.add(fecha_label_1_1_1_1_1_1_1_1);
		
		JLabel fecha_label_1_1_1_1_1_1_1_1_1 = new JLabel("Género:");
		fecha_label_1_1_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		fecha_label_1_1_1_1_1_1_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1_1_1_1_1_1_1_1_1.setBounds(24, 293, 123, 36);
		panel_content.add(fecha_label_1_1_1_1_1_1_1_1_1);
		
		JLabel fecha_label_1_1_1_1_1_1_1_1_1_1 = new JLabel("Lugar nacimiento:");
		fecha_label_1_1_1_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		fecha_label_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1_1_1_1_1_1_1_1_1_1.setBounds(24, 332, 123, 36);
		panel_content.add(fecha_label_1_1_1_1_1_1_1_1_1_1);
		
		JLabel fecha_label_1_1_1_1_1_1_1_1_1_1_1 = new JLabel("Edad:");
		fecha_label_1_1_1_1_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		fecha_label_1_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1_1_1_1_1_1_1_1_1_1_1.setBounds(426, 27, 123, 36);
		panel_content.add(fecha_label_1_1_1_1_1_1_1_1_1_1_1);
		
		txt_nombres = new JTextField();
		txt_nombres.setEditable(false);
		txt_nombres.setColumns(10);
		txt_nombres.setBounds(105, 37, 212, 22);
		panel_content.add(txt_nombres);
		
		txt_apellidos = new JTextField();
		txt_apellidos.setEditable(false);
		txt_apellidos.setColumns(10);
		txt_apellidos.setBounds(105, 75, 212, 22);
		panel_content.add(txt_apellidos);
		
		txt_ocupacion = new JTextField();
		txt_ocupacion.setEditable(false);
		txt_ocupacion.setColumns(10);
		txt_ocupacion.setBounds(105, 112, 212, 22);
		panel_content.add(txt_ocupacion);
		
		txt_profesion = new JTextField();
		txt_profesion.setEditable(false);
		txt_profesion.setColumns(10);
		txt_profesion.setBounds(105, 151, 212, 22);
		panel_content.add(txt_profesion);
		
		txt_fNacimiento = new JTextField();
		txt_fNacimiento.setEditable(false);
		txt_fNacimiento.setColumns(10);
		txt_fNacimiento.setBounds(157, 187, 212, 22);
		panel_content.add(txt_fNacimiento);
		
		txt_fRegistro = new JTextField();
		txt_fRegistro.setEditable(false);
		txt_fRegistro.setColumns(10);
		txt_fRegistro.setBounds(143, 227, 212, 22);
		panel_content.add(txt_fRegistro);
		
		txt_telefonos = new JTextField();
		txt_telefonos.setEditable(false);
		txt_telefonos.setColumns(10);
		txt_telefonos.setBounds(121, 264, 212, 22);
		panel_content.add(txt_telefonos);
		
		txt_genero = new JTextField();
		txt_genero.setEditable(false);
		txt_genero.setColumns(10);
		txt_genero.setBounds(105, 303, 212, 22);
		panel_content.add(txt_genero);
		
		txt_lugar = new JTextField();
		txt_lugar.setEditable(false);
		txt_lugar.setColumns(10);
		txt_lugar.setBounds(157, 342, 212, 22);
		panel_content.add(txt_lugar);
		
		txt_edad = new JTextField();
		txt_edad.setEditable(false);
		txt_edad.setColumns(10);
		txt_edad.setBounds(486, 37, 212, 22);
		panel_content.add(txt_edad);
		
		JLabel fecha_label = new JLabel("Antecedentes personales:");
		fecha_label.setForeground(Color.BLACK);
		fecha_label.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label.setBounds(426, 65, 213, 36);
		panel_content.add(fecha_label);
		
		textArea_ant_personales = new JTextArea();
		textArea_ant_personales.setRows(10);
		textArea_ant_personales.setForeground(new Color(0, 0, 0));
		textArea_ant_personales.setBounds(420, 95, 280, 48);
		textArea_ant_personales.setBorder(border);
		textArea_ant_personales.setLineWrap(true);
		textArea_ant_personales.setWrapStyleWord(true);
		textArea_ant_personales.setCaretPosition(0);
		textArea_ant_personales.setEditable(false);
		panel_content.add(textArea_ant_personales);
		
		JScrollPane scrollPane = new JScrollPane(textArea_ant_personales);
        scrollPane.setBounds(420, 95, 280, 48);
        
        panel_content.add(scrollPane);
        
        JLabel fecha_label_6 = new JLabel("Antecedentes familiares:");
        fecha_label_6.setForeground(Color.BLACK);
        fecha_label_6.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
        fecha_label_6.setBounds(426, 154, 213, 36);
        panel_content.add(fecha_label_6);
        
        textArea_ant_familiares = new JTextArea();
        textArea_ant_familiares.setRows(10);
        textArea_ant_familiares.setForeground(new Color(0, 0, 0));
        textArea_ant_familiares.setBounds(426, 200, 280, 48);
		textArea_ant_familiares.setBorder(border);
		textArea_ant_familiares.setLineWrap(true);
		textArea_ant_familiares.setEditable(false);
		textArea_ant_familiares.setWrapStyleWord(true);
		panel_content.add(textArea_ant_familiares);
		
		JScrollPane scrollPane2 = new JScrollPane(textArea_ant_familiares);
        scrollPane2.setBounds(426, 200, 280, 48);
        
        panel_content.add(scrollPane2);
        
        JLabel fecha_label_6_1 = new JLabel("Antecedentes gineco-obstétricos:");
        fecha_label_6_1.setForeground(Color.BLACK);
        fecha_label_6_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
        fecha_label_6_1.setBounds(426, 269, 237, 36);
        panel_content.add(fecha_label_6_1);
        
        textArea_ant_gineco_obs = new JTextArea();
        textArea_ant_gineco_obs.setRows(10);
        textArea_ant_gineco_obs.setForeground(new Color(0, 0, 0));
        textArea_ant_gineco_obs.setBounds(426, 300, 280, 48);
        textArea_ant_gineco_obs.setBorder(border);
        textArea_ant_gineco_obs.setLineWrap(true);
        textArea_ant_gineco_obs.setWrapStyleWord(true);
        textArea_ant_gineco_obs.setEditable(false);
        panel_content.add(textArea_ant_gineco_obs);
		
		JScrollPane scrollPane1 = new JScrollPane(textArea_ant_gineco_obs);
        scrollPane1.setBounds(426, 300, 280, 48);
        
        panel_content.add(scrollPane1);
        
        btn_registros = new JButton("Ver Registros");
        btn_registros.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btn_registros.setBounds(452, 19, 114, 21);
        panel_1.add(btn_registros);
		
		
		//Título
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 255));
		panel_2.setBounds(183, 0, 801, 57);
		contentPane.add(panel_2);
		panel_2.setLayout(null);


		JLabel lblNewLabel_11 = new JLabel("Historial de Registros");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(0, 22, 801, 25);
		panel_2.add(lblNewLabel_11);
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));

		lvt = new Logic_View_Table(this);
	}
}
