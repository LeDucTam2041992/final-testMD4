package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;
    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(long id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public void save(City model) {
        cityRepository.save(model);
    }

    @Override
    public void remove(long id) {
        cityRepository.deleteById(id);
    }
}
