package br.com.meli.as_perolas_api.service;

import java.util.Collection;

public interface IService<T, U> {
    T create(T t);
    Collection<T> listAll();
    void delete(U u);
    T update(T t);
}
