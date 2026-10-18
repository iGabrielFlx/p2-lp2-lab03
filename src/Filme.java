import java.util.Objects;

public class Filme {

    private String nome;
    private int ano;
    private String local;
    private boolean ehHot = false;

    public Filme(String nome, int ano, String local) {
        this.nome = nome;
        this.ano = ano;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public String getLocal() {
        return local;
    }

    public void setHot(boolean novoEhHot) {
        this.ehHot = novoEhHot;
    }

    public boolean getHot() {
        return ehHot;
    }

    @Override
    public String toString() {
        String textoRetornado = this.getNome() + ", " + this.getAno() + "\n" + this.getLocal();

        if (this.getHot()) {
            return "🔥 " + textoRetornado;
        }
        return textoRetornado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Filme filme2 = (Filme) o;

        return Objects.equals(this.nome, filme2.nome) &&
                this.ano == filme2.ano;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, ano);
    }

}