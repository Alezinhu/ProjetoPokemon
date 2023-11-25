package Model;

public class Pokemon {
    private int id;
    private int id_jogador;
    private String nome;
    private String tipo;
    private int nivel;

    public Pokemon(String nome, String tipo, int nivel, int id_jogador) {
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
        this.id_jogador = id_jogador;
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
    public int getId_jogador() {
        return id_jogador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
