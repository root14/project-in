package com.root14.projectin.repositories;

import com.root14.projectin.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String username);

    Boolean existsByEmail(String email);

}
