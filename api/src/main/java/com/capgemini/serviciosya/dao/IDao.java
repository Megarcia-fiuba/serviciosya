package com.capgemini.serviciosya.dao;

import java.util.List;

public interface IDao<T,I> {

    void create(T target);
    void update(T target);
    void delete(I id);
    List<T> findall();
    T findById(I id);
}
