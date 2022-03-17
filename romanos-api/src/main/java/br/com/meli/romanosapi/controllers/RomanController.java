package br.com.meli.romanosapi.controllers;

import br.com.meli.romanosapi.models.RomanModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/romano")
    public RomanModel calculaRomano(@RequestParam(value = "decimal", defaultValue = "") String decimal) {
        int intDecimal;
        try {
            intDecimal = Integer.parseInt(decimal);
        } catch (NumberFormatException ex) {
            return new RomanModel(0, "Número inválido.");
        }
        int[] valores = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] algarismoRomano = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        String romano = new String();

        for(int i=0;i<valores.length;i++) {
            while(intDecimal >= valores[i]) {
                intDecimal -= valores[i];
                romano = romano.concat(algarismoRomano[i]);
            }
        }

        return new RomanModel(intDecimal, romano);
    }
}
