package modelo;

public class Modulo {

	private String id;
	private String nombre;
	private String nota;
	
	public Modulo(String id, String nombre, String nota) {
		this.id = id;
		this.nombre = nombre;
		this.nota = nota;
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

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Modulo [id=" + id + ", nombre=" + nombre + ", nota=" + nota + "]";
	}
	
}
