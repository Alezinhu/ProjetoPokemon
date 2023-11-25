package DAO;

import Model.Pokemon;

import java.sql.SQLException;
import java.util.ArrayList;

public class PokemonDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertUser(Pokemon pokemon) {

        connectToDB();

        String sql = "INSERT INTO Pokemon (nome,tipo,nivel,Jogador_idJogador) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, pokemon.getNome());
            pst.setString(2, pokemon.getTipo());
            pst.setInt(3, pokemon.getNivel());
            pst.setInt(4,pokemon.getId_jogador());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
    //UPDATE
    public boolean updateUser(int id, Pokemon pokemon) {
        connectToDB();
        String sql = "UPDATE Pokemon SET nome=?,tipo = ?,nivel=?,Jogador_idJogador=? where idPokemon=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, pokemon.getNome());
            pst.setString(2, pokemon.getTipo());
            pst.setInt(3, pokemon.getNivel());
            pst.setInt(4,pokemon.getId_jogador());
            pst.setInt(5,id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
    //DELETE
    public boolean deleteUser(int id) {
        connectToDB();
        String sql = "DELETE FROM Pokemon where idPokemon=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //SELECT
    public ArrayList<Pokemon> selectUser() {
        ArrayList<Pokemon> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Pokemon";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Pokemons: ");

            while (rs.next()) {

                Pokemon pokemonAux = new Pokemon(rs.getString("nome"),rs.getString("tipo"),rs.getInt("nivel"),rs.getInt("Jogador_idJogador"));

                System.out.println("nome = " + pokemonAux.getNome());
                System.out.println("tipo = " + pokemonAux.getTipo());
                System.out.println("nivel = " + pokemonAux.getNivel());
                System.out.println("id do treinador= " + pokemonAux.getId_jogador());
                System.out.println("--------------------------------");

                users.add(pokemonAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return users;
    }
}


