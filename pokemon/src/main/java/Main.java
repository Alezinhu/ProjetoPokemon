import DAO.*;
import Model.*;

public class Main {

    public static void main(String[] args) {

        JogadorDAO jogadorDAO= new JogadorDAO();

        Jogador u1 =  new Jogador("Alezinhu", 105,2000);
        Jogador u2 = new Jogador("Calvo", 67,0);

        jogadorDAO.insertUser(u1);
        jogadorDAO.insertUser(u2);

        jogadorDAO.selectUser();

        jogadorDAO.deleteUser(2);

        jogadorDAO.updateUser(1,u2);

    }
}