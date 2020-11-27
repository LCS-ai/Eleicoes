package candidato;

public class Candidato implements Comparable<Candidato> {
    private String nome;
    private int idade;
    private String partido;
    private int votos;

    public int compareTo(Candidato candidato) {
        if (this.idade > candidato.getIdade()) {
            return -1;
        } else if (this.idade < candidato.getIdade()) {
            return 1;
        }
        return 0;
    }

    public Candidato(String nome, int idade, String partido) {
        this.nome = nome;
        this.idade = idade;
        this.partido = partido;
        this.votos = 0;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getPartido() {
        return this.partido;
    }

    public int getVotos() {
        return this.votos;
    }

    public void vota() {
        this.votos = this.votos + 1;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nIdade: " + getIdade() + "\nPartido: " + getPartido() + "\nVotos: "
                + getVotos();
    }

}
