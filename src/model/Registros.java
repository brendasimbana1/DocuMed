package model;

import java.util.Date;
import java.util.List;

public class Registros {
	private Date fechas_atencion;
	private List<String> diagnostico;
	private double peso;
	private double altura;
	private double temperatura;
	private String presion_arterial;	
	private List<String> evolucion;	//antecedentes
	private List<String> indicaciones;	//medicinas y horarios
	private String responsable; //médico que trata al paciente
	
	public Registros(Date fechas_atencion, List<String> diagnostico, double peso, double altura, double temperatura,
			String presion_arterial, List<String> evolucion, List<String> indicaciones, String responsable) 
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
	}

	public Date getFechas_atencion() 
	{
		return fechas_atencion;
	}

	public void setFechas_atencion(Date fechas_atencion) 
	{
		this.fechas_atencion = fechas_atencion;
	}

	public List<String> getDiagnostico() 
	{
		return diagnostico;
	}

	public void setDiagnostico(List<String> diagnostico) 
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

	public double getAltura() 
	{
		return altura;
	}

	public void setAltura(double altura) 
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

	public List<String> getEvolucion() 
	{
		return evolucion;
	}

	public void setEvolucion(List<String> evolucion) 
	{
		this.evolucion = evolucion;
	}

	public List<String> getIndicaciones() 
	{
		return indicaciones;
	}

	public void setIndicaciones(List<String> indicaciones) 
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

	
	
	
	
	
	
	
	
	
}
