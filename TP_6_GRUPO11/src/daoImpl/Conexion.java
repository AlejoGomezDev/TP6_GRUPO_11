package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	public static Conexion instancia;
	private Connection connection;
	private String db = "jdbc:mysql://localhost:3306/dbPersonas";
	private String user = "root";
	private String pass = "root";
	
	
	private Conexion() {
		try {
			this.connection = DriverManager.getConnection(db, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConnection() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		instancia = null;
	}
}
