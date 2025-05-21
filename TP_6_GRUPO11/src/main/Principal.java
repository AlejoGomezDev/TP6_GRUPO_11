package main;
import  negocio.PersonaNegocio;
import negocioImp.PersonaNegocioImpl;
import presentacion.controlador.Controlador;
import presentacion.vista.*;
public class Principal {

	public static void main(String[] args) {
		
		PersonaNegocio negocio = new PersonaNegocioImpl();
		VentanaPrincipal ventana = new VentanaPrincipal();
		Controlador controlador = new Controlador(ventana,negocio);
		controlador.inicializar();
        
		
	}

}
