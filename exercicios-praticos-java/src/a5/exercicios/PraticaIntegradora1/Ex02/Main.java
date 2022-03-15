package a5.exercicios.PraticaIntegradora1.Ex02;

import a5.exercicios.PraticaIntegradora1.Ex02.document_types.Curriculo;
import a5.exercicios.PraticaIntegradora1.Ex02.document_types.Livro;
import a5.exercicios.PraticaIntegradora1.Ex02.document_types.Relatorio;

public class Main {
    public static void main(String[] args) {
        Curriculo vinicius = new Curriculo("Vinicius 22 anos", "Programo em Java :)");
        Livro livro = new Livro(33, "Vinicius", "Livro do Vinicius", "Terror");
        Relatorio relatorio = new Relatorio("Relatório completo sobre nada", 1, "Vinicius", "Vinicius");

        System.out.println("Teste --------------");
        Printable.print(vinicius);
        Printable.print(livro);
        Printable.print(relatorio);
        System.out.println("--------------------");
    }
}
