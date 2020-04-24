package co.uniquindio.lenguaje.concurso.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class VentanaAgregarProfesor extends javax.swing.JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel cedula;
	private JTextField miCedula;
	private JLabel nombreLabel;
	private JTextField nombre;
	private JLabel apellidoLabel;
	private JTextField apellido;
	private JLabel miFoto;
	private JButton miBoton;
	private JTextField foto;
	private JSeparator jSeparator1;
	private JButton agregar;
	private JComboBox<String> cantidadLibros;
	private JLabel datos;
	private JSeparator miSeparador;
	private JLabel estudios;
	private JRadioButton no;
	private JRadioButton si;
	private ButtonGroup miGrupo;
	private JLabel librosLabel;
	private JCheckBox doctorado;
	private JCheckBox maestria;
	private JCheckBox especializacion;
	private JCheckBox pregrado;
	private String imagen;

	private boolean pregrado1, especializacion1, maestria1, doctorado1;
	private int cantidadLibros1 = 0;
	private VentanaTodosLosDocentes miVentanaTodosLosDocentes;
	private boolean centinela = false;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaSeleccionIdioma idioma;

	public VentanaAgregarProfesor(VentanaPrincipal miVentanaPrincipal,
			VentanaSeleccionIdioma idioma) {
		this.idioma = idioma;
		this.miVentanaPrincipal = miVentanaPrincipal;
		initGUI();
		miFoto.setIcon(new ImageIcon("src/fotos/profesor.jpg"));

	}

	public void setMiVentanaTodosLosDocentes(VentanaTodosLosDocentes miVentanaTodosLosDocentes) {
		this.miVentanaTodosLosDocentes = miVentanaTodosLosDocentes;
	}

	/**
	 * Inicia los componentes.
	 */
	private void initGUI() {
		try {
			this.setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(636, 348));
			this.setVisible(false);
			{
				nombreLabel = new JLabel();
				this.add(nombreLabel);
				nombreLabel.setText(idioma.getTextoMensaje("Etiqueta_Label_Nombre"));
				nombreLabel.setBounds(14, 72, 116, 14);
			}
			{
				nombre = new JTextField();
				this.add(nombre);
				nombre.setOpaque(true);
				nombre.setBackground(Color.BLACK);
				nombre.setForeground(Color.white);
				nombre.setBounds(133, 69, 75, 21);
			}
			{
				apellidoLabel = new JLabel();
				this.add(apellidoLabel);
				apellidoLabel.setText(idioma.getTextoMensaje("Etiqueta_Label_Apellido"));
				apellidoLabel.setBounds(17, 103, 116, 14);
			}
			{
				apellido = new JTextField();
				this.add(apellido);
				apellido.setBounds(133, 102, 75, 21);
			}
			{
				pregrado = new JCheckBox();
				this.add(pregrado);
				pregrado.setText(idioma.getTextoMensaje("Etiqueta_Texto_CheckBox_1"));
				pregrado.setBounds(14, 185, 116, 18);
				//No es necesario.
				pregrado.setOpaque(true);
				//Da el color de fondo al check para que la ventana sea pareja.
				pregrado.setBackground(new java.awt.Color(202, 202, 255));
			}
			{
				especializacion = new JCheckBox();
				this.add(especializacion);
				especializacion.setText(idioma.getTextoMensaje("Etiqueta_Texto_CheckBox_2"));
				especializacion.setBounds(14, 210, 133, 18);
				especializacion.setBackground(new java.awt.Color(202, 202, 255));
			}
			{
				maestria = new JCheckBox();
				this.add(maestria);
				maestria.setText(idioma.getTextoMensaje("Etiqueta_Texto_CheckBox_3"));
				maestria.setBounds(14, 235, 128, 18);
				maestria.setBackground(new java.awt.Color(202, 202, 255));
			}
			{
				doctorado = new JCheckBox();
				this.add(doctorado);
				doctorado.setText(idioma.getTextoMensaje("Etiqueta_Texto_CheckBox_1"));
				doctorado.setBounds(14, 265, 133, 18);
				doctorado.setBackground(new java.awt.Color(202, 202, 255));
			}
			{
				librosLabel = new JLabel();
				this.add(librosLabel);
				librosLabel.setText(idioma.getTextoMensaje("Etiqueta_Label_Libros"));
				librosLabel.setBounds(347, 161, 98, 14);
			}
			{
				si = new JRadioButton();
				this.add(si);
				si.setText(idioma.getTextoMensaje("Etiqueta_Radio_Button_Si"));
				si.setBounds(269, 185, 96, 18);
				si.setToolTipText("Seleccione si cuando haya escrito libros");
				si.setBackground(new java.awt.Color(202, 202, 255));
				si.addActionListener(this);
				getMiGrupo().add(si);
			}
			{
				no = new JRadioButton();
				this.add(no);
				no.setText(idioma.getTextoMensaje("Etiqueta_Radio_Button_No"));
				no.setBounds(376, 185, 98, 18);
				no.setBackground(new java.awt.Color(202, 202, 255));
				no.setSelected(true);
				no.addActionListener(this);
				getMiGrupo().add(no);
			}
			{
				estudios = new JLabel();
				this.add(estudios);
				estudios.setText(idioma.getTextoMensaje("Etiqueta_Label_Estudios"));
				estudios.setBounds(14, 161, 180, 14);
				estudios.setForeground(new java.awt.Color(0, 0, 160));
			}
			{
				//Línea que separa los datos personales y los datos de estudios.
				miSeparador = new JSeparator();
				this.add(miSeparador);
				//Características (posición X, posición Y, ancho, alto).
				miSeparador.setBounds(8, 154, 632, 100);
				//Color de la línea (0,0,64)-> Negro
				miSeparador.setForeground(new java.awt.Color(0, 0, 64));
			}
			{
				datos = new JLabel();
				this.add(datos);
				datos.setText(idioma.getTextoMensaje("Etiqueta_Label_Datos"));
				datos.setBounds(12, 9, 146, 14);
				datos.setForeground(new java.awt.Color(0, 0, 160));
			}
			{	
				//Modelo del comboBox, de allí obtiene la lista de ítems.
				ComboBoxModel<String> cantidadLibrosModel = new DefaultComboBoxModel<String>(
						new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" });
				cantidadLibros = new JComboBox<String>();
				this.add(cantidadLibros);
				//Inicializa el botón agregar.
				this.add(getAgregar());
				//Inicializa la línea que separa los estudios con el botón agregar.
				this.add(getJSeparator1());
				//Inicializa el textField que almacena la dirección de la foto.
				this.add(getFoto());
				//Inicializa el boton Foto (Para seleccionar la foto).
				this.add(getMiBoton());
				//Inicializa el label que carga la foto del profesor.
				this.add(getMiFoto());
				//Inicializa el label cedula que acompaña el TextField de cédula.
				this.add(getCedula());
				//Inicializa el TextField de la cédula.
				this.add(getMiCedula());
				//Se le define el ComboBox modelo.
				cantidadLibros.setModel(cantidadLibrosModel);
				cantidadLibros.setBounds(328, 201, 47, 21);
				cantidadLibros.setOpaque(false);
				cantidadLibros.setVisible(false);
				cantidadLibros.addActionListener(this);
			}
			setVisible(true);
			this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inicializa el grupo de los RadioButton (Asegura la selección de sólo un 
	 * componente RadioButton).
	 * @return Referencia del ButtonGroup.
	 */
	private ButtonGroup getMiGrupo() {
		if (miGrupo == null) {
			miGrupo = new ButtonGroup();
		}
		return miGrupo;
	}

	/**
	 * Inicializa el botón agregar.
	 * @return Referencia del botón agregar.
	 */
	private JButton getAgregar() {
		if (agregar == null) {
			agregar = new JButton();
			agregar.setText(idioma.getTextoMensaje("Etiqueta_Texto_Boton_Agregar"));
			agregar.setBounds(227, 316, 108, 19);
			agregar.addActionListener(this);
		}
		return agregar;
	}

	/**
	 * Controlador de eventos.
	 */
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == agregar) {
			registrarProfesor ();
		}
		if (evento.getSource() == si) {
			cantidadLibros.setVisible(true);
			centinela = true;
		}
		if (evento.getSource() == cantidadLibros) {
			cantidadLibros1 = Integer.parseInt((String) cantidadLibros.getSelectedItem());

		}
		if (evento.getSource() == no) {
			cantidadLibros.setVisible(false);
			cantidadLibros1 = 0;
		}
		if (evento.getSource() == miBoton) {
			JFileChooser fc = new JFileChooser("./fotos");
			fc.setDialogTitle("Buscar foto de la Persona");
			//Limita los resultados a archivos con extensión jpg y png.
			FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg",
					"png");
			fc.setFileFilter(filter);
			fc.setMultiSelectionEnabled(false);
			
			int resultado = fc.showOpenDialog(this);
			//APPROVE_OPTION Retorna el valor si la selección se aprueba (sí ó aceptar).
			if (resultado == JFileChooser.APPROVE_OPTION) {
				//Captura la dirección de la imagen seleccionada.
				imagen = fc.getSelectedFile().getAbsolutePath();
				//Copia la dirección en el TextField de foto.
				foto.setText(imagen);
				//Muestra la foto en el label.
				miFoto.setIcon(new ImageIcon(imagen));
			}

		}
	}

	public void registrarProfesor () {
		if (pregrado.isSelected())
			pregrado1 = true;
		else
			pregrado1 = false;

		if (especializacion.isSelected())
			especializacion1 = true;
		else
			especializacion1 = false;

		if (maestria.isSelected())
			maestria1 = true;
		else
			maestria1 = false;

		if (doctorado.isSelected())
			doctorado1 = true;
		else
			doctorado1 = false;

		if (centinela == true && cantidadLibros1 == 0) {
			cantidadLibros1 = 1;
		}
		centinela = false;
		{
			//Se verifica si se pudo o no agregar el profesor.
			if (miCedula.getText().equals("") == false &&
				nombre.getText().equals("") == false &&
				apellido.getText().equals("") == false) {
			 if (!miVentanaPrincipal.getMiConcursoProfesor().agregarParticipante(miCedula.getText(),
					 nombre.getText(), apellido.getText(), imagen, pregrado1, especializacion1, maestria1,
					 doctorado1, cantidadLibros1)) {
				 JOptionPane.showMessageDialog(null, idioma.getTextoMensaje("Etiqueta_Mensaje_Existente"));
			 } else {
				 String[] a = miVentanaPrincipal.getMiConcursoProfesor().
						 generarListado(idioma.getTextoMensaje("Etiqueta_Label_Cedula"));
					for (String b: a) {
						System.out.println(b);
					}
				 miVentanaPrincipal.guardarArchivoBin();
				 miVentanaPrincipal.actualizarTabla();
			 }
			 limpiar();
			}
		}


	}
	
	private JSeparator getJSeparator1() {
		if (jSeparator1 == null) {
			jSeparator1 = new JSeparator();
			jSeparator1.setForeground(new java.awt.Color(0, 0, 64));
			jSeparator1.setBounds(2, 292, 515, 12);
		}
		return jSeparator1;
	}

	/**
	 * Inicializa el textField de la dirección de la foto.
	 * @return Referencia del TextField.
	 */
	private JTextField getFoto() {
		if (foto == null) {
			foto = new JTextField();
			foto.setText("");
			foto.setBounds(133, 129, 170, 21);
		}
		return foto;
	}

	/**
	 * Inicializa el botón Foto.
	 * @return Referencia del botón.
	 */
	private JButton getMiBoton() {
		if (miBoton == null) {
			miBoton = new JButton();
			miBoton.setText(idioma.getTextoMensaje("Etiqueta_Texto_Boton_Foto"));
			miBoton.setBounds(14, 129, 90, 21);
			miBoton.addActionListener(this);
		}
		return miBoton;
	}

	/**
	 * Inicializa el label que contiene la foto.
	 * @return Referencia del label.
	 */
	private JLabel getMiFoto() {
		if (miFoto == null) {
			miFoto = new JLabel();
			miFoto.setBounds(429, 9, 81, 121);
		}
		return miFoto;
	}
	
	/**
	 * Limpia los campos de registro.
	 */
	public void limpiar() {
		miCedula.setText("");
		cantidadLibros.setVisible(false);
		cantidadLibros1 = 0;
		no.setSelected(true);
		nombre.setText("");
		apellido.setText("");
		foto.setText("");
		pregrado.setSelected(false);
		especializacion.setSelected(false);
		maestria.setSelected(false);
		doctorado.setSelected(false);
	}

	/**
	 * Inicializa el label de Cédula (Instrucción).
	 * @return Referencia del label.
	 */
	private JLabel getCedula() {
		if (cedula == null) {
			cedula = new JLabel();
			cedula.setText(idioma.getTextoMensaje("Etiqueta_Label_Cedula"));
			cedula.setBounds(14, 47, 107, 14);
		}
		return cedula;
	}

	/**
	 * Inicializa el TextField de la cédula.
	 * @return Referencia del TextField.
	 */
	private JTextField getMiCedula() {
		if (miCedula == null) {
			miCedula = new JTextField();
			miCedula.setBounds(133, 44, 75, 21);
		}
		return miCedula;
	}
}