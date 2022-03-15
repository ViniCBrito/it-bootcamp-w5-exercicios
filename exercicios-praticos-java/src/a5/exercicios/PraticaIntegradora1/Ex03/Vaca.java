package a5.exercicios.PraticaIntegradora1.Ex03;

public class Vaca extends Animal implements Herbivoro {
    @Override
    public void emitirSom() {
        System.out.println("Muuuu.");
    }

    @Override
    public void comerPasto() {
        System.out.println("Vaca está comendo pasto!");
    }

    @Override
    public void comerAnimal() {
        this.comerPasto();
    }
}
