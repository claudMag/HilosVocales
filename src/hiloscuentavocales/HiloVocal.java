package hiloscuentavocales;

import java.util.concurrent.Semaphore;

public class HiloVocal extends Thread{

    private Marcador marcador;
    private Semaphore semaforo;
    private char vocal;
    private char vocalMayuscula;
    private String texto;

    public HiloVocal(Semaphore semaforo, char vocal, Marcador marcador, String texto){
        this.semaforo = semaforo;
        this.vocal = vocal;
        this.marcador = marcador;
        this.texto = texto;
        this.vocalMayuscula = Character.toUpperCase(vocal);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            int a = 0;
        }
        try {
            int contadorVocal = 0;
            semaforo.acquire();
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == vocal || texto.charAt(i) == vocalMayuscula){
                    contadorVocal++;
                    marcador.incrementarVocales();
                }
            }
            System.out.println("Hay "+contadorVocal+" vocales "+vocal);
            //System.out.println("Vocales totales hasta ahora: "+marcador.getVocalesTotales());
            semaforo.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
