package DAO;

import Model.Jogador;

import java.sql.SQLException;
import java.util.ArrayList;

public class JogadorDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertUser(Jogador jogador) {

        connectToDB();

        String sql = "INSERT INTO Jogador (nome,nivel,vitorias) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogador.getNome());
            pst.setInt(2, jogador.getNivel());
            pst.setInt(3,jogador.getVitorias());
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
    public boolean updateUser(int id, Jogador jogador) {
        connectToDB();
        String sql = "UPDATE Jogador SET nome=?, nivel=?, vitorias=? where idJogador=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogador.getNome());
            pst.setInt(2, jogador.getNivel());
            pst.setInt(3,jogador.getVitorias());
            pst.setInt(4,id);
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
        String sql = "DELETE FROM Jogador where idJogador=?";
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
    public ArrayList<Jogador> selectUser() {
        ArrayList<Jogador> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Jogador";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de jogadores: ");

            while (rs.next()) {

                Jogador jogadorAux = new Jogador(rs.getString("nome"),rs.getInt("nivel"),rs.getInt("vitorias"));

                System.out.println("nome = " + jogadorAux.getNome());
                System.out.println("nivel = " + jogadorAux.getNivel());
                System.out.println("vitorias = " + jogadorAux.getVitorias());
                System.out.println("--------------------------------");

                users.add(jogadorAux);
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


