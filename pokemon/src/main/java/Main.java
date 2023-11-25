import DAO.*;
import Model.*;

public class Main {

    public static void main(String[] args) {

        JogadorDAO jogadorDAO= new JogadorDAO();
        ArenaDAO arenaDAO = new ArenaDAO();
        PokemonDAO pokemonDAO = new PokemonDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();

        Jogador u1 =  new Jogador("Alezinhu", 105,2000);
        Jogador u2 = new Jogador("Calvo", 67,0);
        Jogador u3 = new Jogador("Ferdinand", 69,10);

        Arena arena1 = new Arena("Arena de Gelo", "Médio");

        Pokemon poke1 = new Pokemon("Charizard","Fogo", 45,1);
        Pokemon poke2 = new Pokemon("Vaporeon","Agua", 33,2);
        Pokemon poke3 = new Pokemon("Pidgey","Voador", 12,1);

        Professor prof1 = new Professor("Professor Caralho", 10, "Todos os tipos",1);

        //* Entrada de dados
        jogadorDAO.insertUser(u1);
        jogadorDAO.insertUser(u2);
        arenaDAO.insertUser(arena1);
        pokemonDAO.insertUser(poke1);
        pokemonDAO.insertUser(poke2);
        pokemonDAO.insertUser(poke3);
        professorDAO.insertUser(prof1);


        //Mostrando as tabelas
        jogadorDAO.selectUser();
        arenaDAO.selectUser();
        professorDAO.selectUser();


        // Atualizando o jogador de id 2
        jogadorDAO.updateUser(2,u3);

        // Deletando um pokemon
       pokemonDAO.deleteUser(3);

    }
}