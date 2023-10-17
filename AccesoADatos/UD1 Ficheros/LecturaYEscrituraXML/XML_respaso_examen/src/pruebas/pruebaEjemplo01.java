package pruebas;

import java.nio.file.Path;
import java.nio.file.Paths;

import controlador.CRUDXMLPrueba02;
import modelo.xmlDAM;

public class pruebaEjemplo01 {
	
	public static void main(String[] args) {
		Path p = Paths.get("C:\\Users\\Usuario\\eclipse-workspace\\XML_respaso_examen\\src\\fichero\\ejemplo01.xml");
		CRUDXMLPrueba02 crud = new CRUDXMLPrueba02(p);
		xmlDAM dam = crud.leer();
		System.out.println(dam);
		crud.crear(dam);
	}

}
