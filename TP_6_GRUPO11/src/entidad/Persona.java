package entidad;

public class Persona {
	private String dni;
	private String nombre;
	private String apellido;
	
	//GETTERS &  SETTERS
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	//CONSTRUCTOR
	public Persona(String dni, String nombre, String apellido) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	//TO-STRING
	@Override
	public String toString() {
		return "DNI: " + dni + ", Nombre: " + nombre + ", Apellido: " + apellido + ".";
	}
}
