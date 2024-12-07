package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import controller.Logic_View_Register;

public class View_Register extends JFrame {
	public JButton btnNuevoPaciente;
	public JButton btnNuevoRegistro;
	public JButton btnPrincipal;
	public JButton btnListado;
	public JButton btnLista;
	public JButton btnSalir;

	public JTextField txt_ci;
	public JTextField txt_presion;
	public JTextField txt_nombres;
	public JTextField txt_apellidos;
	public JTextField txt_edad;
	public JTextField txt_responsable;

	public JDateChooser dateChooser;

	public JTextArea textArea_diagnostico;
	public JTextArea textArea_evolucion;
	public JTextArea textArea_indicaciones;

	public JSpinner spn_peso;
	public JSpinner spn_altura;
	public JSpinner spn_temp;

	public JButton btn_buscar;
	public JButton btn_registro_visita;

	public JPanel infoPanel;
	public JPanel detailsPanel;

	public Logic_View_Register lvr;

	public View_Register() {
		initializeFrame();
		createComponents();
		setupListeners();
	}

	private void initializeFrame() {
		setTitle("DocuMed - Registro Visitas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setMinimumSize(new Dimension(screenSize.width, screenSize.height));
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new BorderLayout(10, 10));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	private void createComponents() {
		// Sidebar Panel
		JPanel sidebarPanel = createSidebarPanel();
		add(sidebarPanel, BorderLayout.WEST);

		JPanel mainContentPanel = createMainContentPanel();
		JPanel titlePanel = createTitlePanel();
		add(mainContentPanel, BorderLayout.CENTER);
		add(titlePanel, BorderLayout.NORTH);
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
		btnListado = createStyledButton("Buscar Paciente", new ImageIcon(getClass().getResource("/resources/buscar.png")));
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

	private JPanel createMainContentPanel() {
		JPanel mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		JPanel searchPanel = new JPanel(new GridBagLayout());
		searchPanel.setBackground(Color.WHITE);
		GridBagConstraints searchGbc = new GridBagConstraints();
		searchGbc.insets = new Insets(5, 5, 5, 5);

		searchGbc.gridx = 0;
		searchGbc.gridy = 0;
		searchGbc.anchor = GridBagConstraints.WEST; 
		JLabel ciLabel = new JLabel("C.I.:");
		searchPanel.add(ciLabel, searchGbc);

		searchGbc.gridx = 1;
		txt_ci = new JTextField(20);
		txt_ci.setPreferredSize(new Dimension(150, 30));
		txt_ci.setMinimumSize(new Dimension(150, 30));
		searchPanel.add(txt_ci, searchGbc);

		searchGbc.gridx = 2;
		btn_buscar = new JButton("Buscar");
		searchPanel.add(btn_buscar, searchGbc);

		gbc.gridx = 0; // Primera columna
		gbc.gridy = 0; // Primera fila
		gbc.gridwidth = 1; // Ocupa solo una columna
		gbc.anchor = GridBagConstraints.NORTHWEST; // Alinea arriba a la izquierda
		gbc.weighty = 0; // No permite expansión vertical
		mainPanel.add(searchPanel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0; 
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.weighty = 0; 
		gbc.weightx = 0;
		JPanel infoPanel = createPatientInfoPanel();
		infoPanel.setPreferredSize(new Dimension(300, 200));  // Set a size
		mainPanel.add(infoPanel, gbc);

		gbc.gridx = -1;
		gbc.gridy = 1; 
		gbc.weighty = 0;
		JPanel visit = ayuda();
		visit.setPreferredSize(new Dimension(500, 500));  // Set a size
		mainPanel.add(visit, gbc);

		return mainPanel;
	}

	private JPanel createPatientInfoPanel() {
		infoPanel = new JPanel(new GridBagLayout());
		infoPanel.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.NORTH;

		// Fuente personalizada
		Font labelFont = new Font("Arial", Font.BOLD, 16);
		Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
		Dimension textFieldDimension = new Dimension(150, 30);

		gbc.gridx = 0;
		gbc.gridy++;
		JLabel nombresLabel = new JLabel("Nombres:");
		nombresLabel.setFont(labelFont);
		infoPanel.add(nombresLabel, gbc);
		gbc.gridx = 1;
		txt_nombres = new JTextField(20);
		txt_nombres.setFont(textFieldFont);
		txt_nombres.setPreferredSize(textFieldDimension);
		txt_nombres.setMinimumSize(textFieldDimension);
		txt_nombres.setEditable(false);
		infoPanel.add(txt_nombres, gbc);
		System.out.println("Dimension: " + txt_nombres.getPreferredSize());


		gbc.gridx = 0;
		gbc.gridy++;
		JLabel apellidosLabel = new JLabel("Apellidos:");
		apellidosLabel.setFont(labelFont);
		infoPanel.add(apellidosLabel, gbc);
		gbc.gridx = 1;
		txt_apellidos = new JTextField(20);
		txt_apellidos.setFont(textFieldFont);
		txt_apellidos.setPreferredSize(textFieldDimension);
		txt_apellidos.setMinimumSize(textFieldDimension);
		txt_apellidos.setEditable(false);
		infoPanel.add(txt_apellidos, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		JLabel edadLabel = new JLabel("Edad:");
		edadLabel.setFont(labelFont);
		infoPanel.add(edadLabel, gbc);
		gbc.gridx = 1;
		txt_edad = new JTextField(20);
		txt_edad.setFont(textFieldFont);
		txt_edad.setPreferredSize(textFieldDimension);
		txt_edad.setMinimumSize(textFieldDimension);
		txt_edad.setEditable(false);
		infoPanel.add(txt_edad, gbc);

		return infoPanel;
	}
	
	private JPanel ayuda() {
		detailsPanel = new JPanel(new GridBagLayout());
		detailsPanel.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;  // Important: allows components to expand
		gbc.weightx = 1.0;  // Horizontal expansion
		gbc.weighty = 1.0;  // Vertical expansion
		
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
		JPanel infoPanel = createVisitDetailsPanel();
		infoPanel.setPreferredSize(new Dimension(300, 500));  // Set a size
		detailsPanel.add(infoPanel, gbc);

		gbc.gridx = 1;
		JPanel visit = createDetalles();
		visit.setPreferredSize(new Dimension(300, 500));  // Set a size
		detailsPanel.add(visit, gbc);
		return detailsPanel;
	}

	private JPanel createDetalles() {
		JPanel detailsPanel = new JPanel(new GridBagLayout());
		detailsPanel.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		
		Font labelFont = new Font("Arial", Font.BOLD, 16);
		Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
		Dimension textFieldDimension = new Dimension(150, 30);
		
		gbc.gridx = 0;
		gbc.gridy=0;
		JLabel diagnosticoLabel = new JLabel("Diagnóstico:");
		diagnosticoLabel.setFont(labelFont);
		detailsPanel.add(diagnosticoLabel, gbc);
		gbc.gridx = 1;
		textArea_diagnostico = new JTextArea(3, 20);
		textArea_diagnostico.setLineWrap(true);
		textArea_diagnostico.setWrapStyleWord(true);
		JScrollPane scrollDiagnostico = new JScrollPane(textArea_diagnostico);
		scrollDiagnostico.setPreferredSize(new Dimension(250, 80));
		scrollDiagnostico.setMinimumSize(new Dimension(250, 80));
		detailsPanel.add(scrollDiagnostico, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		JLabel evolucionLabel = new JLabel("Evolución:");
		evolucionLabel.setFont(labelFont);
		detailsPanel.add(evolucionLabel, gbc);
		gbc.gridx = 1;
		textArea_evolucion = new JTextArea(3, 20);
		textArea_evolucion.setLineWrap(true);
		textArea_evolucion.setWrapStyleWord(true);
		JScrollPane scrollEvolucion = new JScrollPane(textArea_evolucion);
		scrollEvolucion.setPreferredSize(new Dimension(250, 80));
		scrollEvolucion.setMinimumSize(new Dimension(250, 80));
		detailsPanel.add(scrollEvolucion, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		JLabel indicacionesLabel = new JLabel("Indicaciones:");
		indicacionesLabel.setFont(labelFont);
		detailsPanel.add(indicacionesLabel, gbc);
		gbc.gridx = 1;
		textArea_indicaciones = new JTextArea(3, 20);
		textArea_indicaciones.setLineWrap(true);
		textArea_indicaciones.setWrapStyleWord(true);
		JScrollPane scrollIndicaciones = new JScrollPane(textArea_indicaciones);
		scrollIndicaciones.setPreferredSize(new Dimension(250, 80));
		scrollIndicaciones.setMinimumSize(new Dimension(250, 80));
		detailsPanel.add(scrollIndicaciones, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		JLabel resposableLabel = new JLabel("Responsable:");
		resposableLabel.setFont(labelFont);
		detailsPanel.add(resposableLabel, gbc);
		gbc.gridx = 1;
		txt_responsable = new JTextField();
		txt_responsable.setFont(textFieldFont);
		txt_responsable.setPreferredSize(textFieldDimension);
		txt_responsable.setMinimumSize(textFieldDimension);
		detailsPanel.add(txt_responsable, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		btn_registro_visita = new JButton("Registrar Visita");
		btn_registro_visita.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		detailsPanel.add(btn_registro_visita, gbc);
		return detailsPanel;
	}
	private JPanel createVisitDetailsPanel() {
		JPanel detailsPanel = new JPanel(new GridBagLayout());
		detailsPanel.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;

		Font labelFont = new Font("Arial", Font.BOLD, 16);
		Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
		Dimension textFieldDimension = new Dimension(150, 30);

		SpinnerNumberModel modelPeso = new SpinnerNumberModel(0.1, 0.1, 200.0, 0.1);
		SpinnerNumberModel modelAltura = new SpinnerNumberModel(1, 1, 230, 1);
		SpinnerNumberModel modelTemperatura = new SpinnerNumberModel(0.01, 0.01, 50, 0.01);

		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel fechaLabel = new JLabel("Fecha atención:");
		fechaLabel.setFont(labelFont);
		detailsPanel.add(fechaLabel, gbc);
		gbc.gridx = 1;
		dateChooser = new JDateChooser(new Date());
		dateChooser.setPreferredSize(new Dimension(90, 30));
		dateChooser.setMinimumSize(new Dimension(90, 30));
		detailsPanel.add(dateChooser, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		JLabel pesoLabel = new JLabel("Peso (kg):");
		pesoLabel.setFont(labelFont);
		detailsPanel.add(pesoLabel, gbc);
		gbc.gridx = 1;
		spn_peso = new JSpinner(modelPeso);
		spn_peso.setFont(textFieldFont);
		spn_peso.setPreferredSize(textFieldDimension);
		spn_peso.setMinimumSize(new Dimension(90, 30));
		detailsPanel.add(spn_peso, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		JLabel alturaLabel = new JLabel("Altura (cm):");
		alturaLabel.setFont(labelFont);
		detailsPanel.add(alturaLabel, gbc);
		gbc.gridx = 1;
		spn_altura = new JSpinner(modelAltura);
		spn_altura.setFont(textFieldFont);
		spn_altura.setPreferredSize(textFieldDimension);
		spn_altura.setMinimumSize(new Dimension(90, 30));
		detailsPanel.add(spn_altura, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		JLabel tempLabel = new JLabel("Temperatura (°C):");
		tempLabel.setFont(labelFont);
		detailsPanel.add(tempLabel, gbc);
		gbc.gridx = 1;
		spn_temp = new JSpinner(modelTemperatura);
		spn_temp.setFont(textFieldFont);
		spn_temp.setPreferredSize(textFieldDimension);
		spn_temp.setMinimumSize(new Dimension(90, 30));
		detailsPanel.add(spn_temp, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		JLabel presionLabel = new JLabel("Presión Arterial:");
		presionLabel.setFont(labelFont);
		detailsPanel.add(presionLabel, gbc);
		gbc.gridx = 1;
		txt_presion = new JTextField(20);
		txt_presion.setFont(textFieldFont);
		txt_presion.setPreferredSize(new Dimension(90, 30));
		txt_presion.setMinimumSize(new Dimension(90, 30));
		detailsPanel.add(txt_presion, gbc);

		
		return detailsPanel;	
	}
	private JPanel createTitlePanel() {
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 128, 255));
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setPreferredSize(new Dimension(getWidth(), 100));

		JLabel titleLabel = new JLabel("Registro de Visita Médica");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
		titlePanel.add(titleLabel, BorderLayout.CENTER);

		return titlePanel;
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

	private void setupListeners() {
		lvr = new Logic_View_Register(this);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
			View_Register window = new View_Register();
			window.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximize window
			window.setVisible(true);
		});
	}
}