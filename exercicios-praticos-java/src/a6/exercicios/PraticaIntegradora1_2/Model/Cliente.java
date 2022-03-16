package a6.exercicios.PraticaIntegradora1_2.Model;

public class Cliente {
    private String id;
    private String nome;
    private String sobrenome;

    public Cliente(String nome, String sobrenome, String id) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Cliente(String nome, String sobrenome) {
        this.id = "";
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                '}';
    }
}
