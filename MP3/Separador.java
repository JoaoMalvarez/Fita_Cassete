package MP3;

import java.util.ArrayList;
import java.util.List;

public class Separador {
    // guarda o resultado de separar um caso de teste em Lado A / Lado B
    public static class Resultado {
        List<Musica> ladoA = new ArrayList<>();
        List<Musica> ladoB = new ArrayList<>();
        boolean possivel;
    }

    public static Resultado separar(CasoTeste caso) {
        Musica[] musicas = caso.getMusicas();
        boolean[] escolhaLadoA = Mochila.resolver(musicas, caso.getCapacidadeLado());

        Resultado r = new Resultado();
        int somaB = 0;

        for (int i = 0; i < musicas.length; i++) {
            if (escolhaLadoA[i]) {
                r.ladoA.add(musicas[i]);
            } else {
                r.ladoB.add(musicas[i]);
                somaB += musicas[i].duracaoEmSegundos();
            }
        }

        r.possivel = somaB <= caso.getCapacidadeLado();
        return r;
    }
}