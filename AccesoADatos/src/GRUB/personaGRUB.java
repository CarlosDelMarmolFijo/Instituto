package GRUB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class personaGRUB {
	
	private ArrayList<persona> listaPersona = new ArrayList<persona>();
	
	public void listarPersonas(String ruta) {

		File f1 = new File("listaPersonas.txt");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(f1));
			
			String i;
			String[] cadena;
			
			while((i = br.readLine()) != null) {
				cadena = i.split("/");
				try {
					listaPersona.add(new persona(cadena[0], cadena[1]));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			br.close();
			
			for (persona p1 : listaPersona) {
				System.out.println("El nombre es: " + p1.nombre + " y la edad es: " + p1.edad);
			}
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
		}
		
	}
	
	public void crearPersona(String nombre, String edad) {
		try (BufferedWriter escribir = new BufferedWriter(new FileWriter("listaPersonas.txt",true))) {
			File archivoNuevo = new File("listaPersonas.txt");
			
			if (archivoNuevo.length() != 0) {
				escribir.newLine();
			}
			
			escribir.write(nombre + "/" + edad);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void actualizarPersona(String nombre, String nuevoNombre) {
		boolean encontrado = false;
		
		for (int i = 0; i < listaPersona.size(); i++) {
			persona p = listaPersona.get(i);
			
			if (p.nombre.equals(nombre)) {
				encontrado = true;
				p.nombre = nuevoNombre;
				listaPersona.set(i, p);
				break;
			}
		}
		
		if (encontrado) {
//			actualizarFichero();
			System.out.println("El nombre " + nombre + " ha sido actualizado a " + nuevoNombre);
		} else {
			System.out.println("Usuario no encontrado");
		}
	}
	
	public void actualizarFichero() {
		try (BufferedWriter escribir = new BufferedWriter(new FileWriter("listarPersonas.txt"))) {
			for (persona persona : listaPersona) {
				escribir.write(persona.nombre + "/" + persona.edad);
				escribir.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public void borrarPersona() {
//		
//	}

}
