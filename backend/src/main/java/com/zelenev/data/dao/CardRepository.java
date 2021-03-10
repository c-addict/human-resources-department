package com.zelenev.data.dao;

import com.zelenev.data.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    @Query("SELECT c.firstName, c.lastName, c.birthdayDate, c.phone, c.salary, c.department, c.position" +
            " FROM Card c JOIN Account a ON c.account.id=a.id WHERE a.login=:login")
    Optional<Card> findByAccountLogin(
            @Param("login") String login
    );

    Optional<Card> findCardByAccountId(Integer id);
}
