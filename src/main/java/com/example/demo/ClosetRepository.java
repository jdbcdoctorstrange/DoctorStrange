package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface ClosetRepository extends CrudRepository<Closet, Long>{
    Iterable<Closet> findAllByUser(User user);
}
