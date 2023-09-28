package UD1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LeerEscribir {
	
	public static void main(String[] args) {
		
		// declaro el metodo y les paso los ficheros origen y destino y este lo duplicara
		duplicar("ficheroOrigen.txt", "ficheroDestino.txt");
		duplicarDos("ficheroOrigen.txt", "ficheroDestino.txt");
		
	}
	
	public static void duplicar(String ficheroUno, String ficheroDos) {
		// me declaro dos fichos uno para el fichero origen y otro para el destino
		File f1 = new File("ficheroOrigen.txt");
		File f2 = new File("ficheroDestino.txt");
		
		// determino si los ficheros existen y sino me los crea
		if (!f1.exists()) {
			try {
				f1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (!f2.exists()) {
			try {
				f2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// usando el metodo "fileReader" determinamos que sea el f1 
		// de esta forma aremos que lea el fichero 1 "f1"
		try (FileReader fr = new FileReader(f1);
				// de igual forma usamos el metodo "FileWriter"
			 FileWriter fw = new FileWriter(f2)) {
			
			// declaro la varible tipo int ya que vamos a trabajar con numeros
			// que despues pasaremos a "char"
			int i; 
			// uso el bucle while para determinar que en la variable "i"
			// se añada lo que se valla leyendo en el "f1" si esto es diferente a -1
			while ((i=fr.read()) != -1) {
				fw.write((char)i); // escribo en el "f2" caracter a caracter (char)
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
		}
		
	}
	
	// en este caso el metodo "duplicarDos" nos va recoger por parametro el primer ficho y el segundo
	public static void duplicarDos(String ficheroUno, String ficheroDos) {
		File f1 = new File("ficheroOrigen.txt");
		File f2 = new File("ficheroDestino.txt");
		
		// determino si los ficheros existen y sino me los crea
		if (!f1.exists()) {
			try {
				f1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (!f2.exists()) {
			try {
				f2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// usando BufferedReader le pasamos el fichero "f1" que en este caso
		// el el fichero que vamos a leer
		try (BufferedReader fr = new BufferedReader(new FileReader(f1));
				// uso tambien el metodo BufferedWriter con el fichero "f2" que en este caso
				// es donde vamos a escribir
			 BufferedWriter fw = new BufferedWriter(new FileWriter(f2))) {
				
			// para este segundo caso vamos a declarar "i" coomo string ya que trabajamos con letras
			String i; 
			// uso el bucle while para determinar que en la variable "i"
			// se añada lo que se valla leyendo en el "f1" en este caso mientras no se diferente a null
			while ((i=fr.readLine()) != null) {
				fw.write(i); // escribimos en "f2" el valor de "i"
				fw.newLine(); // y realizamos un salto de linea
			}
				
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
		}
		
	}

}