package a4.exercicios.PraticaIntegradora2.Ex01;

public class PraticaExcecoes {
    private static int a = 0;
    private static int b = 300;

    public static void calcularRazao () {
        try {
            System.out.println(b/a);
        } catch (ArithmeticException e) {
//            System.out.print("Ocorreu um erro");
            throw new IllegalArgumentException("Não pode ser dividido por zero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
