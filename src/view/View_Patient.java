package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import controller.Logic_View_Patient;

public class View_Patient extends JFrame {
    public JButton btnNuevoPaciente;
    public JButton btnNuevoRegistro;
    public JButton btnPrincipal;
    public JButton btnListado;
    public JButton btnSalir;
    public JButton btnLista;
    
    public JTextField txt_ci;
    public JTextField txt_nombres;
    public JTextField txt_apellidos;
    public JTextField txt_ocupacion;
    public JTextField txt_profesion;
    public JTextField txt_lugar;
    public JTextField txt_edad;
    
    public JDateChooser date_nacimiento;
    public JTextField date_actual;
    
    public JTextArea textArea_ant_personales;
    public JTextArea textArea_ant_familiares;
    public JTextArea textArea_ant_gineco_obs;
    public JTextArea textArea_telefono;
    
    public JComboBox<Character> cmb_genero;
    public JButton btn_registro_paciente;
    
    private Logic_View_Patient lvp;

    public View_Patient() {
        initializeFrame();
        createComponents();
        setupListeners();
    }

    private void initializeFrame() {
        setTitle("DocuMed - Registro de Pacientes");
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

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(createPatientDetailsPanel(), gbc);

        gbc.gridx = 1;
        mainPanel.add(createMedicalHistoryPanel(), gbc);

        btn_registro_paciente = new JButton("Registrar Paciente");
        btn_registro_paciente.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(btn_registro_paciente, gbc);

        return mainPanel;
    }

