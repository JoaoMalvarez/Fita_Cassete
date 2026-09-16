package MP3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> linhas = Leitor.lerConteudo("tape.in");
        CasoTeste[] casos = Parser.traduz(linhas);

        for (int i = 0; i < casos.length; i++) {
            CasoTeste caso = casos[i];
            System.out.println("Caso " + (i + 1) + ":");
            System.out.println("Capacidade de cada lado (segundos): " + caso.getCapacidadeLado());
            System.out.println("Músicas:");

            Musica[] musicas = caso.getMusicas();
            for (int j = 0; j < musicas.length; j++) {
                Musica m = musicas[j];
                System.out.println("  " + m.getMin() + "m " + m.getSeg() + "s (" + m.duracaoEmSegundos() + "s total)");
            }
            System.out.println();
        }
    }
}