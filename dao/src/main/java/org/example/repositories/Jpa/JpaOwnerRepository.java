package org.example.repositories.Jpa;

import org.example.tables.Cat;
import org.example.tables.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaOwnerRepository extends JpaRepository<Owner, Long> {
    @Modifying(flushAutomatically = true)
    @Query(value = "SELECT * FROM owner", nativeQuery = true)
    List<Owner> findAll();
    @Modifying(flushAutomatically = true)
    @Query(value = "SELECT * FROM cat WHERE ownerId = :ownersId", nativeQuery = true)
    List<Cat> findAllOwnedCats(Long ownersId);
}
