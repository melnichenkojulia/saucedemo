# Saucedemo Login Test

## Overview
Automated login tests for https://www.saucedemo.com/ using Selenium WebDriver, JUnit 5, and Maven.

## Test Cases
- **UC-1**: Login with empty credentials (Type any credentials into "Username"and "Password" fields
- -> clear inputs -> hit the "Login button"→ Expect "Username is required")
- **UC-2**: Login with username only (Type any credentials in "Username"->enter password->clear "Password" field
- ->hit the "Login button"→ Expect "Password is required")
- **UC-3**: Login with valid credentials (Type correct credential in "Username"and "Password"
- -> hit the "Login button"→ Expect title "Swag Labs")

## Technologies
- Selenium WebDriver
- JUnit 5
- Maven
- Browsers: Firefox, Edge
- XPath locators
- Parallel execution supported

# Run
mvn test
