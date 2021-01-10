package com.zelenev.data.dao;

import com.zelenev.data.entities.Change;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeRepository extends JpaRepository<Change, Integer> {

}
