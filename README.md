# JCalculator

A simple GUI calculator application built in Java using Swing. This calculator features a clean, modern interface with color-coded buttons and basic arithmetic operations.

## Features

- **Clean GUI Interface** - User-friendly graphical interface built with Java Swing
- **Color-Coded Buttons** - 
  - Light gray for utility functions (AC, +/-, %)
  - Orange for operators (÷, ×, -, +, =)
  - Dark gray for numbers and decimal point
- **Basic Operations** - Addition, subtraction, multiplication, and division
- **Additional Functions** - Percentage, sign toggle, and square root (√) button
- **Display** - Large display label showing current input/output

## Folder Structure

```
Calculator/
├── src/
│   ├── App.java           - Entry point of the application
│   └── Calculator.java    - Main calculator logic and GUI
├── bin/                   - Compiled output files
├── lib/                   - Dependencies (if any)
└── README.md              - This file
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 25 or higher
- A terminal or IDE to run Java code

### Running the Application

1. **Compile the code:**
   ```bash
   javac -d bin src/App.java src/Calculator.java
   ```

2. **Run the application:**
   ```bash
   java --enable-preview -cp bin App
   ```

The calculator window will appear with all buttons displayed with their respective colors.

## How to Use

1. Click number buttons (0-9) to input numbers
2. Click operator buttons (+, -, ×, ÷) to perform operations
3. Click "=" to calculate the result
4. Click "AC" to clear all and start fresh
5. Click "+/-" to toggle the sign of the current number
6. Click "%" to get the percentage

## Project Structure

### App.java
Entry point that initializes and displays the Calculator.

### Calculator.java
Main calculator class containing:
- GUI components (JFrame, JLabel, JPanel)
- Button layout and styling
- Event listeners for button clicks
- Calculator logic for operations

## Color Scheme

- **Display Background**: Black (#1C1C1C)
- **Display Text**: White
- **Top Buttons**: Light Gray (#DDD4D2)
- **Operator Buttons**: Orange (#FF9500)
- **Number Buttons**: Dark Gray (#505050)
- **Frame Background**: Black (#1C1C1C)

## Future Enhancements

- Implement complete calculation logic for operators
- Add keyboard support
- Add calculation history
- Add more functions (sin, cos, tan, etc.)
- Theme customization
