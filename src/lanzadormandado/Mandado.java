package lanzadormandado;

import java.io.IOException;

public class Mandado {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder(args);
            Process p = pb.start();
            p.waitFor();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El hilo fue interrumpido mientras esperaba al proceso: " + e);
        } catch (IOException e) {
            System.out.println("Error al lanzar el proceso: " + e);
        }
    }

}
