import DAO.*;
import Model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pokedex pokedex = new Pokedex("2", "awdawd");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Escolha uma opção:\n" +
                    "1. Exibir todos os Pokémon\n" +
                    "2. Filtrar por tipo\n" +
                    "3. Adicionar novo Pokémon\n" +
                    "4. Remover Pokémon\n" +
                    "5. Sair\n" +
                    "Opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("\nExibindo todos os Pokémon:");
                    break;
                case "2":
                    System.out.print("Digite o tipo de Pokémon que deseja ver na Pokedex: ");
                    String tipoEscolhido = scanner.nextLine().toLowerCase();
                    System.out.println("\nPokémons do tipo " + tipoEscolhido + ":");
                    break;
                case "3":
                    System.out.println("\nAdicionar novo Pokémon à Pokédex:");

                    System.out.print("Nome do Pokémon: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Tipo do Pokémon: ");
                    String novoTipo = scanner.nextLine().toLowerCase();

                    System.out.print("Nível do Pokémon: ");
                    int novoNivel = Integer.parseInt(scanner.nextLine());

                    System.out.print("Peso do Pokémon: ");
                    int novoPeso = Integer.parseInt(scanner.nextLine());

                    if (novoTipo.equals("eletrico")){
                        System.out.print("Ataque eletrico do Pokémon: ");
                        String novoAtaque = scanner.nextLine().toLowerCase();
                        Eletrico pokemon = new Eletrico(novoNome, novoTipo, novoNivel, novoPeso, novoAtaque);
                        EletricoDAO dao = new EletricoDAO();
                        dao.inserteletrico(pokemon);
                    } else if (novoTipo.equals("agua")) {
                        System.out.print("Tempo longe da agua: ");
                        float tempoLonge = scanner.nextFloat();
                        Agua pokemon = new Agua(novoNome, novoTipo, novoNivel, novoPeso, tempoLonge);
                        AguaDAO dao = new AguaDAO();
                        dao.insertagua(pokemon);
                    } else if (novoTipo.equals("grama")) {
                        System.out.print("Ataque de Grama do Pokémon: ");
                        String novoAtaque = scanner.nextLine().toLowerCase();
                        Grama pokemon = new Grama(novoNome, novoTipo, novoNivel, novoPeso, novoAtaque);
                        GramaDAO dao = new GramaDAO();
                        dao.insertgrama(pokemon);
                    } else if (novoTipo.equals("normal")) {
                        System.out.print("Ataque do tipo Normal do Pokémon: ");
                        String novoAtaque = scanner.nextLine().toLowerCase();
                        Normal pokemon = new Normal(novoNome, novoTipo, novoNivel, novoPeso, novoAtaque);
                        NormalDAO dao = new NormalDAO();
                        dao.insertnormal(pokemon);
                    } else if (novoTipo.equals("fogo")) {
                        System.out.print("Ataque de Fogo do Pokémon: ");
                        String novoAtaque = scanner.nextLine().toLowerCase();
                        Fogo pokemon = new Fogo(novoNome, novoTipo, novoNivel, novoPeso, novoAtaque);
                        FogoDAO dao = new FogoDAO();
                        dao.insertfogo(pokemon);
                    }
                    break;

                case "4":
                    System.out.print("Digite o nome do Pokémon que deseja remover: ");

                    break;
                case "5":
                    System.out.println("Desligando Pokedex. Adeus!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            System.out.println("--------------------");
        }
    }
}
