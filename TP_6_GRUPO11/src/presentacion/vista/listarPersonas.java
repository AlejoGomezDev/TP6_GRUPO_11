package presentacion.vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;

public class listarPersonas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JMenuBar menuBar;
	private JLabel lblNewLabel;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public listarPersonas() {
		setLayout(null);
		
		lblNewLabel = new JLabel("LISTAR");
		lblNewLabel.setBounds(200, 11, 45, 13);
		add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(10, 35, 430, 254);
		add(table);
	}
}
