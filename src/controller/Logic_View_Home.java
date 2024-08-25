package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View_Home;
import view.View_Register;

public class Logic_View_Home implements ActionListener {
	
	private View_Home vh;
	private View_Register vr;
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
		if(e.getSource() == vh.btnNuevoRegistro)	
		{
			vr = new View_Register();
			vr.setVisible(true);
			vh.frame.dispose();
		}
		
	}
}
