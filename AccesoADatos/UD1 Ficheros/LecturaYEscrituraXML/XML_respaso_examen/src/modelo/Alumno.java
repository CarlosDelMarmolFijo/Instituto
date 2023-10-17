package modelo;

import java.util.ArrayList;

public class Alumno {

	private String id;
	private String nombre;
	private String curso;
	private ArrayList<Modulo> modulos;
	
	public Alumno(String id, String nombre, String curso, ArrayList<Modulo> modulos) {
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.modulos = modulos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public ArrayList<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(ArrayList<Modulo> modulos) {
		this.modulos = modulos;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", curso=" + curso + ", modulos=" + modulos + "]";
	}
	
}
