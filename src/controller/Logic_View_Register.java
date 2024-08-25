package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View_Home;
import view.View_Register;

public class Logic_View_Register implements ActionListener{
	
	private View_Register vr;
	private View_Home vh;
	
	public Logic_View_Register(View_Register vr) 
	{
		this.vr = vr;
		this.vr.btnPrincipal.addActionListener(this);
		this.vr.btnNuevoPaciente.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vr.btnPrincipal)
		{
			vh = new View_Home();
			vr.dispose();
			vh.frame.setVisible(true);
		}
	}

}
