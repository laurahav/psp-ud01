package ejercicio05;

/*Crea un programa Java (Repetidor) que imprima 5 veces la palabra que se le envía desde los
argumentos del main(). Si no se le envía ninguna palabra, debe mostrar un mensaje (“No has
introducido ninguna palabra”), y finalizar con System.exit(1).
A continuación, crea un segundo programa (Ejercicio5) que pida por teclado una palabra y se la pase
al programa anterior como parámetro. Captura la salida estándar del proceso lanzado mediante
getInputStream() y muéstrala por consola para comprobar que to.do se ha hecho de manera correcta.
¿Qué deberíamos ver por consola?*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Ejercicio5 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String classpath = System.getProperty("java.class.path");

        System.out.println("Introduce una palabra: ");
        String palabra = sc.nextLine();
        String[] comando = {"java", "-cp", classpath, "ejercicio05.Repetidor", palabra};

        ProcessBuilder pb = new ProcessBuilder(comando);

        try{
            Process proceso = pb.start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream(), StandardCharsets.UTF_8))){
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
            }
            int exitCode = proceso.waitFor();
            System.out.println("Código de salida: " + exitCode);
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error y el programa se ha interrumpido: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }

        sc.close();
    }
}
