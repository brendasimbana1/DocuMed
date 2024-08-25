package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View_Home;

public class Logic_View_Home implements ActionListener {
	
	private View_Home vh;
	public Logic_View_Home(View_Home vh)
	{
		this.vh = vh;
		this.vh.btnPrincipal.addActionListener(this);
		this.vh.btnNuevoPaciente.addActionListener(this);
		this.vh.btnNuevoRegistro.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
