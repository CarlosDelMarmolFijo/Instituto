package GRUB;

public class prueba {

	public static void main(String[] args) {
		
		personaGRUB lista = new personaGRUB();

//		lista.crearPersona("Carlos", "23");
//		lista.crearPersona("Jose", "25");
		
//		lista.listarPersonas("listaPersonas.txt");
		
		lista.actualizarPersona("Carlos", "Manolo");
		lista.listarPersonas("listaPersonas.txt");
		
	}

}
