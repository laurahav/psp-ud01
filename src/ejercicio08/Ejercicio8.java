package ejercicio08;

/*
Queremos obtener el listado de los archivos de una carpeta que el usuario introduce por teclado.
Para ello, implementa un programa en Java que realice las siguientes tareas:
• Pide al usuario que introduzca una ruta.
• Lanza un proceso que muestre el listado de los archivos en una ventana real y visible del
intérprete de comandos. Ten en cuenta que un proceso lanzado directamente desde Java no
tiene consola propia — necesitarás apoyarte en el comando start para conseguir que se abra
una ventana visible.
• Lanza otro proceso que ejecute el mismo comando, pero en este caso, utilizando
redirectOutput() de ProcessBuilder, escribiendo el listado en un fichero llamado
“ListadoCarpeta.txt”.
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Ejercicio8 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una ruta: ");
        String path = sc.nextLine();

        String[] comandoVentana = {"cmd", "/c", "start", "cmd", "/k", "dir" , path};
        ProcessBuilder pbVentana = new ProcessBuilder(comandoVentana);

        String[] comandoArchivo = {"cmd", "/c", "dir" , path};
        ProcessBuilder pbArchivo = new ProcessBuilder(comandoArchivo);

        File archivo = new File("src/ejercicio08/ListadoCarpeta.txt");
        pbArchivo.redirectOutput(archivo);

        try {
            Process procesoVentana = pbVentana.start();
            Process procesoArchivo = pbArchivo.start();

            int exitCodeVentana = procesoVentana.waitFor();
            int exitCodeArchivo = procesoArchivo.waitFor();

            System.out.println("Código de salida del primer proceso: " + exitCodeVentana);
            System.out.println("Código de salida del segundo proceso: " + exitCodeArchivo);
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un problema y el programa se ha detenido: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }

        sc.close();
    }
}
