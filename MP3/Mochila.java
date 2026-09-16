package MP3;

public class Mochila {

    // guardam a melhor solução encontrada em toda a recursão
    private static int melhorSoma;
    private static boolean[] melhorEscolha;

    // método público que você vai chamar de fora (da Main, por exemplo)
    public static boolean[] resolver(Musica[] musicas, int capacidade) {
        int n = musicas.length;

        melhorSoma = 0;
        melhorEscolha = new boolean[n];

        boolean[] usadaAtual = new boolean[n];
        backtracking(musicas, capacidade, 0, 0, usadaAtual);

        return melhorEscolha; // diz quais músicas foram pro Lado A
    }

    // método recursivo (privado, só usado internamente)
    private static void backtracking(Musica[] musicas, int capacidade,
                                      int indice, int somaAtual, boolean[] usadaAtual) {

        // caso base: já decidimos sobre todas as músicas
        if (indice == musicas.length) {
            if (somaAtual > melhorSoma) {
                melhorSoma = somaAtual;
                // copia o estado atual pra "melhorEscolha", já que usadaAtual
                // vai continuar mudando nas próximas chamadas
                System.arraycopy(usadaAtual, 0, melhorEscolha, 0, usadaAtual.length);
            }
            return;
        }

        int duracao = musicas[indice].duracaoEmSegundos();

        // opção 1: NÃO usar a música "indice"
        backtracking(musicas, capacidade, indice + 1, somaAtual, usadaAtual);

        // opção 2: usar a música "indice", só se couber (poda)
        if (somaAtual + duracao <= capacidade) {
            usadaAtual[indice] = true;
            backtracking(musicas, capacidade, indice + 1, somaAtual + duracao, usadaAtual);
            usadaAtual[indice] = false; // "desfaz" a escolha (o backtrack de verdade)
        }
    }
}