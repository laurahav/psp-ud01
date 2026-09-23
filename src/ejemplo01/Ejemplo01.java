package ejemplo01;

import java.io.IOException;

public class Ejemplo01 {
    public static void main(String[] Args){
        // String[] cmdArray = {"notepad.exe", "Ejemplo.txt"};
        String[] cmdArray = {"cmd", "/c", "notepad.exe", "Ejemplo1.txt"};
        Process proceso;
        try {
            proceso = Runtime.getRuntime().exec(cmdArray);
        } catch (IOException ex) {
            System.out.printf("ERROR:%s", ex.getMessage());
        }
    }
}
