package hiloscuentavocales;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        /*Crea una clase Java que utilice 5 hilos para contar el número de vocales que hay en un
determinado texto. Cada hilo se encargará de contar una vocal diferente, actualizando todos
los hilos la misma variable común que representa el número de vocales totales. Para evitar
condiciones de carrera se deben utilizar semáforos.*/

        Semaphore semaforo = new Semaphore(1);
        Marcador marcador = new Marcador();
        String texto = "Hola soy un hilo que hereda de thread";

        HiloVocal a = new HiloVocal(semaforo, 'a', marcador, texto);
        HiloVocal e = new HiloVocal(semaforo, 'e', marcador, texto);
        HiloVocal i = new HiloVocal(semaforo, 'i', marcador, texto);
        HiloVocal o = new HiloVocal(semaforo, 'o', marcador, texto);
        HiloVocal u = new HiloVocal(semaforo, 'u', marcador, texto);

        a.start();
        e.start();
        i.start();
        o.start();
        u.start();

        try {
            a.join();
            e.join();
            i.join();
            o.join();
            u.join();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        System.out.println("Vocales totales " + marcador.getVocalesTotales());

    }
}