package presentacion.vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

public class eliminarPersonas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JMenuBar menuBar;
	private JLabel lblEliminar;

	/**
	 * Create the panel.
	 */
	public eliminarPersonas() {
		setLayout(null);
		
		lblEliminar = new JLabel("ELIMINAR USUARIOS");
		lblEliminar.setBounds(162, 33, 141, 13);
		add(lblEliminar);
		
		JList listUsuarios = new JList();
		listUsuarios.setBounds(135, 57, 168, 175);
		add(listUsuarios);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(135, 242, 168, 23);
		add(btnEliminar);
	}
}
