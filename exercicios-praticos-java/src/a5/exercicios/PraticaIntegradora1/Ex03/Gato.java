package a5.exercicios.PraticaIntegradora1.Ex03;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSom() {
        System.out.println("Miau.");
    }

    @Override
    public void comerCarne() {
        System.out.println("Gato está comendo carne!");
    }

    @Override
    public void comerAnimal() {
        this.comerCarne();
    }
}
