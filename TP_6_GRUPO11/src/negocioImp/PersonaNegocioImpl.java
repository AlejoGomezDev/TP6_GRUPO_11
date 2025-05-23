package negocioImp;

import java.util.List;

import javax.swing.JOptionPane;

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
		
		if( personaValida(persona) && VerificarCampos(persona)) {
			
		    	if(!dao.existe(persona)) {
			    	estado = dao.insert(persona);
		    	}else {
		    		JOptionPane.showMessageDialog(null, "Ya existe un registro con ese DNI", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		    	}
			
		}else {
			 JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		if(estado == true) {
			JOptionPane.showMessageDialog(null, "La persona ha sido agregada exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		return estado;
	}
    public boolean VerificarCampos(Persona persona) {
	boolean camposLlenos =false;
	if(persona.getDni().trim().length() > 0 && persona.getNombre().trim().length() > 0 && persona.getApellido().trim().length() > 0) {
		camposLlenos = true;
	}
	return camposLlenos;
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
   
	public boolean existePersona(String dni) {
		Persona per = new Persona();
		per.setDni(dni);
		return dao.existe(per);
	}


	@Override
	public List<Persona> listarPersonas() {
		return dao.readAll();
	}

}
