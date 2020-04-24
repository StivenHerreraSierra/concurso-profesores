package co.uniquindio.lenguaje.concurso;

import co.uniquindio.lenguaje.concurso.view.VentanaPrincipal;

public class Aplicacion {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Aplicacion ();
	}
	
	public Aplicacion () {
		VentanaPrincipal ventanaPrincipal;
		ventanaPrincipal = new VentanaPrincipal ();
		ventanaPrincipal.setVisible(true);
	}
}
