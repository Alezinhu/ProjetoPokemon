package Model;

public class Professor {
    private int id;
    private String nome;
    private int nivel;
    private String especialidade;

    public Professor(String nome, int nivel, String especialidade) {
        this.nome = nome;
        this.nivel = nivel;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}
