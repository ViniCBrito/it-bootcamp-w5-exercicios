package br.com.meli.starwarschars.repository;

import br.com.meli.starwarschars.entity.Personagem;

import java.util.List;

public interface IRepository {
    List<Personagem> list();
    boolean add(Personagem character);
}
