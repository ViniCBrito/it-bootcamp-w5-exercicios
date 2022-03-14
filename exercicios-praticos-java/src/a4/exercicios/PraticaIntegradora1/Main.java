package a4.exercicios.PraticaIntegradora1;

public class Main {
    public static void main(String[] args) {
        Pessoa kenyo = new Pessoa();
        Pessoa mauri = new Pessoa();
        Pessoa vinicius = new Pessoa("Vinicius", 22, "1", 62, 1.76);

        System.out.println(vinicius.calcularIMC());
        System.out.println(vinicius.ehMaioridade());
        System.out.println(vinicius.toString());
    }
}
