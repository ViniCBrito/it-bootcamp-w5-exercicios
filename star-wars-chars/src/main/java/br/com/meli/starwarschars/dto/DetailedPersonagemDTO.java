package br.com.meli.starwarschars.dto;

import br.com.meli.starwarschars.entity.Personagem;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedPersonagemDTO implements ISWCharDTO<Personagem, DetailedPersonagemDTO> {
    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

    @Override
    public Personagem convertTo() {
        Integer height;
        Integer mass;

        try {
            height = Integer.valueOf(this.height);
        } catch (NumberFormatException ex) {
            height = null;
        }
        try {
            mass = Integer.valueOf(this.mass);
        } catch (NumberFormatException ex) {
            mass = null;
        }

        return new Personagem(this.name,
                height,
                mass,
                this.hairColor,
                this.skinColor,
                this.eyeColor,
                this.birthYear,
                this.gender,
                this.homeworld,
                this.species);
    }

    @Override
    public DetailedPersonagemDTO convertFrom(Personagem character) {
        this.name = character.getName();
        this.height = String.valueOf(character.getHeight());
        this.mass = String.valueOf(character.getMass());
        this.hairColor = character.getHairColor();
        this.skinColor = character.getSkinColor();
        this.eyeColor = character.getEyeColor();
        this.birthYear = character.getBirthYear();
        this.gender = character.getGender();
        this.homeworld = character.getHomeworld();
        this.species = character.getSpecies();
        return this;
    }
}
