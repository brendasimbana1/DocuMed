package model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Paciente {
	private String ci;
	private String nombres;
	private String apellidos;
	private String ocupacion;
	private String profesion;
	private Date fecha_nacimiento;
	private Date fecha_actual;
	private String [] telefonos;
	private Character genero;
	private String lugar_nacimiento;
	private String ant_personales;
	private String ant_familiares;
	private String ant_ginec_obs;
	private List<Registros> registro;


	public Paciente(String ci, String nombres, String apellidos, String ocupacion, String profesion,
			Date fecha_nacimiento, Date fecha_actual, String[] telefonos, Character genero, String lugar_nacimiento,
			String ant_personales, String ant_familiares, String ant_ginec_obs, List<Registros> registros) {
		super();
		this.ci = ci;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.ocupacion = ocupacion;
		this.profesion = profesion;
		this.fecha_nacimiento = fecha_nacimiento;
		this.fecha_actual = fecha_actual;
		this.telefonos = telefonos;
		this.genero = genero;
		this.lugar_nacimiento = lugar_nacimiento;
		this.ant_personales = ant_personales;
		this.ant_familiares = ant_familiares;
		this.ant_ginec_obs = ant_ginec_obs;
		this.registro = registros;
	}
	
	
	public Paciente(String ci, String nombres, String apellidos, String ocupacion, String profesion,
			Date fecha_nacimiento, Date fecha_actual, String[] telefonos, char genero, String lugar_nacimiento,
			String ant_personales, String ant_familiares, String ant_ginec_obs) {
		super();
		this.ci = ci;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.ocupacion = ocupacion;
		this.profesion = profesion;
		this.fecha_nacimiento = fecha_nacimiento;
		this.fecha_actual = fecha_actual;
		this.telefonos = telefonos;
		this.genero = genero;
		this.lugar_nacimiento = lugar_nacimiento;
		this.ant_personales = ant_personales;
		this.ant_familiares = ant_familiares;
		this.ant_ginec_obs = ant_ginec_obs;
	}


	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public Date getFecha_actual() {
		return fecha_actual;
	}
	public void setFecha_actual(Date fecha_actual) {
		this.fecha_actual = fecha_actual;
	}
	public String[] getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(String[] telefonos) {
		this.telefonos = telefonos;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public String getLugar_nacimiento() {
		return lugar_nacimiento;
	}
	public void setLugar_nacimiento(String lugar_nacimiento) {
		this.lugar_nacimiento = lugar_nacimiento;
	}
	public String getAnt_personales() {
		return ant_personales;
	}
	public void setAnt_personales(String ant_personales) {
		this.ant_personales = ant_personales;
	}
	public String getAnt_familiares() {
		return ant_familiares;
	}
	public void setAnt_familiares(String ant_familiares) {
		this.ant_familiares = ant_familiares;
	}
	public String getAnt_ginec_obs() {
		return ant_ginec_obs;
	}
	public void setAnt_ginec_obs(String ant_ginec_obs) {
		this.ant_ginec_obs = ant_ginec_obs;
	}
	
	public List<Registros> getRegistro() 
	{
		return registro;
	}

	public void setRegistro(List<Registros> registro) 
	{
		this.registro = registro;
	}


	@Override
	public String toString() {
		return "Paciente [ci=" + ci + ", nombres=" + nombres + ", apellidos=" + apellidos + ", ocupacion=" + ocupacion
				+ ", profesion=" + profesion + ", fecha_nacimiento=" + fecha_nacimiento + ", fecha_actual="
				+ fecha_actual + ", telefonos=" + Arrays.toString(telefonos) + ", genero=" + genero
				+ ", lugar_nacimiento=" + lugar_nacimiento + ", ant_personales=" + ant_personales + ", ant_familiares="
				+ ant_familiares + ", ant_ginec_obs=" + ant_ginec_obs + "]";
	}
	
	
	
}
