package Model;

public class Professor {
    private int id;
    private String nome;
    private int nivel;
    private String especialidade;
    private int aluno;

    public Professor(String nome, int nivel, String especialidade, int aluno) {
        this.nome = nome;
        this.nivel = nivel;
        this.especialidade = especialidade;
        this.aluno = aluno;
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

    public int getAluno() {
        return aluno;
    }
}
