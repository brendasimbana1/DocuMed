package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import threads.Threads_Hour;
import view.View_Home;
import view.View_Patient;
import view.View_Register;

public class Logic_View_Home implements ActionListener {
	
	public View_Home vh;
	private View_Register vr;
	private View_Patient vp;
	private Threads_Hour tr;

	
	public Logic_View_Home(View_Home vh)
	{
		this.vh = vh;
		this.vh.btnPrincipal.addActionListener(this);
		this.vh.btnNuevoPaciente.addActionListener(this);
		this.vh.btnNuevoRegistro.addActionListener(this);
		setFecha();
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
			vr = new View_Register();
			vr.setVisible(true);
			vh.frame.dispose();
			tr.detener();
		}	
		else if (e.getSource() == vh.btnNuevoPaciente)
		{	
			vp = new View_Patient();
			vp.setVisible(true);
			vh.frame.dispose();
			tr.detener();

		}
		
	}
}
