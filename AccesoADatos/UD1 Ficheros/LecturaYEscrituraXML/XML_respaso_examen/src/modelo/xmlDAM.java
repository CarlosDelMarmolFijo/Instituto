package modelo;

import java.util.ArrayList;

public class xmlDAM {
	
	private String introduccion;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesores> profesores;

	public xmlDAM(String introduccion, ArrayList<Alumno> alumnos, ArrayList<Profesores> profesores) {
		this.setintroduccion(introduccion);
		this.alumnos = alumnos;
		this.setProfesores(profesores);
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public String getintroduccion() {
		return introduccion;
	}

	public void setintroduccion(String introduccion) {
		this.introduccion = introduccion;
	}

	public ArrayList<Profesores> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesores> profesores) {
		this.profesores = profesores;
	}

	@Override
	public String toString() {
		return "xmlDAM [introduccion=" + introduccion + ", alumnos=" + alumnos + ", profesores=" + profesores + "]";
	}

}
