package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao {
	
	private static final String insert = "INSERT INTO personas(dni, nombre, apellido)";
	private static final String delete = "DELETE FROM personas WHERE id=?";
	private static final String get = "SELECT * FROM personas WHERE id=?";
	private static final String readAll = "SELECT * FROM personas";
	
		
	public boolean insert(Persona persona) {
		boolean estado = false;
		PreparedStatement stmt = null;
		Connection conexion = Conexion.getConexion().getSQLConnection();

		try {
			stmt = conexion.prepareStatement(insert);
			stmt.setInt(1, persona.getDni());
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
	
	public boolean delete(Persona persona) {
		
	}
	
	public Persona get(Persona persona) {
		
	}
	
	public List<Persona> readAll() {
		
	}
	
	
}
