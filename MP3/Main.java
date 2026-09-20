package MP3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> linhas = Leitor.lerConteudo("tape.in");
        CasoTeste[] casos = Parser.traduz(linhas);

        for (int i = 0; i < casos.length; i++) {
            CasoTeste caso = casos[i];
            Musica[] musicas = caso.getMusicas();

            int[] escolha = Mochila.resolver(musicas, caso.getCapacidadeLado());
            int total = Mochila.getMelhorSoma();

            System.out.println("Caso " + (i + 1) + ":");
            System.out.println("Capacidade de cada lado: " + caso.getCapacidadeLado() + "s");

            imprimirLado("Lado A", musicas, escolha, Mochila.LADO_A);
            imprimirLado("Lado B", musicas, escolha, Mochila.LADO_B);
            imprimirLado("Fora  ", musicas, escolha, Mochila.FORA);

            System.out.println("Tempo total gravado: " + total + "s");
            System.out.println();
        }
    }

    private static void imprimirLado(String titulo, Musica[] musicas, int[] escolha, int lado) {
        StringBuilder sb = new StringBuilder();
        int soma = 0;
        for (int j = 0; j < musicas.length; j++) {
            if (escolha[j] == lado) {
                Musica m = musicas[j];
                sb.append(m.getMin()).append(":").append(String.format("%02d", m.getSeg())).append("  ");
                soma += m.duracaoEmSegundos();
            }
        }
        System.out.println(titulo + " (" + soma + "s): " + sb.toString().trim());
    }
}