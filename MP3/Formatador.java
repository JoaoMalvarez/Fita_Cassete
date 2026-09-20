package MP3;

import java.util.List;

public class Formatador {
    public static void imprimirResultado(int numeroCaso, Separador.Resultado r) {
        System.out.println("Caso:" + numeroCaso);

        if (!r.possivel) {
            System.out.println("Impossivel gravar as musicas nessa fita.");
            return;
        }

        System.out.println("Lado A");
        imprimirMusicas(r.ladoA);
        System.out.println();
        System.out.println("Lado B");
        imprimirMusicas(r.ladoB);
    }

    private static void imprimirMusicas(List<Musica> musicas) {
        for (Musica m : musicas) {
            System.out.println(m.getMin() + "m " + m.getSeg() + "s");
        }
    }
}