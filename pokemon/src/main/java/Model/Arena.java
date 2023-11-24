package Model;

public class Arena {
    private int id;
    private String nome;
    private String dificuldade;

    public Arena(String nome, String dificuldade) {
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

    public String getNome() {
        return nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }
}
