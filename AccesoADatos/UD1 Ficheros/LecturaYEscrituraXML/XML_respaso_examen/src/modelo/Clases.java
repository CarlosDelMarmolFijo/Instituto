package modelo;

public class Clases {
	
	private int id;
	private String nombre;
	private String planta;
	
	public Clases(int id, String nombre, String planta) {
		this.id = id;
		this.nombre = nombre;
		this.planta = planta;
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

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	@Override
	public String toString() {
		return "Clases [id=" + id + ", nombre=" + nombre + ", planta=" + planta + "]";
	}

}
