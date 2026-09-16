// pega e devolve as linhas cruas

package MP3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Leitor {
    public static List<String> lerConteudo(String caminhoArquivo) {
        try {
            Path caminho = Paths.get(caminhoArquivo);
            List<String> linhas = Files.readAllLines(caminho);
            return linhas;
        } catch (IOException e) { 
            System.err.println("Erro ao ler o arquivo: " + caminhoArquivo);
            return new ArrayList<String>();
        }
    }
}