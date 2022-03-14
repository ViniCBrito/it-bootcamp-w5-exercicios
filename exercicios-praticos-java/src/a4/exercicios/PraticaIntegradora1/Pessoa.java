package a4.exercicios.PraticaIntegradora1;

public class Pessoa {
    private String nome;
    private int idade;
    private String ID;
    private int peso;
    private double altura;

    public Pessoa() {
    }

    public Pessoa(String nome, int idade, String ID) {
        this.nome = nome;
        this.idade = idade;
        this.ID = ID;
    }

    public Pessoa(String nome, int idade, String ID, int peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.ID = ID;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = peso/(altura*altura);
        if (imc > 20) {
            if (imc > 25) {
                System.out.println("Sobrepeso.");
                return 1;
            } else {
                System.out.println("Peso saudável.");
                return 0;
            }
        } else {
            System.out.println("Abaixo do peso.");
            return -1;
        }
    }

    public boolean ehMaioridade() {
        return this.idade > 17;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", ID='" + ID + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
