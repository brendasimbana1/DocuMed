package view;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Logic_View_Home;

public class View_Home extends JFrame {
	public JButton btnNuevoPaciente;
	public JButton btnNuevoRegistro;
	public JButton btnPrincipal;
	public JLabel fecha_label;
	private Logic_View_Home lvh;
	public JButton btnSalir;
	public JButton btnListado;
	private BufferedImage image;

	public View_Home() {
		initializeFrame();
		createComponents();
		setupListeners();
	}

	private void initializeFrame() {
		setTitle("DocuMed - Sistema de Gestión de Pacientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMinimumSize(new Dimension(800, 600));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setMinimumSize(new Dimension(screenSize.width, screenSize.height));
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new BorderLayout(10, 10));
	}

	private void createComponents() {
		// Sidebar Panel
		JPanel sidebarPanel = createSidebarPanel();
		add(sidebarPanel, BorderLayout.WEST);

		// Main Content Panel
		JPanel mainContentPanel = createMainContentPanel();
		JPanel hourPaner = createHourPanel();
		add(mainContentPanel, BorderLayout.CENTER);
		add(hourPaner, BorderLayout.NORTH);
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
		btnSalir = createStyledButton("Cerrar Sesión", new ImageIcon(getClass().getResource("/resources/cerrar-sesion.png")));

		sidebarPanel.add(Box.createVerticalStrut(20));
		sidebarPanel.add(titleLabel);
		sidebarPanel.add(Box.createVerticalStrut(20));
		sidebarPanel.add(btnPrincipal);
		sidebarPanel.add(btnNuevoRegistro);
		sidebarPanel.add(btnNuevoPaciente);
		sidebarPanel.add(btnListado);
		sidebarPanel.add(Box.createVerticalGlue());
		sidebarPanel.add(btnSalir);
		sidebarPanel.add(Box.createVerticalStrut(20));

		return sidebarPanel;
	}

	private JPanel createMainContentPanel() {
		JPanel mainPanel = new JPanel(new GridBagLayout()) {
			protected void paintComponent(Graphics g) {
			    super.paintComponent(g);

			    Graphics2D g2d = (Graphics2D) g.create();

			    Image watermarkImage = null;
			    try {
			        watermarkImage = ImageIO.read(getClass().getResource("/resources/su_salud2.png"));
			    } catch (IOException e) {
			        e.printStackTrace();
			    }

			    if (watermarkImage != null) {
			        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));

			        int x = ((getWidth() - watermarkImage.getWidth(null)) / 2) - 100;
			        int y = (getHeight() - watermarkImage.getHeight(null)) / 2;

			        //g2d.rotate(-Math.PI/4, getWidth()/2, getHeight()/2);

			        g2d.drawImage(watermarkImage, x, y, null);
			    }
			    g2d.dispose();
			}
		};

		mainPanel.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		JLabel welcomeLabel = new JLabel("¡Bienvenido/a!");
		welcomeLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		gbc.gridy = 1;
		mainPanel.add(welcomeLabel, gbc);

		JLabel descriptionLabel = new JLabel(
				"<html>Sistema de Gestión de Pacientes para Centro Médico \"Su Salud\".<br>" +
						"Registro y revisión de antecedentes previos.</html>"
				);
		descriptionLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		gbc.gridy = 2;
		mainPanel.add(descriptionLabel, gbc);

		JLabel featuresLabel = new JLabel(
				"<html>Esta herramienta permite: <br>" +
						"◇ Registro de una nueva visita al médico <br>" +
						"◇ Registro de un nuevo paciente <br>" +
						"◇ Búsqueda de antecedentes <br>" +
						"◇ Generación de reporte</html>"
				);
		featuresLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		gbc.gridy = 3;
		mainPanel.add(featuresLabel, gbc);

		JLabel imageLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/su_salud1.png")));
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridheight = 4;
		mainPanel.add(imageLabel, gbc);

		return mainPanel;
	}
	private JPanel createHourPanel() {
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(0, 128, 255));
		topPanel.setLayout(new BorderLayout());
		topPanel.setPreferredSize(new Dimension(getWidth(), 100));

		// Left side - Title
		JLabel titleLabel = new JLabel("Sistema de Gestión de Pacientes");
		titleLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 10));
		titleLabel.setAlignmentX(LEFT_ALIGNMENT);  
		topPanel.add(titleLabel, BorderLayout.WEST);


		JPanel dateTimePanel = new JPanel();
		dateTimePanel.setOpaque(false);
		dateTimePanel.setLayout(new BoxLayout(dateTimePanel, BoxLayout.Y_AXIS));


		fecha_label = new JLabel();
		fecha_label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		fecha_label.setForeground(Color.WHITE);
		fecha_label.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 10));

		fecha_label.setAlignmentX(RIGHT_ALIGNMENT);    	        
		dateTimePanel.add(fecha_label);

		dateTimePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 20, 10, 10));
		topPanel.add(dateTimePanel, BorderLayout.EAST);

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

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new View_Login().setVisible(true);
				dispose();
			}
		});

		lvh = new Logic_View_Home(this);
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