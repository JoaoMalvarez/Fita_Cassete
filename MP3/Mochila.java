package MP3;

public class Mochila {

    private static int melhorSoma;
    private static boolean[] melhorEscolha;

    public static boolean[] resolver(Musica[] musicas, int capacidade) {
        int n = musicas.length;

        melhorSoma = 0;
        melhorEscolha = new boolean[n];

        boolean[] usadaAtual = new boolean[n];
        backtracking(musicas, capacidade, 0, 0, usadaAtual);

        return melhorEscolha; 
    }

    private static void backtracking(Musica[] musicas, int capacidade, int indice, int somaAtual, boolean[] usadaAtual) {

        if (indice == musicas.length) {
            if (somaAtual > melhorSoma) {
                melhorSoma = somaAtual;
                System.arraycopy(usadaAtual, 0, melhorEscolha, 0, usadaAtual.length);
            }
            return;
        }

        int duracao = musicas[indice].duracaoEmSegundos();

        backtracking(musicas, capacidade, indice + 1, somaAtual, usadaAtual);

        if (somaAtual + duracao <= capacidade) {
            usadaAtual[indice] = true;
            backtracking(musicas, capacidade, indice + 1, somaAtual + duracao, usadaAtual);
            usadaAtual[indice] = false; 
        }
    }
}