package br.com.meli.starwarschars.controller;

import br.com.meli.starwarschars.dto.DetailedPersonagemDTO;
import br.com.meli.starwarschars.dto.PersonagemDTO;
import br.com.meli.starwarschars.entity.Personagem;
import br.com.meli.starwarschars.service.SWCharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CharactersController {

    @Autowired
    private SWCharactersService swchars;

    @PostMapping("/characters")
    public ResponseEntity<List<PersonagemDTO>> addCharacters(@RequestBody List<DetailedPersonagemDTO> personagens) {
        List<Personagem> newPersonagens = personagens.stream().map(DetailedPersonagemDTO::convertTo).collect(Collectors.toList());
        swchars.add(newPersonagens);
        List<PersonagemDTO> formattedPersonagens = newPersonagens.stream().map(x -> new PersonagemDTO().convertFrom(x)).collect(Collectors.toList());
        URI createdURI = URI.create("/characters");
        return ResponseEntity.created(createdURI).body(formattedPersonagens);
    }

    @GetMapping("/characters")
    public ResponseEntity<List<PersonagemDTO>> listCharacters(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
        List<Personagem> personagens = swchars.listFromName(name);
        List<PersonagemDTO> formattedPersonagens = personagens.stream().map(x -> new PersonagemDTO().convertFrom(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(formattedPersonagens);
    }
}
