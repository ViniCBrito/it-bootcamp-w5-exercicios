package a5.exercicios.PraticaIntegradora1.Ex02.document_types;

import a5.exercicios.PraticaIntegradora1.Ex02.Printable;

public class Relatorio implements Printable {
    private String texto;
    private int numPaginas;
    private String autor;
    private String revisor;

    public Relatorio(String texto, int numPaginas, String autor, String revisor) {
        this.texto = texto;
        this.numPaginas = numPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public String getRevisor() {
        return revisor;
    }

    @Override
    public String toString() {
        return "Relatorio {" +
                "texto='" + texto + '\'' +
                ", numPaginas=" + numPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
