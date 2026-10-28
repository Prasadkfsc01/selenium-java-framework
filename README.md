# Selenium Java Automation Framework

A modular web automation testing framework built using **Selenium WebDriver 4, Java 21, TestNG and Maven**, following Page Object Model (POM) principles and modern test automation practices.

The project demonstrates reusable test architecture, data-driven testing, cross-browser configuration and reliable browser lifecycle management.

**Application under test:** [SauceDemo](https://www.saucedemo.com/)

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Selenium WebDriver 4 | Browser automation |
| TestNG | Test execution and assertions |
| Maven | Dependency and build management |
| Page Object Model | Reusable application page abstractions |
| Git / GitHub | Version control and collaboration |

## Framework Architecture

The framework separates responsibilities into the following layers:

**Test Layer**
- TestNG-based UI tests and assertions
- Data-driven scenarios using `@DataProvider`
- Test setup and teardown

**Page Object Layer**
- `BasePage` — reusable Selenium interactions and explicit waits
- `LoginPage` — login elements and business operations

**Framework Core**
- `DriverFactory` — browser creation, management and cleanup using `ThreadLocal<WebDriver>`
- `ConfigManager` — configuration file loading and runtime overrides

**Configuration Layer**
- Browser selection
- Application URL
- Headless execution
- Explicit wait timeout

## Getting Started

### Prerequisites

- JDK 21
- Maven
- Git
- Chrome or another supported browser
- Eclipse IDE or IntelliJ IDEA

### Clone the repository

```bash
git clone https://github.com/Prasadkfsc01/selenium-java-framework.git
cd selenium-java-framework
```

### Execute all tests

```bash
mvn clean test
```

### Run parameterised login tests

```bash
mvn clean test -Dtest=ParameterisedLoginTest
```

### Run tests in Firefox

```bash
mvn clean test -Dbrowser=firefox
```

### Run headless tests

```bash
mvn clean test -Dheadless=true
```

## Configuration Management

Default settings are managed using `config.properties`.

```properties
browser=chrome
baseUrl=https://www.saucedemo.com/
headless=false
explicitWait=10
```

Runtime properties take precedence over file-based configuration.

Example:

```bash
mvn clean test -Dbrowser=chrome -Dheadless=true
```

## Automated Test Coverage

Current login scenarios include:

- Successful login with valid credentials
- Locked-out user login
- Invalid username and password
- Empty username
- Empty password

TestNG DataProvider enables multiple data sets to execute using a shared test method.

## Design Principles

- Separation of concerns
- Object-oriented programming
- Encapsulation and inheritance
- Reusable page objects
- Centralised configuration
- Thread-isolated browser sessions
- Explicit wait-based synchronisation
- Independent test scenarios

## Development Roadmap

- [x] Maven project setup
- [x] Selenium WebDriver integration
- [x] TestNG integration
- [x] Centralised DriverFactory
- [x] ConfigManager
- [x] Configurable headless execution
- [x] BasePage with explicit waits
- [x] Login Page Object
- [x] TestNG DataProvider
- [ ] Product page and inventory validation
- [ ] Dropdown, alert and iframe handling
- [ ] Multiple browser window handling
- [ ] Web table pagination
- [ ] Advanced wait strategies and stale element handling
- [ ] Cucumber BDD integration
- [ ] Parallel cross-browser execution
- [ ] Allure reporting
- [ ] Jenkins CI/CD integration
- [ ] Selenium Grid / Docker execution

## Author

[Prasad Kotamsetti](https://github.com/Prasadkfsc01)

Senior QA Automation Engineer / SDET

## Project Status

Active development. Additional testing capabilities, BDD integration and CI/CD automation are being implemented incrementally.