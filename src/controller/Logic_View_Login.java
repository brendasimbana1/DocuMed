package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Usuario;
import model.UsuarioDAO;
import view.View_Login;
import view.View_Home;

public class Logic_View_Login implements ActionListener {
	private View_Login vl;
	private List<Usuario> users = new ArrayList<Usuario>();
	private UsuarioDAO userDao = new UsuarioDAO();
	private char[] passwd = null;
	private boolean existe = false;
	private View_Home vh;

	public Logic_View_Login(View_Login vl)
	{
		this.vl = vl;		
		this.vl.btnLogin.addActionListener(this);
		this.users = this.userDao.getUsers();
		this.vl.passwordField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (validar()) {
						vl.textField.setText("");
						vl.passwordField.setText("");
						vh = new View_Home();
						vl.dispose();
						vh.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(vl, "Usuario y/o contraseña NO encontrados");
						vl.textField.setText("");
						vl.passwordField.setText("");
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}
		});

	}

	//Convierte el array char en string

	private String password(char [] pass) {
		String aux = "";
		for(char c : pass) {
			aux += c;
		}
		return aux;
	} 

	public boolean validar() {
		existe = false;
		passwd = vl.passwordField.getPassword();
		for(Usuario u: users) {	
			if(u.getUsername().equals(vl.textField.getText()) && 
					u.getPassword().equals(password(passwd))) {
				existe = true;
				break;
			}
		}

		return existe;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(validar()) {
			vl.textField.setText("");
			vl.passwordField.setText("");
			vh = new View_Home();
			vl.dispose();
			vh.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(vl, "Usuario y/o contraseña NO encontrados");
			vl.textField.setText("");
			vl.passwordField.setText("");
		}

	}



}
