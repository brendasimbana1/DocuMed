package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import model.Paciente;
import model.PacienteDAO;
import model.Registros;
import view.View_Home;
import view.View_Login;
import view.View_Patient;
import view.View_Register;
import view.View_Table;
import view.View_Table_Patients;
import view.View_Table_Register;

public class Logic_View_Table implements ActionListener{
	private View_Register vr;
	private View_Home vh;
	private View_Patient vp;
	private View_Table vt;
	private View_Login vl;
	private View_Table_Register vtr;
	private View_Table_Patients vtp;
	public PacienteDAO pdao = new PacienteDAO();
	private Paciente p;
	private String cedulaEscogida;
	public Object[][] infoTable;
	

	public Logic_View_Table() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Logic_View_Table(View_Table vt) 
	{
		this.vt = vt;
		this.vtp = new View_Table_Patients();
		this.vt.btnPrincipal.addActionListener(this);
		this.vt.btnNuevoPaciente.addActionListener(this);
		this.vt.btnNuevoRegistro.addActionListener(this);
		this.vt.btnSalir.addActionListener(this);
		this.vt.btn_buscar.addActionListener(this);
		this.vt.btn_registros.addActionListener(this);
		this.vt.btn_registros.setEnabled(false);
		this.vt.btn_lista.addActionListener(this);
	}

	public JDialog crearVentanaCarga(JFrame parentFrame, String mensaje) {
		JDialog ventanaCarga = new JDialog(parentFrame, "Carga de Pacientes", true);
		ventanaCarga.setSize(200, 100);
		ventanaCarga.setLocationRelativeTo(parentFrame);
		ventanaCarga.setLayout(new BorderLayout());

		JLabel lblMensaje = new JLabel(mensaje, SwingConstants.CENTER);
		ventanaCarga.add(lblMensaje, BorderLayout.CENTER);

		return ventanaCarga;
	}

	public void actualizarTabla(DefaultTableModel model, Object[][] data) {
		model.setRowCount(0);
		for (Object[] fila : data) {
			model.addRow(fila);
		}
	}



	public void setPacientes(JFrame ventanaActual) {
		JDialog ventanaCarga = crearVentanaCarga(ventanaActual, "Cargando listado de pacientes...");
		SwingWorker<Void, Void> worker = new SwingWorker<>() {
			@Override
			protected Void doInBackground() throws Exception {
				List<Object[]> datos = new ArrayList<>();
				for (Paciente p : Logic_View_Home.pacientes) {
					pdao.updateEdad(p);
					Object[] fila = {
							p.getCi(), p.getNombres(), p.getApellidos(), p.getOcupacion(), p.getProfesion(),
							p.getFecha_nacimiento(), p.getEdad(), p.getTelefonos()[0], p.getGenero(), p.getLugar_nacimiento(),
							p.getAnt_personales() == null ? "-" : p.getAnt_personales(),
									p.getAnt_familiares() == null ? "-" : p.getAnt_familiares(),
											p.getAnt_ginec_obs() == null ? "-" : p.getAnt_ginec_obs()
					};
					datos.add(fila);
				}
				infoTable = datos.toArray(new Object[0][]);
				return null;
			}

			@Override
			protected void done() {
				ventanaCarga.dispose();
				View_Table_Patients vtp = new View_Table_Patients();
				actualizarTabla(vtp.model,infoTable);
				vtp.setVisible(true);
				ventanaActual.dispose();				
				JOptionPane.showMessageDialog(null, "Datos cargados correctamente.");
			}
		};
		worker.execute();
		ventanaCarga.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==vt.btnPrincipal)
		{
			vh = new View_Home();
			vt.dispose();
			vh.setVisible(true);
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
				this.cedulaEscogida = this.vt.txt_ci.getText();
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
				this.vt.btn_registros.setEnabled(true);
			}else {
				JOptionPane.showMessageDialog(vl, "Error. No se ha encontrado el paciente.");
				this.vt.txt_ci.setText("");
			}

		}else if (e.getSource() == this.vt.btn_registros) {
			vtr = new View_Table_Register(this.cedulaEscogida);
			vtr.setVisible(true);
			vt.dispose();
		}
		else if (e.getSource() == this.vt.btn_lista) {
			setPacientes(this.vt);
		}


	}

}
