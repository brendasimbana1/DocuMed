package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import model.Paciente;
import model.PacienteDAO;
import view.View_Home;
import view.View_Login;
import view.View_Patient;
import view.View_Register;
import view.View_Table;

public class Logic_View_Patient implements ActionListener {
	
	private View_Home vh;
	private View_Register vr;
	private View_Patient vp;
	private View_Login vl;
	private View_Table vt;
	private Paciente p;
	private Logic_View_Table lvt;
	public PacienteDAO pdao = new PacienteDAO();

	public Logic_View_Patient(View_Patient vp) 
	{
		this.vp = vp;
		this.vp.btn_registro_paciente.addActionListener(this);
		this.vp.btnPrincipal.addActionListener(this);
		this.vp.btnNuevoRegistro.addActionListener(this);
		this.vp.btnSalir.addActionListener(this);
		this.vp.btnListado.addActionListener(this);
		this.vp.btnLista.addActionListener(this);
		this.lvt = new Logic_View_Table();
		Calendar calendar = Calendar.getInstance();
		java.util.Date utilDate = calendar.getTime();
        Date sqlDate = new Date(utilDate.getTime());
		this.vp.date_actual.setText(sqlDate.toString());
		this.vp.date_actual.setEditable(false);

		setOpcionesCmb();
	}

	private void setOpcionesCmb()
	{
		this.vp.cmb_genero.addItem('F');
		this.vp.cmb_genero.addItem('M');
		this.vp.cmb_genero.addItem('-');
		this.vp.cmb_genero.setSelectedItem('-');
		this.pdao.getPacientes();
	}
	
	public boolean validar() {
		if(!ValidateByER.validateNames(vp.txt_nombres.getText())) {
			vp.txt_nombres.setText("");
			return false;
		}else if (!ValidateByER.validateNames(vp.txt_apellidos.getText())){
			vp.txt_apellidos.setText("");
			return false;
		}else if(!ValidateByER.ValidateCi(vp.txt_ci.getText())){
			vp.txt_ci.setText("");
			return false;
		}else if (vp.txt_ocupacion.getText().isBlank()) {
			vp.txt_ocupacion.setText("");
			return false;
		}else if (vp.txt_profesion.getText().isBlank()) {
			vp.txt_profesion.setText("");
			return false;
		}
		if(vp.cmb_genero.getSelectedIndex()==2)
			return false;
		if(Fecha(this.vp.date_nacimiento)==null)
			return false;
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
		vp.txt_lugar.setText("");
		Calendar calendar = Calendar.getInstance();
		java.util.Date utilDate = calendar.getTime();
        Date sqlDate = new Date(utilDate.getTime());
		vp.date_nacimiento.setDate(sqlDate);
		vp.date_actual.setText(sqlDate.toString());
		vp.cmb_genero.setSelectedItem('-');
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
			vh.setVisible(true);
			vp.dispose();
		}
		else if(e.getSource() == vp.btnSalir) 
		{
			vl = new View_Login();
			vl.setVisible(true);
			vp.dispose();
		}else if (e.getSource() == vp.btnListado) {
			vt = new View_Table();
			vt.setVisible(true);
			vp.dispose();
		}else if (e.getSource() == vp.btnLista) {
			lvt.setPacientes(this.vp);
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
						new java.sql.Date(new java.util.Date().getTime()),
						telefonos(vp.textArea_telefono.getText()),
						genero(),
						vp.txt_lugar.getText(),
						vp.textArea_ant_personales.getText(),
						vp.textArea_ant_familiares.getText(),
						vp.textArea_ant_gineco_obs.getText()
						);

				boolean tieneAntecedentesPersonales = !vp.textArea_ant_personales.getText().isBlank();
				boolean tieneAntecedentesFamiliares = !vp.textArea_ant_familiares.getText().isBlank();
				boolean tieneAntecedentesGinecoObst = !vp.textArea_ant_gineco_obs.getText().isBlank();
				boolean ingresado = true;
				boolean verificacion = pdao.addPatient(p);
				if(verificacion) 
				{
					if(tieneAntecedentesFamiliares)
						ingresado = ingresado && pdao.addAntFamiliares(p);
					if(tieneAntecedentesGinecoObst)
						ingresado = ingresado && pdao.addAntGinecoObst(p);
					if(tieneAntecedentesPersonales)
						ingresado = ingresado && pdao.addAntPersonales(p);
					if(ingresado)
					{
						Logic_View_Home.pacientes.add(p);
						System.out.println(p.getAnt_familiares());
						JOptionPane.showMessageDialog(vr, "Paciente agregado");
					}
					else
					{
						JOptionPane.showMessageDialog(vr, "Error al gestionar los antecedentes del paciente");
					}
					vaciar();
				}else {
					if(this.pdao.existente) {
						JOptionPane.showMessageDialog(vr, "Ya existe un paciente con la cédula ingresada");
						this.vp.txt_ci.setText("");
					}
					else
						JOptionPane.showMessageDialog(vr, "Error al agregar paciente");
					
				}
			}else {
				JOptionPane.showMessageDialog(vr, "Corrija los campos indicados");
			}
		}
	}

	public Date Fecha(JDateChooser jd) {
		java.util.Date utilDate = jd.getDate();
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(utilDate);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    
	    java.util.Date fechaSeleccionada = calendar.getTime();
	    
	    calendar.setTime(new java.util.Date());
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    java.util.Date fechaActual = calendar.getTime();
	    
		if (!fechaSeleccionada.before(fechaActual)) {
	        JOptionPane.showMessageDialog(null, "La fecha de nacimiento no puede ser posterior a la fecha actual.");
	        return null; 
	    }

		if (fechaSeleccionada.equals(fechaActual)) {
		        JOptionPane.showMessageDialog(null, "La fecha de nacimiento debe ser diferente a la fecha actual.");
		        return null; 
		    }
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
