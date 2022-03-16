package a6.exercicios.PraticaIntegradora1_2.Model;

import java.math.BigDecimal;

public class Item {
    private String codigo;
    private String nome;
    private int qtdeComprada;
    private BigDecimal precoUnitario;

    public Item(String nome, int qtdeComprada, BigDecimal precoUnitario, String codigo) {
        this.codigo = codigo;
        this.nome = nome;
        this.qtdeComprada = qtdeComprada;
        this.precoUnitario = precoUnitario;
    }

    public Item(String nome, int qtdeComprada, BigDecimal precoUnitario) {
        this.codigo = "";
        this.nome = nome;
        this.qtdeComprada = qtdeComprada;
        this.precoUnitario = precoUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getQtdeComprada() {
        return qtdeComprada;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    @Override
    public String toString() {
        return "Item {" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", qtdeComprada='" + qtdeComprada + '\'' +
                ", precoUnitario=" + precoUnitario +
                '}';
    }
}
