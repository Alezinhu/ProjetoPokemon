package Model;

public class Normal extends Pokemon implements Ataque{

    String ataqueNormal;

    public Normal(String nome, String tipo, int nivel, int peso,String ataqueNormal) {
        super(nome, tipo, nivel, peso);
        this.ataqueNormal = ataqueNormal;


    }
    @Override
    public String getAtaque() {
        return "Investida rapida";
    }

}
