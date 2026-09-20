package MP3;

public class Mochila {

    public static final int FORA = 0;
    public static final int LADO_A = 1;
    public static final int LADO_B = 2;

    private static int melhorSoma;
    private static int[] melhorEscolha;
    private static int[] sobra; // sobra[i] = soma das duracoes de i até o fim (para poda)

    /** Devolve, para cada música, FORA, LADO_A ou LADO_B. */
    public static int[] resolver(Musica[] musicas, int capacidade) {
        int n = musicas.length;

        melhorSoma = 0;
        melhorEscolha = new int[n];

        sobra = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sobra[i] = sobra[i + 1] + musicas[i].duracaoEmSegundos();
        }

        backtracking(musicas, capacidade, 0, 0, 0, new int[n]);
        return melhorEscolha;
    }

    private static void backtracking(Musica[] musicas, int capacidade, int indice, int somaA, int somaB, int[] atual) {

        int somaAtual = somaA + somaB;

        // poda 1: já achamos uma solução que enche os dois lados, não dá para melhorar
        if (melhorSoma == 2 * capacidade) {
            return;
        }

        // poda 2: nem pegando todas as músicas restantes dá para superar o melhor
        if (somaAtual + sobra[indice] <= melhorSoma) {
            return;
        }

        if (indice == musicas.length) {
            melhorSoma = somaAtual;
            System.arraycopy(atual, 0, melhorEscolha, 0, atual.length);
            return;
        }

        int duracao = musicas[indice].duracaoEmSegundos();

        // 1) coloca no lado A
        if (somaA + duracao <= capacidade) {
            atual[indice] = LADO_A;
            backtracking(musicas, capacidade, indice + 1, somaA + duracao, somaB, atual);
        }

        // 2) coloca no lado B
        if (somaB + duracao <= capacidade) {
            atual[indice] = LADO_B;
            backtracking(musicas, capacidade, indice + 1, somaA, somaB + duracao, atual);
        }

        // 3) deixa de fora
        atual[indice] = FORA;
        backtracking(musicas, capacidade, indice + 1, somaA, somaB, atual);
    }

    public static int getMelhorSoma() {
        return melhorSoma;
    }
}