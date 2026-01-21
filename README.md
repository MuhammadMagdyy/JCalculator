# JCalculator

A comprehensive scientific GUI calculator application built in Java using Swing. This calculator features a clean, modern interface with color-coded buttons, supporting both basic arithmetic operations and advanced scientific functions.

## Features

- **Clean GUI Interface** - User-friendly graphical interface built with Java Swing
- **Color-Coded Buttons** - 
  - Light gray for utility functions (AC, +/-, %)
  - Orange for operators (÷, ×, -, +, =)
  - Blue for scientific functions
  - Dark gray for numbers and decimal point
- **Basic Operations** - Addition, subtraction, multiplication, and division
- **Scientific Functions**:
  - **Trigonometric**: sin, cos, tan (angles in degrees)
  - **Logarithmic**: log (base 10), ln (natural logarithm)
  - **Power Functions**: x², x^y (custom exponent)
  - **Root Functions**: √ (square root)
  - **Advanced**: ! (factorial for positive integers)
  - **Constants**: π (pi), e (Euler's number)
- **Keyboard Support** - Type numbers and operations directly from your keyboard
  - Numbers: 0-9
  - Operations: +, -, *, /
  - Calculate: Enter
  - Clear: Backspace
- **Calculation History** - All calculations are logged and displayed in console
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

### Basic Operations
1. Click number buttons (0-9) to input numbers
2. Click operator buttons (+, -, ×, ÷) to perform operations
3. Click "=" to calculate the result
4. Click "AC" to clear all and start fresh
5. Click "+/-" to toggle the sign of the current number
6. Click "%" to get the percentage

### Scientific Functions
- **sin/cos/tan** - Enter angle in degrees and click the function button
- **log/ln** - Enter a positive number and click the function button
- **√** - Enter a positive number and click to get square root
- **x²** - Enter a number and click to square it
- **x^y** - Enter base number, click x^y, enter exponent, click =
- **!** - Enter a positive integer and click for factorial
- **π** - Click to insert the value of pi
- **e** - Click to insert Euler's number

### Keyboard Shortcuts
- Type numbers directly (0-9)
- Use +, -, *, / for operations
- Press Enter to calculate (=)
- Press Backspace to clear (AC)

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
- **Scientific Buttons**: Blue (#6496C8)
- **Number Buttons**: Dark Gray (#505050)
- **Frame Background**: Black (#1C1C1C)

## Available Scientific Functions

### Trigonometric (in degrees)
- sin(x) - Sine of angle x
- cos(x) - Cosine of angle x
- tan(x) - Tangent of angle x

### Logarithmic
- log(x) - Base 10 logarithm
- ln(x) - Natural logarithm (base e)

### Power & Root
- x² - Square of a number
- x^y - Raise x to power y
- √x - Square root of x

### Advanced
- x! - Factorial of x (positive integers only)

### Mathematical Constants
- π ≈ 3.14159265359
- e ≈ 2.71828182846

## Window Size

- **Default Width**: 600 pixels
- **Default Height**: 700 pixels
- Grid Layout: 5 rows × 6 columns for comprehensive button layout

## Error Handling

The calculator includes robust error handling for:
- Division by zero
- Square root of negative numbers
- Logarithm of non-positive numbers
- Invalid factorial inputs
- Invalid number formats

## Future Enhancements

- Theme customization (dark mode, light mode)
- More advanced functions (hyperbolic functions, inverse trig)
- Calculation history panel (visible in GUI)
- Memory functions (M+, M-, MR, MC)
- Different angle modes (radians, gradians)
- Decimal precision settings
