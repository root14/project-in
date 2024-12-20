package com.root14.projectin.repositories;

import com.root14.projectin.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String username);

    Optional<User> findByUserName(String username);

    Boolean existsByEmail(String email);

    Boolean existsByUserName(String username);

}
