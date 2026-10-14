package ejercicio04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjemploLectura {
    public static void main(String[] args) {
        String texto;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Introduce una cadena...");
            texto = br.readLine();
            System.out.println("Cadena escrita: " + texto);
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}

