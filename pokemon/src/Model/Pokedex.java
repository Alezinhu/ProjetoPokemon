package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Pokedex {

    String ID;
    String Nome;
    ArrayList<Pokemon> pokemons;
    public String getID() {
        return ID;
    }

    public String getNome() {
        return Nome;
    }

    public Pokedex(String ID, String nome) {
        this.ID = ID;
        Nome = nome;
    }
}
