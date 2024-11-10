package com.training.web.connector.db.jdbi.dao;

import com.training.web.connector.db.dto.UserDTO;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.springframework.stereotype.Repository;

@Repository
@RegisterBeanMapper(UserDTO.class)
public interface UserRepository  {

    @SqlQuery(value = """ 
            SELECT u.*
            from application_user u 
            where u.name = :name """)
    UserDTO getByName(@Bind("name") String name);

    @SqlQuery(value = """ 
            SELECT u.*
            from application_user u 
            where u.id = :id """)
    UserDTO getByUserId(@Bind("id") Long id);

    UserDTO save(UserDTO userDTO);
}



