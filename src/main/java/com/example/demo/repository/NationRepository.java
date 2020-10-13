package com.example.demo.repository;

import com.example.demo.model.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NationRepository extends PagingAndSortingRepository<Nation, Long> {
}
