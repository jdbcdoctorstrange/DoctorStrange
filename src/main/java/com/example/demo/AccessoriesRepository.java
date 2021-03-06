package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface AccessoriesRepository extends CrudRepository<Accessories, Long>{
    Iterable<Accessories> findAllByCategory(String category);
}
