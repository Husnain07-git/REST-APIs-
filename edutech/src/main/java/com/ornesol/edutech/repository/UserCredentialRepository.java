package com.ornesol.edutech.repository;

import com.ornesol.edutech.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredentials,Integer> {

    Optional<UserCredentials> findByName(String username);
}
