package com.training.web.connector.db.hibernate;

import com.training.web.connector.db.DataSource;
import com.training.web.connector.db.dto.UserDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Profile("postgres")
public interface UserRepository extends JpaRepository<UserDTO, Long>, DataSource {

    @Query(value = """ 
            SELECT u.*
            from application_user u 
            where u.name = ?1 """,
            nativeQuery = true)
    UserDTO getByName(@Param("name") String name);

    @Query(value = """ 
            SELECT u.*
            from application_user u 
            where u.id = ?1 """,
            nativeQuery = true)
    UserDTO getByUserId(@Param("name") Long id);
}
