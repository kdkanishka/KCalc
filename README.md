# KCalc
Yet another calculator based on BODMAS rule :)

## Features
- Ability to evaluate and execute basic mathematical expressions.
- / ,  * , + , - are supported at the moment.
- Calculation history

## Approach
![Aproac](https://raw.githubusercontent.com/kdkanishka/KCalc/master/docs/images/1633417868332.jpg)

## Design
- Applied strategy pattern to implement open-closed principal

#### Core design
![Core Design](https://raw.githubusercontent.com/kdkanishka/KCalc/master/docs/images/kcalc.png)


## Implementation
- The application and core algorithm is implemented in java
- No external dependencies used for expression evaluation
- Java Swing is used to implement the simple calculator UI
- JUnit 5 for unit tests
- JaCoCo for coverage reports

## Screenshots
#### Expression evaluation & history
![screenshot 1](https://raw.githubusercontent.com/kdkanishka/KCalc/master/docs/images/Screenshot_20211005_115355.png)

#### Handling bad expressions
![screenshot 2](https://raw.githubusercontent.com/kdkanishka/KCalc/master/docs/images/Screenshot_20211005_115603.png)
## Requirements
- Java 11 or Higher
- Apache Maven 3.x
- Git (Optional) for cloning. (or direct download sources from github)

## Getting started
- Clone the project

`git clone https://github.com/kdkanishka/KCalc.git`

- Execute (Start the application without creating an executable jar)

`mvn compile exec:java -Dexec.mainClass="com.kani.kcalc.core.Main"`

- Run tests with test coverage

`mvn clean test`

- Coverage reports can be found on

`<PROJECT_DIR>/target/site/jacoco/index.html`

## Author
Kanishka Dilshan (kdkanishka@gmail.com)
