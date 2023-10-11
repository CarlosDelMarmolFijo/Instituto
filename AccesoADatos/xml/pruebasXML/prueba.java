package pruebasXML;

import java.nio.file.Path;
import java.nio.file.Paths;

public class prueba {

	public static void main(String[] args) {
		
		Path path = Paths.get("D:\\TrabajosEclipse\\UD1.FILE\\xml\\pruebasXML\\ejemplo.xml");
		
		padre padre = utilidades.leerXML(path);
		System.out.println(padre);

		utilidades.crearXML(padre, "D:\\TrabajosEclipse\\UD1.FILE\\xml\\pruebasXML\\ejemplo2.xml");
	}

}
