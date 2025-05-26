package presentacion.vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import entidad.Persona;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class eliminarPersonas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JMenuBar menuBar;
	private JLabel lblEliminar;
	private JList<Persona> listPersona;
	private JButton btnEliminar;

	/**
	 * Create the panel.
	 */
	public eliminarPersonas(DefaultListModel<Persona> modelo) {
		setLayout(null);
		
		lblEliminar = new JLabel("ELIMINAR USUARIOS");
		lblEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblEliminar.setBounds(162, 33, 141, 13);
		add(lblEliminar);
		
		listPersona = new JList<Persona>(modelo);
		listPersona.setBounds(64, 57, 311, 175);
		add(listPersona);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(135, 242, 168, 23);
		add(btnEliminar);
	}
	
	public JList<Persona> getListPersona() {
		return listPersona;
	}
	
	public void setListPersona(JList<Persona> listPersona) {
		this.listPersona = listPersona;
	}
	
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
}
