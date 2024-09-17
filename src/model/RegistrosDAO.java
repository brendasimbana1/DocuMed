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
		return registers;
	}
}
