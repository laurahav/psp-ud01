package ejemplo05;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ejemplo05 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("charmap.exe");
        try {
            Process p = pb.start();
            System.out.println("El proceso está en ejecución? " + p.isAlive());
            boolean finished = p.waitFor(10, TimeUnit.SECONDS);
            if (finished) {
                System.out.println("El proceso ha terminado antes de los 10 segundos.");
            } else {
                System.out.println("Se agotó el tiempo. El proceso no ha terminado. Intentando finalizar...");
                p.destroy();
                if (!p.waitFor(3, TimeUnit.SECONDS)) {
                    System.out.println("Forzando la terminación...");
                    p.destroyForcibly();
                    p.waitFor();
                }
            }
            System.out.println("El proceso está en ejecución? " + p.isAlive());
            int status = p.exitValue();
            System.out.println("Código de finalización devuelto: " + status);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El hilo fue interrumpido mientras esperaba al proceso.");
        } catch (IOException e) {
            System.out.println("Error al lanzar el proceso: " + e);
        }
    }
}