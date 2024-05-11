package org.example.repositories.Jpa;

import org.example.tables.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface JpaUserRepository extends JpaRepository<User, Long> {
    public User getUserByName(String name);
}
