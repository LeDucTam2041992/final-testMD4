package com.example.demo.repository;

import com.example.demo.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {
}
