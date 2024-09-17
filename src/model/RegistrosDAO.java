package model;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.ConnectionPostgres;

public class RegistrosDAO {
	private ConnectionPostgres dbConn = new ConnectionPostgres("bd_consulta_medica");
	private String query="";
	
	public List<Registros> getRegistros()
	{
		List<Registros> registers = new ArrayList<Registros>();
		query = "SELECT * FROM usuarios;";
		ResultSet rs;
		rs = dbConn.executeQuery(query);
		try 
		{
			while (rs != null && rs.next()) 
			{
				registers.add(new Registros(
						rs.getDate(3),
						rs.getString(4),
						rs.getDouble(5),
						rs.getDouble(6),
						rs.getDouble(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(2)
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


		return registers;
	}
	
	public boolean addRegister(Registros r)
	{
		query = String.format("INSERT INTO registros VALUES('%s', %t, '%s', %f,  %f, %f, '%s', '%s', '%s', '%s')",
				r.getCi(),
				r.getFechas_atencion(),
				r.getDiagnostico(),
				r.getPeso(),
				r.getAltura(),
				r.getTemperatura(),
				r.getPresion_arterial(),
				r.getEvolucion(),
				r.getIndicaciones(),
				r.getResponsable());
		boolean result = dbConn.executeUpdate(query);
		return result;
	}
}
