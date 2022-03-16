package a6.exercicios.PraticaIntegradora1_2;

import a6.exercicios.PraticaIntegradora1_2.Listas.ListaCliente;
import a6.exercicios.PraticaIntegradora1_2.Listas.ListaItem;
import a6.exercicios.PraticaIntegradora1_2.Model.Cliente;
import a6.exercicios.PraticaIntegradora1_2.Model.Fatura;
import a6.exercicios.PraticaIntegradora1_2.Model.Item;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaCliente clientes = new ListaCliente();
        ListaItem itens = new ListaItem();
        Scanner in = new Scanner(System.in);

        System.out.println("Criando clientes...");
        Cliente cliente1 = new Cliente("Vinicius", "Brito");
        Cliente cliente2 = new Cliente("Joao", "Brito");
        Cliente cliente3 = new Cliente("Paulo", "Brito");
        System.out.println("Clientes criados:");
        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);
        System.out.println("-------------");

        System.out.println("Cadastrando clientes...");
        String id1 = clientes.cadastrar(cliente1);
        System.out.println("Cliente: ".concat(cliente1.getNome().concat(" | ID: ").concat(id1)));
        String id2 = clientes.cadastrar(cliente2);
        System.out.println("Cliente: ".concat(cliente2.getNome().concat(" | ID: ").concat(id2)));
        String id3 = clientes.cadastrar(cliente3);
        System.out.println("Cliente: ".concat(cliente3.getNome().concat(" | ID: ").concat(id3)));
        System.out.println("-------------");

        System.out.println("Clientes cadastrados: ");
        clientes.listarTodos();
        System.out.println("-------------");

        System.out.println("Excluindo cliente de ID: ".concat(id2));
        System.out.println(clientes.apagar(id2) ? "Cliente excluído com sucesso." : "Não foi possível excluir o cliente.");
        System.out.println("Clientes cadastrados: ");
        clientes.listarTodos();
        System.out.println("-------------");


        System.out.println("Digite o ID de um cliente para consultá-lo:");
        String idCliente = in.next();
        Cliente resultado = clientes.consultar(idCliente);
        System.out.println(resultado != null ? "Cliente encontrado: ".concat(resultado.toString()) : "Cliente não encontrado.");
        System.out.println("-------------");

        System.out.println("Criando itens");
        Item item1 = new Item("Batata", 2, BigDecimal.valueOf(3));
        Item item2 = new Item("Cenoura", 5, BigDecimal.valueOf(2.99));
        Item item3 = new Item("Alface", 1, BigDecimal.valueOf(9.50));
        System.out.println("Itens criados:");
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println("Adicionando produtos na lista");
        System.out.println("Resultado: " + itens.cadastrar(item1));
        System.out.println("Resultado: " + itens.cadastrar(item2));
        System.out.println("Resultado: " + itens.cadastrar(item3));
        System.out.println("Listando produtos na lista:");
        itens.listarTodos();
        System.out.println("-------------");

        System.out.println("Criando uma fatura");
        Fatura fat = new Fatura(clientes.consultar(idCliente), itens.getItens());
        System.out.println("Fatura: " + fat);
    }
}
