package model;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
		query = "SELECT * FROM registros;";
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
        PreparedStatement pstmt = null;
        Connection conn = null;
        String query = "INSERT INTO registros (cedula, fecha_atencion, diagnostico, peso, altura, temperatura, presion_arterial, evolucion, indicaciones, responsable) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = dbConn.connect();
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, r.getCi());
            pstmt.setDate(2,  new java.sql.Date(r.getFechas_atencion().getTime())); 
            pstmt.setString(3, r.getDiagnostico());
            pstmt.setDouble(4, r.getPeso());
            pstmt.setDouble(5, r.getAltura());
            pstmt.setDouble(6, r.getTemperatura());
            pstmt.setString(7, r.getPresion_arterial());
            pstmt.setString(8, r.getEvolucion());
            pstmt.setString(9, r.getIndicaciones());
            pstmt.setString(10, r.getResponsable());

            int rowsAffected = pstmt.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) dbConn.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
}
