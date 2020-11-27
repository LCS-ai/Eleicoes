package ordenacao;

import java.util.Comparator;

import candidato.Candidato;

public class OrdenacaoPorIdade implements Comparator<Candidato> {
    public int compare(Candidato candidato1, Candidato candidato2) {
        if (candidato1.getIdade() < candidato2.getIdade())
            return 1;
        if (candidato1.getIdade() > candidato2.getIdade())
            return -1;
        else
            return 0;
    }
}