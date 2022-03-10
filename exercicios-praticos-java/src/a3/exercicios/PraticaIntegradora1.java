package a3.exercicios;

public class PraticaIntegradora1 {
    public static void main(String[] args) {
        String[] cidades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };
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

        for (int i = 0; i < temperaturas.length; i++) {
            iTempMaisAlta = temperaturas[i][1] > temperaturas[iTempMaisAlta][1] ? i : iTempMaisAlta;
            iTempMaisBaixa = temperaturas[i][0] < temperaturas[iTempMaisBaixa][1] ? i : iTempMaisBaixa;
        }

        System.out.println("A temperatura mais alta foi em " + cidades[iTempMaisAlta] + ", com " + temperaturas[iTempMaisAlta][1] + "o C.");
        System.out.println("A temperatura mais baixa foi em " + cidades[iTempMaisBaixa] + ", com " + temperaturas[iTempMaisBaixa][0] + "o C.");
    }
}
