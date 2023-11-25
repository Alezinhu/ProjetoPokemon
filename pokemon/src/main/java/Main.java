import DAO.*;
import Model.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        JogadorDAO jogadorDAO = new JogadorDAO();
        ArenaDAO arenaDAO = new ArenaDAO();
        PokemonDAO pokemonDAO = new PokemonDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();
        BatalhaDAO batalhaDAO = new BatalhaDAO();

        System.out.println("Bem-vindo ao mundo Pokémon! O que deseja fazer?");
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\nOpções:");
            System.out.println("1. Adicionar um Pokémon");
            System.out.println("2. Adicionar um Jogador");
            System.out.println("3. Adicionar uma Arena");
            System.out.println("4. Adicionar um Professor");
            System.out.println("5. Atualizar um dado");
            System.out.println("6. Remover um dado");
            System.out.println("7. Mostrar tabelas");
            System.out.println("8. Criar e iniciar uma batalha");
            System.out.println("0. Sair");

            try {
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();  // Limpa o buffer do teclado

                switch (opcao) {
                    case 1:
                        adicionarPokemon(scanner, pokemonDAO);
                        break;
                    case 2:
                        adicionarJogador(scanner, jogadorDAO);
                        break;
                    case 3:
                        adicionarArena(scanner, arenaDAO);
                        break;
                    case 4:
                        adicionarProfessor(scanner, professorDAO);
                        break;
                    case 5:
                        atualizarDado(scanner, jogadorDAO, arenaDAO, pokemonDAO, professorDAO);
                        break;
                    case 6:
                        removerDado(scanner, jogadorDAO, arenaDAO, pokemonDAO, professorDAO);
                        break;
                    case 7:
                        mostrarTabelasSeparadas(scanner, jogadorDAO, arenaDAO, pokemonDAO, professorDAO, batalhaDAO);
                        break;
                    case 8:
                        criarBatalha(scanner, batalhaDAO, jogadorDAO, arenaDAO);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine();  // Limpa o buffer do teclado
            }
        }

        // Fechando o scanner
        scanner.close();
    }

    private static void adicionarPokemon(Scanner scanner, PokemonDAO pokemonDAO) {
        System.out.println("Adicionando um Pokémon:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Nível: ");
        int nivel = scanner.nextInt();
        System.out.print("ID Treinador: ");
        int idTreinador = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do teclado

        pokemonDAO.insertUser(new Pokemon(nome, tipo, nivel, idTreinador));
        System.out.println("Pokémon adicionado com sucesso!");
    }

    private static void adicionarJogador(Scanner scanner, JogadorDAO jogadorDAO) {
        System.out.println("Adicionando um Jogador:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nível: ");
        int nivel = scanner.nextInt();
        System.out.print("Vitórias: ");
        int vitorias = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do teclado

        jogadorDAO.insertUser(new Jogador(nome, nivel, vitorias));
        System.out.println("Jogador adicionado com sucesso!");
    }

    private static void adicionarArena(Scanner scanner, ArenaDAO arenaDAO) {
        System.out.println("Adicionando uma Arena:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Dificuldade: ");
        String dificuldade = scanner.nextLine();

        arenaDAO.insertUser(new Arena(nome, dificuldade));
        System.out.println("Arena adicionada com sucesso!");
    }

    private static void adicionarProfessor(Scanner scanner, ProfessorDAO professorDAO) {
        System.out.println("Adicionando um Professor:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nível: ");
        int nivel = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do teclado
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.print("ID do Aluno (Jogador): ");
        int idAluno = scanner.nextInt();
        scanner.nextLine();

        professorDAO.insertUser(new Professor(nome, nivel, especialidade, idAluno));
        System.out.println("Professor adicionado com sucesso!");
    }

    private static void criarBatalha(Scanner scanner, BatalhaDAO batalhaDAO, JogadorDAO jogadorDAO, ArenaDAO arenaDAO) {
        System.out.println("Criando uma batalha:");

        // Mostra jogadores disponíveis
        System.out.println("Jogadores disponíveis:");
        jogadorDAO.selectUser();
        System.out.print("Escolha o ID do Jogador: ");
        int idJogador = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do teclado

        // Mostra arenas disponíveis
        System.out.println("Arenas disponíveis:");
        arenaDAO.selectUser();
        System.out.print("Escolha o ID da Arena: ");
        int idArena = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do teclado

        // Cria a batalha
        Batalha novaBatalha = new Batalha(idArena, idJogador);
        batalhaDAO.insertUser(novaBatalha);
        System.out.println("Batalha criada com sucesso!");


        iniciarBatalha(scanner, novaBatalha);
    }

    private static void iniciarBatalha(Scanner scanner, Batalha batalha) {
        System.out.println("Iniciando batalha...");
        System.out.println("Escolha uma ação:");
        System.out.println("1. Ataque básico");
        System.out.println("2. Habilidade especial");
        int escolhaAcao = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do teclado

        switch (escolhaAcao) {
            case 1:
                batalha.ataqueBasico();
                break;
            case 2:
                batalha.habilidadeEspecial();
                break;
            default:
                System.out.println("Ação inválida. Tente novamente.");
        }
    }

    private static void atualizarDado(Scanner scanner, JogadorDAO jogadorDAO, ArenaDAO arenaDAO, PokemonDAO pokemonDAO, ProfessorDAO professorDAO) {
        System.out.println("Atualizando um dado:");
        System.out.println("Selecione a tabela:");
        System.out.println("1. Jogadores");
        System.out.println("2. Arenas");
        System.out.println("3. Pokémons");
        System.out.println("4. Professores");
        int escolha = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do teclado

        switch (escolha) {
            case 1:
                atualizarJogador(scanner, jogadorDAO);
                break;
            case 2:
                atualizarArena(scanner, arenaDAO);
                break;
            case 3:
                atualizarPokemon(scanner, pokemonDAO);
                break;
            case 4:
                atualizarProfessor(scanner, professorDAO);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void atualizarJogador(Scanner scanner, JogadorDAO jogadorDAO) {
        System.out.print("Digite o ID do jogador que deseja atualizar: ");
        int idJogador = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo nível: ");
        int novoNivel = scanner.nextInt();
        System.out.print("Novas vitórias: ");
        int novasVitorias = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do teclado

        jogadorDAO.updateUser(idJogador, new Jogador(novoNome, novoNivel, novasVitorias));
        System.out.println("Jogador atualizado com sucesso!");
    }

    private static void atualizarArena(Scanner scanner, ArenaDAO arenaDAO) {
        System.out.print("Digite o ID da arena que deseja atualizar: ");
        int idArena = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Nova dificuldade: ");
        String novaDificuldade = scanner.nextLine();

        arenaDAO.updateUser(idArena, new Arena(novoNome, novaDificuldade));
        System.out.println("Arena atualizada com sucesso!");
    }

    private static void atualizarPokemon(Scanner scanner, PokemonDAO pokemonDAO) {
        System.out.print("Digite o ID do Pokémon que deseja atualizar: ");
        int idPokemon = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo tipo: ");
        String novoTipo = scanner.nextLine();
        System.out.print("Novo nível: ");
        int novoNivel = scanner.nextInt();
        System.out.print("Novo ID do Treinador: ");
        int novoIdTreinador = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do teclado

        pokemonDAO.updateUser(idPokemon, new Pokemon(novoNome, novoTipo, novoNivel, novoIdTreinador));
        System.out.println("Pokémon atualizado com sucesso!");
    }

    private static void atualizarProfessor(Scanner scanner, ProfessorDAO professorDAO) {
        System.out.print("Digite o ID do Professor que deseja atualizar: ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo nível: ");
        int novoNivel = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do teclado
        System.out.print("Nova especialidade: ");
        String novaEspecialidade = scanner.nextLine();
        System.out.print("Novo ID do Aluno (Jogador): ");
        int novoIdAluno = scanner.nextInt();
        scanner.nextLine();

        professorDAO.updateUser(idProfessor, new Professor(novoNome, novoNivel, novaEspecialidade, novoIdAluno));
        System.out.println("Professor atualizado com sucesso!");
    }

    private static void removerDado(Scanner scanner, JogadorDAO jogadorDAO, ArenaDAO arenaDAO, PokemonDAO pokemonDAO, ProfessorDAO professorDAO) {
        System.out.println("Removendo um dado:");
        System.out.println("Selecione a tabela:");
        System.out.println("1. Jogadores");
        System.out.println("2. Arenas");
        System.out.println("3. Pokémons");
        System.out.println("4. Professores");
        int escolha = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do teclado

        switch (escolha) {
            case 1:
                removerJogador(scanner, jogadorDAO);
                break;
            case 2:
                removerArena(scanner, arenaDAO);
                break;
            case 3:
                removerPokemon(scanner, pokemonDAO);
                break;
            case 4:
                removerProfessor(scanner, professorDAO);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void removerJogador(Scanner scanner, JogadorDAO jogadorDAO) {
        System.out.print("Digite o ID do jogador que deseja remover: ");
        int idJogador = scanner.nextInt();
        scanner.nextLine();

        jogadorDAO.deleteUser(idJogador);
        System.out.println("Jogador removido com sucesso!");
    }

    private static void removerArena(Scanner scanner, ArenaDAO arenaDAO) {
        System.out.print("Digite o ID da arena que deseja remover: ");
        int idArena = scanner.nextInt();
        scanner.nextLine();

        arenaDAO.deleteUser(idArena);
        System.out.println("Arena removida com sucesso!");
    }

    private static void removerPokemon(Scanner scanner, PokemonDAO pokemonDAO) {
        System.out.print("Digite o ID do Pokémon que deseja remover: ");
        int idPokemon = scanner.nextInt();
        scanner.nextLine();

        pokemonDAO.deleteUser(idPokemon);
        System.out.println("Pokémon removido com sucesso!");
    }

    private static void removerProfessor(Scanner scanner, ProfessorDAO professorDAO) {
        System.out.print("Digite o ID do Professor que deseja remover: ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();

        professorDAO.deleteUser(idProfessor);
        System.out.println("Professor removido com sucesso!");
    }

    private static void mostrarTabelasSeparadas(Scanner scanner, JogadorDAO jogadorDAO, ArenaDAO arenaDAO, PokemonDAO pokemonDAO, ProfessorDAO professorDAO, BatalhaDAO batalhaDAO) {
        System.out.println("Escolha a tabela que deseja mostrar:");
        System.out.println("1. Jogadores");
        System.out.println("2. Arenas");
        System.out.println("3. Pokémons");
        System.out.println("4. Professores");
        System.out.println("5. Batalhas");
        int escolha = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do teclado

        switch (escolha) {
            case 1:
                mostrarTabelaJogadores(jogadorDAO);
                break;
            case 2:
                mostrarTabelaArenas(arenaDAO);
                break;
            case 3:
                mostrarTabelaPokemons(pokemonDAO);
                break;
            case 4:
                mostrarTabelaProfessores(professorDAO);
                break;
            case 5:
                mostrarTabelaBatalhas(batalhaDAO);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void mostrarTabelaJogadores(JogadorDAO jogadorDAO) {
        System.out.println("\nTabela Jogadores:");
        jogadorDAO.selectUser();
    }

    private static void mostrarTabelaArenas(ArenaDAO arenaDAO) {
        System.out.println("\nTabela Arenas:");
        arenaDAO.selectUser();
    }

    private static void mostrarTabelaPokemons(PokemonDAO pokemonDAO) {
        System.out.println("\nTabela Pokémons:");
        pokemonDAO.selectUser();
    }

    private static void mostrarTabelaProfessores(ProfessorDAO professorDAO) {
        System.out.println("\nTabela Professores:");
        professorDAO.selectUser();
    }

    private static void mostrarTabelaBatalhas(BatalhaDAO batalhaDAO) {
        System.out.println("\nTabela Batalhas:");
        batalhaDAO.selectUser();
    }
}