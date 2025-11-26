package org.saucedemo.factory;

import org.saucedemo.dto.UserDTO;

public class UserFactory {
    public static UserDTO validUser() {
        return new UserDTO("standard_user", "secret_sauce");
    }

    public static UserDTO invalidUser() {
        return new UserDTO("anyUser", "anyPassword");
    }

    public static UserDTO userWithInvalidPassword() {
        return new UserDTO("standard_user", "anyPassword");
    }


}


