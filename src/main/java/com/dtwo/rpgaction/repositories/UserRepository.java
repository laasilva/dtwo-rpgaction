package com.dtwo.rpgaction.repositories;

import com.dtwo.rpgaction.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("FROM User u WHERE u.username = :username")
    User findUserByUsername(@Param("username") String username);

    @Override
    List<User> findAll();

    @Override
    <S extends User> S save(S entity);

    @Override
    void delete(User entity);
}
