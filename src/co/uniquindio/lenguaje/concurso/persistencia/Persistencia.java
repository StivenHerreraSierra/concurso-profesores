/**
 * Clase encargada del manejo de archivos.
 */
package co.uniquindio.lenguaje.concurso.persistencia;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Stiven Herrera Sierra.
 */
public class Persistencia {
	/**
	 * 
	 * @param ruta
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deserializar (String ruta)
			throws IOException, ClassNotFoundException {
		FileInputStream lector = new FileInputStream(ruta);
		ObjectInputStream lectorObjeto = new ObjectInputStream(lector);
		Object objeto = lectorObjeto.readObject();
		lector.close();
		lectorObjeto.close();
		return objeto;
	}
	
	/**
	 * 
	 * @param ruta
	 * @param objeto
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void serializar (String ruta, Object objeto)
			throws IOException, ClassNotFoundException {
		FileOutputStream escritor = new FileOutputStream(ruta);
		ObjectOutputStream escritorObjeto = new ObjectOutputStream (escritor);
		escritorObjeto.writeObject(objeto);
		escritor.close();
		escritorObjeto.close();
	}
	
	/**
	 * 
	 * @param ruta
	 * @param objeto
	 * @throws IOException
	 */
	public static void serializarXML (String ruta, Object objeto)
			throws IOException {
		XMLEncoder escritorXML = new XMLEncoder (new FileOutputStream (ruta));
		escritorXML.writeObject(objeto);
		escritorXML.close();
	}
	
	/**
	 * 
	 * @param ruta
	 * @return
	 * @throws IOException
	 */
	public static Object deserializarXML (String ruta) throws IOException {
		XMLDecoder lectorXML = new XMLDecoder (new FileInputStream(ruta));
		Object objeto = lectorXML.readObject();
		lectorXML.close();
		return objeto;
	}
}
