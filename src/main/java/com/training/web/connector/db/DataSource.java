package com.training.web.connector.db;

import com.training.web.connector.db.dto.UserDTO;

public interface DataSource {

    UserDTO getByUserId(Long id);

    UserDTO getByName(String name);

    UserDTO save(UserDTO userDTO);
}
