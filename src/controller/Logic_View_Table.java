package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
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
	private List<String> errores = new ArrayList<String>();


	public Logic_View_Table() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Logic_View_Table(View_Table vt) 
	{
		this.vt = vt;
		this.vtp = new View_Table_Patients();
		this.vtp = new View_Table_Patients();
		this.vt.btnPrincipal.addActionListener(this);
		this.vt.btnNuevoPaciente.addActionListener(this);
		this.vt.btnNuevoRegistro.addActionListener(this);
		this.vt.btnSalir.addActionListener(this);
		this.vt.btn_buscar.addActionListener(this);
		this.vt.btn_registros.addActionListener(this);
		this.vt.btn_editar.addActionListener(this);
		this.vt.btnLista.addActionListener(this);
		this.vt.btnExamen.addActionListener(this);
		this.vt.btnExamen1.addActionListener(this);
		this.vt.btn_guardar.addActionListener(this);
		disableExtra();
	}

	private void disableExtra()
	{
		this.vt.btnExamen.setEnabled(false);
		this.vt.btnExamen1.setEnabled(false);
		this.vt.btn_editar.setEnabled(false);
		this.vt.btn_registros.setEnabled(false);
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
		 if (model == null) {
		        System.err.println("El modelo de la tabla es nulo. No se puede actualizar.");
		        return;
		    }
		model.setRowCount(0);
		if (data != null && data.length > 0) {
	        for (Object[] row : data) {
	            model.addRow(row);
	        }
	    } else {
	        System.out.println("No hay datos disponibles para mostrar en la tabla.");
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
							p.getAnt_personales()==null ? "-" : p.getAnt_personales(),
									p.getAnt_familiares()==null ? "-" : p.getAnt_familiares(),
											p.getAnt_ginec_obs()==null? "-" : p.getAnt_ginec_obs()
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


	private void enableEdicion()
	{
		this.vt.txt_nombres.setEditable(true);
		this.vt.txt_apellidos.setEditable(true);
		this.vt.txt_ocupacion.setEditable(true);
		this.vt.txt_profesion.setEditable(true);
		this.vt.txt_fNacimiento.setEditable(true);
		//this.vt.txt_fRegistro.setEditable(true);
		this.vt.txt_telefonos.setEditable(true);
		this.vt.txt_genero.setEditable(true);
		this.vt.txt_lugar.setEditable(true);
		this.vt.txt_ci.setEditable(false);
		this.vt.txt_edad.setEditable(true);
		this.vt.txt_fRegistro.setEditable(false);
		//Cambio de nombre y uso de JTextField
		this.vt.txt_edad.setText(this.vt.txt_ci.getText());
		this.vt.txt_nombres.requestFocusInWindow();
	}

	private void disableEdicion()
	{
		this.vt.txt_nombres.setEditable(false);
		this.vt.txt_apellidos.setEditable(false);
		this.vt.txt_ocupacion.setEditable(false);
		this.vt.txt_profesion.setEditable(false);
		this.vt.txt_fNacimiento.setEditable(false);
		//this.vt.txt_fRegistro.setEditable(false);
		this.vt.txt_telefonos.setEditable(false);
		this.vt.txt_genero.setEditable(false);
		this.vt.txt_lugar.setEditable(false);
		this.vt.txt_ci.setEditable(true);
		this.vt.txt_edad.setEditable(false);
		this.vt.txt_edad.setText("");
		this.vt.txt_ci.requestFocusInWindow();
	}
	

	private void vaciarCampos()
	{
		this.vt.txt_ci.setText("");
		this.vt.txt_nombres.setText("");
		this.vt.txt_apellidos.setText("");
		this.vt.txt_ocupacion.setText("");
		this.vt.txt_profesion.setText("");
		this.vt.txt_fNacimiento.setText("");
		this.vt.txt_fRegistro.setText("");
		this.vt.txt_telefonos.setText("");
		this.vt.txt_genero.setText("");
		this.vt.txt_lugar.setText("");
	}

	public boolean validar() {
		if(!ValidateByER.validateNames(vt.txt_nombres.getText())) 
		{
			errores.add("nombres");
		}
		if (!ValidateByER.validateNames(vt.txt_apellidos.getText()))
		{
			errores.add("apellidos");
		}
		if(!ValidateByER.ValidateCi(vt.txt_ci.getText()))
		{
			errores.add("cédula");
		}
		if (!ValidateByER.validateText(vt.txt_ocupacion.getText())) 
		{
			errores.add("ocupación");
		}
		if (!ValidateByER.validateText(vt.txt_profesion.getText())) 
		{
			errores.add("profesión");
		}
		System.out.println(errores.size());
		if(errores.isEmpty())
			return true;
		else
		{
			return false;
		}
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
			p = pdao.pacienteData(this.vt.txt_ci.getText());
			if(p != null) {
				this.cedulaEscogida = this.vt.txt_ci.getText();
				this.vt.txt_nombres.setText(p.getNombres());
				this.vt.txt_apellidos.setText(p.getApellidos());
				this.vt.txt_fNacimiento.setText(p.getFecha_nacimiento().toString());
				this.vt.txt_fRegistro.setText(p.getFecha_actual().toString());
				pdao.updateEdad(p);
				this.vt.txt_edad.setText(String.valueOf(pdao.calcularEdad(this.vt.txt_ci.getText())));
				this.vt.txt_ocupacion.setText(p.getOcupacion());
				this.vt.txt_profesion.setText(p.getProfesion());
				this.vt.txt_telefonos.setText(String.join(", ", p.getTelefonos()));
				this.vt.txt_genero.setText(String.valueOf(p.getGenero()));
				this.vt.txt_lugar.setText(p.getLugar_nacimiento());
				this.vt.textArea_ant_personales.setText(p.getAnt_personales());
				this.vt.textArea_ant_familiares.setText(p.getAnt_familiares());
				this.vt.textArea_ant_gineco_obs.setText(p.getAnt_ginec_obs());
				this.vt.btn_registros.setEnabled(true);
				this.vt.btnExamen.setEnabled(true);
				this.vt.btnExamen1.setEnabled(true);
				this.vt.btn_editar.setEnabled(true);
			}else {
				JOptionPane.showMessageDialog(vl, "Error. No se ha encontrado el paciente.");
				this.vt.txt_ci.setText("");
			}

		}
		else if (e.getSource() == this.vt.btn_registros) {
			vtr = new View_Table_Register(this.cedulaEscogida);
			vtr.setVisible(true);
			vt.dispose();
		}
		else if (e.getSource() == this.vt.btnLista) {
			setPacientes(this.vt);
		}
		else if(e.getSource() == this.vt.btn_editar)
		{
			enableEdicion();
			disableExtra();
			this.vt.labelArray[9].setText("Nueva Cédula: ");
			this.vt.btn_editar.setVisible(false);
			this.vt.btn_guardar.setVisible(true);
		}else if (e.getSource() == this.vt.btnExamen) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));

			int result = fileChooser.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				boolean success = pdao.addPdfFile(p, selectedFile);
				if (success) {
					JOptionPane.showMessageDialog(null, "Archivo PDF cargado exitosamente.");
				} else {
					JOptionPane.showMessageDialog(null, "Hubo un error al cargar el archivo.");
				}
			}
		}else if (e.getSource() == this.vt.btnExamen1) {
		    boolean fileDownloaded = pdao.consultarFile(p);
		    
		    if (fileDownloaded) {
		        JOptionPane.showMessageDialog(null, "Archivo descargado correctamente.");
		    } else {
		        JOptionPane.showMessageDialog(null, "Hubo un error al descargar el archivo.");
		    }
		}
		else if(e.getSource() == this.vt.btn_guardar)
		{	
			//this.vt.txt_fNacimiento.getText().matches("\\d{4}-\\d{2}-\\d{2}")
			if(!validar())
			{
				JOptionPane.showMessageDialog(vh, "Error al actualizar la información", "Error", 0);
			}
			else 
			{
				JOptionPane.showMessageDialog(vh, "Coming Soon...", "Actualización", 1);
				disableEdicion();
				this.vt.labelArray[9].setText("Edad: ");
				this.vt.btn_editar.setVisible(true);
				this.vt.btn_guardar.setVisible(false);
				vaciarCampos();
			}
			errores.clear();
			
		}



	}

}
