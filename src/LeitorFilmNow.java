import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorFilmNow {

    private static final int COLUNA_POSICAO = 0;
    private static final int COLUNA_NOME = 1;
    private static final int COLUNA_ANO = 2;
    private static final int COLUNA_LOCAL = 3;


    public int carregaContatos(String arquivoFilmes, FilmNow fn) throws FileNotFoundException, IOException {
        int carregados = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoFilmes))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                carregados += 1;
                if (carregados == 1) {
                    // pulamos a primeira linha, o cabeçalho
                    continue;
                }
                String[] campos = linha.split(",");
                processaLinhaCsvFilmes(campos, fn);
            }
        }

        return carregados;
    }

    private void processaLinhaCsvFilmes(String[] campos, FilmNow fn) {
        int posicao = Integer.parseInt(campos[COLUNA_POSICAO]);
        String nome = campos[COLUNA_NOME].trim();
        int ano = Integer.parseInt(campos[COLUNA_ANO].trim());
        String local = campos[COLUNA_LOCAL].trim();

        fn.adicionaFilme(posicao, nome, ano, local);
    }

}
