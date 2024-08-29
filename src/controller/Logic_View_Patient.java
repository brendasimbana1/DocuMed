package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View_Home;
import view.View_Patient;
import view.View_Register;

public class Logic_View_Patient implements ActionListener {
	private View_Home vh;
	private View_Register vr;
	private View_Patient vp;
	
	public Logic_View_Patient(View_Patient vp) 
	{
		this.vp = vp;
		this.vp.btn_registro_visita.addActionListener(this);
		this.vp.btnPrincipal.addActionListener(this);
		this.vp.btnNuevoRegistro.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == vp.btnNuevoRegistro)	
		{
			vr = new View_Register();
			vr.setVisible(true);
			vp.dispose();
		}
		else if (e.getSource() == vp.btnPrincipal)
		{	
			vh = new View_Home();
			vh.frame.setVisible(true);
			vp.dispose();
		}
	}
	
	

}
