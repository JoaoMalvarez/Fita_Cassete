#include <stdio.h>
#include <stdlib.h>

void abreArquivo() {
    FILE *arquivo = fopen("tape.in", "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo.\n");
    }
    char linha[100];
    while (fgets(linha, sizeof(linha), arquivo) != NULL) {
        printf("%s", linha);
    }
    fclose(arquivo);
    return 0;
}


int main() {
    
}