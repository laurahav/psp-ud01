package ejercicio07;

public class Lector {
    static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("No has introducido ninguna palabra.");
            System.exit(1);
        }

        String palabra = args[0];
        char[] letras = palabra.toCharArray();
        int vocales = 0, consonantes = 0;
        for (char letra : letras) {
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                vocales++;
            } else {
                consonantes++;
            }
        }
        System.out.printf("El número de vocales es: %d\nEl número de consonantes es: %d", vocales, consonantes);
    }
}
