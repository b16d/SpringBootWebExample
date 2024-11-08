package com.training.web.service.impl;

import com.training.web.connector.db.dto.UserDTO;
import com.training.web.connector.db.repository.UserRepository;
import com.training.web.domain.User;
import com.training.web.domain.exception.BadUserException;
import com.training.web.service.IUserService;
import com.training.web.utils.BeanValidator;
import com.training.web.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User getById(Long id) {
        UserDTO userDTO = userRepository.getReferenceById(id);
        return UserMapper.toUser(userDTO);
    }

    @Override
    public User getByName(String name) {
        UserDTO userDTO = userRepository.getByName(name);
        return UserMapper.toUser(userDTO);
    }

    @Override
    public boolean saveUser(User user) {
        BeanValidator.of().isNull(user, () -> new BadUserException("user is null"))
                .valid(!user.name().isEmpty(), () -> new BadUserException( "Name is empty"))
                .valid(!user.familyName().isEmpty(), () -> new BadUserException("Family Name is Empty"));

        userRepository.save(UserMapper.userDTO(user));
        return false;
    }
}
