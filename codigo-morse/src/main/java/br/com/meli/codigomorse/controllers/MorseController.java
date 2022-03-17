package br.com.meli.codigomorse.controllers;

import br.com.meli.codigomorse.models.MorseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @GetMapping
    public String ping() {
        return "pong";
    }

    @GetMapping("/translateMorse")
    public MorseModel getTranslation(@RequestParam String morseCode) {
        String translation = "";
        String palavra = "";
        String caractere = "";
        int espacos = 0;

        for (int i = 0; i < morseCode.length(); i++) {
            String simbolo = morseCode.substring(i, i+1);
            if (simbolo.equals(" ")){
                espacos++;
                simbolo = "";
            } else if(espacos != 0) {
                if(espacos == 1) {
                    palavra = palavra.concat(MorseModel.translateMorseToChar(caractere));
                    caractere = "";
                    espacos = 0;
                } else if(espacos >= 3) {
                    palavra = palavra.concat(MorseModel.translateMorseToChar(caractere));
                    translation = translation.concat(palavra).concat(" ");
                    palavra= "";
                    caractere = "";
                    espacos = 0;
                }
            }
            caractere = caractere.concat(simbolo);
        }
        palavra = palavra.concat(MorseModel.translateMorseToChar(caractere));
        translation = translation.concat(palavra);

        return new MorseModel(translation, morseCode);

//        Retornos:
//        {"translation":"--- .-.. .-","morseCode":"OLA"}
//        {"translation":"-- . .-. -.-. .- -.. ---   .-.. .. ...- .-. .","morseCode":"MERCADO LIVRE"}
//        {"translation":"... .--. .-. .. -. --.","morseCode":"SPRING"}

    }
}
