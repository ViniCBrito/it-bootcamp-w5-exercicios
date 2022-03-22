package br.com.meli.starwarschars.service;

import br.com.meli.starwarschars.entity.Personagem;

import java.util.List;

public interface IService {
    List<Personagem> listAll();
    List<Personagem> listFromName(String name);
    boolean add(Personagem character);
    boolean add(List<Personagem> newPersonagens);
}
