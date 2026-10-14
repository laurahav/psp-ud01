package ejercicio02;

/*Crea un programa Java llamado LeerNombre que reciba desde los argumentos de main() un nombre
y lo muestre por pantalla. Utiliza System.exit(0) para una finalización correcta del programa y
System.exit(1) para el caso en que no se haya introducido ningún argumento.
A continuación, haz un programa (Ejercicio2) que lance LeerNombre (LeerNombre.class) utilizando
su classpath. Captura y muestra por pantalla la salida estándar del proceso lanzado (mediante
getInputStream()), y utiliza el metodo waitFor() para comprobar su valor de salida. Prueba la
ejecución pasando un argumento a LeerNombre y también sin pasárselo. ¿Qué valor devuelve
waitFor() en cada caso?
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Ejercicio2 {
    static void main(String[] args) {
        String classpath = System.getProperty("java.class.path");
        String[] comandoConNombre = {"java", "-cp", classpath, "ejercicio02.LeerNombre", "Laura"};
        String[] comandoSinNombre = {"java", "-cp", classpath, "ejercicio02.LeerNombre"};

        // CON NOMBRE
        ProcessBuilder pb = new ProcessBuilder(comandoConNombre);
        try {
            Process proceso = pb.start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream(), StandardCharsets.UTF_8))) {
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

        // SIN NOMBRE
        ProcessBuilder pbSin = new ProcessBuilder(comandoSinNombre);
        try {
            Process proceso = pbSin.start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream(), StandardCharsets.UTF_8))) {
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
    }
}
