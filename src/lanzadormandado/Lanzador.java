package lanzadormandado;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lanzador {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el programa / comando que quieres ejecutar: ");
        String comando = teclado.nextLine();
        String[] partesComando = comando.split("\\s+");
        try {
            // 1ª Posibilidad: cambiar el directorio de trabajo
//            List<String> comandoCompleto = new ArrayList<>();
//            comandoCompleto.add("java");
//            comandoCompleto.add("lanzadormandado.Mandado");
//            comandoCompleto.addAll(Arrays.asList(partesComando));
//            ProcessBuilder pb = new ProcessBuilder(comandoCompleto);
//            pb.directory(new File("out/production/psp-ud1")); // IntelliJ IDEA
            // 2ª Posibilidad: -cp explícito apuntando al directorio de salida
            // List<String> comandoCompleto = new ArrayList<>();
            // comandoCompleto.add("java");
            // comandoCompleto.add("-cp");
            // comandoCompleto.add("out/production/NombreDelModulo"); // IntelliJ IDEA
            // comandoCompleto.add("lanzadormandado.Mandado");
            // comandoCompleto.addAll(Arrays.asList(partesComando));
            // ProcessBuilder pb = new ProcessBuilder(comandoCompleto);
            // 3ª Posibilidad (recomendada): reutilizar el classpath del propio Lanzador
             List<String> comandoCompleto = new ArrayList<>();
             comandoCompleto.add("java");
             comandoCompleto.add("-cp");
             comandoCompleto.add(System.getProperty("java.class.path"));
             comandoCompleto.add("lanzadormandado.Mandado");
             comandoCompleto.addAll(Arrays.asList(partesComando));
             ProcessBuilder pb = new ProcessBuilder(comandoCompleto);
            // Lanzamos el proceso hijo
            Process p = pb.start();
            // Esperamos a que acabe
            p.waitFor();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El hilo fue interrumpido mientras esperaba al proceso: " + e);
        } catch (IOException e) {
            System.out.println("Error al lanzar el proceso: " + e);
        }
    }
}
