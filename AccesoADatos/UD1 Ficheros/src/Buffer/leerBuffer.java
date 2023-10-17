package Buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class leerBuffer {

		//programa que leer por ejemplo un "pdf" un fichero en byte y realiza una copia exacta

		public static void main(String[] args) {
				
			leerBuf("unidad1.pdf", "unidad1copia.pdf");

		}
			
		public static void leerBuf(String origen, String destino) {
				
			File f1 = new File(origen);
			File f2 = new File(destino);
				
			if (!f1.exists()) {
				try {
					f1.createNewFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				
			if (!f2.exists()) {
				try {
					f2.createNewFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				
			try {
				// abrimos los flujos
				FileInputStream fis = new FileInputStream(f1);
				BufferedInputStream bis = new BufferedInputStream(fis);
					
				FileOutputStream fos = new FileOutputStream(f2);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
					
				// vemos el contenido
				int i;
				byte [] buff = new byte[1024];
					
				// leemos el contenido con los byte del buffer
				while ((i = bis.read(buff,0,1024)) != -1) {
				// escribir en el nuevo fichero convertidos ya los byte
					bos.write(buff,0,i);
				}
					
				// cerramos los flujos
				bis.close();
				fis.close();
				bos.close();

			} catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
			}
				
		}

}
