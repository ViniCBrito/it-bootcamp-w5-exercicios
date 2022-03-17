package br.com.meli.codigomorse.models;

import br.com.meli.codigomorse.utils.MorseTranslation;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MorseModel {
    private String translation;
    private String morseCode;

    public static String translateMorseToChar(String morse) {
        for (MorseTranslation value : MorseTranslation.values()) {
            if(morse.equals(value.getMorse().getMorseCode())) {
                return value.getMorse().getTranslation();
            }
        }
        return "";
    }
}
