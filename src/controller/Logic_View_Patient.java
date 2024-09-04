package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.toedter.calendar.JDateChooser;

import model.Paciente;
import view.View_Home;
import view.View_Patient;
import view.View_Register;

public class Logic_View_Patient implements ActionListener {
	private View_Home vh;
	private View_Register vr;
	private View_Patient vp;
	private Paciente p;
	
	public Logic_View_Patient(View_Patient vp) 
	{
		this.vp = vp;
		this.vp.btn_registro_paciente.addActionListener(this);
		this.vp.btnPrincipal.addActionListener(this);
		this.vp.btnNuevoRegistro.addActionListener(this);
		this.vp.cmb_genero.addItem('F');
		this.vp.cmb_genero.addItem('M');
		this.vp.cmb_genero.addItem('-');
	}
	
	public boolean validar() {
		if(!ValidateByER.validateNames(vp.txt_nombres.getText())) {
			vp.txt_nombres.setText("");
			return false;
		}else if (!ValidateByER.validateNames(vp.txt_apellidos.getText())){
			vp.txt_apellidos.setText("");
			return false;
		}else if(!ValidateByER.ValidateCi(vp.txt_ci.getText())){
			vp.txt_ci.getText();
			return false;
		}
		return true;
	}
	
	public void vaciar() {
		vp.txt_nombres.setText("");
		vp.txt_apellidos.setText("");
		vp.txt_ocupacion.setText("");
		vp.txt_profesion.setText("");
		vp.txt_ci.setText("");
		vp.textArea_telefono.setText("");
		vp.textArea_ant_familiares.setText("");
		vp.textArea_ant_gineco_obs.setText("");
		vp.textArea_ant_personales.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == vp.btnNuevoRegistro)	
		{
			vr = new View_Register();
			vr.setVisible(true);
			vh.frame.dispose();
		}
		else if (e.getSource() == vp.btnNuevoPaciente)
		{	
			vp = new View_Patient();
			vp.setVisible(true);
			vh.frame.dispose();
		}
		else if (e.getSource() == vp.btn_registro_paciente)
		{	
			if(validar()) {
				p= new Paciente(
							vp.txt_ci.getText(),
							vp.txt_nombres.getText(),
							vp.txt_apellidos.getText(),
							vp.txt_ocupacion.getText(),
							vp.txt_profesion.getText(),
							Fecha(vp.date_nacimiento),
							Fecha(vp.date_actual),
							telefonos(vp.textArea_telefono.getText()),
							genero(),
							vp.txt_lugar.getText(),
							vp.textArea_ant_personales.getText(),
							vp.textArea_ant_familiares.getText(),
							vp.textArea_ant_gineco_obs.getText()
						);
						
			}
		}
	}
	
	public Date Fecha(JDateChooser jd) {
		Calendar calendario = jd.getCalendar();
		System.out.println("----------- Fecha seleccionada ------------");
		int dia = calendario.get(Calendar.DATE); 
		int mes = calendario.get(Calendar.MONTH) + 1;
		int year = calendario.get(Calendar.YEAR);
		System.out.println("dia = " + dia);
		System.out.println("mes = " + mes);
		System.out.println("año = " + year);
		java.util.Date utilDate = jd.getDate();

		//Formato para base de datos
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;

	}
	
	public String [] telefonos(String text) {
		String [] telefonos = text.split(",");
		return telefonos;
	}
	
	public Character genero() {
		Character seleccion = (Character) vp.cmb_genero.getSelectedItem();
		return seleccion;
	}
}
