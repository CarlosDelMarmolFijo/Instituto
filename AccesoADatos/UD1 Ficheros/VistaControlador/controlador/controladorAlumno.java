package controlador;

import modelo.personasCRUD;
import vista.vistaAlumno;

public class controladorAlumno {
	
	personasCRUD aCrud;
	vistaAlumno vAlumno;
	
	public controladorAlumno() {
		this.aCrud = new personasCRUD();
		this.vAlumno = new vistaAlumno();
	}
	
	public void mostrarAlumnos() {
		aCrud.seleccionarTodo();
		vAlumno.verContenido(aCrud.getPersonas(), aCrud.getCabecera());
	}

	public void añadir() {
		aCrud.añadirPersona("manolo", 23);
	}

}
