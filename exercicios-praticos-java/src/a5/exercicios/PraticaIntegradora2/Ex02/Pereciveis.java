package a5.exercicios.PraticaIntegradora2.Ex02;

public class Pereciveis extends Produto {
    private int diasParaVencer;

    public Pereciveis(String nome, double preco, int diasParaVencer) {
        super(nome, preco);
        this.diasParaVencer = diasParaVencer;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public void setDiasParaVencer(int diasParaVencer) {
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public String toString() {
        return "Produto {" +
                "nome='" + super.getNome() + '\'' +
                ", preco=" + super.getPreco() +
                ", diasParaVencer=" + diasParaVencer +
                '}';
    }

    @Override
    public double calcular(int quantidadeDeProdutos) {
        double valor = super.calcular(quantidadeDeProdutos);
        switch (diasParaVencer) {
            case 3:
                valor/=2;
                break;
            case 2:
                valor/=3;
                break;
            case 1:
                valor/=4;
                break;
            default:
                break;
        }
        return valor;
    }
}
