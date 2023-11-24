package DAO;

import Model.Agua;

import java.sql.SQLException;
import java.util.ArrayList;

public class AguaDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertagua(Agua agua) {

        connectToDB();

        String sql = "INSERT INTO agua (nome,tipo,nivel,peso) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, agua.getNome());
            pst.setString(2, agua.getTipo());
            pst.setInt(3, agua.getNivel());
            pst.setFloat(4, agua.getPeso());
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
    public boolean updateagua(String nome, Agua agua) {
        connectToDB();
        String sql = "UPDATE agua SET nome=?, tipo=?, nivel=?, peso= ? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, agua.getNome());
            pst.setString(2, agua.getTipo());
            pst.setInt(3, agua.getNivel());
            pst.setFloat(4, agua.getPeso());
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
    public boolean deleteagua(String nome) {
        connectToDB();
        String sql = "DELETE FROM agua where id=?";
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
    public ArrayList<Agua> selectagua() {
        ArrayList<Agua> aguas = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM agua";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de aguas: ");

            while (rs.next()) {

                Agua aguaAux = new Agua(rs.getString("nome"),rs.getString("tipo"),rs.getInt("nivel"),rs.getInt("peso"),rs.getInt("100"));

                System.out.println("nome = " + aguaAux.getNome());
                System.out.println("tipo = " + aguaAux.getTipo());
                System.out.println("nivel = " + aguaAux.getNivel());
                System.out.println("peso = " + aguaAux.getPeso());
                System.out.println("--------------------------------");

                aguas.add(aguaAux);
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
        return aguas;
    }
}