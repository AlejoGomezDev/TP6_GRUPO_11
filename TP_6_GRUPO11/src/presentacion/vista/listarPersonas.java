package presentacion.vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class listarPersonas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JMenuBar menuBar;
	private JLabel lblListar;
	private JTable tableListar;

	/**
	 * Create the panel.
	 */
	public listarPersonas(DefaultTableModel model) {
		setLayout(null);
		
		lblListar = new JLabel("LISTAR");
		lblListar.setBounds(200, 11, 45, 13);
		add(lblListar);
		
		tableListar = new JTable();
		tableListar.setBounds(10, 36, 430, 254);
		tableListar.setModel(model);
		add(tableListar);
	}

	public JTable getTableListar() {
		return tableListar;
	}

	public void setTableListar(JTable tableListar) {
		this.tableListar = tableListar;
	}
	
}
