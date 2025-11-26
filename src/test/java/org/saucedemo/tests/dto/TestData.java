package org.saucedemo.tests.dto;

import org.saucedemo.dto.UserDTO;
import org.saucedemo.enums.Browser;
import org.saucedemo.enums.LoginMode;

public record TestData(String id, UserDTO user, LoginMode loginMode, String error, String title, Browser browser) {
}
