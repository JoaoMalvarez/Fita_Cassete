package MP3;

import java.util.List;

public class Parser {
    public static CasoTeste[] traduz(List<String> linhas) {
        int indice = pularLinhasVazias(linhas, 0);
        int n = Integer.parseInt(linhas.get(indice).trim()); // quantos casos de teste
        CasoTeste[] casos = new CasoTeste[n];

        indice++;
        int t, l, m, s;
        for (int i = 0; i < n; i++) {
            indice = pularLinhasVazias(linhas, indice);
            String[] parte = linhas.get(indice).trim().split("\\s+");
            l = Integer.parseInt(parte[0]);
            int capacidadeLado = l * 30; // (l * 60) / 2
            t = Integer.parseInt(parte[1]);
            indice++;
            Musica[] musicas = new Musica[t];
            for (int j = 0; j < t; j++) {
                parte = linhas.get(indice).trim().split("\\s+");
                m = Integer.parseInt(parte[0]);
                s = Integer.parseInt(parte[1]);
                musicas[j] = new Musica(m, s);
                indice++;
            }
            casos[i] = new CasoTeste(capacidadeLado, musicas);
        }

        return casos;
    }

    public static int pularLinhasVazias(List<String> linhas, int indice) {
        while (indice < linhas.size() && linhas.get(indice).trim().isEmpty()) {
            indice++;
        }
        return indice;
    }
}