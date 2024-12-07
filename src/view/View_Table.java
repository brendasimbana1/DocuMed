package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

import controller.Logic_View_Table;

public class View_Table extends JFrame {
    public JButton btnNuevoPaciente;
    public JButton btnNuevoRegistro;
    public JButton btnPrincipal;
    public JButton btnListado;
    public JButton btnSalir;
    
    public JTextField txt_ci;
    public JButton btn_buscar;
    public JButton btn_registros;
    public JButton btn_editar;
    public JButton btnLista;
    public JButton btnExamen;
    public JButton btn_guardar;
    
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
    
    public JTextArea textArea_ant_personales;
    public JTextArea textArea_ant_familiares;
    public JTextArea textArea_ant_gineco_obs;
    
    public JLabel[] labelArray;
    public  JTextField[] textFields;
    
    private Logic_View_Table lvt;

    public View_Table() {
        initializeFrame();
        createComponents();
        setupListeners();
    }

    private void initializeFrame() {
        setTitle("DocuMed - Búsqueda de Paciente");
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

        Font labelFont = new Font("Arial", Font.BOLD, 16); // Fuente para los labels
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14); // Fuente para los campos de texto
        Dimension textFieldDimension = new Dimension(250, 30); // Dimensiones para los campos de texto

        // Search Section
        JPanel searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setBackground(Color.WHITE);
        GridBagConstraints searchGbc = new GridBagConstraints();
        searchGbc.insets = new Insets(5, 5, 5, 5);

        searchGbc.gridx = 0;
        searchGbc.gridy = 0;
        JLabel ciLabel = new JLabel("C.I.:");
        ciLabel.setFont(labelFont);
        searchPanel.add(ciLabel, searchGbc);

        searchGbc.gridx = 1;
        txt_ci = new JTextField(20);
        txt_ci.setFont(textFieldFont);
        txt_ci.setPreferredSize(textFieldDimension);
        searchPanel.add(txt_ci, searchGbc);

        searchGbc.gridx = 2;
        btn_buscar = new JButton("Buscar");
        btn_buscar.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        searchPanel.add(btn_buscar, searchGbc);

        searchGbc.gridx = 3;
        btn_registros = new JButton("Ver Registros");
        btn_registros.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        searchPanel.add(btn_registros, searchGbc);

        searchGbc.gridx = 4;
        btn_editar = new JButton("Editar");
        btn_editar.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        searchPanel.add(btn_editar, searchGbc);
        
        searchGbc.gridx = 4;
        btn_guardar = new JButton("Guardar");
        btn_guardar.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        btn_guardar.setVisible(false);
        searchPanel.add(btn_guardar, searchGbc);

        searchGbc.gridx = 5;
        btnExamen = new JButton("Añadir Exámen");
        btnExamen.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        searchPanel.add(btnExamen, searchGbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(searchPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JPanel patientDetailsPanel = createPatientDetailsPanel();
        applyFontAndSizeToComponents(patientDetailsPanel, labelFont, textFieldFont, textFieldDimension);
        mainPanel.add(patientDetailsPanel, gbc);

        gbc.gridx = 1;
        JPanel medicalHistoryPanel = createMedicalHistoryPanel();
        applyFontAndSizeToComponents(medicalHistoryPanel, labelFont, textFieldFont, textFieldDimension);
        mainPanel.add(medicalHistoryPanel, gbc);

        return mainPanel;
    }

    /**
     * Método para aplicar fuentes y tamaños a todos los componentes de un panel.
     */
    private void applyFontAndSizeToComponents(JPanel panel, Font labelFont, Font textFieldFont, Dimension textFieldDimension) {
        for (Component component : panel.getComponents()) {
            if (component instanceof JLabel) {
                component.setFont(labelFont);
            } else if (component instanceof JTextField) {
                component.setFont(textFieldFont);
                ((JTextField) component).setPreferredSize(textFieldDimension);
            } else if (component instanceof JScrollPane) {
                Component viewportComponent = ((JScrollPane) component).getViewport().getView();
                if (viewportComponent instanceof JTextArea) {
                    viewportComponent.setFont(textFieldFont);
                }
            }
        }
    }


    private JPanel createPatientDetailsPanel() {
        JPanel detailsPanel = new JPanel(new GridBagLayout());
        detailsPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        String[] labels = {"Nombres:", "Apellidos:", "Ocupación:", "Profesión:", 
                           "Fecha Nacimiento:", "Fecha Registro:", "Teléfonos:", 
                           "Género:", "Lugar Nacimiento:", "Edad:"};
        textFields = new  JTextField[]{txt_nombres, txt_apellidos, txt_ocupacion, 
                                   txt_profesion, txt_fNacimiento, txt_fRegistro, 
                                   txt_telefonos, txt_genero, txt_lugar, txt_edad};

        labelArray = new JLabel[labels.length];
        
        //Cambios de tamaño y fuente
        Font labelFont = new Font("Arial", Font.BOLD, 16); 
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        Dimension textFieldDimension = new Dimension(250, 30);
        
        for (int i = 0; i < labels.length; i++) {
        	gbc.gridx = 0;
            gbc.gridy = i;

            JLabel label = new JLabel(labels[i]);
            label.setFont(labelFont);
            labelArray[i] = label;
            detailsPanel.add(label, gbc);
            
            gbc.gridx = 1;
            textFields[i] = new JTextField(20);
            textFields[i].setEditable(false);
            textFields[i].setFont(textFieldFont); 
            textFields[i].setPreferredSize(textFieldDimension);
            detailsPanel.add(textFields[i], gbc);
        }

        txt_nombres = textFields[0];
        txt_apellidos = textFields[1];
        txt_ocupacion = textFields[2];
        txt_profesion = textFields[3];
        txt_fNacimiento = textFields[4];
        txt_fRegistro = textFields[5];
        txt_telefonos = textFields[6];
        txt_genero = textFields[7];
        txt_lugar = textFields[8];
        txt_edad = textFields[9];

        return detailsPanel;
    }

    private JPanel createMedicalHistoryPanel() {
        JPanel historyPanel = new JPanel(new GridBagLayout());
        historyPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        String[] labels = {"Antecedentes Personales:", 
                           "Antecedentes Familiares:", 
                           "Antecedentes Gineco-obstétricos:"};
        JTextArea[] textAreas = new JTextArea[3];

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i * 2;
            historyPanel.add(new JLabel(labels[i]), gbc);

            gbc.gridy = i * 2 + 1;
            textAreas[i] = new JTextArea(5, 30);
            textAreas[i].setLineWrap(true);
            textAreas[i].setEditable(false);
            textAreas[i].setBorder(border);
            historyPanel.add(new JScrollPane(textAreas[i]), gbc);
        }

        textArea_ant_personales = textAreas[0];
        textArea_ant_familiares = textAreas[1];
        textArea_ant_gineco_obs = textAreas[2];

        return historyPanel;
    }

    private JPanel createTitlePanel() {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0, 128, 255));
        topPanel.setLayout(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(getWidth(), 100));

        JLabel titleLabel = new JLabel("Búsqueda de Pacientes");
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

        lvt = new Logic_View_Table(this);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            View_Table window = new View_Table();
            window.setSize(1024, 768);
            window.setLocationRelativeTo(null);
            window.setVisible(true);
        });
    }
}