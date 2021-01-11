package com.zelenev.data.dao;

import com.zelenev.data.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("SELECT r FROM Role r JOIN AccountRole ar ON r.id=ar.role.id JOIN Account a ON a.id=ar.account.id WHERE a.login=:login")
    List<Role> findByAccountLogin(
            @Param("login") String login
    );
}
