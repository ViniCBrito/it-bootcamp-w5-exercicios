package a3.exercicios.PraticaIntegradora2.Model;

public class ParticipanteModel {
    private String rg;
    private String nome;
    private String sobrenome;
    private int idade;
    private String celular;
    private String contatoEmergencia;
    private String grupoSanguineo;
    private boolean inscricaoAtiva;
    private int idCategoria;


    public ParticipanteModel(String rg, String nome, String sobrenome, int idade, String celular, String contatoEmergencia, String grupoSanguineo) {
        this.rg = rg;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.celular = celular;
        this.contatoEmergencia = contatoEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.inscricaoAtiva = true;
    }

    public String getRg() {
        return rg;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCelular() {
        return celular;
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public boolean isInscricaoAtiva() {
        return inscricaoAtiva;
    }

    public void setInscricaoAtiva(boolean inscricaoAtiva) {
        this.inscricaoAtiva = inscricaoAtiva;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "Participante {" +
                "rg='" + rg + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", idade=" + idade +
                ", celular='" + celular + '\'' +
                ", contatoEmergencia='" + contatoEmergencia + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                ", inscricaoAtiva=" + inscricaoAtiva +
                ", idCategoria=" + idCategoria +
                '}';
    }
}
