package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClosetRepository extends CrudRepository<Closet, Long>{
    //Iterable<Closet>findAllById(Long id);
    //Closet findByIdAndUid(Long id, Long uid);
    Iterable<Closet> findAllClosetsByUid(Long uid);
    Closet findByIdAndUid(Long id, Long uid);
<<<<<<< HEAD
    Closet findByIdAndUserId(Long id, Long uid);

    @Override
    Optional<Closet> findById(Long aLong);
=======
    Optional<Closet> findById(Long id);
>>>>>>> 97aa589a0503e1237d9d97348d11c289e8b32ee6
}
