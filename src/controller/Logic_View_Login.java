package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Usuario;
import model.UsuarioDAO;
import view.View_Login;

public class Logic_View_Login implements ActionListener {
	private View_Login vl;
	private List<Usuario> users = new ArrayList<Usuario>();
	private UsuarioDAO userDao = new UsuarioDAO();
	private char[] passwd = null;
	private boolean existe = false;

	public Logic_View_Login(View_Login vl)
	{
		this.vl = vl;
		this.vl.btnLogin.addActionListener(this);
		this.users = this.userDao.getUsers();
		if(users.isEmpty())
		{
			System.out.println("vacio");
		}
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
			JOptionPane.showMessageDialog(vl, "Usuario y/o contraseña encontrados");
			vl.textField.setText("");
			vl.passwordField.setText("");

		}else {
			JOptionPane.showMessageDialog(vl, "Usuario y/o contraseña NO encontrados");
			vl.textField.setText("");
			vl.passwordField.setText("");
		}

	}

}
