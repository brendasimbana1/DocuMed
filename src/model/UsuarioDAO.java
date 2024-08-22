package model;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.ConnectionPostgres;


public class UsuarioDAO {
	private ConnectionPostgres dbConn = new ConnectionPostgres("bd_consultorio");
	private String query="";
	
	public List<Usuario> getUsers() throws SQLException
	{
		List<Usuario> users = new ArrayList<Usuario>();
		query = "SELECT * FROM usuarios";
        ResultSet rs= dbConn.executeQuery(query);
        try 
        {
            while (rs != null && rs.next()) 
            {
            	users.add(new Usuario(
            			rs.getInt(1),
            			rs.getString(2),
            			rs.getString(3)
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
        return users;

	}
	
	public boolean addUser(Usuario user)
	{
		query = String.format("INSERT INTO usuarios VALUES('%s', '%s')",
				user.getNombre(),
				user.getContrasenia());
		boolean result = dbConn.executeUpdate(query);
		return result;
	}
	
	public boolean editPswById(Usuario user)
	{
		query = String.format("UPDATE usuarios SET password = '%s' WHERE id = %d;",
				user.getContrasenia(),
				user.getId());
		boolean result = dbConn.executeUpdate(query);
		return result;
	}
	
	
	
	
	

}
