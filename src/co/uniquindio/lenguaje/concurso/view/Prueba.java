package co.uniquindio.lenguaje.concurso.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import co.uniquindio.lenguaje.concurso.Aplicacion;

public class Prueba extends JFrame {

	private JPanel contentPane;
	private JButton espanolButton;
	private JButton inglesButton;
	private ResourceBundle mensaje;
//	private Aplicacion aplicacion;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
			//		Prueba frame = new Prueba();
			//		frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		new Prueba();
	}
	
	public Prueba () {
		Prueba frame = new Prueba();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public void init () {
//		this.aplicacion = aplicacion;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel tituloLabel = new JLabel("Idioma");
		tituloLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblNewLabel = new JLabel("Seleccione su idioma:");
		
		espanolButton = new JButton("Español");
		
		inglesButton = new JButton("Inglés");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(170)
					.addComponent(tituloLabel)
					.addContainerGap(186, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(138, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(125))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(163)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(inglesButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
						.addComponent(espanolButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(163))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(tituloLabel)
					.addGap(28)
					.addComponent(lblNewLabel)
					.addGap(36)
					.addComponent(espanolButton)
					.addGap(18)
					.addComponent(inglesButton)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
	
	private ActionListener handlerEvents = new ActionListener () {
		@Override
		public void actionPerformed (ActionEvent evento) {
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
//			aplicacion.mostrarVentanaPrincipal();
		}
	};
}
