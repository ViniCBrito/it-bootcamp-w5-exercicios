package a4.exercicios.PraticaIntegradora2.Ex02;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();

        produtos.add(new Pereciveis("Queijo", 49.90, 2));
        produtos.add(new Pereciveis("Leite", 3.50, 15));
        produtos.add(new Pereciveis("Pao", 5.99, 1));
        produtos.add(new NaoPereciveis("Prego", 2.5, "Construcao"));
        produtos.add(new NaoPereciveis("Martelo", 20, "Construcao"));
        produtos.add(new NaoPereciveis("Caderno", 8.50, "Papelaria"));

        System.out.println(produtos.toString());
        for (Produto produto: produtos) {
            System.out.println(produto.toString());
            System.out.println("Valor total para 5 unidades: " + produto.calcular(5));
            System.out.println("------------");
        }
    }
}
