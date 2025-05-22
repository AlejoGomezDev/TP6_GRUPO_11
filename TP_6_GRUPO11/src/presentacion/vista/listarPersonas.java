package presentacion.vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class listarPersonas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JMenuBar menuBar;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public listarPersonas() {
		setLayout(null);
		
		lblNewLabel = new JLabel("LISTAR");
		lblNewLabel.setBounds(171, 140, 45, 13);
		add(lblNewLabel);
	}

}
