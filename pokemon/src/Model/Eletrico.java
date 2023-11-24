package Model;

public class Eletrico extends Pokemon implements Ataque{

    String ataqueEletrico;
    public Eletrico(String nome, String tipo, int nivel, int peso, String ataqueEletrico) {
        super(nome, tipo, nivel, peso);
        this.ataqueEletrico = ataqueEletrico;
    }
    @Override
    public String getAtaque() {
        return ataqueEletrico;
    }
}
