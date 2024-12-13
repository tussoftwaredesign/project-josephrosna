# OOP1 Assignment

This project demonstrates various modern Java features through a House Rental Management System. The features are integrated into different parts of the code to showcase their usage and benefits in a real-world application.

## Fundamentals:

### 1. Classes:

#### 1.1 Contrast `this()` and `this`

#### 1.2 Method Overloading

#### 1.3 Varargs

#### 1.4 Local Variable Type Inference (LVTI)

### 2. Encapsulation

### 3. Interfaces

### 4. Inheritance:

#### 4.1 Overriding and Polymorphism

#### 4.2 Contrast `super()` and `super.`

### 5. Exceptions:

#### 5.1 Checked Exceptions

#### 5.2 Unchecked Exceptions

### 6. Enums

### 7. Arrays

### 8. Java Core API:

#### 8.1 String

#### 8.2 StringBuilder

#### 8.3 List/ArrayList

#### 8.4 Date API

## Advanced:

### 9. Call-by-Value and Defensive Copying

### 10. Private, Default, and Static Interface Methods

### 11. Records

### 12. Custom Immutable Type

### 13. Lambdas (Predicate):

#### 13.1 Discussion of `final` or Effectively Final

#### 13.2 Method References

### 14. Switch Expressions and Pattern Matching

### 15. Sealed Classes and Interfaces



# House Rental Management System

The main class demonstrates the application functionality and allows users to interact with the system via terminal commands.

![UML Diagram](house-rental-management-uml-diagram.svg)

## Features

### 1. Classes
- **Contrast `this()` and `this`**: Demonstrated in `Person` and `Landlord` classes.
- **Method Overloading**: Demonstrated in `Person` and `Landlord` classes.
- **Varargs**: Demonstrated in `Utility` class with `readInt` method.
- **Local Variable Type Inference (LVTI)**: Demonstrated in `RentalService` class with `displayPropertyDetails` method.

### 2. Encapsulation
- Demonstrated in `Person` and `Landlord` classes with private fields and public getters/setters.

### 3. Interfaces
- Demonstrated in `PropertyInterface` and implemented by `House` and `Apartment` classes.

### 4. Inheritance
- **Overriding and Polymorphism**: Demonstrated in `Landlord` class.
- **Contrast `super()` and `super.`**: Demonstrated in `Landlord` class.

### 5. Exceptions
- **Checked Exceptions**: Demonstrated in `Main` class with `PropertyNotFoundException`.
- **Unchecked Exceptions**: Demonstrated in `InvalidPaymentException`.

### 6. Enums
- Demonstrated in `PropertyType`.

### 7. Arrays
- Demonstrated in `Utility` class and `RentalService` class.

### 8. Java Core API
- **String**: Demonstrated in various parts of the code.
- **StringBuilder**: Demonstrated in `Main` class with `displayAvailableProperties` method.
- **List/ArrayList**: Demonstrated in `RentalService` class.
- **Date API**: Demonstrated in `RentalAgreement` and `Main` class with `rentProperty` method.

### 9. Advanced
- **Call-by-Value and Defensive Copying**: Demonstrated in `RentalService` class with `getTenantCopy` and `copyProperty` methods.
- **Private, Default, and Static Interface Methods**: Demonstrated in `PropertyInterface`.
- **Records**: Demonstrated with `RentalAgreement`.
- **Custom Immutable Type**: Demonstrated with `ImmutableProperty`.
- **Lambdas (Predicate)**:
  - **Discussion of `final` or Effectively Final**: Demonstrated in `RentalService` class with `demonstrateFinalAndMethodReferences` method.
  - **Method References**: Demonstrated in `RentalService` class with `demonstrateFinalAndMethodReferences` method.
- **Switch Expressions and Pattern Matching**: Demonstrated in `RentalService` class.
- **Sealed Classes and Interfaces**: Demonstrated in `Property`, `House`, and `Apartment`.

## Where Each Feature is Used

### Main.java
- **StringBuilder**: Used in `displayAvailableProperties` method.
- **Date API**: Used in `rentProperty` method.
- **Call-by-Value and Defensive Copying**: Used in `copyProperty` method.
- **Records**: Used in `rentProperty` method with `RentalAgreement`.
- **Custom Immutable Type**: Used in `demonstrateImmutableProperty` method.
- **Lambdas (Predicate)**: Used in `checkAffordableProperties` method.
  - **Discussion of `final` or Effectively Final**: Used in `checkAffordableProperties` method.
  - **Method References**: Used in `checkAffordableProperties` method.

### RentalService.java
- **Local Variable Type Inference (LVTI)**: Used in `displayPropertyDetails` method.
- **Call-by-Value and Defensive Copying**: Used in `getTenantCopy` and `copyProperty` methods.
- **Private, Default, and Static Interface Methods**: Used in `PropertyInterface`.
- **Records**: Used with `RentalAgreement`.
- **Custom Immutable Type**: Used with `ImmutableProperty`.
- **Lambdas (Predicate)**: Used in `demonstrateFinalAndMethodReferences` method.
  - **Discussion of `final` or Effectively Final**: Used in `demonstrateFinalAndMethodReferences` method.
  - **Method References**: Used in `demonstrateFinalAndMethodReferences` method.
- **Switch Expressions and Pattern Matching**: Used in `RentalService` class.
- **Sealed Classes and Interfaces**: Used in `Property`, `House`, and `Apartment`.

### Utility.java
- **Varargs**: Used in `readInt` method.

### Person.java and Landlord.java
- **Contrast `this()` and `this`**: Demonstrated in constructors.
- **Method Overloading**: Demonstrated with overloaded methods.
- **Encapsulation**: Demonstrated with private fields and public getters/setters.

### PropertyInterface.java
- **Interfaces**: Demonstrated with `PropertyInterface`.
- **Private, Default, and Static Interface Methods**: Demonstrated in `PropertyInterface`.

### PropertyType.java
- **Enums**: Demonstrated with `PropertyType`.

### InvalidPaymentException.java
- **Unchecked Exceptions**: Demonstrated with `InvalidPaymentException`.

### Property.java, House.java, and Apartment.java
- **Sealed Classes and Interfaces**: Demonstrated with `Property`, `House`, and `Apartment`.

### PropertyNotFoundException.java
- **Checked Exceptions**: Demonstrated with `PropertyNotFoundException`.
