package DAO;

import Model.Treinador;

import java.sql.SQLException;
import java.util.ArrayList;

public class TreinadorDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean inserttreinador(Treinador treinador) {

        connectToDB();

        String sql = "INSERT INTO treinador (nome,especialidade) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, treinador.getNome());
            pst.setString(2, treinador.getEspecialidade());
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
    public boolean updatetreinador(String nome, Treinador treinador) {
        connectToDB();
        String sql = "UPDATE treinador SET nome=?, especialidade=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, treinador.getNome());
            pst.setString(2, treinador.getEspecialidade());
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
    public boolean deletetreinador(String nome) {
        connectToDB();
        String sql = "DELETE FROM treinador where id=?";
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
    public ArrayList<Treinador> selecttreinador() {
        ArrayList<Treinador> treinadors = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Treinador";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de treinadors: ");

            while (rs.next()) {

                Treinador treinadorAux = new Treinador(rs.getString("nome"),rs.getString("especialidade"));

                System.out.println("nome = " + treinadorAux.getNome());
                System.out.println("especialidade = " + treinadorAux.getEspecialidade());
                System.out.println("--------------------------------");

                treinadors.add(treinadorAux);
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
        return treinadors;
    }
}