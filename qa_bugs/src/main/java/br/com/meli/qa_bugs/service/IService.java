package br.com.meli.qa_bugs.service;

import java.util.Collection;

public interface IService<T, U, V> {
    T create(T t);
    Collection<T> listAll(V filters);
    T find(U id);
    void delete(U id);
    T update(U id, T t);
}
