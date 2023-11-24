package DAO;

import Model.Normal;

import java.sql.SQLException;
import java.util.ArrayList;

public class NormalDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertnormal(Normal normal) {

        connectToDB();

        String sql = "INSERT INTO normal (nome,tipo,nivel,peso) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, normal.getNome());
            pst.setString(2, normal.getTipo());
            pst.setInt(3, normal.getNivel());
            pst.setFloat(4, normal.getPeso());
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
    public boolean updatenormal(String nome, Normal normal) {
        connectToDB();
        String sql = "UPDATE normal SET nome=?, tipo=?, nivel=?, peso= ? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, normal.getNome());
            pst.setString(2, normal.getTipo());
            pst.setInt(3, normal.getNivel());
            pst.setFloat(4, normal.getPeso());
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
    public boolean deletenormal(String nome) {
        connectToDB();
        String sql = "DELETE FROM normal where id=?";
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
    public ArrayList<Normal> selectnormal() {
        ArrayList<Normal> normals = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Normal";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de normals: ");

            while (rs.next()) {

                Normal normalAux = new Normal(rs.getString("nome"),rs.getString("tipo"),rs.getInt("nivel"),rs.getInt("peso"),rs.getString("ataque"));

                System.out.println("nome = " + normalAux.getNome());
                System.out.println("tipo = " + normalAux.getTipo());
                System.out.println("nivel = " + normalAux.getNivel());
                System.out.println("peso = " + normalAux.getPeso());
                System.out.println("--------------------------------");

                normals.add(normalAux);
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
        return normals;
    }
}