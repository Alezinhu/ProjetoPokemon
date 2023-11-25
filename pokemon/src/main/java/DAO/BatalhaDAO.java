package DAO;

import Model.Batalha;

import java.sql.SQLException;
import java.util.ArrayList;

public class BatalhaDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertUser(Batalha batalha) {

        connectToDB();

        String sql = "INSERT INTO Batalha (Jogador_idJogador,Arena_idArena) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, batalha.getIdJogador());
            pst.setInt(2, batalha.getIdArena());
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


    //SELECT
    public ArrayList<Batalha> selectUser() {
        ArrayList<Batalha> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Batalha";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de batalhas: ");

            while (rs.next()) {

                Batalha batalhaAux = new Batalha(rs.getInt("Jogador_idJogador"),rs.getInt("Arena_idArena"));

                System.out.println("id do jogador = " + batalhaAux.getIdJogador());
                System.out.println("id da arena = " + batalhaAux.getIdArena());
                System.out.println("--------------------------------");

                users.add(batalhaAux);
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


