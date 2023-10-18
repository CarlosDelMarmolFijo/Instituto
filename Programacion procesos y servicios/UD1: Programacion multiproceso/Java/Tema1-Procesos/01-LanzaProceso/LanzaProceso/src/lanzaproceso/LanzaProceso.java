package lanzaproceso;

import java.util.Arrays;
import java.io.IOException;

public class LanzaProceso {

  public static void main(String[] args) {

    String si = "ipconfig";
	 
    if (si.length() <= 0) {
      System.out.println("Debe indicarse comando a ejecutar.");
      System.exit(1);
    }

    ProcessBuilder pb = new ProcessBuilder(si);
    pb.inheritIO();

    try {
      Process p = pb.start();
      int codRet = p.waitFor();
      System.out.println("La ejecución de " + Arrays.toString(args)
              + " devuelve " + codRet
              + " " + (codRet == 0 ? "(ejecución correcta)" : "(ERROR)")
      );
    } catch (IOException e) {
      System.err.println("Error durante ejecución del proceso");
      System.err.println("Información detallada");
      System.err.println("---------------------");
      System.err.println("---------------------");
      System.exit(2);
    } catch (InterruptedException e) {
      System.err.println("Proceso interrumpido");
      System.exit(3);
    }

  }

}
