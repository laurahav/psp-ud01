package ejercicio01;
/*
En este primer ejercicio, debes realizar las siguientes tareas:
a. Crea un programa en Java que imprima por pantalla el mensaje “Hola mundo”. A continuación,
genera el fichero .jar.
b. Crea un programa (Ejercicio1) que lance el ejecutable HolaMundo.jar.
c. ¿Podemos coger la salida del programa HolaMundo.jar y tratarla en el programa lanzador
(Ejercicio1) para que cuente los caracteres que contiene el mensaje?
*/
import java.io.IOException;

public class Ejercicio1 {
    static void main(String[] args) {
        String[] comando = {"cmd", "/c", "java", "-jar", "C:/Ejecutables/HolaMundo.jar"};

    }
}
