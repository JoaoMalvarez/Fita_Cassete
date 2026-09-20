package MP3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> linhas = Leitor.lerConteudo("tape.in");
        CasoTeste[] casos = Parser.traduz(linhas);

        for (int i = 0; i < casos.length; i++) {
            Separador.Resultado resultado = Separador.separar(casos[i]);
            Formatador.imprimirResultado(i + 1, resultado);
            System.out.println();
        }
    }
}