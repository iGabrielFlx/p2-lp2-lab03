public class FilmNow {

    private Filme[] filmes;
    private int[] hotList;

    public FilmNow() {
        this.filmes = new Filme[100];
        this.hotList = new int[10];
    }

    public void adicionaFilme(int idFilme, String nome, int ano, String local) {
        filmes[idFilme] = new Filme(nome, ano, local);
    }

    public void atribuirHot(int idFilme, int idFilmeH) {
        hotList[idFilmeH] = idFilme;
        filmes[idFilme].setHot(true);
    }

    public String detalhaFilme(int idFilme) {
        filmes[idFilme].toString();
    }

    public String[] listaFilmes() {

    }

    public String[] listaHotList() {

    }

    public void removerHot(int idFilmeH) {
        int idFilmeAlvo = hotList[idFilmeH];

        filmes[idFilmeAlvo].setHot(false);
        hotList[idFilmeH] = null;
    }

}