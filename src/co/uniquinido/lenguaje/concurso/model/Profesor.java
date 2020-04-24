package co.uniquinido.lenguaje.concurso.model;

import java.io.Serializable;

public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cedula, nombre, apellido, foto;
	private boolean pregrado, especializacion, maestria, doctorado;
	private int cantidadLibros, puntos;

	public Profesor () {
		setNombre("Nn");
	}
	
	/**
	 * Este es el m�todo constructor post: Se creo un profesor
	 * 
	 * @param cedula          Es la cedula de docente. cedula !=null cedula!=""
	 * @param nombre          Es el nombre del docente. nombre !=null nombre!=""
	 * @param apellido        Es el apellido del docente. apellido !=null
	 *                        apellido!=""
	 * @param foto            Es la ruta de la foto del docente. ruta !=null
	 *                        ruta!=""
	 * @param pregrado        Indica si el docente tiene pregrado . pregrado == true
	 * @param especializacion Indica si el docente maestria.
	 * @param doctorado       Indica si el docente tiene doctorado .
	 * @param cantidadLibros  Indica la cantidad de libros que tiene el docente.
	 *                        cantidaLibros>=0
	 */
	public Profesor(String cedula, String nombre, String apellido, String foto, boolean pregrado,
			boolean especializacion, boolean maestria, boolean doctorado, int cantidadLibros) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.foto = foto;
		this.pregrado = pregrado;
		this.especializacion = especializacion;
		this.maestria = maestria;
		this.doctorado = doctorado;
		this.cantidadLibros = cantidadLibros;
	}

	/**
	 * Metodo accesor
	 * 
	 * @return el nombre del docente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo modificador
	 * 
	 * @param nombre Es el nombre del docente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo accesor
	 * 
	 * @return el apellido del docente
	 */
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Metodo accesor
	 * 
	 * @return la ruta de la foto del docente
	 */
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * Metodo accesor
	 * 
	 * @return indica si tiene pregrado
	 */
	public boolean isPregrado() {
		return pregrado;
	}

	public void setPregrado(boolean pregrado) {
		this.pregrado = pregrado;
	}

	/**
	 * Metodo accesor
	 * 
	 * @return indica si tiene especializacion
	 */
	public boolean isEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(boolean especializacion) {
		this.especializacion = especializacion;
	}

	/**
	 * Metodo accesor
	 * 
	 * @return indica si tiene maestria
	 */
	public boolean isMaestria() {
		return maestria;
	}

	public void setMaestria(boolean maestria) {
		this.maestria = maestria;
	}

	/**
	 * Metodo accesor
	 * 
	 * @return indica si tiene doctorado
	 */
	public boolean isDoctorado() {
		return doctorado;
	}

	/**
	 * Metodo modificador
	 * 
	 * @param doctorado Indica si el docente tiene doctorado
	 */
	public void setDoctorado(boolean doctorado) {
		this.doctorado = doctorado;
	}

	/**
	 * Metodo accesor
	 * 
	 * @return indica la cantidad de libros
	 */
	public int getCantidadLibros() {
		return cantidadLibros;
	}

	/**
	 * Permite fijar la cantidad de libros
	 * 
	 * @param cantidadLibros Cantidad de libros del docente
	 */
	public void setCantidadLibros(int cantidadLibros) {
		this.cantidadLibros = cantidadLibros;
	}

	/**
	 * Permite fijar la cantidad de puntos
	 */
	public void fijarPuntos() {
		puntos = 178;

		if (especializacion == true)
			puntos += 30;

		if (maestria == true && especializacion == false)
			puntos += 120;

		if (maestria == true && especializacion == true)
			puntos += 60;

		if (doctorado == true) {
			if (especializacion == false && maestria == false)
				puntos += 170;
			else
				puntos += 80;
		}

		puntos += (cantidadLibros * 15);

	}

	/**
	 * Metodo accesor
	 * 
	 * @return indica la cantidad de puntos
	 */
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getCedula() {
		return cedula;
	}

	/**
	 * Permite fijar la cedula
	 * 
	 * @param cedula Es la cedula del docente
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;

	}
}
