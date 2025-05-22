package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao {
	
	private static final String insert = "INSERT INTO Personas(Dni, Nombre, Apellido) VALUES (?, ?, ?)";
	private static final String delete = "DELETE FROM Personas WHERE Dni=?";
	private static final String readAll = "SELECT * FROM Personas";
	
	@Override	
	public boolean insert(Persona persona) {
		boolean estado = false;
		PreparedStatement stmt = null;
		Connection conexion = Conexion.getConexion().getSQLConnection();

		try {
			stmt = conexion.prepareStatement(insert);
			stmt.setString(1, persona.getDni());
			stmt.setString(2, persona.getNombre());
			stmt.setString(3, persona.getApellido());

			if (stmt.executeUpdate() > 0) {
				estado = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return estado;
	}

	@Override	
	public boolean delete(Persona persona) {
		boolean estado = false;
		PreparedStatement stmt = null;
		Connection conexion = Conexion.getConexion().getSQLConnection();
		
		try {
			stmt = conexion.prepareStatement(delete);
			stmt.setString(1, persona.getDni().toString().trim());
			
			if(stmt.executeUpdate() > 0 ) {
				estado = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (stmt != null) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return estado;
		
	}

	@Override	
	public List<Persona> readAll() {
		
		PreparedStatement stmt = null;
		Connection conexion = Conexion.getConexion().getSQLConnection();
		ResultSet resultSet;
		
		ArrayList<Persona> personas = new ArrayList<Persona>();

		try 
		{
			stmt = conexion.prepareStatement(readAll);
			
			resultSet = stmt.executeQuery();
			
			while(resultSet.next())
			{
				String dni = resultSet.getString("Dni");
				String nombre = resultSet.getString("Nombre");
				String apellido = resultSet.getString("Apellido");
				
				Persona newPersona = new Persona(dni,nombre,apellido);
				
				personas.add(newPersona);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	
	
}
