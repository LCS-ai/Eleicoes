package ordenacao;

import java.util.Comparator;

import candidato.Candidato;

public class OrdemVotacao implements Comparator<Candidato> {
    public int compare(Candidato candidato1, Candidato candidato2) {
        if (candidato1.getVotos() < candidato2.getVotos())
            return 1;
        if (candidato1.getVotos() > candidato2.getVotos())
            return -1;
        else
            return 0;
    }
}
