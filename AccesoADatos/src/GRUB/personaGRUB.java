package GRUB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// en este fichero se encuentran los cuatro metodos del CRUD (listar, borrar, actializar, añadir)
public class personaGRUB {

	// clase ArrayList donde vamos a ir almacenando el contenido de las personas
	private ArrayList<persona> listaPersona = new ArrayList<persona>();

	// a este metodo le pasaremos la ruta del fichero
	public void listarPersonas(String ruta) {

		// me declaro un metodo "File" el cual determino que sea un fichero .txt en este caso
		File f1 = new File("listaPersonas.txt");
		
		try {
			// declaramos un BufferedReader al cual le diremos que sea igual a un BufferedReader que contiene
			// un nuevo FileReader el cual seria "f1" esto significa que que vamos a leer un nuevo fichero f1
			// pero a su vez usando "bufferedReader"
			BufferedReader br = new BufferedReader(new FileReader(f1));
			
			String i; // declaro una variable "string" donde vamos a almacenar los datos de los ficheros
			String[] cadena; // declaro un tring que sera un array que sera una cadena en este caso

			// usando un bucle determino que me valla almacenando en la variable "i" todos los datos de "br"
			// leyendolo linea por linea este se ira repitiendo mientras no sea igual a null
			while((i = br.readLine()) != null) {
			      // almaceno en cadena el valor de "i" al cual con el metodo "split" determino que me quite
			      // en este caso el caracter "/"
			      cadena = i.split("/"); 
			      try {
			          // una ves se cumple el bucle en el arrayList determino que añada una nueva persona
			          // en la posicion [0] almaceno el "nombre" y en la posicion [1] la "edad"
		   	          listaPersona.add(new persona(cadena[0], cadena[1]));
			      } catch (Exception e) {
				  e.printStackTrace();
			      }
			}
			
			br.close(); // cerramos el buffer

			for (persona p1 : listaPersona) {
			     // pinto por pantalla cada uno de los nombres y la edad que tiene las personas almacenadas
			     // en el arrayList
			     System.out.println("El nombre es: " + p1.nombre + " y la edad es: " + p1.edad);
			}
		} catch (IOException e) {
		    e.printStackTrace();
		    e.getMessage();
		}
		
	}

	// para el metodo "crearPersona" le paso un nombre y una edad de tipo "String"
	public void crearPersona(String nombre, String edad) {
		// declaro un "BufferedWriter" ya que vamos a escribir en el fichero el cual se lo pasamos como parametro
		// y determino tambien la condicion "true" el cual nos permite que cada vez que vallamos a escribir en el
		// este nos borrara el fichero y lo creara nuevamente
		try (BufferedWriter escribir = new BufferedWriter(new FileWriter("listaPersonas.txt",true))) {
			// me creo con File un fichero nuevo pasandole la ruta del fichero actual
			File archivoNuevo = new File("listaPersonas.txt");

			// compruebo que si en el fichero no quedan mas filas o no ahí
			if (archivoNuevo.length() != 0) {
			    escribir.newLine(); // en ese caso en el fichero le añadimos una nueva linea
			}

			// y escribimos en el fichero el nombre y la edad con el separador "/"
			escribir.write(nombre + "/" + edad);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// para el metodo "actualizarPersona" le voy a pasar tres parametros -> "NombreArchivo, nombreAReemplazar, nombreDeReemplazo"
	public void actualizarPersona(String archivo, String nombreBuscado, String nombreReemplazo) {
		try {
		     // me creo con File un fichero de entra que sera el fichero original
		     File archivoEntrada = new File(archivo);
		     File archivoTemporal = new File("temp.txt"); // a su vez me creo tambien un fichero auxiliar
		     // con el BufferedReader le dicimos que este sea igual a un new FileReader al cual le pasaremos el archivoEntrada
		     // de esta forma podremos leer el contenido del fichero
		     BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
		     // determino tambien un BufferedWriter al cual en este caso le pasaremos el archivo temporal donde vamos a realizar el cambio
		     BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal));
				
		     String linea;
		     // esta varible tipo "boolean" nos servira para de esta forma seguidamente determinar si nos encontramos en la primera 
		     // linea del fichero o no antes de realizar un salto de linea y evitar espacios en blanco antes de la primera linea escrita
		     boolean primeraLinea = true; 

		     // en el bucle while lo realizamos mientras en el fichero tengamos datos que leer y estos datos se iran almacenando en la
		     // variable "linea"
		     while ((linea = br.readLine()) != null) {
			if (primeraLinea) { // si la condicion de primeraLinea se cumple 
			    primeraLinea = false; // pasamos la condicion a false
			} else {
			    bw.newLine(); // sino escribimos un espacio en blanco
			}
			// determino que "linea" es igual a la varible linea que usando el metodo "raplaceAll" le pasamos como parametro
			// el nombreBuscado en el fichero y por cual lo queremos reemplazar
			linea = linea.replaceAll(nombreBuscado, nombreReemplazo);
			bw.write(linea); // finalmente escribimos el nombre en el fichero
		     }
				
		     br.close(); // cerramos el BufferedReader
		     bw.close(); // cerramos el BufferedWriter
				
		     archivoEntrada.delete(); // ahora primero eliminamos el archivo original
		     // y determino que el archivoTemporal se renombre como el archivo original dado que en este fichero ahora es donde
		     // se encuentra el nombre cambiado
		     archivoTemporal.renameTo(archivoEntrada); 
		
		     System.out.println("Reemplazo completado"); 
		} catch (IOException e) {
		     e.printStackTrace();
		     e.getMessage();
		}
	}
	
	public void borrarPersona(String archivo, String nombreABorrar) {
		try {
		   // me creo con File un fichero de entra que sera el fichero original
		   File archivoEntrada = new File(archivo);
		   File archivoTemporal = new File("temp.txt"); // a su vez me creo tambien un fichero auxiliar
		   // con el BufferedReader le dicimos que este sea igual a un new FileReader al cual le pasaremos el archivoEntrada
		   // de esta forma podremos leer el contenido del fichero
		   BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
		   // determino tambien un BufferedWriter al cual en este caso le pasaremos el archivo temporal donde vamos a realizar el cambio
		   BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal));
				
		   String linea;

		   // en el bucle while lo realizamos mientras en el fichero tengamos datos que leer y estos datos se iran almacenando en la
		   // variable "linea"
		   while ((linea = br.readLine()) != null) {
			// si la varible linea no contiene el nombre a buscar
			if (!linea.contains(nombreABorrar)) {
			    bw.write(linea); // escribimos en el fichero el nombre que si esta en la varible linea
			}
		   }
				
		   br.close(); // cerramos el BufferedReader
		   bw.close(); // cerramos el BufferedWriter
				
	           archivoEntrada.delete(); // ahora primero eliminamos el archivo original
		   // y determino que el archivoTemporal se renombre como el archivo original dado que en este fichero ahora es donde
		   // se encuentra el nombre cambiado
	           archivoTemporal.renameTo(archivoEntrada);
				
		   System.out.println("Elinacion completada");
		} catch (IOException e) {
		   e.printStackTrace();
		   e.getMessage();
		}
	}

}
