package a5.exercicios.PraticaIntegradora1.Ex02.document_types;

import a5.exercicios.PraticaIntegradora1.Ex02.Printable;

public class Livro implements Printable {
    private int numPaginas;
    private String nomeAutor;
    private String titulo;
    private String genero;

    public Livro(int numPaginas, String nomeAutor, String titulo, String genero) {
        this.numPaginas = numPaginas;
        this.nomeAutor = nomeAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Livro {" +
                "numPaginas=" + numPaginas +
                ", nomeAutor='" + nomeAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
