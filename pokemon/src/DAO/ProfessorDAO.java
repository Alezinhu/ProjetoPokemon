package DAO;


import Model.Professor;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertprofessor(Professor professor) {

        connectToDB();

        String sql = "INSERT INTO professor (nome,especialidade) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, professor.getNome());
            pst.setInt(2, professor.getqntDePokemons());
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
    public boolean updateprofessor(String nome, Professor professor) {
        connectToDB();
        String sql = "UPDATE professor SET nome=?, especialidade=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, professor.getNome());
            pst.setInt(2, professor.getqntDePokemons());
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
    public boolean deleteprofessor(String nome) {
        connectToDB();
        String sql = "DELETE FROM professor where id=?";
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
    public ArrayList<Professor> selectprofessor() {
        ArrayList<Professor> professors = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Professor";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de professors: ");

            while (rs.next()) {

                Professor professorAux = new Professor(rs.getString("nome"),rs.getInt("qntDePokemons"));

                System.out.println("nome = " + professorAux.getNome());
                System.out.println("especialidade = " + professorAux.getqntDePokemons());
                System.out.println("--------------------------------");

                professors.add(professorAux);
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
        return professors;
    }
}