package GRUB;

public class persona {

	// parametros de la clase persona
	String nombre;
	String edad;

	// contructor de la clase persona
	public persona(String nombre, String edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	// metodos get/set de la clase
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

}
