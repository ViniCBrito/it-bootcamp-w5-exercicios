package a6.exercicios.PraticaIntegradora1_2.Listas;

import a6.exercicios.PraticaIntegradora1_2.Model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListaCliente implements Operacional<Cliente, String> {
    private List<Cliente> clientes;
    private int seqId;

    public ListaCliente() {
        clientes = new ArrayList<>();
        seqId = 0;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public int getSeqId() {
        return seqId;
    }

    @Override
    public String cadastrar(Cliente o) {
        String newId = "CLI" + seqId++;
        clientes.add(new Cliente(o.getNome(), o.getSobrenome(), newId));
        return newId;
    }

    @Override
    public Cliente consultar(String id) {
        Optional<Cliente> any = clientes.stream().filter(x -> x.getId().equals(id)).findAny();
        return any.orElse(null);
    }

    @Override
    public boolean apagar(String id) {
        Cliente cliente = this.consultar(id);
        if (cliente == null) { return false; }
        return clientes.remove(cliente);
    }

    @Override
    public boolean atualizar(Cliente o) {
        Cliente cliente = this.consultar(o.getId());
        int i = clientes.lastIndexOf(cliente);
        return i > -1 && clientes.set(i, o) != null;
    }

    public void listarTodos() {
        clientes.forEach(System.out::println);
    }
}
