package a3.exercicios.PraticaIntegradora2.Controller;

import a3.exercicios.PraticaIntegradora2.Model.CircuitoModel;
import a3.exercicios.PraticaIntegradora2.Model.ParticipanteModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppController {
    private List<CircuitoModel> categorias;
    private HashMap<Integer, ParticipanteModel> inscricoes;
    private int quantidadesInscricoes;

    public AppController() {
        this.categorias = new ArrayList<CircuitoModel>();
        this.inscricoes = new HashMap<>();
        this.quantidadesInscricoes = 0;

    }

    public AppController(List<CircuitoModel> categorias, HashMap<Integer, ParticipanteModel> inscricoes, int quantidadesInscricoes) {
        this.categorias = categorias;
        this.inscricoes = inscricoes;
        this.quantidadesInscricoes = quantidadesInscricoes;
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
        quantidadesInscricoes++;
        this.inscricoes.put(quantidadesInscricoes, participante);
        return mensagem;
    }

    public void cancelarInscricao(int numeroInscricao) {
        ParticipanteModel participante = this.inscricoes.get(numeroInscricao);
        participante.setInscricaoAtiva(false);
        this.inscricoes.put(numeroInscricao, participante);
    }

    public ParticipanteModel[] listarPorCategoria(int idCategoria) {
//        ParticipanteModel[] participantes
//        for (Map.Entry<Integer, ParticipanteModel> entry : inscricoes.entrySet()) {
//            ParticipanteModel participante = entry.getValue();
//            int numeroInscricao = entry.getKey();
//        }
        return (ParticipanteModel[]) this.inscricoes.entrySet().stream().filter(x -> x.getValue().getIdCategoria() == idCategoria).toArray();
//        return this.inscricoes.values().;
    }
}
