package a6.exercicios.PraticaIntegradora1_2.Listas;

import a6.exercicios.PraticaIntegradora1_2.Model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListaItem implements Operacional<Item, String>{
    private List<Item> itens;
    private int seqCodigo;

    public ListaItem() {
        itens = new ArrayList<>();
        seqCodigo = 0;
    }

    public List<Item> getItens() {
        return itens;
    }

    public int getSeqCodigo() {
        return seqCodigo;
    }

    @Override
    public String cadastrar(Item o) {
        String novoCod = "ITM" + seqCodigo++;
        itens.add(new Item(o.getNome(), o.getQtdeComprada(), o.getPrecoUnitario(), novoCod));
        return novoCod;
    }

    @Override
    public Item consultar(String id) {
        Optional<Item> any = itens.stream().filter(x -> x.getCodigo().equals(id)).findAny();
        return any.orElse(null);
    }

    @Override
    public boolean apagar(String id) {
        Item item = this.consultar(id);
        if(item == null) { return false; }
        return itens.remove(item);
    }

    @Override
    public boolean atualizar(Item o) {
        Item item = this.consultar(o.getCodigo());
        int i = itens.lastIndexOf(item);
        return i > -1 && itens.set(i, o) != null;
    }

    public void listarTodos() {
        itens.forEach(System.out::println);
    }
}
