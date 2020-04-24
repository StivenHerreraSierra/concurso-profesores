package co.uniquindio.lenguaje.concurso.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;
import java.util.Locale;
import java.awt.Color;

public class VentanaSeleccionIdioma extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static ResourceBundle mensaje;
	private VentanaPrincipal ventanaPrincipal;
	private JLabel idiomaLabel;
	private JLabel lblSeleccioneSuIdioma;
	private JButton espanolButton;
	private JButton inglesButton;

	/**
	 * Create the panel.
	 */
	public VentanaSeleccionIdioma (VentanaPrincipal ventanaPrincipal) {
		setBackground(Color.LIGHT_GRAY);
		this.ventanaPrincipal = ventanaPrincipal;
		setLayout(null);
		
		idiomaLabel = new JLabel("Idioma");
		idiomaLabel.setBounds(152, 43, 58, 19);
		idiomaLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		add(idiomaLabel);
		
		lblSeleccioneSuIdioma = new JLabel("Seleccione su idioma:");
		lblSeleccioneSuIdioma.setBounds(113, 111, 153, 15);
		add(lblSeleccioneSuIdioma);
		
		espanolButton = new JButton("Español");
		espanolButton.setBounds(143, 172, 90, 25);
		espanolButton.addActionListener(this);
		add(espanolButton);
		
		inglesButton = new JButton("Inglés");
		inglesButton.setBounds(143, 222, 90, 25);
		inglesButton.addActionListener(this);
		add(inglesButton);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		JButton botonAux = (JButton) evento.getSource();
		Locale localizacion;
		String idioma;
		String pais;
		
		if (botonAux.equals(espanolButton)) {
			idioma = "es";
			pais = "ES";
		}
		else {
			idioma = "en";
			pais = "US";
		}
		localizacion = new Locale (idioma, pais);
		mensaje = mensaje.getBundle("resources.Etiquetas", localizacion);
		ventanaPrincipal.cargarVentanaAplicacion (this);
		this.setVisible(false);
	}
	
	public String getTextoMensaje (String clave) {
		return mensaje.getString(clave);
	}
}
