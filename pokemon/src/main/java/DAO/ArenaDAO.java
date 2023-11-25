package DAO;

import Model.Arena;

import java.sql.SQLException;
import java.util.ArrayList;

public class ArenaDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertUser(Arena arena) {

        connectToDB();

        String sql = "INSERT INTO Arena (nome,dificuldade) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, arena.getNome());
            pst.setString(2, arena.getDificuldade());
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
    public boolean updateUser(int id, Arena arena) {
        connectToDB();
        String sql = "UPDATE Arena SET nome=?, dificuldade=? where idArena=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, arena.getNome());
            pst.setString(2, arena.getDificuldade());
            pst.setInt(3,id);
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
        String sql = "DELETE FROM Arena where idArena=?";
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
    public ArrayList<Arena> selectUser() {
        ArrayList<Arena> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Arena";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de arenas: ");

            while (rs.next()) {

                Arena arenaAux = new Arena(rs.getString("nome"),rs.getString("dificuldade"));

                System.out.println("nome = " + arenaAux.getNome());
                System.out.println("dificuldade = " + arenaAux.getDificuldade());
                System.out.println("--------------------------------");

                users.add(arenaAux);
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


