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
	private static final String select = "SELECT * FROM Personas  WHERE Dni=?";
	
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
				personas.add(getPersona(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException{
		String Dni = resultSet.getString("Dni");
		String nombre = resultSet.getString("Nombre");
		String Apel = resultSet.getString("Apellido");
		return new Persona(Dni, nombre, Apel);
	}
	public boolean existe(Persona persona) {
		boolean existe = false;
		PreparedStatement pst;
	Connection conexion = Conexion.getConexion().getSQLConnection();
		try {
			pst = conexion.prepareStatement(select);
			pst.setString(1, persona.getDni());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				existe = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}
	
}
