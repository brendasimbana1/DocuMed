package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Paciente;
import model.PacienteDAO;
import model.Registros;
import model.RegistrosDAO;
import threads.Threads_Hour;
import view.View_Home;
import view.View_Login;
import view.View_Patient;
import view.View_Register;
import view.View_Table;
import view.View_Table_Patients;
import view.View_Table_Register;

public class Logic_View_Home implements ActionListener {
	
	public View_Home vh;
	private View_Register vr;
	private View_Patient vp;
	private View_Login vl;
	private View_Table vt;
	private View_Table_Register vtr;
	private View_Table_Patients vtp;
	private Logic_View_Table lvt;
	private Threads_Hour tr;
	private PacienteDAO pdao = new PacienteDAO();
	private RegistrosDAO rdao = new RegistrosDAO();
	
	//valor estatico en el login para controlar metodo
	
	public static List<Registros> registros;
	public static List<Paciente> pacientes;


	public Logic_View_Home(View_Home vh)
	{
		this.vh = vh;
		this.lvt = new Logic_View_Table();
		this.vtp = new View_Table_Patients();
		this.vh.btnPrincipal.addActionListener(this);
		this.vh.btnNuevoPaciente.addActionListener(this);
		this.vh.btnNuevoRegistro.addActionListener(this);
		this.vh.btnSalir.addActionListener(this);
		this.vh.btnListado.addActionListener(this);
		this.vh.btnLista.addActionListener(this);
		setFecha();
		this.vh.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                tr.detener(); 
                vh.dispose();
            }
        });
		setInfo();
	}
	
	
	private void setInfo() 
	{
		Logic_View_Home.registros = rdao.getRegistros();
		Logic_View_Home.pacientes = pdao.getPacientes();
	}
	
	private void setFecha()
	{
		tr = new Threads_Hour(this);
		tr.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == vh.btnNuevoRegistro)	
		{
			tr.detener();
			vr = new View_Register();
			vr.setVisible(true);
			vh.dispose();
		}	
		else if (e.getSource() == vh.btnNuevoPaciente)
		{	
			tr.detener();
			vp = new View_Patient();
			vp.setVisible(true);
			vh.dispose();

		}
		else if(e.getSource() == vh.btnSalir)
		{
			tr.detener();
			vl = new View_Login();
			vl.setVisible(true);
			vh.dispose();
		}
		else if (e.getSource() == vh.btnListado) 
		{
			tr.detener();
			vt = new View_Table();
			vt.setVisible(true);
			vh.dispose();
		} else if (e.getSource() == this.vh.btnLista) {
			tr.detener();
			lvt.setPacientes(this.vh);
		}
		
	}
}
