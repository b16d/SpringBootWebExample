package com.training.web.utils;

import java.util.Objects;
import java.util.function.Supplier;

public class BeanValidator {

    private BeanValidator() {};

    public static BeanValidator of() {
        return new BeanValidator();
    }

    public <T extends RuntimeException> BeanValidator isNull(Object object, Supplier<T> exception) {
        return valid(!Objects.isNull(object), exception);
    }

    public <T extends RuntimeException> BeanValidator valid(boolean valid, Supplier<T> exception)  {
        if (valid) {
            return this;
        }

        throw exception.get();
    }
}
