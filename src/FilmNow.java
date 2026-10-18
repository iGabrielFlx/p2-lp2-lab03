import java.util.Arrays;

public class FilmNow {

    private Filme[] filmes;
    private int[] hotList;

    public FilmNow() {
        this.filmes = new Filme[100];
        this.hotList = new int[10];
        Arrays.fill(hotList, -1);
    }

    public void adicionaFilme(int idFilme, String nome, int ano, String local) {
        filmes[idFilme] = new Filme(nome, ano, local);
    }

    public void atribuirHot(int idFilme, int idFilmeH) {
        hotList[idFilmeH] = idFilme;
        filmes[idFilme].setHot(true);
    }

    public String detalhaFilme(int idFilme) {
        return filmes[idFilme].toString();
    }

    public String[] listaFilmes() {
        int qtdFilmes = 0;
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i] != null) {
                qtdFilmes++;
            }
        }

        String[] filmesCadastrados = new String[qtdFilmes];
        int indexString = 0;
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i] != null) {
                filmesCadastrados[indexString] = i + " - " + filmes[i].getNome();
                indexString++;
            }
        }

        return filmesCadastrados;

    }

    public String[] listaHotList() {
        int qtdHotFilmes = 0;
        for (int i = 0; i < hotList.length; i++) {
            int idFilmeAlvo = hotList[i];
            if (idFilmeAlvo != -1) {
                if (filmes[idFilmeAlvo] != null) {
                    qtdHotFilmes++;
                }
            }
        }

        String[] filmesCadastradosHotList = new String[qtdHotFilmes];
        int indexString = 0;
        for (int i = 0; i < hotList.length; i++) {
            int idFilmeAlvo = hotList[i];
            if (idFilmeAlvo != -1) {
                if (filmes[idFilmeAlvo] != null) {
                    filmesCadastradosHotList[indexString] = i + " - " + filmes[idFilmeAlvo].getNome() + ", " + filmes[idFilmeAlvo].getLocal();
                    indexString++;
                }
            }
        }

        return filmesCadastradosHotList;

    }

    public void removerHot(int idFilmeH) {
        int idFilmeAlvo = hotList[idFilmeH];

        filmes[idFilmeAlvo].setHot(false);
        hotList[idFilmeH] = -1;
    }

}