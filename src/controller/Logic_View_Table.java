package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View_Home;
import view.View_Login;
import view.View_Patient;
import view.View_Register;
import view.View_Table;

public class Logic_View_Table implements ActionListener{
	private View_Register vr;
	private View_Home vh;
	private View_Patient vp;
	private View_Table vt;
	private View_Login vl;
	
	public Logic_View_Table(View_Table vt) 
	{
		this.vt = vt;
		this.vt.btnPrincipal.addActionListener(this);
		this.vt.btnNuevoPaciente.addActionListener(this);
		this.vt.btnNuevoRegistro.addActionListener(this);
		this.vt.btnSalir.addActionListener(this);
		this.vt.btn_buscar.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==vt.btnPrincipal)
		{
			vh = new View_Home();
			vt.dispose();
			vh.frame.setVisible(true);
		}
		else if (e.getSource() == vt.btnNuevoPaciente)
		{	
			vp = new View_Patient();
			vp.setVisible(true);
			vt.dispose();
		}else if (e.getSource() == vt.btnNuevoRegistro) {
			vr = new View_Register();
			vr.setVisible(true);
			vt.dispose();
		}else if (e.getSource() == vt.btnSalir) {
			vl = new View_Login();
			vl.setVisible(true);
			vt.dispose();
		}
	}
	
}
