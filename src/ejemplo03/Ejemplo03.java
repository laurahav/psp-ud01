package ejemplo03;

import java.text.DecimalFormat;
import java.util.Map;

public class Ejemplo03 {
    public static void main(String[] args) {
        long memoriaMaxima = Runtime.getRuntime().maxMemory();
        long memoriaLibre = Runtime.getRuntime().freeMemory();
        long memoriaTotal = Runtime.getRuntime().totalMemory();
        long memoriaUsada = memoriaTotal - memoriaLibre;
        DecimalFormat megabytes = new DecimalFormat("#.00");
        System.out.println("Memoria máxima que la JVM podría llegar a usar (Mbytes): " +
                megabytes.format((double) memoriaMaxima / (1024 * 1024)));
        System.out.println("Memoria total reservada actualmente por la JVM(Mbytes): " +
                megabytes.format((double) memoriaTotal / (1024 * 1024)));
        System.out.println("Memoria libre en JVM(Mbytes): " + (megabytes.format((double)
                memoriaLibre / (1024 * 1024))));
        System.out.println("Memoria usada en JVM(Mbytes): " + megabytes.format((double)
                memoriaUsada / (1024 * 1024)));
        System.out.println("Procesadores en el sistema: " +
                Runtime.getRuntime().availableProcessors());
        for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println("> " + key + " => " + val);
        }
    }
}