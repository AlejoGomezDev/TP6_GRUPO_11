package presentacion.vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class modificarPersonas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JMenuBar menuBar;
	private JLabel lblSeleccione;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JButton btnModificar;

	/**
	 * Create the panel.
	 */
	public modificarPersonas() {
		setLayout(null);
		
		lblSeleccione = new JLabel("Seleccione la persona que desea modificar");
		lblSeleccione.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSeleccione.setBounds(58, 32, 300, 13);
		add(lblSeleccione);
		
		JList listPersona = new JList();
		listPersona.setBounds(58, 55, 300, 160);
		add(listPersona);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(36, 255, 96, 19);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(142, 255, 96, 19);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(248, 255, 96, 19);
		add(txtDNI);
		txtDNI.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(355, 254, 85, 21);
		add(btnModificar);
	}
}
