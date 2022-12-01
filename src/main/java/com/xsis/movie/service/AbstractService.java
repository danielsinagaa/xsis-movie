package com.xsis.movie.service;

import org.springframework.data.jpa.repository.JpaRepository;
public class AbstractService<T> {

    protected final JpaRepository<T, Long> repository;

    public AbstractService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

}
