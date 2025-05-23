package negocioImp;

import java.util.List;

import entidad.Persona;
import negocio.PersonaNegocio;
import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;

public class PersonaNegocioImpl implements PersonaNegocio{

	PersonaDao dao = new PersonaDaoImpl();
	
	
	private boolean personaValida(Persona persona) {
		
		String dni = persona.getDni().trim();
		String nombre = persona.getNombre().trim();
		String apellido = persona.getApellido().trim();
		
		if(dni.length() <= 0 || dni.length() > 20) return false;
		if(nombre.length() <= 0 || nombre.length() > 45) return false;
		if(apellido.length() <= 0 || apellido.length() > 45) return false;
		
		return true;	
	}
	
	private void limpiarPersona(Persona persona) {
		persona.setDni(persona.getDni().trim());
		persona.setNombre(persona.getNombre().trim());
		persona.setApellido(persona.getApellido().trim());
	}
	
	@Override
	public boolean agregarPersona(Persona persona) {
		
		boolean estado = false;
		
		limpiarPersona(persona);
		
		if( personaValida(persona) ) {
			
			estado = dao.insert(persona);
		}
		
		return estado;
	}

	@Override
	public boolean eliminarPersona(Persona persona) {
		boolean estado = false;
		
		limpiarPersona(persona);
		
		if( personaValida(persona) ) {
			estado = dao.delete(persona);
		}
		
		return estado;
	}



	@Override
	public List<Persona> listarPersonas() {
		return dao.readAll();
	}

}
