package DAO;

import Model.Eletrico;

import java.sql.SQLException;
import java.util.ArrayList;

public class EletricoDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean inserteletrico(Eletrico eletrico) {

        connectToDB();

        String sql = "INSERT INTO eletrico (nome,tipo,nivel,peso) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, eletrico.getNome());
            pst.setString(2, eletrico.getTipo());
            pst.setInt(3, eletrico.getNivel());
            pst.setFloat(4, eletrico.getPeso());
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
    public boolean updateeletrico(String nome, Eletrico eletrico) {
        connectToDB();
        String sql = "UPDATE eletrico SET nome=?, tipo=?, nivel=?, peso= ? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, eletrico.getNome());
            pst.setString(2, eletrico.getTipo());
            pst.setInt(3, eletrico.getNivel());
            pst.setFloat(4, eletrico.getPeso());
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
    public boolean deleteeletrico(String nome) {
        connectToDB();
        String sql = "DELETE FROM eletrico where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
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
    public ArrayList<Eletrico> selecteletrico() {
        ArrayList<Eletrico> eletricos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Eletrico";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de eletricos: ");

            while (rs.next()) {

                Eletrico eletricoAux = new Eletrico(rs.getString("nome"),rs.getString("tipo"),rs.getInt("nivel"),rs.getInt("peso"), rs.getString("ataque"));

                System.out.println("nome = " + eletricoAux.getNome());
                System.out.println("tipo = " + eletricoAux.getTipo());
                System.out.println("nivel = " + eletricoAux.getNivel());
                System.out.println("peso = " + eletricoAux.getPeso());
                System.out.println("ataque = " + eletricoAux.getAtaque());
                System.out.println("--------------------------------");

                eletricos.add(eletricoAux);
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
        return eletricos;
    }
}