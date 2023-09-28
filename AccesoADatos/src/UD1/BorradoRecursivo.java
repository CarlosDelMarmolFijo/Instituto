package UD1;

import java.io.File;
import java.io.IOException;

public class BorradoRecursivo {

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
		
		borrar(d1); 

	}
	
	public static void borrar(File dir) {
		if (dir.isDirectory()) {
			File[] contenido = dir.listFiles();
			if (contenido != null) {
				for (File file : contenido) {
					borrar(file);
				}
			}
		}
		dir.delete();
	}

}
