	package view;
	
	import java.awt.EventQueue;
	
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import javax.swing.JPasswordField;
	import java.awt.Font;
	import javax.swing.SwingConstants;
	import javax.swing.JButton;

	import controller.Logic_View_Login;
	
	public class View_Login extends JFrame {
	
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		public JTextField textField;
		public JPasswordField passwordField;
		public JButton btnLogin;
		private Logic_View_Login lvl;
	
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						View_Login frame = new View_Login();
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
		public View_Login() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			setResizable(false);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 434, 261);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblUsername = new JLabel("Usuario");
			lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
			lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblUsername.setBounds(74, 31, 86, 24);
			panel.add(lblUsername);
			
			textField = new JTextField();
			textField.setBounds(74, 53, 286, 24);
			panel.add(textField);
			textField.setColumns(10);
			
			JLabel lblPassword = new JLabel("Contraseña");
			lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
			lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblPassword.setBounds(74, 88, 86, 24);
			panel.add(lblPassword);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(74, 112, 286, 24);
			panel.add(passwordField);
			
			btnLogin = new JButton("Iniciar Sesión");
			btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			btnLogin.setBounds(134, 175, 166, 42);
			panel.add(btnLogin);
			setLocationRelativeTo(null);	//esta línea es la encargada de centrar la ventana
			this.lvl = new Logic_View_Login(this);
		}
	}
