package a5.exercicios.PraticaIntegradora1.Ex03;

public class Main {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        cachorro.emitirSom();
        gato.emitirSom();
        vaca.emitirSom();

        cachorro.comerCarne();
        gato.comerCarne();
        vaca.comerPasto();

        cachorro.comerAnimal();
        gato.comerAnimal();
        vaca.comerAnimal();
    }
}
