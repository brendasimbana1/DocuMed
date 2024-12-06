package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
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

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class View_Register extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnPrincipal;
	public JButton btnNuevoRegistro;
	public JButton btnNuevoPaciente;
	public JTextField txt_ci;
	public JTextField txt_presion;
	public JButton btn_registro_visita;
	public JTextArea textArea_diagnostico;
	public JTextArea textArea_evolucion;
	public JTextArea textArea_indicaciones;
	public JSpinner spn_peso;
	public JSpinner spn_altura;
	public JSpinner spn_temp;
	public JTextField txt_responsable;
	public JDateChooser dateChooser;
	public JButton btn_buscar;
	public JTextField txt_apellidos;
	public JTextField txt_nombres;
	public JTextField txt_edad;
	public JPanel panel_info;
	public JPanel panel_content;
	public JButton btnSalir;
	public JButton btnListado;
	public JButton btnLista;

	public Logic_View_Register lvr;

	public View_Register() {
		initializeFrame();
		createComponents();
		setupListeners();
	}

	private void initializeFrame() {
		setTitle("DocuMed - Registro Visitas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMinimumSize(new Dimension(800, 600));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setMinimumSize(new Dimension(screenSize.width, screenSize.height));
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(10, 10));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	private void createComponents() {
		JPanel sidebarPanel = createSidebarPanel();
		getContentPane().add(sidebarPanel, BorderLayout.WEST);

		JPanel topPanel = createTopPanel();
		getContentPane().add(topPanel, BorderLayout.NORTH);

		JPanel mainContentPanel = createMainContentPanel();
		getContentPane().add(mainContentPanel);
	}

	private JPanel createSidebarPanel() {
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setBackground(new Color(0, 82, 164));
		sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
		sidebarPanel.setPreferredSize(new Dimension(200, getHeight()));

		JLabel titleLabel = new JLabel("DocuMed", SwingConstants.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		titleLabel.setAlignmentX(CENTER_ALIGNMENT);

		btnPrincipal = createStyledButton("Principal", new ImageIcon(getClass().getResource("/resources/casa.png")));
		btnNuevoRegistro = createStyledButton("Nuevo Registro", new ImageIcon(getClass().getResource("/resources/registro.png")));
		btnNuevoPaciente = createStyledButton("Nuevo Paciente", new ImageIcon(getClass().getResource("/resources/nueva-cuenta.png")));
		btnLista = createStyledButton("Lista Pacientes", new ImageIcon(getClass().getResource("/resources/lista.png")));
		btnSalir = createStyledButton("Cerrar Sesión", new ImageIcon(getClass().getResource("/resources/cerrar-sesion.png")));

		sidebarPanel.add(Box.createVerticalStrut(20));
		sidebarPanel.add(titleLabel);
		sidebarPanel.add(Box.createVerticalStrut(20));
		sidebarPanel.add(btnPrincipal);
		sidebarPanel.add(btnNuevoRegistro);
		sidebarPanel.add(btnNuevoPaciente);
		sidebarPanel.add(btnListado);
		sidebarPanel.add(btnLista);
		sidebarPanel.add(Box.createVerticalGlue());
		sidebarPanel.add(btnSalir);
		sidebarPanel.add(Box.createVerticalStrut(20));

		return sidebarPanel;
	}

	private JButton createStyledButton(String text, ImageIcon icon) {
		JButton button = new JButton(text, icon);
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 82, 164));
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		button.setAlignmentX(CENTER_ALIGNMENT);
		button.setIconTextGap(10);
		return button;
	}

	private JPanel createTopPanel() {
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(0, 128, 255));
		topPanel.setLayout(new BorderLayout());
		topPanel.setPreferredSize(new Dimension(getWidth(), 100));

		JLabel titleLabel = new JLabel("Registro de Visita Médica");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 10));
		topPanel.add(titleLabel, BorderLayout.CENTER);

		return topPanel;

	}



	private JPanel createMainContentPanel() {
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
		lblNewLabel.setBounds(10, 14, 87, 13);
		panel_info.add(lblNewLabel);

		txt_nombres = new JTextField();
		txt_nombres.setEnabled(false);
		txt_nombres.setEditable(false);
		txt_nombres.setBounds(10, 28, 212, 22);
		panel_info.add(txt_nombres);
		txt_nombres.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidos.setBounds(10, 58, 93, 13);
		panel_info.add(lblApellidos);

		txt_apellidos = new JTextField();
		txt_apellidos.setEnabled(false);
		txt_apellidos.setEditable(false);
		txt_apellidos.setColumns(10);
		txt_apellidos.setBounds(10, 72, 212, 22);
		panel_info.add(txt_apellidos);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEdad.setBounds(10, 102, 48, 13);
		panel_info.add(lblEdad);

		txt_edad = new JTextField();
		txt_edad.setEnabled(false);
		txt_edad.setEditable(false);
		txt_edad.setColumns(10);
		txt_edad.setBounds(51, 100, 87, 22);
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

		txt_presion = new JTextField();
		txt_presion.setBounds(418, 87, 96, 20);
		panel_content.add(txt_presion);
		txt_presion.setColumns(10);

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

		txt_responsable = new JTextField();
		txt_responsable.setBounds(527, 220, 232, 20);
		panel_content.add(txt_responsable);
		txt_responsable.setColumns(10);

		btn_registro_visita = new JButton("Registrar");
		btn_registro_visita.setBounds(282, 270, 232, 25);
		panel_content.add(btn_registro_visita);
		btn_registro_visita.setFont(new Font("Tahoma", Font.PLAIN, 13));

		return panel_1;
	}

	private void setupListeners() {
		btnSalir.addActionListener(e -> {
			new View_Login().setVisible(true);
			dispose();
		});

		// Initialize Logic_View_Register
		lvr = new Logic_View_Register(this);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
			View_Home window = new View_Home();
			window.setSize(1024, 768);
			window.setLocationRelativeTo(null);
			window.setVisible(true);
		});
	}
}