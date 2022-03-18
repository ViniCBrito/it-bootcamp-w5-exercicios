package br.com.meli.idade;

import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDate;

@RestController
@RequestMapping("/")
public class IdadeController {

    @GetMapping("/{dia}/{mes}/{ano}")
    public Integer calcularIdadeEmAnos(@PathVariable(name = "dia") Integer dia,
                                      @PathVariable(name = "mes") Integer mes,
                                      @PathVariable(name = "ano") Integer ano) {
        if (dia != null && mes != null && ano !=null) {
            try {
                LocalDate idade = LocalDate.of(ano, mes, dia);
                return idade.until(LocalDate.now()).getYears();
            } catch (DateTimeException ex) {
                return null;
            }
        }
        return null;
    }
}
