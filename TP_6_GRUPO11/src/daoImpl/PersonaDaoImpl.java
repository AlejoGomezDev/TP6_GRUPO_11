package daoImpl;

import java.util.List;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao {
	
	private static final String insert = "INSERT INTO personas(dni, nombre, apellido)";
	private static final String delete = "DELETE FROM personas WHERE id=?";
	private static final String get = "SELECT * FROM personas WHERE id=?";
	private static final String readAll = "SELECT * FROM personas";
	
		
	public boolean insert(Persona persona) {
		
	}
	
	public boolean delete(Persona persona) {
		
	}
	
	public Persona get(Persona persona) {
		
	}
	
	public List<Persona> readAll() {
		
	}
	
	
}
