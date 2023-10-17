package UD1;

import java.io.File;
import java.io.IOException;

public class ListadoRecursivo {

	public static void main(String[] args) {
		
		String sHome = System.getProperty("user.home");
		File dHome = new File(sHome);
		
		File d1 = new File(dHome, "pruebaRecursiva");
		
		if (!d1.exists()) {
			d1.mkdir();
		}
		
		File f1 = new File(d1, "prueba.txt");
		
		if (!f1.exists()) {
			try {
				f1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		listar(d1);

	}
	
	public static void listar(File dir) {
		File[] archivos = dir.listFiles();
		
		if (archivos != null) {
			System.out.println("Directorio " + dir.getName());
			for (File archivo : archivos) {
				if (archivo.isFile()) {
					System.out.println(" Archivo en " + dir + ": " + archivo.getName());
				} else if (archivo.isDirectory()) {
					System.out.println(" Subdirectorio en : " + dir + ": " + archivo.getName());
					listar(archivo);
				}
			}
		}
	}

}
