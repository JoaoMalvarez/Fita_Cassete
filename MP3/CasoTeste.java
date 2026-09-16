package MP3;

public class CasoTeste {
    private int capacidadeLado; // capacidade de CADA lado, em segundos
    private Musica[] musicas;

    public CasoTeste(int capacidadeLado, Musica[] musicas) {
        this.capacidadeLado = capacidadeLado;
        this.musicas = musicas;
    }

    public int getCapacidadeLado() {
        return capacidadeLado;
    }

    public Musica[] getMusicas() {
        return musicas;
    }
}