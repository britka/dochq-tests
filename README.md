# Test task for DoHQ 
## Scenario
### Steps
* Register new user
* Login with newly registered user
* Go to Personal trainer section on dashboard
* Start free trial
* Select subscription
* Enter payment data
* Select training plan
* Start workout
* Check that workout is started

## Software for automation
### Main software
* Java as programming language 
* [Playwright Java](https://playwright.dev/java/docs/intro) as UI test automation tool
* [TestNG](https://testng.org/) as test runner
* [Allure](https://allurereport.org/) report as a reporter
### Additional software
* [Lombok](https://projectlombok.org/) - easy to use tool for writing classes
* [Slf4j](https://www.slf4j.org/) - logger library
* [javafaker](https://github.com/DiUS/java-faker) - tool for random data generating
* [java-dotenv](https://github.com/cdimascio/java-dotenv) - library for working with app properties

## Project structure
```commandline
DocHQTests
├── README.md
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── io
    │   │       └── github
    │   │           └── britka
    │   │               ├── AppConfig.java
    │   │               ├── application
    │   │               │   ├── Application.java
    │   │               │   ├── HealthChecksMenu.java
    │   │               │   ├── PersonalTrainer.java
    │   │               │   ├── Physiotherapy.java
    │   │               │   ├── Registration.java
    │   │               │   ├── TravelMedicineChecker.java
    │   │               │   ├── UserDashBoard.java
    │   │               │   ├── checks
    │   │               │   └── navigation
    │   │               │       ├── AppNavigation.java
    │   │               │       ├── DashboardNavigation.java
    │   │               │       └── WebsiteNavigation.java
    │   │               ├── driver
    │   │               │   └── DriverHolder.java
    │   │               ├── models
    │   │               │   ├── CardData.java
    │   │               │   ├── ProviderUserInfo.java
    │   │               │   ├── UserModel.java
    │   │               │   └── UserRegisterResponse.java
    │   │               └── pages
    │   │                   ├── BasePage.java
    │   │                   ├── IndividualsBasePage.java
    │   │                   ├── PersonalTrainerStartPage.java
    │   │                   ├── Utils.java
    │   │                   ├── dashboard
    │   │                   │   └── UserDashBoardPage.java
    │   │                   ├── menu
    │   │                   │   └── NavigationMenu.java
    │   │                   ├── registration
    │   │                   │   ├── ActivateRequestPage.java
    │   │                   │   ├── AfterActivationPage.java
    │   │                   │   └── RegistrationPage.java
    │   │                   ├── signin
    │   │                   │   └── SignInPage.java
    │   │                   └── workout
    │   │                       ├── ExerciseSettingsPage.java
    │   │                       ├── MyWorkoutTodayPage.java
    │   │                       ├── MyWorkoutsPage.java
    │   │                       ├── plans
    │   │                       │   └── RecommendedWorkoutPlansPage.java
    │   │                       └── subscriptions
    │   │                           └── SubscriptionPage.java
    │   └── resources
    │       └── allure.properties
    └── test
        ├── java
        │   └── io
        │       └── github
        │           └── britka
        │               ├── checks
        │               │   ├── Checks.java
        │               │   └── WorkoutChecks.java
        │               ├── listeners
        │               │   └── TestListener.java
        │               └── tests
        │                   ├── BaseTest.java
        │                   └── FirstTests.java
        └── resources
            └── META-INF
                └── services
                    ├── io.qameta.allure.listener.StepLifecycleListener
                    └── io.qameta.allure.listener.TestLifecycleListener

```
### Explanation
* src 
    * **AppConfig.java** - in this class .env file is loaded
    * **application** package - here are all classes for high level steps
    * **driver** package - here are classes for Playwright driver to run it in parallel
    * **models** package - different POJOs for tests
    * **pages** package for page objects
* test
    * **checks** package for different check steps
    * **listeners** - all listeners are living here
    * **tests** - package for tests

## How to run tests locally
* Clone this repo
```commandline
git clone https://github.com/britka/dochq-tests.git
```
* CD to the directory
```commandline
cd dochq-tests
```
* Create .env file using an example **.env.example** file. Add base url there 
```properties
BASE_URL=https://some.base.url
```

> [!NOTE]  
> Java, maven, and allure report should be installed
* By default, you can run tests
```commandline
mvn clean test
```
* If you want to run with different browsers you can use
```commandline
mvn clean test -D browserToRun=firefox
```
> [!NOTE]  
> Playwright allows to run tests in 3 browser engines: chromium, firefox, webkit
* If you want to run test in headless mode
```commandline
mvn clean test -D isHeadless=true 
```

## Run test using github actions
Please see [playwright.yaml](.github/workflows/playwright.yml)