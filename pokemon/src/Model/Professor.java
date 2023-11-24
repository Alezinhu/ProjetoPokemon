package Model;

public class Professor {
    String nome;
    int qntDePokemons;


    public String getNome() {
        return nome;
    }

    public int getqntDePokemons() {
        return qntDePokemons;
    }

    public Professor(String nome, int qntDePokemons) {
        this.nome = nome;
        this.qntDePokemons = qntDePokemons;
    }
}
