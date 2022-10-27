import java.util.concurrent.Semaphore;

public class HiloVocal extends Thread{

    private Marcador marcador;
    private Semaphore semaforo;
    private char vocal;
    private String texto;

    public HiloVocal(Semaphore semaforo, char vocal, Marcador marcador, String texto){
        this.semaforo = semaforo;
        this.vocal = vocal;
        this.marcador = marcador;
        this.texto = texto;
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
                if (texto.charAt(i) == vocal){
                    contadorVocal++;
                    marcador.incrementarVocales();
                }
            }

            System.out.println("Hay "+contadorVocal+" vocales "+vocal+" y las vocales totales hasta ahora son "+marcador.getVocalesTotales());
            semaforo.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
