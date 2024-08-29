# Flexible Calculator

## Overview
This project is a simple, extensible calculator implemented in Java. It supports basic arithmetic operations such as addition, subtraction, multiplication, and division. The design follows key object-oriented principles, specifically the Open-Closed Principle, ensuring that the code is easy to maintain and extend with additional operations.

## Features
1. Basic Operations: Supports addition, subtraction, multiplication, and division.
2. Extensibility: Easily extendable to support additional operations without modifying the existing codebase.
3. Chaining Operations: Allows users to perform a series of operations sequentially on an initial value.
4. IoC Compatibility: Designed to be compatible with Inversion of Control (IoC) environments for easier testing and swapping of implementations.
5. Error Handling: Gracefully handles unsupported operations by throwing an appropriate exception.
6. Unit Testing: Comprehensive unit tests included to verify both normal cases and edge cases.

## Assumptions and Design Decisions
1. **Supported Operations**: The calculator initially supports four basic operations: addition, subtraction, multiplication, and division. New operations can be added by extending the Operation enum and creating corresponding operation classes.
2. **Input Validity**: Inputs are expected to be valid numbers. The calculator does not perform input validation; it should be handled by the caller.
3. **Error Handling**: The calculator throws an UnsupportedOperationException when an unsupported operation is requested.
4. **Chaining Functionality**: Users can start with an initial value and chain multiple operations using the Calculator class's methods.
5. **Input Validity**: Assume the inputs passed to the operation classes are valid integers or floating-point numbers. Input validation (such as checking if the input is a valid number) should be handled by the caller before passing them to the Calculator.
6. **Division by Zero Handling**: In the DivideOperation class, it is assumed that the denominator is not zero. If a division by zero occurs, an ArithmeticException will be thrown during the execution of the operation, which should be handled by the caller.
7. **Modular Design**: The codebase is organized into distinct packages to enhance maintainability and scalability. Core functionalities, specific operation implementations, calculator logic, exception handling, and test code are all separated into different packages. This modular approach reduces coupling by effectively isolating classes based on their responsibilities.
8. **Factory Pattern**: The factory pattern is employed through the `OperationFactory` class to handle the creation of operations. This design pattern allows for the easy addition of new operation types without requiring changes to the client code, promoting flexibility and extensibility.
9. **Builder Pattern**:  The `CalculatorBuilder` class utilizes the builder pattern to provide a flexible and configurable way to create instances of `Calculator`. This approach makes the code more adaptable to changes and easier to extend.
10. **Unit Testing**: Unit tests are used to verify the core functionality of the calculator, ensuring that all operations perform as expected. All test code is organized in the `tests` package, separate from production code, to maintain high code quality and to isolate test logic from application logic.

## Directory Structure
```plaintext
org.example
├── core
│   ├── Operation.java
│   ├── OperationFactory.java
│   └── OperationType.java
├── operations
│   ├── AddOperation.java
│   ├── SubtractOperation.java
│   ├── MultiplyOperation.java
│   └── DivideOperation.java
├── calculator
│   ├── Calculator.java
│   └── CalculatorBuilder.java
├── exceptions
│   └── UnsupportedOperationException.java
└── tests
    └── CalculatorTest.java
 ```

## Getting Started

### Prerequisites

Before you can build and run this project, ensure you have the following installed:

- **Java Development Kit (JDK) 8 or higher**: Required for compiling and running Java applications. You can download it from the [Oracle website](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) or use OpenJDK from [AdoptOpenJDK](https://adoptopenjdk.net/).
- **Maven**: A build automation tool used for managing dependencies and running tests. You can download Maven from the [official website](https://maven.apache.org/).

## Installation

To get started with the project, follow these steps:

1. **Clone the repository**:

   ```bash
   git clone https://github.com/yourusername/Interview_Assignment.git
   cd Interview_Assignment
   
2. **Build the project**:
   ```bash
   mvn clean install

3. **Run the tests**:
   ```bash
   mvn test

## Contact

For any questions, suggestions, or contributions, feel free to reach out:

- **Email**: [eric.wangwe2@gmail.com](mailto:eric.wangwe2@gmail.com)
- **GitHub**: [Eric Wang](https://github.com/ericwongwa)

We welcome your feedback and contributions to make this project better!
