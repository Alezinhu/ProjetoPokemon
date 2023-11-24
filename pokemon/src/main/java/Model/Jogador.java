package Model;

public class Jogador {

    private String nome;
    private int nivel;
    private int vitorias;
    private int id;

    public Jogador(String nome, int nivel, int vitorias) {
        this.nome = nome;
        this.nivel = nivel;
        this.vitorias = vitorias;
    }

    public String getNome() {
        return nome;
    }
    public int getNivel() {
        return nivel;
    }
    public int getVitorias() {
        return vitorias;
    }

}
