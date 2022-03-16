package a6.exercicios.PraticaIntegradora1_2.Listas;

public interface Operacional<T, U> {
    U cadastrar(T o);
    T consultar(U id);
    boolean apagar(U id);
    boolean atualizar(T o);
}
