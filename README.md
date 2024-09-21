# Java Design Patterns Excercise 1

This project demonstrates the implementation of various design patterns in Java. It includes examples of behavioral, creational, and structural design patterns, each applied to a practical use case.

## Table of Contents

1. [Behavioral Patterns](#behavioral-patterns)
2. [Creational Patterns](#creational-patterns)
3. [Structural Patterns](#structural-patterns)

## Behavioral Patterns

### Observer Pattern: Weather Station

**Use Case:** A weather station that updates multiple displays when weather data changes.

**Key Classes:**
- `WeatherData`: Subject that maintains state and notifies observers
- `CurrentConditionsDisplay`: Observer that displays current weather conditions

### Strategy Pattern: Payment Processing

**Use Case:** A shopping cart system that can use different payment methods interchangeably.

**Key Classes:**
- `PaymentStrategy`: Interface for payment methods
- `CreditCardStrategy`, `PayPalStrategy`: Concrete payment strategies
- `ShoppingCart`: Context that uses the payment strategy

## Creational Patterns

### Singleton Pattern: Database Connection Manager
**Use Case:** Ensuring only one instance of a database connection manager exists.
**Key Class:**

- `DatabaseConnectionManager`: Singleton class for managing database connections

### Builder Pattern: Computer Configuration System

**Use Case:** Constructing complex Computer objects step by step.

**Key Classes:**
- `Computer`: Complex object being built
- `ComputerBuilder`: Interface defining construction steps
- `DesktopComputerBuilder`: Concrete builder implementing the steps
- `ComputerDirector`: Defines construction processes for different computer types

## Structural Patterns

### Adapter Pattern: Legacy Payment System Integration

**Use Case:** Adapting a legacy payment system to work with a new payment processing interface.

**Key Classes:**
- `NewPaymentSystem`: Target interface
- `LegacyPaymentSystem`: Adaptee (legacy system)
- `LegacyPaymentAdapter`: Adapter that makes legacy system compatible with new interface

### Composite Pattern: File System Structure

**Use Case:** Representing a hierarchical file system structure where both files and directories are treated uniformly.

**Key Classes:**
- `FileSystemComponent`: Base component class
- `File`: Leaf node representing a file
- `Directory`: Composite node that can contain other components

## How to Run the Examples

1. Ensure you have Java Development Kit (JDK) installed on your system.
2. Clone this repository to your local machine.
3. Navigate to the project directory in your terminal.
4. Compile all Java files:
   ```
   javac *.java
   ```
5. Run the specific demo class for each pattern. For example:
   ```
   java WeatherStationDemo
   java PaymentDemo
   java DocumentManagementDemo
   java BuilderPatternDemo
   java AdapterDemo
   java FileSystemDemo
   ```

## Contributing

Contributions to this project are welcome! Please follow these steps:

1. Fork the repository
2. Create a new branch: `git checkout -b feature-branch-name`
3. Make your changes and commit them: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature-branch-name`
5. Submit a pull request
