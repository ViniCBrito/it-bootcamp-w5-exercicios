package br.com.meli.starwarschars.repository;

import br.com.meli.starwarschars.entity.Personagem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SWCharactersRepository implements IRepository {

    private List<Personagem> banco;

    public SWCharactersRepository() {
        this.banco = new ArrayList<>();
    }

    public SWCharactersRepository(List<Personagem> banco) {
        this.banco = banco;
    }

    @Override
    public List<Personagem> list() {
        return this.banco;
    }

    @Override
    public boolean add(Personagem character) {
        return this.banco.add(character);
    }
}
