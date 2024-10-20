package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Paciente;
import model.PacienteDAO;
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
	private DefaultTableModel tableModel;
	public PacienteDAO pdao = new PacienteDAO();
	private Paciente p;

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
		}else if(e.getSource() == vt.btn_buscar) {
			// Ejemplo de agregar filas
			p = pdao.pacienteData(this.vt.txt_ci.getText());
			if(p != null) {
				this.vt.txt_nombres.setText(p.getNombres());
				this.vt.txt_apellidos.setText(p.getApellidos());
				this.vt.txt_fNacimiento.setText(p.getFecha_nacimiento().toString());
				this.vt.txt_fRegistro.setText(p.getFecha_actual().toString());
				this.vt.txt_edad.setText(String.valueOf(p.getEdad()));
				this.vt.txt_ocupacion.setText(p.getOcupacion());
				this.vt.txt_profesion.setText(p.getProfesion());
				this.vt.txt_telefonos.setText(String.join(", ", p.getTelefonos()));
				this.vt.txt_genero.setText(String.valueOf(p.getGenero()));
				this.vt.txt_lugar.setText(p.getLugar_nacimiento());
				this.vt.textArea_ant_personales.setText(p.getAnt_personales());
				this.vt.textArea_ant_familiares.setText(p.getAnt_familiares());
				this.vt.textArea_ant_gineco_obs.setText(p.getAnt_ginec_obs());
			}else {
				JOptionPane.showMessageDialog(vl, "Error. No se ha encontrado el paciente.");
				this.vt.txt_ci.setText("");
			}
			

		}
	}

}
