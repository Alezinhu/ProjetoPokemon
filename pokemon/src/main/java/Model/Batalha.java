package Model;

public class Batalha implements BatalhaEfeitos {
    private int idArena;
    private int idJogador;

    public Batalha(int idArena, int idJogador) {
        this.idArena = idArena;
        this.idJogador = idJogador;
    }

    public int getIdArena() {
        return idArena;
    }

    public int getIdJogador() {
        return idJogador;
    }

    // Implementação dos métodos da interface
    @Override
    public void ataqueBasico() {
        System.out.println("Realizando ataque básico...");
        // Implemente o código para o ataque básico aqui
    }

    @Override
    public void habilidadeEspecial() {
        System.out.println("Usando habilidade especial...");
        // Implemente o código para a habilidade especial aqui
    }
}