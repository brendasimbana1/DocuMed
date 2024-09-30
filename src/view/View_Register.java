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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controller.Logic_View_Register;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnPrincipal;
	public JButton btnNuevoRegistro;
	public JButton btnNuevoPaciente;
	public JTextField txt_ci;
	public JTextField textField_2;
	public JButton btn_registro_visita;
	public JTextArea textArea_diagnostico;
	public JTextArea textArea_evolucion;
	public JTextArea textArea_indicaciones;
	public JSpinner spn_peso;
	public JSpinner spn_altura;
	public JSpinner spn_temp;
	public JTextField textField_1;
	public JDateChooser dateChooser;
	public JButton btn_buscar;
	public JTextField txt_apellidos;
	public JTextField txt_nombres;
	public JTextField txt_edad;
	public JPanel panel_info;
	public JPanel panel_content;
	public JButton btnSalir;

	private Logic_View_Register lvr;

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
	public View_Register() {
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
		txt_ci.setColumns(10);
		txt_ci.setBounds(95, 21, 242, 20);
		panel_1.add(txt_ci);
		
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
        btn_buscar.setBounds(252, 51, 85, 21);
        panel_1.add(btn_buscar);
        
        panel_info = new JPanel();
        panel_info.setBackground(new Color(255, 255, 255));
        panel_info.setBounds(541, 21, 232, 128);
        panel_1.add(panel_info);
        panel_info.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Nombres:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(10, 10, 62, 13);
        panel_info.add(lblNewLabel);
        
        txt_nombres = new JTextField();
        txt_nombres.setBounds(10, 28, 212, 19);
        panel_info.add(txt_nombres);
        txt_nombres.setColumns(10);
        
        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblApellidos.setBounds(10, 50, 93, 13);
        panel_info.add(lblApellidos);
        
        txt_apellidos = new JTextField();
        txt_apellidos.setColumns(10);
        txt_apellidos.setBounds(10, 68, 212, 19);
        panel_info.add(txt_apellidos);
        
        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEdad.setBounds(10, 97, 48, 13);
        panel_info.add(lblEdad);
        
        txt_edad = new JTextField();
        txt_edad.setColumns(10);
        txt_edad.setBounds(51, 95, 87, 19);
        panel_info.add(txt_edad);
        
        panel_content = new JPanel();
        panel_content.setBackground(new Color(255, 255, 255));
        panel_content.setBounds(0, 162, 801, 342);
        panel_1.add(panel_content);
        panel_content.setLayout(null);
        
        JLabel fecha_label = new JLabel("Fecha atención:");
        fecha_label.setBounds(24, 10, 124, 36);
        panel_content.add(fecha_label);
        fecha_label.setForeground(Color.BLACK);
        fecha_label.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
        
        dateChooser = new JDateChooser((Date) null);
        dateChooser.setBounds(144, 20, 167, 20);
        panel_content.add(dateChooser);
        
        JLabel fecha_label_3 = new JLabel("Peso (kg):");
        fecha_label_3.setBounds(10, 50, 124, 36);
        panel_content.add(fecha_label_3);
        fecha_label_3.setHorizontalAlignment(SwingConstants.CENTER);
        fecha_label_3.setForeground(Color.BLACK);
        fecha_label_3.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
        
        JLabel fecha_label_4 = new JLabel("Altura (cm):");
        fecha_label_4.setBounds(134, 50, 124, 36);
        panel_content.add(fecha_label_4);
        fecha_label_4.setHorizontalAlignment(SwingConstants.CENTER);
        fecha_label_4.setForeground(Color.BLACK);
        fecha_label_4.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
        
        JLabel fecha_label_5 = new JLabel("Temperatura (°C):");
        fecha_label_5.setBounds(257, 50, 138, 36);
        panel_content.add(fecha_label_5);
        fecha_label_5.setHorizontalAlignment(SwingConstants.CENTER);
        fecha_label_5.setForeground(Color.BLACK);
        fecha_label_5.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
        
        JLabel fecha_label_7 = new JLabel("Presión Arterial:");
        fecha_label_7.setBounds(395, 50, 138, 36);
        panel_content.add(fecha_label_7);
        fecha_label_7.setHorizontalAlignment(SwingConstants.CENTER);
        fecha_label_7.setForeground(Color.BLACK);
        fecha_label_7.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
        
        textField_2 = new JTextField();
        textField_2.setBounds(418, 87, 96, 20);
        panel_content.add(textField_2);
        textField_2.setColumns(10);
        spn_temp = new JSpinner(model_temperatura);
        spn_temp.setBounds(280, 86, 96, 20);
        panel_content.add(spn_temp);
        spn_temp.setFont(new Font("Tahoma", Font.PLAIN, 11));
        spn_altura = new JSpinner(model_altura);
        spn_altura.setBounds(144, 86, 96, 20);
        panel_content.add(spn_altura);
        spn_altura.setFont(new Font("Tahoma", Font.PLAIN, 11));
        spn_peso = new JSpinner(model_peso);
        spn_peso.setBounds(20, 86, 96, 20);
        panel_content.add(spn_peso);
        spn_peso.setFont(new Font("Tahoma", Font.PLAIN, 11));
        
        JLabel fecha_label_1_1 = new JLabel("Diagnostico:");
        fecha_label_1_1.setBounds(24, 116, 124, 36);
        panel_content.add(fecha_label_1_1);
        fecha_label_1_1.setForeground(Color.BLACK);
        fecha_label_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
        
        JLabel fecha_label_8 = new JLabel("Evolución:");
        fecha_label_8.setBounds(24, 162, 138, 36);
        panel_content.add(fecha_label_8);
        fecha_label_8.setForeground(Color.BLACK);
        fecha_label_8.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
        
        JLabel fecha_label_9 = new JLabel("Indicaciones:");
        fecha_label_9.setBounds(24, 209, 138, 36);
        panel_content.add(fecha_label_9);
        fecha_label_9.setForeground(Color.BLACK);
        fecha_label_9.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
        
        JLabel fecha_label_10 = new JLabel("Responsable:");
        fecha_label_10.setBounds(409, 209, 138, 36);
        panel_content.add(fecha_label_10);
        fecha_label_10.setForeground(Color.BLACK);
        fecha_label_10.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
        
        textArea_diagnostico = new JTextArea();
        textArea_diagnostico.setBounds(10, 128, 230, 34);
        textArea_diagnostico.setRows(10);
        textArea_diagnostico.setBorder(border);
        textArea_diagnostico.setLineWrap(true);
        textArea_diagnostico.setWrapStyleWord(true);
        panel_1.add(textArea_diagnostico);
        
        JScrollPane scrollPane_diagnostico = new JScrollPane(textArea_diagnostico);
        scrollPane_diagnostico.setBounds(144, 116, 230, 34);
        panel_content.add(scrollPane_diagnostico);
        
                textArea_evolucion = new JTextArea();
                textArea_evolucion.setBounds(147, 326, 230, 34);
                textArea_evolucion.setRows(10);
                textArea_evolucion.setBorder(border);
                textArea_evolucion.setLineWrap(true);
                textArea_evolucion.setWrapStyleWord(true);
                panel_1.add(textArea_evolucion);
                
                JScrollPane scrollPane_evolucion = new JScrollPane(textArea_evolucion);
                scrollPane_evolucion.setBounds(146, 162, 230, 34);
                panel_content.add(scrollPane_evolucion);
                
                textArea_indicaciones = new JTextArea();
                textArea_indicaciones.setBounds(147, 376, 230, 34);
                textArea_indicaciones.setRows(10);
                textArea_indicaciones.setBorder(border);
                textArea_indicaciones.setLineWrap(true);
                textArea_indicaciones.setWrapStyleWord(true);
                panel_1.add(textArea_indicaciones);
                
                JScrollPane scrollPane_indicaciones = new JScrollPane(textArea_indicaciones);
                scrollPane_indicaciones.setBounds(146, 208, 230, 34);
                panel_content.add(scrollPane_indicaciones);
                
                textField_1 = new JTextField();
                textField_1.setBounds(527, 220, 232, 20);
                panel_content.add(textField_1);
                textField_1.setColumns(10);
                
                btn_registro_visita = new JButton("Registrar");
                btn_registro_visita.setBounds(282, 270, 232, 25);
                panel_content.add(btn_registro_visita);
                btn_registro_visita.setFont(new Font("Tahoma", Font.PLAIN, 13));

		//Título
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 255));
		panel_2.setBounds(183, 0, 801, 57);
		contentPane.add(panel_2);
		panel_2.setLayout(null);


		JLabel lblNewLabel_11 = new JLabel("Registro Visita Médica");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(0, 22, 801, 25);
		panel_2.add(lblNewLabel_11);
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		
		lvr = new Logic_View_Register(this);
	}
}
