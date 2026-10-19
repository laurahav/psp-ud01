package ejercicio07;

/*
Crea un programa en Java que cuente el número de vocales y de consonantes que tiene una palabra
que se le envía desde los argumentos del main(). Si no se le envía ninguna palabra, que muestre un
mensaje indicando el error y finalice el programa con System.exit(1). Este programa, al que has de
llamar Lector, tiene que imprimir por pantalla un mensaje tal y como se muestra a continuación:
Suponiendo que hemos introducido la palabra ‘caracola’:
El número de vocales es:4
El número de consonantes es:4
A continuación, crea un segundo programa en Java (Ejercicio7) que lea por teclado una palabra y
lance el programa anterior (Lector), pasándosela como argumento. Captura la salida estándar de
Lector mediante getInputStream() y muéstrala por pantalla.
Ejemplo de ejecución (palabra introducida: “examen”):
Introduce una palabra:
examen
====================
Salida del Lector
====================
El número de vocales es:3
El número de consonantes es:3
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Ejercicio7 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String classpath = System.getProperty("java.class.path");

        System.out.println("Introduce una palabra: ");
        String palabra = sc.nextLine();
        String[] comando = {"java", "-cp", classpath, "ejercicio07.Lector", palabra};

        ProcessBuilder pb = new ProcessBuilder(comando);
        System.out.println("----SALIDA DEL PROGRAMA----");
        try {
            Process proceso = pb.start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream(), StandardCharsets.UTF_8))) {
                String linea;
                while((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            }
            int exitCode = proceso.waitFor();
            System.out.printf("Código de salida: %d", exitCode);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ha ocurrido un error y el programa se ha interrumpido: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}