    private JPanel createPatientDetailsPanel() {
        JPanel detailsPanel = new JPanel(new GridBagLayout());
        detailsPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Fuente personalizada
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        Dimension textFieldDimension = new Dimension(250, 30);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel ciLabel = new JLabel("C.I.:");
        ciLabel.setFont(labelFont);
        detailsPanel.add(ciLabel, gbc);
        gbc.gridx = 1;
        txt_ci = new JTextField();
        txt_ci.setFont(textFieldFont);
        txt_ci.setPreferredSize(textFieldDimension);
        detailsPanel.add(txt_ci, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel nombresLabel = new JLabel("Nombres:");
        nombresLabel.setFont(labelFont);
        detailsPanel.add(nombresLabel, gbc);
        gbc.gridx = 1;
        txt_nombres = new JTextField();
        txt_nombres.setFont(textFieldFont);
        txt_nombres.setPreferredSize(textFieldDimension);
        detailsPanel.add(txt_nombres, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel apellidosLabel = new JLabel("Apellidos:");
        apellidosLabel.setFont(labelFont);
        detailsPanel.add(apellidosLabel, gbc);
        gbc.gridx = 1;
        txt_apellidos = new JTextField();
        txt_apellidos.setFont(textFieldFont);
        txt_apellidos.setPreferredSize(textFieldDimension);
        detailsPanel.add(txt_apellidos, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel generoLabel = new JLabel("Género:");
        generoLabel.setFont(labelFont);
        detailsPanel.add(generoLabel, gbc);
        gbc.gridx = 1;
        cmb_genero = new JComboBox<>();
        cmb_genero.setFont(textFieldFont);
        cmb_genero.setPreferredSize(textFieldDimension);
        detailsPanel.add(cmb_genero, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel ocupacionLabel = new JLabel("Ocupación:");
        ocupacionLabel.setFont(labelFont);
        detailsPanel.add(ocupacionLabel, gbc);
        gbc.gridx = 1;
        txt_ocupacion = new JTextField();
        txt_ocupacion.setFont(textFieldFont);
        txt_ocupacion.setPreferredSize(textFieldDimension);
        detailsPanel.add(txt_ocupacion, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel profesionLabel = new JLabel("Profesión:");
        profesionLabel.setFont(labelFont);
        detailsPanel.add(profesionLabel, gbc);
        gbc.gridx = 1;
        txt_profesion = new JTextField();
        txt_profesion.setFont(textFieldFont);
        txt_profesion.setPreferredSize(textFieldDimension);
        detailsPanel.add(txt_profesion, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lugarNacimientoLabel = new JLabel("Lugar de Nacimiento:");
        lugarNacimientoLabel.setFont(labelFont);
        detailsPanel.add(lugarNacimientoLabel, gbc);
        gbc.gridx = 1;
        txt_lugar = new JTextField();
        txt_lugar.setFont(textFieldFont);
        txt_lugar.setPreferredSize(textFieldDimension);
        detailsPanel.add(txt_lugar, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel fechaNacimientoLabel = new JLabel("Fecha Nacimiento:");
        fechaNacimientoLabel.setFont(labelFont);
        detailsPanel.add(fechaNacimientoLabel, gbc);
        gbc.gridx = 1;
        date_nacimiento = new JDateChooser(new Date());
        date_nacimiento.setPreferredSize(new Dimension(250, 30));
        detailsPanel.add(date_nacimiento, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel fechaActualLabel = new JLabel("Fecha Actual:");
        fechaActualLabel.setFont(labelFont);
        detailsPanel.add(fechaActualLabel, gbc);
        gbc.gridx = 1;
        date_actual =new JTextField();
        date_actual.setPreferredSize(new Dimension(250, 30));
        detailsPanel.add(date_actual, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel telefonoLabel = new JLabel("Teléfonos:");
        telefonoLabel.setFont(labelFont);
        detailsPanel.add(telefonoLabel, gbc);
        gbc.gridx = 1;
        textArea_telefono = new JTextArea(2, 30);
        textArea_telefono.setFont(textFieldFont);
        textArea_telefono.setLineWrap(true);
        detailsPanel.add(new JScrollPane(textArea_telefono), gbc);

        return detailsPanel;
    }

    private JPanel createMedicalHistoryPanel() {
        JPanel historyPanel = new JPanel(new GridBagLayout());
        historyPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Fuente personalizada
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font textAreaFont = new Font("Arial", Font.PLAIN, 14);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel personalesLabel = new JLabel("Antecedentes Personales:");
        personalesLabel.setFont(labelFont);
        historyPanel.add(personalesLabel, gbc);
        gbc.gridy++;
        textArea_ant_personales = new JTextArea(5, 30);
        textArea_ant_personales.setFont(textAreaFont);
        textArea_ant_personales.setLineWrap(true);
        historyPanel.add(new JScrollPane(textArea_ant_personales), gbc);

        gbc.gridy++;
        JLabel familiaresLabel = new JLabel("Antecedentes Familiares:");
        familiaresLabel.setFont(labelFont);
        historyPanel.add(familiaresLabel, gbc);
        gbc.gridy++;
        textArea_ant_familiares = new JTextArea(5, 30);
        textArea_ant_familiares.setFont(textAreaFont);
        textArea_ant_familiares.setLineWrap(true);
        historyPanel.add(new JScrollPane(textArea_ant_familiares), gbc);

        gbc.gridy++;
        JLabel ginecoLabel = new JLabel("Antecedentes Gineco-obstétricos:");
        ginecoLabel.setFont(labelFont);
        historyPanel.add(ginecoLabel, gbc);
        gbc.gridy++;
        textArea_ant_gineco_obs = new JTextArea(5, 30);
        textArea_ant_gineco_obs.setFont(textAreaFont);
        textArea_ant_gineco_obs.setLineWrap(true);
        historyPanel.add(new JScrollPane(textArea_ant_gineco_obs), gbc);

        return historyPanel;
    }

    private JPanel createTitlePanel() {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0, 128, 255));
        topPanel.setLayout(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(getWidth(), 100));

        JLabel titleLabel = new JLabel("Registro de Nuevo Paciente");
        titleLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 10));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        return topPanel;
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
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new View_Login().setVisible(true);
            }
        });

        lvp = new Logic_View_Patient(this);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            View_Patient window = new View_Patient();
            window.setSize(1024, 768);
            window.setLocationRelativeTo(null);
            window.setVisible(true);
        });
    }
}