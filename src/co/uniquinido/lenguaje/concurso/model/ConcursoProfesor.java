package co.uniquinido.lenguaje.concurso.model;

import java.util.ArrayList;

import co.uniquindio.lenguaje.concurso.persistencia.Persistencia;

import java.io.IOException;
import java.io.Serializable;

public class ConcursoProfesor implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Profesor> miProfesor;

	/**
	 * Este es el m�todo constructor post: Se creo un nuevo concurso
	 */
	public ConcursoProfesor() {
		miProfesor = new ArrayList<Profesor>();
	}

	/**
	 * Permite agregar un nuevo Profesor post: El participante fue agregado
	 * 
	 * @param                 cedula. Es la cedula del profesor. cedula!=null y
	 *                        cedula!=""
	 * @param nombre          Es el nombre del profesor. nombre!=null y nombre!=""
	 * @param apellido        Es el apellido del profesor. apellido!=null y
	 *                        apellido!=""
	 * @param foto            Es la ruta de la foto. foto!=null y foto!=""
	 * @param pregrado        Indica si tiene pregrado.pregrado==true
	 * @param especializacion Indica si tiene especializacion
	 * @param maestria        Indica si tiene maestria
	 * @param doctorado       Indica si tiene doctorado
	 * @param cantidadLibros  Indica la cantidad de libros. cantidadLibros>=0
	 * @return
	 */
	public boolean agregarParticipante(String cedula, String nombre, String apellido, String foto, boolean pregrado,
			boolean especializacion, boolean maestria, boolean doctorado, int cantidadLibros) {
		boolean esta = false;
		if (miProfesor.size() > 0)
			esta = determinarSiExisteProfesor(cedula);

		if (esta == false) {
			Profesor miProfe = new Profesor(cedula, nombre, apellido, foto, pregrado, especializacion, maestria,
					doctorado, cantidadLibros);
			miProfe.fijarPuntos();
			miProfesor.add(miProfe);
			return true;
		}
		return false;
	}

	/**
	 * Permite verificar si un profesor existe en el listado
	 * 
	 * @param cedula Es la cedula del profesor
	 * @return booleano que indica si existe o no
	 */
	public boolean determinarSiExisteProfesor(String cedula) {
		for (int i = 0; i < miProfesor.size(); i++) {
			if (miProfesor.get(i).getCedula().equals(cedula)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Permite determinar si no hay profesores repetidos
	 * 
	 * @return booleano que indica si existe o no
	 */
	public boolean determinarSiNoHayRepeticiones() {
		for (int i = 1; i < miProfesor.size(); i++) {
			for (int j = 0; j < i; j++)
				if (miProfesor.get(i).getCedula().equals(miProfesor.get(j).getCedula()))
					return true;

		}
		return false;
	}

	/**
	 * Permite generar el listado de docentes por puntaje
	 * 
	 * @return un array de string con la informacion de los docentes
	 */
	public String[] generarListadoPorPuntaje() {
		String info[] = new String[miProfesor.size()];

		for (int i = 0; i < miProfesor.size(); i++) {
			for (int j = 0; j < miProfesor.size() - 1; j++) {
				if (miProfesor.get(j).getPuntos() > miProfesor.get(j + 1).getPuntos()) {
					Profesor miProfe = this.miProfesor.get(j);
					miProfesor.set(j, miProfesor.get(j + 1));
					miProfesor.set(j + 1, miProfe);

				}
			}
		}
		for (int i = 0; i < miProfesor.size(); i++) {
			info[i] = miProfesor.get(i).getNombre() + " " + miProfesor.get(i).getApellido() + " Cedula:"
					+ miProfesor.get(i).getCedula();

		}

		return info;
	}

	/**
	 * Permite generar el listado de los docentes
	 * @return un array de String
	 */
	public String[] generarListado() {
		String info[] = new String[miProfesor.size()];
		for (int i = 0; i < miProfesor.size(); i++) {
			info[i] = miProfesor.get(i).getNombre() + "  " + miProfesor.get(i).getApellido() + " Cedula:"
					+ miProfesor.get(i).getCedula();
		}
		return info;
	}

	/**
	 * Devuelve el array de docentes
	 * 
	 * @return un array list
	 */
	public ArrayList<Profesor> getMiProfesor() {
		return miProfesor;
	}
	
	/**
	 * 
	 * @param miProfesor
	 */
	public void setMiProfesor (ArrayList<Profesor> miProfesor) {
		this.miProfesor = miProfesor;
	}

	/**
	 * Permite generar el listado ordenado por nombre
	 * 
	 * @return un array con la informacion de los docentes
	 */
	public String[] generarListadoOrdenadoPorNombre() {
		String info[] = new String[miProfesor.size()];

		for (int i = 0; i < miProfesor.size(); i++) {
			for (int j = 0; j < miProfesor.size() - 1; j++) {
				if (miProfesor.get(j).getNombre().concat(miProfesor.get(j).getApellido())
						.compareTo(miProfesor.get(j + 1).getNombre().concat(miProfesor.get(j + 1).getApellido())) > 0) {
					Profesor miProfe = this.miProfesor.get(j);
					miProfesor.set(j, miProfesor.get(j + 1));
					miProfesor.set(j + 1, miProfe);

				}

			}
		}
		for (int i = 0; i < miProfesor.size(); i++) {
			info[i] = miProfesor.get(i).getNombre() + " " + miProfesor.get(i).getApellido() + " Cedula:"
					+ miProfesor.get(i).getCedula();
		}
		return info;
	}
	
	public ConcursoProfesor cargarArchivoBin (String ruta)
			throws IOException, ClassNotFoundException {
		ConcursoProfesor miConcurso = (ConcursoProfesor) 
				Persistencia.deserializar (ruta);
		return miConcurso;
	}
	
	public void guardarArchivoBin (String ruta)
			throws IOException, ClassNotFoundException {
		Persistencia.serializar(ruta, this);
	}
}
