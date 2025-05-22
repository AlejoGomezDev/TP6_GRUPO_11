package presentacion.vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class eliminarPersonas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JMenuBar menuBar;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public eliminarPersonas() {
		setLayout(null);
		
		lblNewLabel = new JLabel("ELIMINAR");
		lblNewLabel.setBounds(176, 139, 58, 13);
		add(lblNewLabel);
	}

}
