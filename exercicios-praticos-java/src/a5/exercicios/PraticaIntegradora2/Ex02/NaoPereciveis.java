package a5.exercicios.PraticaIntegradora2.Ex02;

public class NaoPereciveis extends Produto {
    private String tipo;

    public NaoPereciveis(String nome, double preco, String tipo) {
        super(nome, preco);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Produto {" +
                "nome='" + super.getNome() + '\'' +
                ", preco=" + super.getPreco() +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
