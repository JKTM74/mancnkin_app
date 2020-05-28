package com.manchkin.app.jpa.repositories;

import com.manchkin.app.jpa.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    /*
    Так нельзя (void не должно быть, нужно в идеале возвращать Player) и это просто пример составления нативного запроса к БД без использования автогенератора
    P.S. никогда не сэйви нативным запросом в JPA, есть save и saveAll, спасибо
    @Query(value = "INSERT INTO Player (login, pass) VALUES (:login, :pass)", nativeQuery = true)
    void createNewUser(@Param("login") String login, @Param("pass") String pass);*/

    boolean existsByLogin(@Param("login") String login);

    @Query(value = "select * from player where pass = :pass and login = :login", nativeQuery = true)
    Player checkPassAndLogin(@Param("pass") String pass, @Param("login") String login);


}
