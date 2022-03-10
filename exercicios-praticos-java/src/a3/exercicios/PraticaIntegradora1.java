package a3.exercicios;

public class PraticaIntegradora1 {
    public static void main(String[] args) {
        String[] cidades = {"Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"};
        int[][] temperaturas = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        int iTempMaisAlta = 0, iTempMaisBaixa = 0;
        int tempMaisAlta = temperaturas[0][1], tempMaisBaixa = temperaturas[0][0];

        for (int i = 0; i < temperaturas.length; i++) {
            if(temperaturas[i][1] > tempMaisAlta) {
                tempMaisAlta = temperaturas[i][1];
                iTempMaisAlta = i;
            }

            if(temperaturas[i][0] < tempMaisBaixa) {
                tempMaisBaixa = temperaturas[i][0];
                iTempMaisBaixa = i;
            }
        }

        System.out.println("A temperatura mais alta foi em " + cidades[iTempMaisAlta] + ", com " + temperaturas[iTempMaisAlta][1] + "o C.");
        System.out.println("A temperatura mais baixa foi em " + cidades[iTempMaisBaixa] + ", com " + temperaturas[iTempMaisBaixa][0] + "o C.");
    }
}
