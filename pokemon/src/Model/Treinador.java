package Model;

public class Treinador {
    String nome;
    String especialidade;

    public Treinador(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}
