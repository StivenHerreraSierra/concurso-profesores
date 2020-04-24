package co.uniquindio.lenguaje.concurso.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
 * @author Sonia Jaramillo Valbuena
 * 
 *         Esta clase es la encargada de listar los contactos
 * 
 */
public class VentanaTodosLosDocentes extends JPanel implements ActionListener, ListSelectionListener {
	private static final long serialVersionUID = 1L;
	private JScrollPane miScroll;
	private JButton todos;
	private JTextField nombre;
	private JTextField apellido;
	private JLabel puntos;
	private JLabel foto;
	private JTextField puntajeTotal;
	private JButton puntaje;
	private JList <String> lista;
	private VentanaPrincipal miVentana;
	private VentanaSeleccionIdioma idioma;

	/**
	 * Constructor de la clase VentanaTodosLosContactos
	 * 
	 * @param arreglo informaci�n de los contactos
	 * @param titulo  titulo del panel
	 */
	public VentanaTodosLosDocentes(VentanaPrincipal miVentana, String titulo,
			VentanaSeleccionIdioma idioma) {
		this.idioma = idioma;
		this.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(null);
		String info[] = new String[2];
		info[0] = info[1] = "";
		this.miVentana = miVentana;
		lista = new JList <String> (info);
		lista.addListSelectionListener(this);

		miScroll = new JScrollPane(lista);
		miScroll.setBounds(20, 20, 180, 143);
		add(miScroll);
		{
			todos = new JButton();
			this.add(todos);
			todos.setText(idioma.getTextoMensaje("Etiqueta_Texto_Boton_Ordenar_Nombre"));
			todos.setBounds(218, 24, 177, 22);
			todos.addActionListener(this);
		}
		{
			puntaje = new JButton();
			this.add(puntaje);
			puntaje.setText(idioma.getTextoMensaje("Etiqueta_Texto_Boton_Ordenar_Puntaje"));
			puntaje.setBounds(218, 51, 177, 21);
			puntaje.addActionListener(this);
		}
		{
			nombre = new JTextField();
			this.add(nombre);
			nombre.setBounds(218, 94, 75, 21);
			nombre.setEnabled(false);
		}
		{
			apellido = new JTextField();
			this.add(apellido);
			apellido.setBounds(310, 94, 70, 21);
			apellido.setEnabled(false);
		}
		{
			puntajeTotal = new JTextField();
			this.add(puntajeTotal);
			puntajeTotal.setBounds(218, 135, 59, 21);
			puntajeTotal.setEnabled(false);
		}
		{
			puntos = new JLabel();
			this.add(puntos);
			puntos.setText(idioma.getTextoMensaje("Etiqueta_Label_Puntos"));
			puntos.setBounds(281, 142, 89, 14);
		}
		{
			foto = new JLabel();
			this.add(foto);
			foto.setBounds(404, 65, 165, 151);
			foto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		}
		setVisible(true);
		setSize(200, 200);
		this.setPreferredSize(new java.awt.Dimension(580, 221));
		repaint();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == todos) {
			lista.setListData(miVentana.getMiConcursoProfesor().
					generarListadoOrdenadoPorNombre(idioma.getTextoMensaje("Etiqueta_Label_Cedula")));

		}

		if (e.getSource() == puntaje) {

			lista.setListData(miVentana.getMiConcursoProfesor().
					generarListadoPorPuntaje(idioma.getTextoMensaje("Etiqueta_Label_Cedula")));

		}

	}

	public JList <String> getLista() {
		return lista;
	}

	public void setLista(JList <String> lista) {
		this.lista = lista;
	}

	public void valueChanged(ListSelectionEvent e) {
		int posicion = lista.getSelectedIndex();
		if (posicion != -1) {
			nombre.setText(miVentana.getMiConcursoProfesor().getMiProfesor().get(posicion).getNombre());
			apellido.setText(miVentana.getMiConcursoProfesor().getMiProfesor().get(posicion).getApellido());
			puntajeTotal.setText("" + miVentana.getMiConcursoProfesor().getMiProfesor().get(posicion).getPuntos());
			foto.setIcon(new ImageIcon(miVentana.getMiConcursoProfesor().getMiProfesor().get(posicion).getFoto()));
		}
	}
}
