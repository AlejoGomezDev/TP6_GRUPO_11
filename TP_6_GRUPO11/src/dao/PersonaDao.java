package dao;

import java.util.List;

import entidad.Persona;

public interface PersonaDao {
	
	public boolean insert(Persona persona);
	public boolean delete(Persona persona);
	public List<Persona> readAll();
	public boolean existe(Persona persona);
	public boolean update(Persona persona);
}
