package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;

public class View_Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JDateChooser dateChooser;
	private JTextField txt_ci;
	private JTextField txt_presion;
	private JTextField txt_responsable;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);


		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 82, 164));
		panel.setBounds(0, 0, 184, 463);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNuevoPaciente = new JButton("Nuevo Paciente");
		btnNuevoPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		btnNuevoPaciente.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		btnNuevoPaciente.setForeground(Color.WHITE);
		btnNuevoPaciente.setBackground(new Color(0, 82, 164));  
		btnNuevoPaciente.setBorderPainted(false);  
		btnNuevoPaciente.setFocusPainted(false);   
		btnNuevoPaciente.setBounds(46, 250, 138, 43);
		panel.add(btnNuevoPaciente);

		JButton btnNuevoRegistro = new JButton("Nuevo Registro");
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

		JButton btnPrincipal = new JButton("Principal");
		btnPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		btnPrincipal.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		btnPrincipal.setForeground(Color.WHITE);
		btnPrincipal.setBackground(new Color(0, 82, 164));  
		btnPrincipal.setBorderPainted(false);  
		btnPrincipal.setFocusPainted(false);   
		btnPrincipal.setBounds(46, 166, 138, 43);
		panel.add(btnPrincipal);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(183, 57, 605, 402);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_6_1_1 = new JLabel("Sistema de Gestión de Pacientes");
		lblNewLabel_6_1_1.setBounds(27, 0, 295, 25);
		panel_1.add(lblNewLabel_6_1_1);
		lblNewLabel_6_1_1.setForeground(Color.BLACK);
		lblNewLabel_6_1_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));

		JLabel fecha_label = new JLabel("Fecha atención:");
		fecha_label.setForeground(Color.BLACK);
		fecha_label.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label.setBounds(27, 22, 138, 36);
		panel_1.add(fecha_label);

		//Se puede poner la hora con JCalendarDemo, revisar documentación eligir luego

		dateChooser = new JDateChooser(new Date());
		dateChooser.setBounds(161, 27, 124, 25);
		panel_1.add(dateChooser);

		JButton jbSeleccFecha = new JButton("Obtener fecha seleccionada");
		jbSeleccFecha.setBounds(161, 353, 232, 25);
		panel_1.add(jbSeleccFecha);
		
		JLabel fecha_label_1 = new JLabel("C.I.:");
		fecha_label_1.setForeground(Color.BLACK);
		fecha_label_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1.setBounds(27, 52, 138, 36);
		panel_1.add(fecha_label_1);
		
		txt_ci = new JTextField();
		txt_ci.setBounds(161, 63, 96, 20);
		panel_1.add(txt_ci);
		txt_ci.setColumns(10);
		
		JLabel fecha_label_1_1 = new JLabel("Diagnostico:");
		fecha_label_1_1.setForeground(Color.BLACK);
		fecha_label_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1_1.setBounds(27, 80, 138, 36);
		panel_1.add(fecha_label_1_1);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		JTextArea textArea_diagnostico = new JTextArea();
		textArea_diagnostico.setForeground(new Color(0, 0, 0));
		textArea_diagnostico.setBounds(161, 89, 203, 20);
		textArea_diagnostico.setBorder(border);
		panel_1.add(textArea_diagnostico);
		
		JLabel fecha_label_1_1_1 = new JLabel("Peso:");
		fecha_label_1_1_1.setForeground(Color.BLACK);
		fecha_label_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1_1_1.setBounds(27, 112, 138, 36);
		panel_1.add(fecha_label_1_1_1);
		
		JLabel fecha_label_1_1_1_1 = new JLabel("Altura:");
		fecha_label_1_1_1_1.setForeground(Color.BLACK);
		fecha_label_1_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1_1_1_1.setBounds(27, 154, 138, 36);
		panel_1.add(fecha_label_1_1_1_1);
		
		JLabel fecha_label_1_1_1_1_1 = new JLabel("Temperatura:");
		fecha_label_1_1_1_1_1.setForeground(Color.BLACK);
		fecha_label_1_1_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_1_1_1_1_1.setBounds(27, 199, 138, 36);
		panel_1.add(fecha_label_1_1_1_1_1);
		
		JSpinner spn_temp = new JSpinner();
		spn_temp.setBounds(161, 209, 73, 20);
		panel_1.add(spn_temp);
		
		JSpinner spn_altura = new JSpinner();
		spn_altura.setBounds(161, 164, 73, 20);
		panel_1.add(spn_altura);
		
		JSpinner spn_peso = new JSpinner();
		spn_peso.setBounds(161, 122, 73, 20);
		panel_1.add(spn_peso);
		
		JLabel fecha_label_7 = new JLabel("Presión Arterial:");
		fecha_label_7.setForeground(Color.BLACK);
		fecha_label_7.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_7.setBounds(27, 239, 138, 36);
		panel_1.add(fecha_label_7);
		
		txt_presion = new JTextField();
		txt_presion.setColumns(10);
		txt_presion.setBounds(161, 249, 96, 20);
		panel_1.add(txt_presion);
		
		JLabel fecha_label_8 = new JLabel("Evolución:");
		fecha_label_8.setForeground(Color.BLACK);
		fecha_label_8.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_8.setBounds(27, 274, 138, 36);
		panel_1.add(fecha_label_8);
		
		JTextArea textArea_evolucion = new JTextArea();
		textArea_evolucion.setForeground(Color.BLACK);
		textArea_evolucion.setBounds(161, 282, 203, 20);
		textArea_evolucion.setBorder(border);
		panel_1.add(textArea_evolucion);
		
		JLabel fecha_label_9 = new JLabel("Indicaciones:");
		fecha_label_9.setForeground(Color.BLACK);
		fecha_label_9.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_9.setBounds(27, 313, 138, 36);
		panel_1.add(fecha_label_9);
		
		JTextArea textArea_indicaciones = new JTextArea();
		textArea_indicaciones.setForeground(Color.BLACK);
		textArea_indicaciones.setBounds(161, 313, 203, 20);
		textArea_indicaciones.setBorder(border);
		panel_1.add(textArea_indicaciones);
		
		JLabel fecha_label_10 = new JLabel("Responsable:");
		fecha_label_10.setForeground(Color.BLACK);
		fecha_label_10.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14));
		fecha_label_10.setBounds(323, 154, 138, 36);
		panel_1.add(fecha_label_10);
		
		txt_responsable = new JTextField();
		txt_responsable.setColumns(10);
		txt_responsable.setBounds(426, 164, 124, 20);
		panel_1.add(txt_responsable);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 255));
		panel_2.setBounds(183, 0, 605, 57);
		contentPane.add(panel_2);
		panel_2.setLayout(null);



		JLabel lblNewLabel_6_1 = new JLabel("Consultorios Médicos");
		lblNewLabel_6_1.setBounds(10, 11, 215, 46);
		panel_2.add(lblNewLabel_6_1);
		lblNewLabel_6_1.setForeground(Color.BLACK);
		lblNewLabel_6_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		jbSeleccFecha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Fecha();
			}
		});
	}

	public void Fecha() {
		Calendar calendario = dateChooser.getCalendar();
		System.out.println("----------- Fecha seleccionada ------------");
		int dia = calendario.get(Calendar.DATE); 
		int mes = calendario.get(Calendar.MONTH) + 1;
		int year = calendario.get(Calendar.YEAR);
		System.out.println("dia = " + dia);
		System.out.println("mes = " + mes);
		System.out.println("año = " + year);
	}
}