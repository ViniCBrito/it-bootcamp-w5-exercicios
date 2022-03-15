package a5.exercicios.PraticaIntegradora1.Ex02.document_types;

import a5.exercicios.PraticaIntegradora1.Ex02.Printable;

public class Curriculo implements Printable {
    private String pessoa;
    private String habilidades;

    public Curriculo(String pessoa, String habilidades) {
        this.pessoa = pessoa;
        this.habilidades = habilidades;
    }

    public String getPessoa() {
        return pessoa;
    }

    public String getHabilidades() {
        return habilidades;
    }

    @Override
    public String toString() {
        return "Curriculo {" +
                "pessoa='" + pessoa + '\'' +
                ", habilidades='" + habilidades + '\'' +
                '}';
    }
}
