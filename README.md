# Saucedemo Login Test

## Overview
Automated login tests for https://www.saucedemo.com/ using Selenium WebDriver, JUnit 5, and Maven.

## Test Scenarios
- **UC-1**: Login with empty credentials → Expect "Username is required"
- **UC-2**: Login with username only → Expect "Password is required"
- **UC-3**: Login with valid credentials → Expect title "Swag Labs"

## Technologies
- Selenium WebDriver
- JUnit 5
- Maven
- Browsers: Firefox, Edge
- XPath locators
- Parallel execution supported

# Run
mvn test
