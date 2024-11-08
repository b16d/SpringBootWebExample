package com.training.web.connector.db.repository;

import com.training.web.connector.db.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserDTO, Long> {
/*
    @Query("""
            SELECT *
            FROM USER u
            WHERE u.id = (:id)
            """)
    UserDTO getById(@Param("id") Long id);*/

    @Query(value = """ 
            SELECT u.*
            from application_user u 
            where u.name = ?1 """,
            nativeQuery = true)
    UserDTO getByName(@Param("name") String name);
}
