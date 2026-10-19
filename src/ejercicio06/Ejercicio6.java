package ejercicio06;

/*
Partiendo del ejercicio anterior, realiza los cambios necesarios para que la salida del proceso
Repetidor (capturada mediante getInputStream()) se almacene en un fichero de texto llamado
“salida.txt”, en lugar de mostrarse por pantalla.
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Ejercicio6 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String classpath = System.getProperty("java.class.path");

        System.out.println("Introduce una palabra: ");
        String palabra = sc.nextLine();
        String[] comando = {"java", "-cp", classpath, "ejercicio05.Repetidor", palabra};

        ProcessBuilder pb = new ProcessBuilder(comando);

        try{
            Process proceso = pb.start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream(), StandardCharsets.UTF_8));
                PrintWriter pw = new PrintWriter(new FileWriter("src/ejercicio06/salida.txt", StandardCharsets.UTF_8))){
                String linea;
                while ((linea = br.readLine()) != null) {
                    pw.println(linea);
                }
            }
            int exitCode = proceso.waitFor();
            System.out.println("Código de salida: " + exitCode);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ha ocurrido un error y el programa se ha interrumpido: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
        sc.close();
    }
}

