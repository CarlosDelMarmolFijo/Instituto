package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class personasCRUD {
	
	private String cabecera;
	private ArrayList<personas> personas;
	private static String rutaOrigen = "D:\\TrabajosEclipse\\UD1.FILE\\VistaControlador\\modelo\\alumnos.txt";
	
	public personasCRUD() {
		personas = new ArrayList<personas>();
	}

	public void seleccionarTodo() {
		File archivo = new File(rutaOrigen);
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)))) {
			String linea;
			this.setCabecera(br.readLine());
			
			while (br.ready()) {
				linea = br.readLine();
				String[] contenido = linea.split("-");
				personas.add(new personas(contenido[0],Integer.parseInt(contenido[1])));
			}
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
		} 
	}

	public void añadirPersona(String nombre, int edad) {
		try (BufferedWriter escribir = new BufferedWriter(new FileWriter(rutaOrigen,true))) {
			escribir.newLine();
			escribir.write(nombre + "-" + edad);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getCabecera() {
		return cabecera;
	}

	public void setCabecera(String cabecera) {
		this.cabecera = cabecera;
	}

	public ArrayList<personas> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<personas> personas) {
		this.personas = personas;
	}
	
}
