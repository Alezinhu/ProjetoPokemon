package Model;

public class Grama extends Pokemon implements Ataque {

    String ataqueGrama;

    public Grama(String nome, String tipo, int nivel, int peso,String ataqueGrama) {
        super(nome, tipo, nivel, peso);
        this.ataqueGrama = ataqueGrama;
    }

    @Override
    public String getAtaque() {
        return "Chicote Selvagem";
    }
}
