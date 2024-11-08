package com.training.web.utils;

import com.training.web.connector.db.dto.UserDTO;
import com.training.web.domain.User;

public class UserMapper {

    public static User toUser(UserDTO userDTO) {

        return new User(userDTO.getName(), userDTO.getFamilyName());
    }

   public static UserDTO userDTO(User user) {
        return new UserDTO(user.name(), user.familyName());
    }
}
