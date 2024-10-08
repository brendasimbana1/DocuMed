	package model;

import java.util.Date;
import java.util.List;

public class Registros {
	private Date fechas_atencion;
	private String diagnostico;
	private String ci;
	private double peso;
	private int altura;
	private double temperatura;
	private String presion_arterial;	
	private String evolucion;	//antecedentes
	private String indicaciones;	//medicinas y horarios
	private String responsable; //médico que trata al paciente
	
	public Registros(Date fechas_atencion, String diagnostico, double peso, int altura, double temperatura,
			String presion_arterial, String evolucion, String indicaciones, String responsable, 
			String ci) 
	{
		super();
		this.fechas_atencion = fechas_atencion;
		this.diagnostico = diagnostico;
		this.peso = peso;
		this.altura = altura;
		this.temperatura = temperatura;
		this.presion_arterial = presion_arterial;
		this.evolucion = evolucion;
		this.indicaciones = indicaciones;
		this.responsable = responsable;
		this.ci=ci;
	}

	public Date getFechas_atencion() 
	{
		return fechas_atencion;
	}

	public void setFechas_atencion(Date fechas_atencion) 
	{
		this.fechas_atencion = fechas_atencion;
	}

	public String getDiagnostico() 
	{
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) 
	{
		this.diagnostico = diagnostico;
	}

	public double getPeso() 
	{
		return peso;
	}

	public void setPeso(double peso) 
	{
		this.peso = peso;
	}

	public int getAltura() 
	{
		return altura;
	}

	public void setAltura(int altura) 
	{
		this.altura = altura;
	}

	public double getTemperatura() 
	{
		return temperatura;
	}

	public void setTemperatura(double temperatura) 
	{
		this.temperatura = temperatura;
	}

	public String getPresion_arterial() 
	{
		return presion_arterial;
	}

	public void setPresion_arterial(String presion_arterial) 
	{
		this.presion_arterial = presion_arterial;
	}

	public String getEvolucion() 
	{
		return evolucion;
	}

	public void setEvolucion(String evolucion) 
	{
		this.evolucion = evolucion;
	}

	public String getIndicaciones() 
	{
		return indicaciones;
	}

	public void setIndicaciones(String indicaciones) 
	{
		this.indicaciones = indicaciones;
	}

	public String getResponsable() 
	{
		return responsable;
	}

	public void setResponsable(String responsable) 
	{
		this.responsable = responsable;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}
	
}
