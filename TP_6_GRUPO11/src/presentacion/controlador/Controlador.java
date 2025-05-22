package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

import negocio.PersonaNegocio;
import presentacion.vista.VentanaPrincipal;
import presentacion.vista.agregarPersonas;
import presentacion.vista.eliminarPersonas;
import presentacion.vista.listarPersonas;
import presentacion.vista.modificarPersonas;

public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private agregarPersonas pnlAgregarPersonas;
	private eliminarPersonas pnlEliminarPersonas;
	private modificarPersonas pnlModificarPersonas;
	private listarPersonas pnlListarPersonas;
	private PersonaNegocio pNeg;
	
	
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg)
	{
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;
		
		this.pnlAgregarPersonas = new agregarPersonas();
		this.pnlModificarPersonas = new modificarPersonas();
		this.pnlListarPersonas = new listarPersonas();
		this.pnlEliminarPersonas = new eliminarPersonas();
		
		//EVENTOS VENTANA PRINCIPAL
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMntmEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getMntmModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
		this.ventanaPrincipal.getMntmListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersona(a));
		
		//EVENTOS VENTANA AGREGAR
		this.ventanaPrincipal.getMntmEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getMntmModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
		this.ventanaPrincipal.getMntmListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersona(a));
		
		//EVENTOS VENTANA ELIMINAR
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMntmModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
		this.ventanaPrincipal.getMntmListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersona(a));
		
		//EVENTOS VENTANA MODIFICAR
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMntmEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getMntmListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersona(a));
		
		//EVENTOS VENTANA LISTAR
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMntmEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getMntmModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
	}
	
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlAgregarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlListarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
