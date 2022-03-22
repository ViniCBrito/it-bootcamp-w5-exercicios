package br.com.meli.starwarschars.service;

import br.com.meli.starwarschars.entity.Personagem;
import br.com.meli.starwarschars.repository.SWCharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SWCharactersService implements IService {

    @Autowired
    private SWCharactersRepository repo;

    @Override
    public List<Personagem> listAll() {
        return this.repo.list();
    }

    @Override
    public List<Personagem> listFromName(String name) {
        return this.repo.list().stream().filter(x -> x.getName().contains(name)).collect(Collectors.toList());
    }

    @Override
    public boolean add(Personagem character) {
        return this.repo.add(character);
    }

    @Override
    public boolean add(List<Personagem> newPersonagens) {
        boolean addOK = true;
        for (Personagem x : newPersonagens) { addOK = addOK && this.repo.add(x); }
        return addOK;
    }
}
