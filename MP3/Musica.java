package MP3;

public class Musica {
    private int minutos;
    private int segundos;

    public Musica(int min, int seg) {
        this.minutos = min;
        this.segundos = seg;
    }

    public int getMin() {
        return minutos;
    }

    public int getSeg() {
        return segundos;
    }

    public int duracaoEmSegundos() {
        return minutos * 60 + segundos;
    }
}