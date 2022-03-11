package a3.exercicios.PraticaIntegradora2.View;

import a3.exercicios.PraticaIntegradora2.Controller.AppController;
import a3.exercicios.PraticaIntegradora2.Model.CircuitoModel;
import a3.exercicios.PraticaIntegradora2.Model.ParticipanteModel;

import java.util.List;
import java.util.Scanner;

public class AppView {
    AppController app = new AppController();

    public void start() {
        CircuitoModel circPequeno = new CircuitoModel("Circuito pequeno", "2 km pela selva e riachos.", true, 1300, 1500);
        CircuitoModel circMedio = new CircuitoModel("Circuito médio", "5 km pela selva, riachos e lama.", true, 2000, 2300);
        CircuitoModel circAvancado = new CircuitoModel("Circuito Avançado", "10 km pela selva, riachos, lama e escalada.", false, 0, 2800);

        this.app.adicionarCategoria(circPequeno);
        this.app.adicionarCategoria(circMedio);
        this.app.adicionarCategoria(circAvancado);

        Scanner in = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("--------------------------------------");
            System.out.println("-------- Selecione uma opção: --------");
            System.out.println("- 1. Inscrever participante          -");
            System.out.println("- 2. Cancelar participante           -");
            System.out.println("- 3. Ver os inscritos por categoria  -");
            System.out.println("-                                    -");
            System.out.println("- 0. Sair                            -");
            System.out.println("--------------------------------------");
            System.out.print("Opção: ");
            try {
                opcao = in.nextInt();
            } catch (Exception e) {
                System.out.println("Não foi possível encontrar a opção informada.");
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    inscreverParticipante();
                    break;
                case 2:
                    cancelarParticipante();
                    break;
                case 3:
                    listarInscritos();
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

    private void inscreverParticipante() {
        String rg;
        String nome;
        String sobrenome;
        int idade;
        String celular;
        String contatoEmergencia;
        String grupoSanguineo;
        int idCategoria;
        Scanner inInteger = new Scanner(System.in);
        Scanner inString = new Scanner(System.in);

        System.out.println("--------------------------------------");
        System.out.println("-------- Escolha a categoria: --------");
        System.out.println("-                                    -");

        List<CircuitoModel> categorias = this.app.listarCategorias();
        for (int i = 0; i < categorias.size(); i++) {
            CircuitoModel categoria = categorias.get(i);
            System.out.println("- " + (i+1) + ". " + categoria.getNome());
            System.out.println("-     " + categoria.getDescricao());
            System.out.println("-                                    -");
        }

        try {
            System.out.print("Opção: ");
            idCategoria = inInteger.nextInt() - 1;

            System.out.println("--------------------------------------");
            System.out.println("--------- Preencha os dados: ---------");
            System.out.println("-                                    -");
            System.out.print("- RG: ");
            rg = inString.next();
            System.out.print("- Nome: ");
            nome = inString.next();
            System.out.print("- Sobrenome: ");
            sobrenome = inString.next();
            System.out.print("- Idade: ");
            idade = inInteger.nextInt();
            System.out.print("- Celular: ");
            celular = inString.next();
            System.out.print("- Contato de Emergência: ");
            contatoEmergencia = inString.next();
            System.out.print("- Grupo Sanguíneo: ");
            grupoSanguineo = inString.next();
            ParticipanteModel novoParticipante = new ParticipanteModel(rg, nome, sobrenome, idade, celular, contatoEmergencia, grupoSanguineo);

            System.out.println("-                                    -");
            System.out.println(this.app.inscreverParticipante(novoParticipante, idCategoria));
        } catch (Exception e) {
            System.out.println("Não foi possível completar a inscrição.");
            System.out.println("Verifique os dados informados e refaça a operação.");
        }

    }

    private void cancelarParticipante() {
        int inscricao;
        Scanner inInteger = new Scanner(System.in);

        System.out.println("--------------------------------------");
        System.out.println("-------- Informe a inscrição: --------");
        System.out.println("-                                    -");

        try {
            System.out.print("Nª: ");
            inscricao = inInteger.nextInt();

            this.app.cancelarInscricao(inscricao);
            System.out.println("Cancelamento realizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Não foi possível completar o cancelamento.");
            System.out.println("Verifique os dados informados e refaça a operação.");
        }
    }

    private void listarInscritos() {
        int idCategoria;
        ParticipanteModel[] inscritos = {};
        Scanner inInteger = new Scanner(System.in);

        System.out.println("--------------------------------------");
        System.out.println("-------- Escolha a categoria: --------");
        System.out.println("-                                    -");

        List<CircuitoModel> categorias = this.app.listarCategorias();
        for (int i = 0; i < categorias.size(); i++) {
            CircuitoModel categoria = categorias.get(i);
            System.out.println("- " + (i+1) + ". " + categoria.getNome());
            System.out.println("-     " + categoria.getDescricao());
            System.out.println("-                                    -");
        }

        // TODO: Corrigir o retorno do método "listarPorCategoria" e implementar corretamente.
        try {
            System.out.print("Opção: ");
            idCategoria = inInteger.nextInt() - 1;

            System.out.println("-                                    -");

            inscritos = this.app.listarPorCategoria(idCategoria);
        } catch (Exception e) {
            System.out.println("Não foi possível encontrar a categoria informada.");
            System.out.println("Verifique os dados informados e refaça a operação.");
        }

        System.out.println(inscritos.toString());
    }
}
