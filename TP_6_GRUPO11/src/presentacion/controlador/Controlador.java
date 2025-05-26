package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImp.PersonaNegocioImpl;
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
	private DefaultListModel<Persona> modeloPersonas;
	private DefaultTableModel tablaPersonas;
	private JList<Persona> listaEliminar;
	
	
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg)
	{
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;
		this.modeloPersonas = new DefaultListModel<Persona>();
		
		cargarDatosEnModelo();
		cargarDatosEnTabla();
		this.pnlAgregarPersonas = new agregarPersonas();
		this.pnlModificarPersonas = new modificarPersonas(this.modeloPersonas);
		this.pnlListarPersonas = new listarPersonas(this.tablaPersonas);
		this.pnlEliminarPersonas = new eliminarPersonas(this.modeloPersonas);
		//EVENTOS VENTANA PRINCIPAL
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMntmEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getMntmModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
		this.ventanaPrincipal.getMntmListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersona(a));
		
		
		//EVENTOS VENTANA AGREGAR
		
		
		this.pnlAgregarPersonas.getTxtDNI().addKeyListener( new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				eventoKeyTyped_SoloNumeros(e);
			}
		});
		this.pnlAgregarPersonas.getTxtNombre().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				eventoKeyTyped_SoloLetras(e);
			}
		});
		this.pnlAgregarPersonas.getTxtApellido().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				eventoKeyTyped_SoloLetras(e);
			}
		});
		this.pnlAgregarPersonas.getBtnAgregar().addActionListener(e -> agregarPersona());
		
		//EVENTOS VENTANA ELIMINAR
		this.pnlEliminarPersonas.getBtnEliminar().addActionListener(e -> eliminarPersona());
		
		//EVENTOS VENTANA MODIFICAR
		this.pnlModificarPersonas.getBtnModificar().addActionListener(e -> actualizarPersona());
		this.pnlModificarPersonas.getListPersona().addListSelectionListener(e->{
	        if (!e.getValueIsAdjusting()) {
	            cargarTxtPanelAgregar_ConPersonaSeleccionada();
	        }
	    });
		
		// Botón agregar persona
	}
	 public void cargarTxtPanelAgregar_ConPersonaSeleccionada(){
		    Persona seleccionada = this.pnlModificarPersonas.getListPersona().getSelectedValue();
		    if(seleccionada != null) {
		    	
		    	this.pnlModificarPersonas.getTxtDNI().setText(seleccionada.getDni());
		    	this.pnlModificarPersonas.getTxtApellido().setText(seleccionada.getApellido());
		    	this.pnlModificarPersonas.getTxtNombre().setText(seleccionada.getNombre());
		    	
		    }
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
		String nombre = pnlAgregarPersonas.getTxtNombre().getText();
		String apellido = pnlAgregarPersonas.getTxtApellido().getText();
		String dni = pnlAgregarPersonas.getTxtDNI().getText();

		Persona persona = new Persona(dni, nombre, apellido);
		if (pNeg.agregarPersona(persona)) {
			
			pnlAgregarPersonas.limpiarCampos();
		}
		cargarDatosEnModelo();
	}
	
	public void eliminarPersona(){
	    listaEliminar = this.pnlEliminarPersonas.getListPersona();
	    Persona seleccionada = listaEliminar.getSelectedValue();
		String nombre = seleccionada.getNombre();
		String apellido = seleccionada.getApellido();
		String dni = seleccionada.getDni();
		
		Persona persona = new Persona(dni, nombre, apellido);
		if (pNeg.eliminarPersona(persona)) {
			JOptionPane.showMessageDialog(null, "Persona eliminada correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		cargarDatosEnModelo();
	}
	
	public void actualizarPersona(){
		String nombre = pnlModificarPersonas.getTxtNombre().getText();
		String apellido = pnlModificarPersonas.getTxtApellido().getText();
		String dni = pnlModificarPersonas.getTxtDNI().getText();
		
		Persona persona = new Persona(dni, nombre, apellido);
		if (pNeg.actualizarPersona(persona)) {
			
			//pnlModificarPersonas.limpiarCampos();
		}
		cargarDatosEnModelo();
	}
	
	public void eventoKeyTyped_SoloNumeros(KeyEvent e) {
		char teclaPresionada = e.getKeyChar();
		if(!Character.isDigit(teclaPresionada)) {
			e.consume();
		}
	}
	public void eventoKeyTyped_SoloLetras(KeyEvent e) {
			char c = e.getKeyChar();
			if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
				e.consume();
			}
	}
	
	public DefaultListModel<Persona> cargarDatosEnModelo(){
		modeloPersonas.clear();
		List<Persona> personas = pNeg.listarPersonas();
		for(Persona p : personas) {
			modeloPersonas.addElement(p);;
		}
		return modeloPersonas;
	}
	
	public DefaultTableModel cargarDatosEnTabla(){
		String[] columnas = {"Nombre", "Apellido", "DNI"};
	    tablaPersonas = new DefaultTableModel(columnas, 0);

	    List<Persona> personas = pNeg.listarPersonas();
	    for (Persona p : personas) {
	        Object[] fila = { p.getNombre(), p.getApellido(), p.getDni() };
	        tablaPersonas.addRow(fila);
	    }
		return tablaPersonas;
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
