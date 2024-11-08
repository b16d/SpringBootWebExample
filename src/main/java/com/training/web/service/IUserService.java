package com.training.web.service;

import com.training.web.domain.User;

public interface IUserService {

    public User getById(Long id);

    User getByName(String name);

    public boolean saveUser(User user);
}
