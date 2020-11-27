package votacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import candidato.Candidato;
import ordenacao.OrdemVotacao;
import ordenacao.OrdenacaoPorIdade;

public class Votos {

    private List<Candidato> votacao;
    private int totalDeVotos = 0;

    public Votos() {
        votacao = new ArrayList<>();
    }

    public int tamanhoDalistaDeVotos() {
        return votacao.size();
    }

    public Candidato getCandidato(int i) {
        return votacao.get(i);
    }

    public int retornaTotalDeVotos() {
        return totalDeVotos;
    }

    public void adicionaCandidato(String nome, int idade, String partido) {
        votacao.add(new Candidato(nome, idade, partido));
    }

    public Candidato retornaCandidatoMaisVelho() {
        OrdenacaoPorIdade ordemPorIdade = new OrdenacaoPorIdade();
        Collections.sort(votacao, ordemPorIdade);
        return votacao.get(0);
    }

    public Candidato retornaCandidatoMaisNovo() {
        OrdenacaoPorIdade ordemPorIdade = new OrdenacaoPorIdade();
        Collections.sort(votacao, ordemPorIdade);
        return votacao.get(votacao.size() - 1);
    }

    public Candidato candidatoMaisVotado() {
        if (votacao.size() > 0) {
            OrdemVotacao ordemPorVotacao = new OrdemVotacao();
            Collections.sort(votacao, ordemPorVotacao);
            return votacao.get(0);
        }
        return null;

    }

    public Candidato candidatoMenosVotado() {
        if (votacao.size() > 0) {
            OrdemVotacao ordemPorVotacao = new OrdemVotacao();
            Collections.sort(votacao, ordemPorVotacao);
            return votacao.get(votacao.size() - 1);
        }
        return null;
    }

    public void ordenaListaPorVotos(){
        OrdemVotacao ordemPorVotacao = new OrdemVotacao();
        Collections.sort(votacao, ordemPorVotacao);
    }

    public int calculaPorCentoDeVotos(int votosDoCandidato) {
        int porCentagemDeVotosDoCandidato = ((votosDoCandidato * 100) / totalDeVotos);
        return porCentagemDeVotosDoCandidato;
    }

    public int votaNoCandidato(String partido) {
        int j = 0;
        if (verificaExistenciaDoPartido(partido)) {
            for (int i = 0; i < votacao.size(); i++) {
                if (votacao.get(i).getPartido().equals(partido)) {
                    votacao.get(i).vota();
                    totalDeVotos = totalDeVotos + 1;
                    j = 1;
                    break;
                }
            }
        }
        return j;
    }

    public boolean verificaExistenciaDeCandidato(String nome) {
        for (int i = 0; i < votacao.size(); i++) {
            if (votacao.get(i).getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificaExistenciaDoPartido(String partido) {
        for (int i = 0; i < votacao.size(); i++) {
            if (votacao.get(i).getPartido().equals(partido)) {
                return true;
            }
        }
        return false;
    }

}
