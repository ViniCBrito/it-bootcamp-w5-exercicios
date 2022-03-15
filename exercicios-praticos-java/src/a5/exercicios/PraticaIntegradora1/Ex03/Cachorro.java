package a5.exercicios.PraticaIntegradora1.Ex03;

public class Cachorro extends Animal implements Carnivoro{
    @Override
    public void emitirSom() {
        System.out.println("Auau.");
    }

    @Override
    public void comerCarne() {
        System.out.println("Cachorro está comendo carne!");
    }

    @Override
    public void comerAnimal() {
        this.comerCarne();
    }
}
