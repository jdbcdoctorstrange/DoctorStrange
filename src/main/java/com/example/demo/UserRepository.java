package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
//    Iterable<Closet>findAllByUsernameAndClosets(String username);
    Iterable<Closet> findAllClosetsByUsername(String username);

}
