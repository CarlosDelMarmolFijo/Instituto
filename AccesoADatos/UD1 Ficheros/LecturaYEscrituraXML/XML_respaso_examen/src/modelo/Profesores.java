package modelo;

import java.util.ArrayList;

public class Profesores {
	
	private int id;
	private String nombre;
	private ArrayList<Clases> clases;
	private ArrayList<Asignatura> asignaturas;
	
	public Profesores(int id, String nombre, ArrayList<Clases> clases, ArrayList<Asignatura> asignaturas) {
		this.id = id;
		this.nombre = nombre;
		this.asignaturas = asignaturas;
		this.setClases(clases);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public ArrayList<Clases> getClases() {
		return clases;
	}

	public void setClases(ArrayList<Clases> clases) {
		this.clases = clases;
	}

	@Override
	public String toString() {
		return "Profesores [id=" + id + ", nombre=" + nombre + ", clases=" + clases + ", asignaturas=" + asignaturas + "]";
	}

}
