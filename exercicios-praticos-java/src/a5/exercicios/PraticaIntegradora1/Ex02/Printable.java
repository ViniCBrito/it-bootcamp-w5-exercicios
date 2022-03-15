package a5.exercicios.PraticaIntegradora1.Ex02;

public interface Printable {
    String toString();
    static void print(Printable p) {
        System.out.println(p.toString());
    }
}
