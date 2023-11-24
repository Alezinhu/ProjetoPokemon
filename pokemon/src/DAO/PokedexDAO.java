package DAO;

import Model.Pokedex;

import java.sql.SQLException;
import java.util.ArrayList;

public class PokedexDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertpokedex(Pokedex pokedex) {

        connectToDB();

        String sql = "INSERT INTO pokedex (ID,nome) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, pokedex.getID());
            pst.setString(2, pokedex.getNome());
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
    public boolean updatepokedex(String nome, Pokedex pokedex) {
        connectToDB();
        String sql = "UPDATE pokedex SET id=?, nome=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, pokedex.getID());
            pst.setString(2, pokedex.getNome());

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
    public boolean deletepokedex(String nome) {
        connectToDB();
        String sql = "DELETE FROM pokedex where id=?";
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
    public ArrayList<Pokedex> selectpokedex() {
        ArrayList<Pokedex> pokedexs = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Pokedex";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de pokedexs: ");

            while (rs.next()) {

                Pokedex pokedexAux = new Pokedex(rs.getString("id"),rs.getString("nome"));

                System.out.println("id = " + pokedexAux.getID());
                System.out.println("nome = " + pokedexAux.getNome());
                System.out.println("--------------------------------");

                pokedexs.add(pokedexAux);
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
        return pokedexs;
    }
}
