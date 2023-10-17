package vista;

import java.util.ArrayList;

import modelo.personas;

public class vistaAlumno {
	
	public void verContenido(ArrayList<personas> personas, String cabecera) {
		System.out.println(cabecera);
		
		for (personas listaPersonas : personas) {
			System.out.println(listaPersonas.getNombre() + "--" +listaPersonas.getEdad());
		}
	}

}
