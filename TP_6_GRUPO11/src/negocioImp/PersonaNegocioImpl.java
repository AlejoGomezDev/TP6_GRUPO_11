package negocioImp;

import java.util.List;

import entidad.Persona;
import negocio.PersonaNegocio;
import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;

public class PersonaNegocioImpl implements PersonaNegocio{

	PersonaDao dao = new PersonaDaoImpl();
	
	@Override
	public boolean agregarPersona(Persona persona) {
		
		return false;
	}

	@Override
	public boolean eliminarPersona(Persona persona) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Persona obtenerPersona(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> listarPersonas() {
		// TODO Auto-generated method stub
		return null;
	}

}
