package com.training.web.rest;


import com.training.web.domain.User;
import com.training.web.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;


    @GetMapping("/getById/")
    public User getById(Long id) {
        logger.info("Request Id {}", id);
        return userService.getById(id);
    }

    @GetMapping("/getByName/")
    public User getByName(String name) {
        logger.info("Request Name {}", name);
        return userService.getByName(name);
    }

    @PostMapping
    public boolean saveUser(User user) {
        logger.info("Request user {}", user);
        return userService.saveUser(user);
    }


}
