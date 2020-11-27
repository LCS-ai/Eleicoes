package ui;

import java.util.InputMismatchException;

import util.Entrada;
import votacao.Votos;

public class VotosUi {
    Entrada entrada = new Entrada();
    Votos listaDeVotos = new Votos();

    public void cadastraCandidato() {
        String nome = entrada.inString("Digite o nome do candidato: ");

        if (listaDeVotos.verificaExistenciaDeCandidato(nome)) {
            System.out.println("Candidato já existe");
        }

        else {

            boolean chave = true;
            while (chave) {
                try {
                    int idade = entrada.inInt("Digite a idade de " + nome + " : ");
                    String partido = entrada.inString("Digite o partido " + nome + " : ");
                    listaDeVotos.adicionaCandidato(nome, idade, partido);
                    chave = false;
                } catch (InputMismatchException e) {
                    System.out.println("Digite somente números para idade!");
                }
            }
        }
    }

    public void votoNoCandidato() {
        boolean chave = true;
        while (chave) {
            String partido = entrada.inString("Digite o número do partido: ");
            if (listaDeVotos.votaNoCandidato(partido) == 1) {
                System.out.println("Voto computado!");
                chave = false;
            }

            else {
                System.out.println("Candidato não encontrado.");
            }
        }
    }

    public void imprimeCandidatosMaisVelho() {
        if (listaDeVotos.tamanhoDalistaDeVotos() > 0) {
            System.out.println("O candidato mais velho é: " + listaDeVotos.retornaCandidatoMaisVelho().getNome()
                    + "\nPartido: " + listaDeVotos.retornaCandidatoMaisVelho().getPartido());
        }

        else {
            System.out.println("Não há candidatos!");
        }

    }

    public void imprimeCandidatoMaisNovo() {
        if (listaDeVotos.tamanhoDalistaDeVotos() > 0) {
            System.out.println("O candidato mais novo é: " + listaDeVotos.retornaCandidatoMaisNovo().getNome()
                    + "\nPartido: " + listaDeVotos.retornaCandidatoMaisNovo().getPartido());
        }

        else {
            System.out.println("Não há candidatos!");
        }

    }

    public void imprimeApuração() {
        if (listaDeVotos.retornaTotalDeVotos() > 0) {
            listaDeVotos.ordenaListaPorVotos();
            for (int i = 0; i < listaDeVotos.tamanhoDalistaDeVotos(); i++) {
                System.out.println(
                        listaDeVotos.getCandidato(i).getNome() + "(" + listaDeVotos.getCandidato(i).getPartido() + ")"
                                + "\t" + listaDeVotos.calculaPorCentoDeVotos(listaDeVotos.getCandidato(i).getVotos())
                                + "%\t" + listaDeVotos.getCandidato(i).getVotos() + " votos");
            }
        }

        else {
            System.out.println("Não teve nenhum voto computado.");
        }
    }

    public void imprimeCandidatoMaisVotado() {
        if (listaDeVotos.candidatoMaisVotado() != null) {
            System.out.println("Candidato mais votado: " + listaDeVotos.candidatoMaisVotado().getNome() + "\nPartido: "
                    + listaDeVotos.candidatoMaisVotado().getPartido());
        }

        else if (listaDeVotos.candidatoMaisVotado() != null && listaDeVotos.retornaTotalDeVotos() == 0) {
            System.out.println("Não houve votação.");
        }

        else {
            System.out.println("Não há candidatos!");
        }

    }

    public void imprimeCandidatoMenosVotado() {
        if (listaDeVotos.candidatoMenosVotado() != null) {
            System.out.println("Candidato menos votado: " + listaDeVotos.candidatoMenosVotado().getNome()
                    + "\nPartido: " + listaDeVotos.candidatoMenosVotado().getPartido());
        }

        else if (listaDeVotos.candidatoMenosVotado() != null && listaDeVotos.retornaTotalDeVotos() == 0) {
            System.out.println("Não houve votação.");
        }

        else {
            System.out.println("Não há candidatos!");
        }

    }

    public void imprimeTotalDeVotos() {
        System.out.println("Total de votos: " + listaDeVotos.retornaTotalDeVotos());
    }

}
