#include <stdio.h>
#include <stdlib.h>

int abreArquivo(char linha[][100], int maxLinhas) {
    FILE *arquivo = fopen("tape.in", "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 0;
    }
    int total = 0;
    while (total < maxLinhas && fgets(linhas[total], 100, arquivo) != NULL) {
        int tamanho = strlen(linhas[total]);
        if (tamanho > 0 && linhas[total][tamanho - 1] == '\n') {
            linhas[total][tamanho - 1] = '\0';
        }
        total++;
    }
    fclose(arquivo);
    return total;
}




int main() {
    char linhas[1000][100];
    int totalLinhas = lerArquivo(linhas, 1000);
    printf("Total de linhas lidas: %d\n", totalLinhas);
    for(int i = 0; i < totalLinhas; i++) printf("linha[%d] = \"%s\"\n", i, linhas[i]);

    return 0;
}