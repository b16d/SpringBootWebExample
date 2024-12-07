package com.training.web.service.impl;

import com.training.web.aop.LogExecutionTime;
import com.training.web.connector.db.DataSource;
import com.training.web.connector.db.dto.UserDTO;
import com.training.web.connector.db.jdbi.dao.UserRepository;
import com.training.web.domain.User;
import com.training.web.domain.exception.BadUserException;
import com.training.web.service.IUserService;
import com.training.web.utils.BeanValidator;
import com.training.web.utils.UserMapper;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final DataSource dataSource;

    @Autowired
    public UserService(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public User getById(Long id) {
        UserDTO userDTO = dataSource.getByUserId(id);
        return UserMapper.toUser(userDTO);
    }

    @Override
    public User getByName(String name) {
        UserDTO userDTO = dataSource.getByName(name);
        return UserMapper.toUser(userDTO);
    }

    @Override
    @LogExecutionTime
    public boolean saveUser(User user) {
        dataSource.save(UserMapper.userDTO(user));
        return true;
    }
}
