package com.example.dataBaseAGDRestAPI;

import java.util.List;

public interface Repository<T, K> {

    T create(T entity);
    T delete(T entity);
    T update(T entity);
    T readById(K id);
    List<T> read();

}
