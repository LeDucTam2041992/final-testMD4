package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService<T> {
    Page<T> findAll(Pageable pageable);

    Iterable<T> findAll();

    T findById(long id);

    void save(T model) ;

    void remove(long id);
}
