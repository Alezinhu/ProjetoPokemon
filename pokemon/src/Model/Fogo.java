package Model;

public class Fogo extends Pokemon implements Ataque{

    String ataqueFogo;
    public Fogo(String nome, String tipo, int nivel, int peso,String ataqueFogo) {
        super(nome, tipo, nivel, peso);
        this.ataqueFogo = ataqueFogo;


    }

    @Override
    public String getAtaque() {
        return "Explosao de lava";
    }
}
