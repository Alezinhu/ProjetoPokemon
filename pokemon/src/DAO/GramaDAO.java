package DAO;

import Model.Grama;

import java.sql.SQLException;
import java.util.ArrayList;

public class GramaDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertgrama(Grama grama) {

        connectToDB();

        String sql = "INSERT INTO grama (nome,tipo,nivel,peso) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, grama.getNome());
            pst.setString(2, grama.getTipo());
            pst.setInt(3, grama.getNivel());
            pst.setFloat(4, grama.getPeso());
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
    public boolean updategrama(String nome, Grama grama) {
        connectToDB();
        String sql = "UPDATE grama SET nome=?, tipo=?, nivel=?, peso= ? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, grama.getNome());
            pst.setString(2, grama.getTipo());
            pst.setInt(3, grama.getNivel());
            pst.setFloat(4, grama.getPeso());
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
    public boolean deletegrama(String nome) {
        connectToDB();
        String sql = "DELETE FROM grama where id=?";
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
    public ArrayList<Grama> selectgrama() {
        ArrayList<Grama> gramas = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Grama";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de gramas: ");

            while (rs.next()) {

                Grama gramaAux = new Grama(rs.getString("nome"),rs.getString("tipo"),rs.getInt("nivel"),rs.getInt("peso"),rs.getString("ataque"));

                System.out.println("nome = " + gramaAux.getNome());
                System.out.println("tipo = " + gramaAux.getTipo());
                System.out.println("nivel = " + gramaAux.getNivel());
                System.out.println("peso = " + gramaAux.getPeso());
                System.out.println("--------------------------------");

                gramas.add(gramaAux);
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
        return gramas;
    }
}