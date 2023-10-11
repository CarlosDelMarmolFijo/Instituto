package pruebasXML;

public class hijo {

	private String nombre;
	private int id;
	
	public hijo(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Hijo [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
