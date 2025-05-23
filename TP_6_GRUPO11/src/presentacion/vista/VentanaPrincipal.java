package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	JMenuBar menuBar;
	JMenu mnMenu;
	JMenuItem mntmAgregar;
	JMenuItem mntmModificar;
	JMenuItem mntmEliminar;
	JMenuItem mntmListar;

	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setTitle("Programa");
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMenu = new JMenu("Persona");
		menuBar.add(mnMenu);
		
		mntmAgregar = new JMenuItem("Agregar");
		mnMenu.add(mntmAgregar);
		
		mntmModificar = new JMenuItem("Modificar");
		mnMenu.add(mntmModificar);
		
		mntmEliminar = new JMenuItem("Eliminar");
		mnMenu.add(mntmEliminar);
		
		mntmListar = new JMenuItem("Listar");
		mnMenu.add(mntmListar);
		getContentPane().setLayout(new BorderLayout(0, 0));
	
}

	public JMenuItem getMntmAgregar() {
		return mntmAgregar;
	}

	public void setMntmAgregar(JMenuItem mntmAgregar) {
		this.mntmAgregar = mntmAgregar;
	}

	public JMenuItem getMntmModificar() {
		return mntmModificar;
	}

	public void setMntmModificar(JMenuItem mntmModificar) {
		this.mntmModificar = mntmModificar;
	}

	public JMenuItem getMntmEliminar() {
		return mntmEliminar;
	}

	public void setMntmEliminar(JMenuItem mntmEliminar) {
		this.mntmEliminar = mntmEliminar;
	}

	public JMenuItem getMntmListar() {
		return mntmListar;
	}

	public void setMntmListar(JMenuItem mntmListar) {
		this.mntmListar = mntmListar;
	}
	
	
}
