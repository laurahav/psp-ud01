package ejercicio03;

/*Crea un programa Java (Ejercicio3) que lance un proceso del intérprete de comandos y ejecute un
comando erróneo a propósito para provocar salida de error (por ejemplo, ejecuta cmd /c dirr).
Captura dicha salida de error mediante getErrorStream() y almacénala en un fichero de texto llamado
“errores.txt”.*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Ejercicio3 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el comando que quieres ejecutar: ");
        String[] comando =  sc.nextLine().split(" ");

        ProcessBuilder pb = new ProcessBuilder(comando);
        try {
            Process p = pb.start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                 PrintWriter pw = new PrintWriter(new FileWriter("errores.txt"))) {
                     String linea;
                     while ((linea = br.readLine()) != null) {
                         pw.println(linea);
                     }
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
            }
            int exitCode = p.waitFor();
            System.out.printf("Código de finalización: %d", exitCode);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ha ocurrido un error y el proceso se ha interrumpido: " +  e.getMessage());
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}
