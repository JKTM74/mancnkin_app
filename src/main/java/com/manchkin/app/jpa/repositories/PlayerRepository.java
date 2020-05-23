package com.manchkin.app.jpa.repositories;

import com.manchkin.app.jpa.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
    /*
    Так нельзя (void не должно быть, нужно в идеале возвращать Player) и это просто пример составления нативного запроса к БД без использования автогенератора
    @Query(value = "INSERT INTO Player (login, pass) VALUES (:login, :pass)", nativeQuery = true)
    void createNewUser(@Param("login") String login, @Param("pass") String pass);*/

    boolean existsByLogin(@Param("login") String login);
}
