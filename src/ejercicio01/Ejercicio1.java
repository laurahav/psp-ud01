package ejercicio01;
/*
En este primer ejercicio, debes realizar las siguientes tareas:
a. Crea un programa en Java que imprima por pantalla el mensaje “Hola mundo”. A continuación,
genera el fichero .jar.
b. Crea un programa (Ejercicio1) que lance el ejecutable HolaMundo.jar.
c. ¿Podemos coger la salida del programa HolaMundo.jar y tratarla en el programa lanzador
(Ejercicio1) para que cuente los caracteres que contiene el mensaje?
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Ejercicio1 {
    static void main(String[] args) {
        String[] comando = {"java", "-jar", "C:/Ejecutables/HolaMundo.jar"};
        ProcessBuilder pb = new ProcessBuilder(comando);
        try {
            Process proceso = pb.start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream(), StandardCharsets.UTF_8))) {
                String linea = br.readLine();
                if (linea != null) {
                    System.out.printf("Mensaje: %s\n", linea);
                    System.out.printf("Número de caracteres: %d\n", linea.length());
                }
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
            }
            int exitCode = proceso.waitFor();
            System.out.printf("Código: %d", exitCode);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ha ocurrido un error y el programa se ha interrumpido: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}
