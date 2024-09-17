package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import model.UsuarioDAO;
import view.View_Home;
import view.View_Patient;
import view.View_Register;

public class Logic_View_Register implements ActionListener{
	
	private View_Register vr;
	private View_Home vh;
	private View_Patient vp;
	private UsuarioDAO udao = new UsuarioDAO();

	
	public Logic_View_Register(View_Register vr) 
	{
		this.vr = vr;
		this.vr.btnPrincipal.addActionListener(this);
		this.vr.btnNuevoPaciente.addActionListener(this);
		this.vr.btn_registro_visita.addActionListener(this);
		this.vr.panel_info.setVisible(false);
		this.vr.panel_content.setVisible(false);
	}

	public int[] getFecha() {
		Calendar calendario = vr.dateChooser.getCalendar();
		int dia = calendario.get(Calendar.DATE); 
		int mes = calendario.get(Calendar.MONTH) + 1;
		int year = calendario.get(Calendar.YEAR);
		int fecha[] = new int[3];
		fecha[0] = dia;
		fecha[1] = mes;
		fecha[2] = year;
		return fecha;
	}
	
	private void createRegister()
	{
		int[] fecha = getFecha();
		String cedula = vr.txt_ci.getText();
		//AQUI DEBO IMPLEMENTAR UN METODO QUE VERIFIQUE LA EXISTENCIA DE LA CÉDULA
		//String diagnostico = vr.textArea_diagnostico.getText();
		double peso = (Double)vr.spn_peso.getValue();
		double altura = (Double)vr.spn_altura.getValue();
		double temperatura = (Double)vr.spn_temp.getValue();

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
		else if (e.getSource() == vr.btnNuevoPaciente)
		{	
			vp = new View_Patient();
			vp.setVisible(true);
			vr.dispose();
		}
		else if (e.getSource() == vr.btn_registro_visita)
		{
			createRegister();
		}
	}

}
