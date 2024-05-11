package org.example.repositories.Jpa;

import org.example.tables.Cat;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan
public interface JpaCatRepository extends JpaRepository<Cat, Long> {
        @Modifying(flushAutomatically = true)
        @Query(value = "INSERT INTO cat_cat VALUES (?1, ?2)", nativeQuery = true)
        Cat addFriend(Long toId, Long friendId);

        @Modifying(flushAutomatically = true)
        @Query(value = "DELETE FROM cat_cat WHERE (cat1_id = ?1 AND cat2_id = ?2) OR (cat1_id = ?2 AND cat2_id = ?1)", nativeQuery = true)
        Cat deleteFriend(Long toId, Long friendId);
}
