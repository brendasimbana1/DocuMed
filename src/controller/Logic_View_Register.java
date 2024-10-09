package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.JOptionPane;

import model.Paciente;
import model.Registros;
import model.RegistrosDAO;
import model.UsuarioDAO;
import view.View_Home;
import view.View_Login;
import view.View_Patient;
import view.View_Register;

public class Logic_View_Register implements ActionListener{
	
	private View_Register vr;
	private View_Home vh;
	private View_Patient vp;
	private View_Login vl;
	
	private RegistrosDAO rdao = new RegistrosDAO();
	
	public Logic_View_Register(View_Register vr) 
	{
		this.vr = vr;
		this.vr.btnPrincipal.addActionListener(this);
		this.vr.btnNuevoPaciente.addActionListener(this);
		this.vr.btn_registro_visita.addActionListener(this);
		this.vr.btnSalir.addActionListener(this);
		this.vr.btn_buscar.addActionListener(this);
		this.vr.panel_info.setVisible(false);
		this.vr.panel_content.setVisible(false);
	}

	public int[] getFecha() {
		Calendar calendario = vr.dateChooser.getCalendar();
		if(calendario == null)
			return null;
		int dia = calendario.get(Calendar.DATE); 
		int mes = calendario.get(Calendar.MONTH) + 1;
		int year = calendario.get(Calendar.YEAR);
		int fecha[] = new int[3];
		fecha[0] = dia;
		fecha[1] = mes;
		fecha[2] = year;
		return fecha;
	}
	
	private Paciente busquedaPaciente(String cedula)
	{
		if(!Logic_View_Home.pacientes.isEmpty())
		{
			for(Paciente p:Logic_View_Home.pacientes)
			{
				if(p.getCi().equals(cedula))
				{
					return p;
				}
			}
			return null;
		}
		return null;

	}
	private boolean createRegister()
	{
		String cedula = vr.txt_ci.getText();
		if(cedula==null)
			return false;
		int[] fecha_array = getFecha();
		if(fecha_array == null)
			return false;
		java.time.LocalDate localDate = java.time.LocalDate.of(fecha_array[2], fecha_array[1], fecha_array[0]);		
		java.sql.Date fecha = java.sql.Date.valueOf(localDate);
		double peso = (Double)vr.spn_peso.getValue();
		int altura = (Integer)vr.spn_altura.getValue();
		double temperatura = (Double)vr.spn_temp.getValue();
		String presion = vr.txt_presion.getText();
		if(vr.txt_presion.getText().isBlank())
			return false;
		String diagnostico = vr.textArea_diagnostico.getText();
		if(vr.textArea_diagnostico.getText().isBlank())
			return false;
		String evolucion = vr.textArea_evolucion.getText();
		if(vr.textArea_evolucion.getText().isBlank())
			return false;
		String indicaciones = vr.textArea_indicaciones.getText();
		if(vr.textArea_indicaciones.getText().isBlank())
			return false;
		String responsable = vr.txt_responsable.getText();
		if(vr.txt_responsable.getText().isBlank())
			return false;
		
		Registros r = new Registros(fecha, diagnostico, peso, altura, temperatura, presion, evolucion, indicaciones, responsable, cedula);
		rdao.addRegister(r);
		Logic_View_Home.registros.add(r);
		return true;

	}
	
	
	private void setLabelsInfo(Paciente p)
	{
		this.vr.txt_nombres.setText(p.getNombres());
		this.vr.txt_apellidos.setText(p.getApellidos());
//		this.vr.txt_edad.setText(p.get);
//		Necesitamos la edad del paciente

	}
	
	private void verificarExistenciaPaciente()
	{
		String cedula = vr.txt_ci.getText();
		Paciente p = busquedaPaciente(cedula);
		if(p != null)
		{
			this.vr.panel_info.setVisible(true);
			this.vr.panel_content.setVisible(true);
			setLabelsInfo(p);
			this.vr.txt_ci.setEditable(false);
		}
		else
		{
			JOptionPane.showMessageDialog(vr, "No se ha encontrado al paciente!");

		}
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
			if(createRegister())
			{
				JOptionPane.showMessageDialog(vr, "¡Registro creado exitosamente!");
				this.vr.dispose();
				this.vr = new View_Register();
				this.vr.setVisible(true);
			}
		}
		else if(e.getSource() == vr.btnSalir)
		{
			vl = new View_Login();
			vl.setVisible(true);
			vr.dispose();
		}
		else if(e.getSource() == vr.btn_buscar)
		{
			verificarExistenciaPaciente();
		}
	}

}
