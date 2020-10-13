package com.example.demo.service;

import com.example.demo.model.Nation;
import com.example.demo.repository.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class NationServiceImpl implements NationService{
    @Autowired
    private NationRepository nationRepository;

    @Override
    public Page<Nation> findAll(Pageable pageable) {
        return nationRepository.findAll(pageable);
    }

    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public Nation findById(long id) {
        return nationRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Nation model) {
        nationRepository.save(model);
    }

    @Override
    public void remove(long id) {
        nationRepository.deleteById(id);
    }
}
