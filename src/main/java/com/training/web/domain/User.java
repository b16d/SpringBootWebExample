package com.training.web.domain;

import com.training.web.domain.exception.BadUserException;
import com.training.web.utils.BeanValidator;

public record User(String name, String familyName) {

     public User {
        BeanValidator.of()
                .valid(!name.isEmpty(), () -> new BadUserException( "Name is empty"))
                .valid(!familyName.isEmpty(), () -> new BadUserException("Family Name is Empty"));
    }
}
