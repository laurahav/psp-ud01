package ejemplo04;

import java.io.IOException;
import java.util.Scanner;


public class Ejemplo04 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Selecciona tu opción (s-shutdown | r-reboot | h-hibernate): ");
        String opcion = entrada.nextLine().trim().toLowerCase();
        ProcessBuilder shutdowner = null;
        boolean esWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        if (esWindows) {
            if (opcion.equals("s") || opcion.equals("r") || opcion.equals("h")) {
                shutdowner = new ProcessBuilder("shutdown", "/" + opcion);
            } else {
                System.out.println("Opción no reconocida.");
            }
        } else {
            if (opcion.equals("s")) {
                shutdowner = new ProcessBuilder("shutdown", "-h", "now");
            } else if (opcion.equals("r")) {
                shutdowner = new ProcessBuilder("shutdown", "-r", "now");
            } else if (opcion.equals("h")) {
                System.out.println("La opción 'hibernar' no tiene un comando estándar en Linux/macOS (depende de la distribución; en sistemas con systemd seria, por ejemplo, systemctl hibernate).");
            } else {
                System.out.println("Opción no reconocida.");
            }
        }
        if (shutdowner != null) {
            System.out.print("El comando a ejecutar es: ");
            for (String commandPart : shutdowner.command()) {
                System.out.print(commandPart + " ");
            }
            System.out.println();
            try {
                shutdowner.start();
            } catch (IOException ex) {
                System.out.println("ERROR:" + ex.getMessage());
            }
        }
    }
}

