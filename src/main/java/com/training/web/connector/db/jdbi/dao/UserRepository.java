package com.training.web.connector.db.jdbi.dao;

import com.training.web.connector.db.DataSource;
import com.training.web.connector.db.dto.UserDTO;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;
import org.springframework.stereotype.Repository;

@Repository
@RegisterBeanMapper(UserDTO.class)
public interface UserRepository extends DataSource {

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

    @Transaction
    @GetGeneratedKeys
    @SqlUpdate("insert into application_user (name, family_name) values (:name, :familyName)")
    UserDTO save(@BindBean UserDTO userDTO);
}



