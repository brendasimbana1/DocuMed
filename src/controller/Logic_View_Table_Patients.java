package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.PacienteDAO;
import model.RegistrosDAO;
import view.View_Home;
import view.View_Login;
import view.View_Patient;
import view.View_Register;
import view.View_Table;
import view.View_Table_Patients;
import view.View_Table_Register;

public class Logic_View_Table_Patients implements ActionListener {
	public View_Home vh;
	private View_Table_Patients vtp;
	private View_Register vr;
	private View_Patient vp;
	private View_Login vl;
	private View_Table vt;
	private View_Table_Register vtr;
	private PacienteDAO pdao = new PacienteDAO();
	
	public Logic_View_Table_Patients(View_Table_Patients vtp) {
		this.vtp = vtp;
		this.vtp.btnLista.addActionListener(this);
		this.vtp.btnPrincipal.addActionListener(this);
		this.vtp.btnNuevoPaciente.addActionListener(this);
		this.vtp.btnNuevoRegistro.addActionListener(this);
		this.vtp.btnSalir.addActionListener(this);
		this.vtp.btnListado.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == vtp.btnNuevoRegistro)	
		{
			vr = new View_Register();
			vr.setVisible(true);
			vtp.dispose();
		}	
		else if (e.getSource() == vtp.btnPrincipal)
		{	
			vh = new View_Home();
			vh.setVisible(true);
			vtp.dispose();

		}
		else if (e.getSource() == vtp.btnNuevoPaciente)
		{	
			vp = new View_Patient();
			vp.setVisible(true);
			vtp.dispose();

		}
		else if(e.getSource() == vtp.btnSalir)
		{
			vl = new View_Login();
			vl.setVisible(true);
			vtp.dispose();
		}
		else if (e.getSource() == vtp.btnListado) 
		{
			vt = new View_Table();
			vt.setVisible(true);
			vtp.dispose();
		}
	}
	
	
	
}
