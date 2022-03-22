package br.com.meli.starwarschars.dto;

public interface ISWCharDTO<Personagem, U> {
    Personagem convertTo();
    U convertFrom(Personagem character);
}
