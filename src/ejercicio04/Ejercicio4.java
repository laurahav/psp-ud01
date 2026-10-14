package ejercicio04;

/*
Supongamos que tenemos un programa Java que lee una cadena desde la entrada estándar y la
visualiza.
Partiendo de este programa, crea un nuevo programa (Ejercicio4) que lance el programa anterior y
le envíe datos a su entrada estándar. Para simplificarlo, haz que le envíe la cadena “Bienvenido a
PSP!!!”.
A continuación, lee de la salida estándar del proceso lanzado e imprímela por consola.
*/

import java.io.*;

public class Ejercicio4 {
    static void main(String[] args) {
        String classpath = System.getProperty("java.class.path");
        String[] comando = {"java", "-cp", classpath, "ejercicio04.EjemploLectura"};

        ProcessBuilder pb = new ProcessBuilder(comando);

        try {
            Process proceso = pb.start();
            try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(proceso.getOutputStream()))) {
                pw.println("Bienvenido a PSP!!!");
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
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
