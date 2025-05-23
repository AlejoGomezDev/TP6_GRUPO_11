package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class agregarPersonas extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JButton btnAgregar;

	public agregarPersonas() {
		setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(88, 55, 55, 13);
		add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(88, 124, 55, 18);
		add(lblApellido);

		txtNombre = new JTextField();
		txtNombre.setBounds(171, 55, 120, 19);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(171, 124, 120, 19);
		add(txtApellido);
		txtApellido.setColumns(10);

		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDNI.setBounds(88, 189, 55, 13);
		add(lblDNI);

		txtDNI = new JTextField();
		txtDNI.setBounds(171, 189, 120, 19);
		add(txtDNI);
		txtDNI.setColumns(10);
		

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAgregar.setBounds(88, 253, 110, 21);
		add(btnAgregar);
	}

	// Getters
	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public JTextField getTxtDNI() {
		return txtDNI;
	}

	// Método para limpiar los campos
	public void limpiarCampos() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDNI.setText("");
	}
}