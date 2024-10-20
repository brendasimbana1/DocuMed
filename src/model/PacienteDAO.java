package model;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.Logic_View_Home;
import database.ConnectionPostgres;

public class PacienteDAO {
	private ConnectionPostgres dbConn = new ConnectionPostgres("bd_consulta_medica");
	private String query="";
	private boolean result = false;
	
	public Paciente pacienteData(String ci) {
		for(Paciente p:Logic_View_Home.pacientes) {
			if(p.getCi().equals(ci)) {
				return p;
			}
		}
		return null;
	}

	public List<Paciente> getPacientes()
	{
		List<Paciente> pacientes = new ArrayList<Paciente>();
		query = "SELECT p.cedula, p.nombres, p.apellidos, p.ocupacion, p.profesion, "+
				"p.fecha_nacimiento, p.fecha_actual, p.telefonos, p.genero, "+
				"p.lugar_nacimiento, a.antecedentes, f.antecedentes, g.antecedentes, "
				+ "p.edad "+
				"FROM pacientes p "+
				"LEFT JOIN antecedentes_personales a ON p.cedula = a.cedula "+
				"LEFT JOIN antecedentes_familiares f ON p.cedula = f.cedula "+
				"LEFT JOIN antecedentes_gineco_obst g ON p.cedula = g.cedula;";
		ResultSet rs;
		rs = dbConn.executeQuery(query);
		try 
		{
			while (rs != null && rs.next()) 
			{
				pacientes.add(new Paciente(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDate(6),
						rs.getDate(7),
						(String[]) rs.getArray(8).getArray(),
						(rs.getString(9)).charAt(0),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12),
						rs.getString(13),
						rs.getInt(14)
						));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		finally 
		{
			try 
			{
				if (rs != null) 
					rs.close();
				dbConn.close(dbConn.connect());
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}

		return pacientes;
	}


	public boolean addPatient(Paciente p){
		query = "INSERT INTO pacientes (cedula, nombres, apellidos, ocupacion, profesion, fecha_nacimiento, fecha_actual, telefonos, genero, lugar_nacimiento)"
				+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = dbConn.connect();
				PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setString(1, p.getCi());
			stmt.setString(2, p.getNombres());
			stmt.setString(3, p.getApellidos());
			stmt.setString(4, p.getOcupacion());
			stmt.setString(5, p.getProfesion());
			stmt.setDate(6, new Date(p.getFecha_nacimiento().getTime())); 
			stmt.setDate(7, new Date(p.getFecha_actual().getTime()));
			Array telefonosArray = conn.createArrayOf("varchar", p.getTelefonos());
			stmt.setArray(8, telefonosArray);
			char genero = p.getGenero(); 
			stmt.setString(9, String.valueOf(genero));
			stmt.setString(10, p.getLugar_nacimiento());
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Operación realizada con éxito." );
			return rowsAffected > 0;

		} catch (SQLException e) {
			System.err.println("Error al ejecutar la operación.");
			e.printStackTrace();
			return false;
		}		
	}

	public boolean addAntPersonales(Paciente p) {
		query = "INSERT INTO antecedentes_personales (cedula, antecedentes)"
				+"VALUES (?, ?)";
		try (Connection conn = dbConn.connect();
				PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setString(1, p.getCi());
			stmt.setString(2, p.getAnt_personales());
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Operación realizada con éxito." );
			return rowsAffected > 0;

		} catch (SQLException e) {
			System.err.println("Error al ejecutar la operación.");
			e.printStackTrace();
			return false;
		}
	}

	public boolean addAntGinecoObst(Paciente p) {
		query = "INSERT INTO antecedentes_gineco_obst (cedula, antecedentes)"
				+"VALUES (?, ?)";
		try (Connection conn = dbConn.connect();
				PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setString(1, p.getCi());
			stmt.setString(2, p.getAnt_ginec_obs());
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Operación realizada con éxito." );
			return rowsAffected > 0;

		} catch (SQLException e) {
			System.err.println("Error al ejecutar la operación.");
			e.printStackTrace();
			return false;
		}
	}

	public boolean addAntFamiliares(Paciente p) {
		query = "INSERT INTO antecedentes_familiares(cedula, antecedentes)"
				+"VALUES (?, ?)";
		try (Connection conn = dbConn.connect();
				PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setString(1, p.getCi());
			stmt.setString(2, p.getAnt_familiares());
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Operación realizada con éxito." );
			return rowsAffected > 0;

		} catch (SQLException e) {
			System.err.println("Error al ejecutar la operación.");
			e.printStackTrace();
			return false;
		}
	}
	
	public int calcularEdad(String ci) {
		query = "SELECT p.fecha_nacimiento "+
				"FROM pacientes p "+
				"WHERE p.cedula = "+"'"+ci+"';";
		ResultSet rs;
		rs = dbConn.executeQuery(query);
		int edad = 0;
		try 
		{
			while (rs != null && rs.next()) 
			{
				Date fechaNacimientoSQL = rs.getDate("fecha_nacimiento");
                LocalDate fechaNacimiento = fechaNacimientoSQL.toLocalDate();
                LocalDate fechaActual = LocalDate.now();
                Period periodo = Period.between(fechaNacimiento, fechaActual);
                edad = periodo.getYears();
			}
		}catch (Exception e) {
			System.err.println("Error al calcular la edad");
			e.printStackTrace();
		}
		return edad;
	}
	
	public boolean updateEdad(Paciente p) {
		if(this.calcularEdad(p.getCi()) != p.getEdad())
		{
			query = "UPDATE pacientes"+
					" SET edad = "+this.calcularEdad(p.getCi())+
					" WHERE cedula = "+"'"+p.getCi()+"';";
			if (dbConn.executeUpdate(query)) {
				p.setEdad(this.calcularEdad(p.getCi()));
	            return true;
	        } else {
	            System.out.println("No se actualizó ninguna fila.");
	        }
	    }
	    
	    return false; 
		
	}
}

