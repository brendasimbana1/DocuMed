package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Logic_View_Login;

public class View_Login extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final String JOptionPane = null;
	private JPanel contentPane;
	public JTextField textField;
	public JPasswordField passwordField;
	public JButton btnLogin;
	public JButton btnCancelar;
	private Logic_View_Login lvl;

	public View_Login() {
		initializeFrame();
		createComponents();
		setupListeners();
	}

	private void initializeFrame() {
		setTitle("DocuMed - Inicio de Sesión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(400, 500);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
	}

	private void createComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Logo
		JLabel logoLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/su_salud1.png")));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		add(logoLabel, gbc);

		// Título
		JLabel tituloLabel = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
		tituloLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		gbc.gridy = 1;
		add(tituloLabel, gbc);

		// Usuario
		JLabel usuarioLabel = new JLabel("Usuario:");
		usuarioLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		add(usuarioLabel, gbc);

		textField = new JTextField();
		textField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		gbc.gridx = 1;
		add(textField, gbc);

		// Contraseña
		JLabel passwordLabel = new JLabel("Contraseña:");
		passwordLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(passwordLabel, gbc);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		gbc.gridx = 1;
		add(passwordField, gbc);

		// Botones
		btnLogin = createStyledButton("Ingresar", new ImageIcon(getClass().getResource("/resources/casa.png")));
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(btnLogin, gbc);

		btnCancelar = createStyledButton("Cancelar", new ImageIcon(getClass().getResource("/resources/cerrar-sesion.png")));
		gbc.gridx = 1;
		add(btnCancelar, gbc);
	}

	private JButton createStyledButton(String text, ImageIcon icon) {
		JButton button = new JButton(text, icon);
		button.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 82, 164));
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		return button;
	}

	private void setupListeners() {

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		lvl = new Logic_View_Login(this);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
			new View_Login().setVisible(true);
		});
	}
}
