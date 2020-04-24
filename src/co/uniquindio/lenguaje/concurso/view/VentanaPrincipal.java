package co.uniquindio.lenguaje.concurso.view;

import java.awt.BorderLayout;
import java.awt.Dimension; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import co.uniquindio.lenguaje.concurso.view.VentanaSeleccionIdioma;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;
import co.uniquinido.lenguaje.concurso.model.ConcursoProfesor;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 * @version 1.0
 * @created Nov-2007
 * @author Sonia Jaramillo Valbuena Esta clase es la encargada de permitir la
 *         interacci�n con el usuario
 * 
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private String rutaBin = "src/Concurso.dat";
	private VentanaAgregarProfesor ventanaAgregarProfesor1;
	private ConcursoProfesor miConcursoProfesor;
	private VentanaTodosLosDocentes miVentanaTodosLosDocentes1;
	VentanaSeleccionIdioma ventanaSeleccionIdioma;
	
	private WindowListener handlerWindow = new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent arg0) {}
		
		@Override
		public void windowIconified(WindowEvent arg0) {}
		
		@Override
		public void windowDeiconified(WindowEvent arg0) {}
		
		@Override
		public void windowDeactivated(WindowEvent arg0) {}
		
		@Override
		public void windowClosing(WindowEvent arg0) {
			System.out.println("Cerrando ventana");
			if (ventanaAgregarProfesor1 != null) {
				ventanaAgregarProfesor1.registrarProfesor();
			}
		}
		
		@Override
		public void windowClosed(WindowEvent arg0) {}
		
		@Override
		public void windowActivated(WindowEvent arg0) {}
	};
	
	/**
	 * Constructor de la clase VentanaPrincipal
	 */
	public VentanaPrincipal() {
		cargarVentanaIdioma ();
		addWindowListener(handlerWindow);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void cargarVentanaIdioma () {
		setVisible(true);
		setLayout(new BorderLayout());
		this.setSize(new Dimension (400, 300));
		this.setResizable(false);
		this.setTitle("Seleccion Idioma");
		ventanaSeleccionIdioma = new VentanaSeleccionIdioma (this);
		this.add(ventanaSeleccionIdioma);
		ventanaSeleccionIdioma.setVisible(true);
	}
	
	public void cargarVentanaAplicacion (VentanaSeleccionIdioma idioma) {
		miConcursoProfesor = new ConcursoProfesor();
		getContentPane().setLayout(null);
		cargarArchivoBin();
		setVisible(true);
		// Se agregan los componentes
		{
			ventanaAgregarProfesor1 = new VentanaAgregarProfesor(this,
					ventanaSeleccionIdioma);
			getContentPane().add(ventanaAgregarProfesor1);
			ventanaAgregarProfesor1.setBounds(49, 12, 522, 369);
			ventanaAgregarProfesor1.setVisible(true);
			ventanaAgregarProfesor1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 0)));
		}

		miVentanaTodosLosDocentes1 = new VentanaTodosLosDocentes(this, "Concursantes",
				ventanaSeleccionIdioma);
		actualizarTabla();
		miVentanaTodosLosDocentes1.setBounds(0, 404, 604, 257);
		getContentPane().add(miVentanaTodosLosDocentes1);
		miVentanaTodosLosDocentes1.setVisible(true);
		miVentanaTodosLosDocentes1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 0)));
		miVentanaTodosLosDocentes1.setBackground(new java.awt.Color(202, 202, 255));
		this.setTitle(idioma.getTextoMensaje("Etiqueta_Titulo_Principal"));
		getContentPane().setBackground(new java.awt.Color(128, 128, 255));
		ventanaAgregarProfesor1.setMiVentanaTodosLosDocentes(miVentanaTodosLosDocentes1);
		ventanaAgregarProfesor1.setBackground(new java.awt.Color(202, 202, 255));
				
		repaint();
		this.setSize(624, 718);
	}

	/**
	 * Permite configurar las acciones a realizar si ocurre un evento
	 */
	public void actionPerformed(ActionEvent evento) {

	}

	public void actualizarTabla () {
//		String[] a = miConcursoProfesor.generarListado();
//		for (String b: a) {
//			System.out.println(b);
//		}
		miVentanaTodosLosDocentes1.getLista().
		setListData(miConcursoProfesor.generarListado());
	}
	
	public ConcursoProfesor getMiConcursoProfesor() {
		return miConcursoProfesor;
	}

	public void setMiConcursoProfesor(ConcursoProfesor miConcursoProfesor) {
		this.miConcursoProfesor = miConcursoProfesor;
	}

	/**
	 * 
	 */
	public void cargarArchivoBin () {
		try {
			File archivo = new File (rutaBin);
			if (archivo.exists() == true) {
				miConcursoProfesor = miConcursoProfesor.cargarArchivoBin(rutaBin);
			}
		} catch (IOException|ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void guardarArchivoBin () {
		try {
			miConcursoProfesor.guardarArchivoBin(rutaBin);
		} catch (IOException|ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
