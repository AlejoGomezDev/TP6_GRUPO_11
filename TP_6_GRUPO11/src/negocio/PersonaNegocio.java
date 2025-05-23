package negocio;

import entidad.Persona;
import java.util.List;

public interface PersonaNegocio {
	
    public boolean agregarPersona(Persona persona);
    public boolean eliminarPersona(Persona persona);
    public List<Persona> listarPersonas();
    /*public boolean existePersonaPorDNI(String dni) {
    	return personaDao.obtenerPorDNI(dni) != null;
    }*/
}
