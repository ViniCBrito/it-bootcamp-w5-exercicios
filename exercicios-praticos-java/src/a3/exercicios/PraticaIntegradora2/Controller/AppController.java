package a3.exercicios.PraticaIntegradora2.Controller;

import a3.exercicios.PraticaIntegradora2.Model.CircuitoModel;
import a3.exercicios.PraticaIntegradora2.Model.ParticipanteModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AppController {
    private List<CircuitoModel> categorias;
    private List<ParticipanteModel> inscricoes;

    public AppController() {
        this.categorias = new ArrayList<CircuitoModel>();
        this.inscricoes = new ArrayList<>();
    }

    public AppController(List<CircuitoModel> categorias, List<ParticipanteModel> inscricoes, int quantidadesInscricoes) {
        this.categorias = categorias;
        this.inscricoes = inscricoes;
    }

    public int adicionarCategoria(CircuitoModel categoria) {
        this.categorias.add(categoria);
        return this.categorias.lastIndexOf(categoria);
    }

    public List<CircuitoModel> listarCategorias() {
        return this.categorias;
    }

    public String inscreverParticipante(ParticipanteModel participante, int idCategoria) {
        CircuitoModel categoria = categorias.get(idCategoria);
        String mensagem;
        if(participante.getIdade() > 17) {
            mensagem = "Inscrição feita com sucesso!\n" +
                    "O valor a ser pago é " + categoria.getValorMaiorIdade();
        } else {
            if(categoria.isMenorIdadePermitida()) {
                mensagem = "Inscrição feita com sucesso!\n" +
                        "O valor a ser pago é " + categoria.getValorMenorIdade();
            } else {
                return "A inscrição não é permitida para menores de 18 anos para essa categoria.";
            }
        }
        participante.setIdCategoria(idCategoria);
        this.inscricoes.add(participante);
        mensagem += "\nO número de inscrição é " + this.inscricoes.size();
        return mensagem;
    }

    public void cancelarInscricao(int numeroInscricao) {
        ParticipanteModel participante = this.inscricoes.get(numeroInscricao-1);
        participante.setInscricaoAtiva(false);
        this.inscricoes.set(numeroInscricao-1, participante);
    }

    public List<ParticipanteModel> listarPorCategoria(int idCategoria) {
        return this.inscricoes
                        .stream()
                        .filter(x -> x.getIdCategoria() == idCategoria && x.isInscricaoAtiva())
                        . collect(Collectors.toList());
    }
}
