package br.com.meli.starwarschars.dto;

import br.com.meli.starwarschars.entity.Personagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonagemDTO implements ISWCharDTO<Personagem, PersonagemDTO> {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    @Override
    public Personagem convertTo() {
        return new Personagem(this.name,
                this.height,
                this.mass,
                "",
                "",
                "",
                "",
                this.gender,
                this.homeworld,
                this.species);
    }

    @Override
    public PersonagemDTO convertFrom(Personagem character) {
        this.name = character.getName();
        this.height = character.getHeight();
        this.mass = character.getMass();
        this.gender = character.getGender();
        this.homeworld = character.getHomeworld();
        this.species = character.getSpecies();
        return this;
    }
}
