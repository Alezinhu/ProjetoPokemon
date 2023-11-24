package DAO;

import Model.Fogo;

import java.sql.SQLException;
import java.util.ArrayList;

public class FogoDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertfogo(Fogo fogo) {

        connectToDB();

        String sql = "INSERT INTO fogo (nome,tipo,nivel,peso) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, fogo.getNome());
            pst.setString(2, fogo.getTipo());
            pst.setInt(3, fogo.getNivel());
            pst.setFloat(4, fogo.getPeso());
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
    public boolean updatefogo(String nome, Fogo fogo) {
        connectToDB();
        String sql = "UPDATE fogo SET nome=?, tipo=?, nivel=?, peso= ? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, fogo.getNome());
            pst.setString(2, fogo.getTipo());
            pst.setInt(3, fogo.getNivel());
            pst.setFloat(4, fogo.getPeso());
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
    public boolean deletefogo(String nome) {
        connectToDB();
        String sql = "DELETE FROM fogo where id=?";
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
    public ArrayList<Fogo> selectfogo() {
        ArrayList<Fogo> fogos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Fogo";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de fogos: ");

            while (rs.next()) {

                Fogo fogoAux = new Fogo(rs.getString("nome"),rs.getString("tipo"),rs.getInt("nivel"),rs.getInt("peso"),rs.getString("ataqueFogo"));

                System.out.println("nome = " + fogoAux.getNome());
                System.out.println("tipo = " + fogoAux.getTipo());
                System.out.println("nivel = " + fogoAux.getNivel());
                System.out.println("peso = " + fogoAux.getPeso());
                System.out.println("--------------------------------");

                fogos.add(fogoAux);
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
        return fogos;
    }
}