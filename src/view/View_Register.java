package view;

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

public class View_Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnPrincipal;
	public JButton btnNuevoRegistro;
	public JButton btnNuevoPaciente;
	private Logic_View_Register lvr;
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
		panel.setBounds(0, 0, 184, 561);
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
		lblNewLabel_4.setBounds(10, 396, 49, 35);
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

		//Body
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(183, 57, 801, 504);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel fecha_label = new JLabel("Fecha atención:");
		fecha_label.setForeground(Color.BLACK);
		fecha_label.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label.setBounds(23, 38, 124, 36);
		panel_1.add(fecha_label);
		
		dateChooser = new JDateChooser((Date) null);
		dateChooser.setBounds(147, 49, 167, 20);
		panel_1.add(dateChooser);
		
		JLabel fecha_label_1 = new JLabel("C.I.:");
		fecha_label_1.setForeground(Color.BLACK);
		fecha_label_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1.setBounds(23, 79, 124, 36);
		panel_1.add(fecha_label_1);
		
		txt_ci = new JTextField();
		txt_ci.setColumns(10);
		txt_ci.setBounds(147, 89, 167, 20);
		panel_1.add(txt_ci);
		
		JLabel fecha_label_1_1 = new JLabel("Diagnostico:");
		fecha_label_1_1.setForeground(Color.BLACK);
		fecha_label_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1_1.setBounds(23, 114, 124, 36);
		panel_1.add(fecha_label_1_1);
		
		JLabel fecha_label_3 = new JLabel("Peso:");
		fecha_label_3.setForeground(Color.BLACK);
		fecha_label_3.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_3.setBounds(23, 165, 124, 36);
		panel_1.add(fecha_label_3);
		
		spn_peso = new JSpinner();
		spn_peso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spn_peso.setBounds(147, 175, 96, 20);
		panel_1.add(spn_peso);
		
		spn_altura = new JSpinner();
		spn_altura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spn_altura.setBounds(147, 212, 96, 20);
		panel_1.add(spn_altura);
		
		JLabel fecha_label_4 = new JLabel("Altura:");
		fecha_label_4.setForeground(Color.BLACK);
		fecha_label_4.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_4.setBounds(23, 202, 124, 36);
		panel_1.add(fecha_label_4);
		
		JLabel fecha_label_5 = new JLabel("Temperatura:");
		fecha_label_5.setForeground(Color.BLACK);
		fecha_label_5.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_5.setBounds(23, 243, 138, 36);
		panel_1.add(fecha_label_5);
		
		spn_temp = new JSpinner();
		spn_temp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spn_temp.setBounds(147, 249, 96, 20);
		panel_1.add(spn_temp);
		
		JLabel fecha_label_10 = new JLabel("Responsable:");
		fecha_label_10.setForeground(Color.BLACK);
		fecha_label_10.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_10.setBounds(398, 165, 138, 36);
		panel_1.add(fecha_label_10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(501, 175, 232, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 290, 96, 20);
		panel_1.add(textField_2);
		
		JLabel fecha_label_7 = new JLabel("Presión Arterial:");
		fecha_label_7.setForeground(Color.BLACK);
		fecha_label_7.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_7.setBounds(23, 280, 138, 36);
		panel_1.add(fecha_label_7);
		
		JLabel fecha_label_8 = new JLabel("Evolución:");
		fecha_label_8.setForeground(Color.BLACK);
		fecha_label_8.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_8.setBounds(23, 321, 138, 36);
		panel_1.add(fecha_label_8);
		
		JLabel fecha_label_9 = new JLabel("Indicaciones:");
		fecha_label_9.setForeground(Color.BLACK);
		fecha_label_9.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_9.setBounds(23, 368, 138, 36);
		panel_1.add(fecha_label_9);
		
		btn_registro_visita = new JButton("Registrar");
		btn_registro_visita.setBounds(283, 431, 232, 25);
		panel_1.add(btn_registro_visita);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		textArea_diagnostico = new JTextArea();
		textArea_diagnostico.setBounds(147, 126, 230, 34);
		textArea_diagnostico.setRows(10);
		textArea_diagnostico.setBorder(border);
		textArea_diagnostico.setLineWrap(true);
		textArea_diagnostico.setWrapStyleWord(true);
		panel_1.add(textArea_diagnostico);
		
		JScrollPane scrollPane_diagnostico = new JScrollPane(textArea_diagnostico);
		scrollPane_diagnostico.setBounds(147, 126, 230, 34);
        
        panel_1.add(scrollPane_diagnostico);

        textArea_evolucion = new JTextArea();
        textArea_evolucion.setBounds(147, 326, 230, 34);
        textArea_evolucion.setRows(10);
        textArea_evolucion.setBorder(border);
        textArea_evolucion.setLineWrap(true);
        textArea_evolucion.setWrapStyleWord(true);
		panel_1.add(textArea_evolucion);
		
		JScrollPane scrollPane_evolucion = new JScrollPane(textArea_evolucion);
		scrollPane_evolucion.setBounds(147, 326, 230, 34);
        
        panel_1.add(scrollPane_evolucion);
        
        textArea_indicaciones = new JTextArea();
        textArea_indicaciones.setBounds(147, 376, 230, 34);
        textArea_indicaciones.setRows(10);
        textArea_indicaciones.setBorder(border);
        textArea_indicaciones.setLineWrap(true);
        textArea_indicaciones.setWrapStyleWord(true);
		panel_1.add(textArea_indicaciones);
		
		JScrollPane scrollPane_indicaciones = new JScrollPane(textArea_indicaciones);
		scrollPane_indicaciones.setBounds(147, 376, 230, 34);
        
        panel_1.add(scrollPane_indicaciones);

		//Título
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 255));
		panel_2.setBounds(183, 0, 801, 57);
		contentPane.add(panel_2);
		panel_2.setLayout(null);


		JLabel lblNewLabel_11 = new JLabel("Registro Visita Médica");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(10, 21, 791, 25);
		panel_2.add(lblNewLabel_11);
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		
		lvr = new Logic_View_Register(this);
	}
}
