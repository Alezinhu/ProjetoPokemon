package Model;

public class Pokemon {
     String nome;
     String tipo;
     int nivel;
     float peso;

    public Pokemon(String nome, String tipo, int nivel, int peso) {
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public float getPeso() {
        return peso;
    }
}
