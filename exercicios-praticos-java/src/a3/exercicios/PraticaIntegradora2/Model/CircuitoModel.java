package a3.exercicios.PraticaIntegradora2.Model;

public class CircuitoModel {
    private String nome;
    private String descricao;
    private boolean menorIdadePermitida;
    private float valorMenorIdade;
    private float valorMaiorIdade;

    public CircuitoModel(String nome, String descricao, boolean menorIdadePermitida, float valorMenorIdade, float valorMaiorIdade) {
        this.nome = nome;
        this.descricao = descricao;
        this.menorIdadePermitida = menorIdadePermitida;
        this.valorMenorIdade = valorMenorIdade;
        this.valorMaiorIdade = valorMaiorIdade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isMenorIdadePermitida() {
        return menorIdadePermitida;
    }

    public void setMenorIdadePermitida(boolean menorIdadePermitida) {
        this.menorIdadePermitida = menorIdadePermitida;
    }

    public float getValorMenorIdade() {
        return valorMenorIdade;
    }

    public void setValorMenorIdade(float valorMenorIdade) {
        this.valorMenorIdade = valorMenorIdade;
    }

    public float getValorMaiorIdade() {
        return valorMaiorIdade;
    }

    public void setValorMaiorIdade(float valorMaiorIdade) {
        this.valorMaiorIdade = valorMaiorIdade;
    }
}
