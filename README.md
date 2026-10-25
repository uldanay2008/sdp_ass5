# Space Flight Planner — Strategy Pattern

Assignment #5 for the Software Design Patterns course.

## Project Description

This Java application calculates fuel consumption for a space flight.
It uses the Strategy pattern to switch between flight modes at runtime.

The formulas are simplified examples for educational purposes.

## Strategy Pattern Components

| Component | Class | Responsibility |
|-----------|-------|----------------|
| Strategy | FlightStrategy | Declares the calculateFuel method |
| Concrete Strategy | EconomyFlightStrategy | Calculates fuel for economy mode |
| Concrete Strategy | StandardFlightStrategy | Calculates fuel for standard mode |
| Concrete Strategy | BoostFlightStrategy | Calculates fuel for boost mode |
| Context | FlightPlanner | Stores a strategy and delegates fuel calculation |
| Client | Main | Creates and changes strategies |

## Flight Modes

- **Economy:** distance × 0.5
- **Standard:** distance × 1.0
- **Boost:** distance × 2.0 + 100 liters for boost activation

Distance is measured in kilometers and fuel in liters.

## How It Works

The client creates a FlightPlanner with an initial strategy:

```java
FlightPlanner planner =
        new FlightPlanner(new EconomyFlightStrategy());
```

The planner delegates the calculation to the selected strategy:

```java
return strategy.calculateFuel(distance);
```

The client can change the strategy on the same planner object:

```java
planner.setStrategy(new BoostFlightStrategy());
```

FlightPlanner does not use if/switch statements to identify strategy types.
Its if statement only validates the distance.

## Project Structure

```text
src/
├── FlightStrategy.java
├── EconomyFlightStrategy.java
├── StandardFlightStrategy.java
├── BoostFlightStrategy.java
├── FlightPlanner.java
└── Main.java
```

## Requirements

- JDK 8 or later
- IntelliJ IDEA or a terminal

No external libraries are required.

## How to Run

### IntelliJ IDEA

1. Open the project.
2. Select a JDK.
3. Open src/Main.java.
4. Run the main method.

### Terminal

Run these commands from the project root:

```bash
mkdir out
javac -d out src/*.java
java -cp out Main
```

## Expected Output

```text
Distance: 1000.0 km
Economy mode: 500.0 L
Standard mode: 1000.0 L
Boost mode: 2100.0 L
```

## Input Validation

FlightPlanner rejects:

- A null strategy.
- A distance that is zero or negative.
- NaN or infinite distance values.

## Clean Code Principles

### 1. Meaningful Names

Names such as FlightPlanner, calculateFuel, and EconomyFlightStrategy
clearly describe their purpose.

### 2. Single Responsibility

Each strategy contains one fuel calculation algorithm.
FlightPlanner manages delegation and input validation.
Main demonstrates how to use the classes.

### 3. Polymorphism Instead of Type Conditions

FlightPlanner calls the strategy through the FlightStrategy interface.
It does not need conditional statements to choose a formula.

### 4. Algorithm-Agnostic Context

FlightPlanner depends on FlightStrategy.
It does not know the formulas or internal details of concrete strategies.

### 5. Open/Closed Principle

A new flight mode can be added by creating another class that implements
FlightStrategy. Existing strategies and FlightPlanner remain unchanged.
The client selects the new strategy.

### 6. Named Constants

Fuel rates and boost activation fuel are stored in named constants.
This makes the formulas easier to understand and update.

## Extensibility Example

A new strategy can be added in a separate file:

```java
public class SolarAssistFlightStrategy implements FlightStrategy {
    private static final double FUEL_PER_KM = 0.3;

    @Override
    public double calculateFuel(double distance) {
        return distance * FUEL_PER_KM;
    }
}
```

The client can activate it with:

```java
planner.setStrategy(new SolarAssistFlightStrategy());
```

No changes to FlightPlanner are needed.

## Author

Bazarbay Uldanay  
Astana IT University  
Software Engineering
