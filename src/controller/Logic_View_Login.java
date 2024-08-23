package controller;

import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Usuario;
import model.UsuarioDAO;
import view.View_Login;

public class Logic_View_Login implements ActionListener {
	private View_Login vl;
	private List<Usuario> users = new ArrayList<Usuario>();
	private UsuarioDAO userDao = new UsuarioDAO();
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
