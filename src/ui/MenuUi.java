package ui;

import java.util.InputMismatchException;

import util.Entrada;

public class MenuUi {

    VotosUi votacao = new VotosUi();
    Entrada entrada = new Entrada();

    public void menuUi() {
        boolean chave = true;
        while (chave) {
            try {
                int opcao = entrada.inInt(
                        "=====================================\n[1] cadastro de candidato\n[2] voto\n[3] imprime apuração\n[4] imprime candidato mais velho\n[5] imprime candidato mais novo\n[6] imprime candidato mais votado\n[7] imprime candidato menos votado\n[8] sair\n=====================================");
                switch (opcao) {
                    case 1:
                        votacao.cadastraCandidato();
                        break;

                    case 2:
                        votacao.votoNoCandidato();
                        break;

                    case 3:
                        votacao.imprimeApuração();
                        break;

                    case 4:
                        votacao.imprimeCandidatosMaisVelho();
                        break;

                    case 5:
                        votacao.imprimeCandidatoMaisNovo();
                        break;

                    case 6:
                        votacao.imprimeCandidatoMaisVotado();
                        break;

                    case 7:
                        votacao.imprimeCandidatoMenosVotado();
                        break;

                    case 8:
                        chave = false;
                        break;

                    case 9:
                        votacao.imprimeTotalDeVotos();

                    default:
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Dígito incorreto.");
            }

        }

    }
}
