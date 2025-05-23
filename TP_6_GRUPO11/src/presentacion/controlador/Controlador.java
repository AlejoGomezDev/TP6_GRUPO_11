package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import entidad.Persona;
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
		
		// Botón agregar persona
		this.pnlAgregarPersonas.getBtnAgregar().addActionListener(e -> agregarPersona());
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

	
	public void agregarPersona() {
		String nombre = pnlAgregarPersonas.getTxtNombre().getText().trim();
		String apellido = pnlAgregarPersonas.getTxtApellido().getText().trim();
		String dni = pnlAgregarPersonas.getTxtDNI().getText().trim();

		if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos.");
			return;
		}

		if (!dni.matches("\\d+")) {
			JOptionPane.showMessageDialog(null, "El DNI debe contener solo números.");
			return;
		}

		// Verificar si el DNI ya existe
		/*if (pNeg.existeDNI(dni)) {
			JOptionPane.showMessageDialog(null, "Ya existe una persona con ese DNI.");
			return;
		}*/

		Persona persona = new Persona(nombre, apellido, dni);
		if (pNeg.agregarPersona(persona)) {
			JOptionPane.showMessageDialog(null, "Persona agregada con éxito.");
			pnlAgregarPersonas.limpiarCampos();
		} else {
			JOptionPane.showMessageDialog(null, "Error al agregar persona.");
		}
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
