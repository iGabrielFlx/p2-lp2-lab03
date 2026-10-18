import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FilmNow fn = new FilmNow();

        System.out.println("Carregando filmes ...");
        try {
            carregaFilmes("filmes_inicial.csv", fn);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro lendo arquivo: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = exibirMenu(scanner);
            comando(escolha, fn, scanner);
        }

    }

    private static String exibirMenu(Scanner scanner) {
        System.out.println(
                "\n---\nMENU\n" +
                        "(A)Adicionar filme\n" +
                        "(M)Mostrar todos\n" +
                        "(D)Detalhar filme\n" +
                        "(S)air\n" +
                        "\n" +
                        "Opção> ");
        return scanner.next().toUpperCase();
    }

    private static void comando(String opcao, FilmNow fn, Scanner scanner) {
        switch (opcao) {
            case "A":
                adicionaFilme(fn, scanner);
                break;
            case "M":
                mostrarFilmes(fn);
                break;
            case "D":
                detalharFilme(fn, scanner);
                break;
            case "S":
                sai();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void mostrarFilmes(FilmNow fn) {

        String[] filmes = fn.listaFilmes();
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i] != null) {
                System.out.println(formataFilme(i, filmes[i]));
            }
        }
    }

    private static void detalharFilme(FilmNow fn, Scanner scanner) {
        System.out.print("\nQual filme> ");
        int posicao = scanner.nextInt();
        String filme = fn.detalhaFilme(posicao);
        System.out.println("Dados do filme:\n" + filme);
    }

    private static String formataFilme(int posicao, String filme) {
        return posicao + " - " + filme;
    }

    private static void adicionaFilme(FilmNow fn, Scanner scanner) {
        System.out.print("\nPosição no sistema> ");
        int posicao = scanner.nextInt();
        System.out.print("\nNome> ");
        String nome = scanner.next();
        System.out.print("\nAno> ");
        int ano = scanner.nextInt();
        System.out.print("\nLocal> ");
        String local = scanner.next();
        fn.adicionaFilme(posicao, nome, ano, local);
    }

    private static void sai() {
        System.out.println("\nVlw flw o/");
        System.exit(0);
    }

    private static void carregaFilmes(String arquivoFilmes, FilmNow fn) throws FileNotFoundException, IOException {
        LeitorFilmNow leitor = new LeitorFilmNow();

        int carregados =  leitor.carregaContatos(arquivoFilmes, fn);
        System.out.println("Carregamos " + carregados + " registros.");
    }
}