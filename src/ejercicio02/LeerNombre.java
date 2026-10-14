package ejercicio02;

public class LeerNombre {
    static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No se ha introducido ningún nombre.");
            System.exit(1);
        }
        String nombre = args[0];
        System.out.println("Nombre introducido: " + nombre);
        System.exit(0);
    }
}
