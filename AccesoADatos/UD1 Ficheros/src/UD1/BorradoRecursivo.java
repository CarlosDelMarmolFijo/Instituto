package UD1;

import java.io.File;
import java.io.IOException;

public class BorradoRecursivo {

	public static void main(String[] args) {

		// almaceno en la varible sHome el directorio padre usando "user-home"
		String sHome = System.getProperty("user.home");
		// declaro un File y a este le paso "sHome" de esta forma el fichero
		// se creara en esta ruta
		File dHome = new File(sHome); 

		// declaro un nuevo File que este caso sera para crear un directorio
		// le paso por parametros la ruta padre y el nombre de la carpeta
		File d1 = new File(dHome, "pruebaRecursiva");

		// compruebo que si el directorio "d1" no existe
		if (!d1.exists()) {
			d1.mkdir(); // me lo crea automaticamente
		}

		// en este siguiente caso uso un nuevo File pero en este caso para crear
		// un fichero pasando como parametro el directorio "d1" y el nombre del fichero
		File f1 = new File(d1, "prueba.txt");

		// compruebo que si el fichero no existe
		if (!f1.exists()) {
			try {
				f1.createNewFile(); // hacemos que este nos lo cree en la ruta por defecto
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		borrar(d1); // metodo borrar que en este caso borraria el directorio "d1"

	}

	// al metodo borrar le pasamos un "File" y un nombre descriptivo en este caso dir "para saber que es de un directorio"
	public static void borrar(File dir) {
		// determino que si "dir" es un directorio usando "isDirectory()"
		if (dir.isDirectory()) {
			// me creo un array de contenio usando File y determino que este sea igual a "dir.listFiles()"
			// esto me permite que en el array contenido este guarde todos los datos del directorio "dir"
			File[] contenido = dir.listFiles();
			// si el contenido es diferente a null "significa que no ahi datos dentro"
			if (contenido != null) {
				// recorro todo el array y almaceno los datos en un variable llamada "file"
				for (File file : contenido) {
					// finalmente le paso usando el metodo borrar el contenido de la variable
					// de esta forma nos borrara todos los ficheros y carpetas que haya dentro del directorio padre
					borrar(file); 
				}
			}
		}
		dir.delete(); // por ultimo borro el directorio padre
	}

}
