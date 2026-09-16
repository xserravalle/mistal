# Mistal

A text-based RPG built in Java, designed to reinforce core Object-Oriented Programming (OOP) concepts and foundational Java principles through manual implementation without heavy third-party abstractions.

Designed and developed by **Peyton Holland** as an ongoing portfolio project.

---

## 🎯 Project Goals

- **Reinforce OOP Foundations**: Practical application of encapsulation, inheritance, polymorphism, and abstraction.
- **Manual Implementation**: Writing core game mechanics, input handling, and domain logic by hand rather than relying on high-level frameworks.
- **Clean Architecture & Design**: Establishing clean domain models, defensive boundary validation, and clear separation of concerns.

---

## 🛠️ Current Features (Early Stages)

- **Encapsulated Player Model (`Player.java`)**:
  - State management for player attributes: Name, Max HP, Current HP, Attack Power, and Gold.
  - **Constructor Overloading & Chaining**: Multi-tier constructors defaulting RPG base stats while delegating to a primary constructor via `this(...)`.
  - **Defensive Boundary Checks**: Enforces invariants (e.g. `currentHp` clamped between `0` and `maxHp` using `Math.clamp()`, non-negative gold and attack power).
  - **Domain Logic**: Dynamic methods for taking damage, healing, earning/spending gold, and life state checks (`isAlive()`).
  - **Contract Overrides**: Custom implementations of `toString()`, `equals()`, and `hashCode()` using modern pattern matching.

- **Game Engine & CLI Flow (`Main.java`)**:
  - Interactive terminal intro screen and banner.
  - Player character creation and name entry with input sanitation.
  - Race selection system (Human, Elven, Kurgar).

---

## 📂 Project Structure

```
Mistal/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── Main.java      # Application entry point and interactive game loop
│   │       └── Player.java    # Core player entity and OOP domain model
│   └── test/
│       └── java/
├── pom.xml                    # Maven project configuration (Java 25)
└── README.md                  # Project documentation
```

---

## 🚀 Getting Started

### Prerequisites
- **JDK 25** (or compatible modern JDK)
- **Maven** (or your preferred IDE such as IntelliJ IDEA, Eclipse, or VS Code)

### Running via Terminal
1. Compile the source files:
   ```bash
   javac -d target/classes src/main/java/*.java
   ```
2. Run the game:
   ```bash
   java -cp target/classes Main
   ```

### Running via Maven
```bash
mvn compile
mvn exec:java -Dexec.mainClass="Main"
```
