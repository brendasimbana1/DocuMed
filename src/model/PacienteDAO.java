package model;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.ConnectionPostgres;

public class PacienteDAO {
	private ConnectionPostgres dbConn = new ConnectionPostgres("bd_consulta_medica");
	private String query="";
	private boolean result = false;
	
	public boolean addPatient(Paciente p)
	{
		query = "INSERT INTO pacientes (cedula, nombres, apellidos, ocupacion, profesion, fecha_nacimiento, fecha_actual, telefonos, genero, lugar_nacimiento)"
				+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = dbConn.connect();
		         PreparedStatement stmt = conn.prepareStatement(query)) {
		        
		        stmt.setString(1, p.getCi());
		        System.out.println(p.getCi());
		        stmt.setString(2, p.getNombres());
		        stmt.setString(3, p.getApellidos());
		        stmt.setString(4, p.getOcupacion());
		        stmt.setString(5, p.getProfesion());
		        stmt.setDate(6, new Date(p.getFecha_nacimiento().getTime())); // Conversión a java.sql.Date
		        stmt.setDate(7, new Date(p.getFecha_actual().getTime()));
		        Array telefonosArray = conn.createArrayOf("varchar", p.getTelefonos());
		        stmt.setArray(8, telefonosArray);
		        char genero = p.getGenero(); // Obtén el carácter del objeto Paciente
		        stmt.setString(9, String.valueOf(genero)); // Convertir char a String
		        stmt.setString(10, p.getLugar_nacimiento());
		        // Ejecutar la consulta
		        int rowsAffected = stmt.executeUpdate();
		        System.out.println("Operación realizada con éxito." );
		        return rowsAffected > 0;
		        
		    } catch (SQLException e) {
		        System.err.println("Error al ejecutar la operación.");
		        e.printStackTrace();
		        return false;
		    }
		
		
	}
}
