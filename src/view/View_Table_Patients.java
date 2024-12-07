package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.Logic_View_Table_Patients;

public class View_Table_Patients extends JFrame {
    public JButton btnNuevoPaciente;
    public JButton btnNuevoRegistro;
    public JButton btnPrincipal;
    public JButton btnListado;
    public JButton btnSalir;
    public JButton btnLista;

    public JTable table;
    public DefaultTableModel model;

    private Logic_View_Table_Patients lvtp;

    public View_Table_Patients() {
        initializeFrame();
        createComponents();
        setupListeners();
    }

    private void initializeFrame() {
        setTitle("DocuMed - Listado de Pacientes");
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
        btnLista = createStyledButton("Lista Pacientes", new ImageIcon(getClass().getResource("/resources/lista.png")));
        btnListado = createStyledButton("Buscar Paciente", new ImageIcon(getClass().getResource("/resources/buscar.png")));
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

        // Create table model with existing column names
        String[] labels = {"Cédula", "Nombres", "Apellidos", "Ocupación", "Profesión", 
                           "Fecha de Nacimiento", "Edad", "Teléfonos", "Género", 
                           "Lugar de Nacimiento", "Ant. Personales", "Ant. Familiares", "Ant.Gineco-Obst"};
        model = new DefaultTableModel(null, labels) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Create table with the model
        table = new JTable(model);
        table.setBackground(Color.WHITE);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();

                if (row >= 0 && column >= 0) {
                    Object value = table.getValueAt(row, column);
                    String contenido = value != null ? value.toString() : "Celda vacía";

                    JOptionPane.showMessageDialog(View_Table_Patients.this, contenido, "Contenido de la Celda", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(scrollPane, gbc);

        return mainPanel;
    }

    private JPanel createTitlePanel() {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0, 128, 255));
        topPanel.setLayout(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(getWidth(), 100));

        JLabel titleLabel = new JLabel("Listado de Pacientes");
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

        lvtp = new Logic_View_Table_Patients(this);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            View_Table_Patients window = new View_Table_Patients();
            window.setSize(1024, 768);
            window.setLocationRelativeTo(null);
            window.setVisible(true);
        });
    }
}