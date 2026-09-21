package MP3;

public class Mochila {

    private static int melhorSoma;
    private static boolean[] melhorEscolha;

    public static boolean[] resolver(Musica[] musicas, int capacidade) {
        int n = musicas.length;
        melhorEscolha = new boolean[n];

        Integer[][] memo = new Integer[n][capacidade + 1];
        melhorSoma = backtracking(musicas, capacidade, 0, 0, memo);

        int indice = 0;
        int somaAcumulada = 0;

        while (indice < n) {
            int alvo = backtracking(musicas, capacidade, indice, somaAcumulada, memo);
            int duracao = musicas[indice].duracaoEmSegundos();
            int valorSemUsar = backtracking(musicas, capacidade, indice + 1, somaAcumulada, memo);

            if (valorSemUsar == alvo) {
                melhorEscolha[indice] = false;
            } else {
                melhorEscolha[indice] = true;
                somaAcumulada += duracao;
            }
            indice++;
        }

        return melhorEscolha; 
    }

    private static int backtracking(Musica[] musicas, int capacidade, int indice, int somaAtual, Integer[][] memo) {
        if (indice == musicas.length) {
            return somaAtual;
        }

        if (memo[indice][somaAtual] != null) {
            return memo[indice][somaAtual];
        }

        int duracao = musicas[indice].duracaoEmSegundos();

        int semUsar = backtracking(musicas, capacidade, indice + 1, somaAtual, memo);


        int comUsar = 0;
        if (somaAtual + duracao <= capacidade) {
            comUsar = backtracking(musicas, capacidade, indice + 1, somaAtual + duracao, memo);
        }

        int melhor = Math.max(semUsar, comUsar);
        memo[indice][somaAtual] = melhor; 
        return melhor;
    }
}