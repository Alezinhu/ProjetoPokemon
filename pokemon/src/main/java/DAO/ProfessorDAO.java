package DAO;

import Model.Professor;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertUser(Professor professor) {

        connectToDB();

        String sql = "INSERT INTO Professor (nome,nivel,especialidade) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, professor.getNome());
            pst.setInt(2, professor.getNivel());
            pst.setString(3,professor.getEspecialidade());
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
    public boolean updateUser(int id, Professor professor) {
        connectToDB();
        String sql = "UPDATE Professor SET nome=?, nivel=?, especialidade=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, professor.getNome());
            pst.setInt(2, professor.getNivel());
            pst.setString(3, professor.getEspecialidade());
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
        String sql = "DELETE FROM Professor where id=?";
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
    public ArrayList<Professor> selectUser() {
        ArrayList<Professor> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Professor";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de users: ");

            while (rs.next()) {

                Professor professorAux = new Professor(rs.getString("nome"),rs.getInt("nivel"),rs.getString("especialidade"));

                System.out.println("nome = " + professorAux.getNome());
                System.out.println("nivel = " + professorAux.getNivel());
                System.out.println("especialidade= " + professorAux.getEspecialidade());
                System.out.println("--------------------------------");

                users.add(professorAux);
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


