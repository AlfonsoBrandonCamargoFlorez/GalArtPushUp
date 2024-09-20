package com.brandon.old.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.brandon.old.domain.entities.UserEntity;



public interface UserRepository extends CrudRepository<UserEntity,Long> {
    Optional<UserEntity> findUserEntityByUsername(String username);
}
