package ejemplo02;

import java.io.IOException;

public class Ejemplo02 {
    static void main(String[] args) {
        String homeDirectory = System.getProperty("user.home");
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        String[] comando = {"cmd", "/c", "start", "dir", homeDirectory};
        try {
            if (isWindows)
                Runtime.getRuntime().exec(comando);
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error, descripción: " + ex.toString());
        }
    }
}
