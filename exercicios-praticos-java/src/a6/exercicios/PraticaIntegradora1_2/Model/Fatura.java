package a6.exercicios.PraticaIntegradora1_2.Model;

import java.math.BigDecimal;
import java.util.List;

public class Fatura {
    private Cliente cliente;
    private List<Item> itens;
    private BigDecimal totalCompra = BigDecimal.valueOf(0);

    public Fatura(Cliente cliente, List<Item> itens) {
        this.cliente = cliente;
        this.itens = itens;
        for (Item item : itens) {
            BigDecimal totalMulti = item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQtdeComprada()));
            this.totalCompra = this.totalCompra.add(totalMulti);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public BigDecimal getTotalCompra() {
        return totalCompra;
    }

    @Override
    public String toString() {
        return "Fatura {" +
                "cliente=" + cliente +
                ", item=" + itens +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
