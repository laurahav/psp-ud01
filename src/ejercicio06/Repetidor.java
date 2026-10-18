package ejercicio06;

public class Repetidor {
    static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("No has introducido ninguna palabra.");
            System.exit(1);
        }

        String palabra = args[0];
        System.out.println((palabra + " ").repeat(5));
        System.exit(0);
    }
}
