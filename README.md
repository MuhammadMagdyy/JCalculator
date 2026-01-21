# JCalculator

A comprehensive advanced scientific GUI calculator application built in Java using Swing. This calculator features a modern interface with dark/light theme customization, color-coded buttons, memory functions, visible calculation history, and extensive mathematical operations.

## Features

### Core Functionality
- **Clean GUI Interface** - User-friendly graphical interface built with Java Swing
- **Color-Coded Buttons** - 
  - Light gray for utility functions (AC, +/-, %)
  - Orange for operators (÷, ×, -, +, =)
  - Blue for scientific and advanced functions
  - Dark gray for numbers and decimal point
- **Display** - Large display label showing current input/output with customizable decimal precision

### Arithmetic Operations
- Basic arithmetic: Addition, subtraction, multiplication, and division
- Percentage calculations
- Sign toggle (+/-)

### Scientific Functions
- **Trigonometric**: sin, cos, tan (with angle mode support)
- **Inverse Trigonometric**: arcsin (asin), arccos (acos), arctan (atan)
- **Hyperbolic**: sinh, cosh, tanh
- **Logarithmic**: log (base 10), ln (natural logarithm)
- **Power Functions**: x², x^y (custom exponent)
- **Root Functions**: √ (square root)
- **Advanced**: ! (factorial for positive integers)
- **Mathematical Constants**: π (pi), e (Euler's number)

### Advanced Features
1. **Theme Customization** - Switch between dark mode and light mode
2. **Calculation History** - Visible scrollable panel showing all calculations
3. **Memory Functions** - M+ (add), M- (subtract), MR (recall), MC (clear)
4. **Angle Modes** - Select between Degrees, Radians, and Gradians for trigonometric functions
5. **Decimal Precision** - Choose to display 2, 4, 6, or 8 decimal places
6. **Keyboard Support** - Type numbers and operations directly from keyboard
   - Numbers: 0-9
   - Operations: +, -, *, /
   - Calculate: Enter
   - Clear: Backspace

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

The calculator window will appear with all buttons, memory panel, and history panel.

## How to Use

### Basic Operations
1. Click number buttons (0-9) to input numbers
2. Click operator buttons (+, -, ×, ÷) to perform operations
3. Click "=" to calculate the result
4. Click "AC" to clear all and start fresh
5. Click "+/-" to toggle the sign of the current number
6. Click "%" to get the percentage

### Scientific Functions
- **sin/cos/tan** - Enter angle and click the function button (respects angle mode)
- **asin/acos/atan** - Enter a value in [-1, 1] range for inverse functions
- **sinh/cosh/tanh** - Hyperbolic functions
- **log/ln** - Enter a positive number and click the function button
- **√** - Enter a positive number and click to get square root
- **x²** - Enter a number and click to square it
- **x^y** - Enter base number, click x^y, enter exponent, click =
- **!** - Enter a positive integer and click for factorial
- **π** - Click to insert the value of pi
- **e** - Click to insert Euler's number

### Memory Functions
- **M+** - Add current display value to memory
- **M-** - Subtract current display value from memory
- **MR** - Recall value from memory to display
- **MC** - Clear memory

### Settings
- **Angle Mode** - Choose Degrees, Radians, or Gradians for trigonometric calculations
- **Decimal Places** - Set precision to 2, 4, 6, or 8 decimal places

### Theme
- Use the **Theme** menu to switch between Dark Mode and Light Mode
- Dark Mode: Default theme with dark colors
- Light Mode: Bright theme for better visibility

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
- GUI components (JFrame, JLabel, JPanel, JTextArea)
- Theme management with dark/light modes
- Memory functions implementation
- Button layout and styling with scientific functions
- Event listeners for button clicks and keyboard input
- Complete calculator logic for all operations
- Angle conversion for different angle modes
- Decimal formatting with precision control

## Color Scheme

### Dark Mode
- **Display Background**: Black (#1C1C1C)
- **Display Text**: White
- **Top Buttons**: Light Gray (#DDD4D2)
- **Operator Buttons**: Orange (#FF9500)
- **Scientific Buttons**: Blue (#6496C8)
- **Number Buttons**: Dark Gray (#505050)
- **Panel Background**: Dark (#282828)

### Light Mode
- **Display Background**: Light Gray (#F0F0F0)
- **Display Text**: Black
- **Top Buttons**: Light Gray (#DDD4D2)
- **Operator Buttons**: Orange (#FF9500)
- **Scientific Buttons**: Blue (#6496C8)
- **Number Buttons**: Dark Gray (#505050)
- **Panel Background**: Very Light (#E6E6E6)

## Window Size

- **Default Width**: 900 pixels
- **Default Height**: 800 pixels
- **Layout**: Split pane with buttons on left and history on right
- **Button Grid**: 6 rows × 6 columns for comprehensive button layout

## Error Handling

The calculator includes robust error handling for:
- Division by zero
- Square root of negative numbers
- Logarithm of non-positive numbers
- Invalid factorial inputs (only non-negative integers)
- Invalid number formats
- Domain errors for inverse trigonometric functions

## Supported Angle Modes

1. **Degrees** - Standard degree measurement (0-360°)
2. **Radians** - Radian measurement (0-2π)
3. **Gradians** - Gradian measurement (0-400 grad)

## Decimal Precision Options

- 2 decimal places (default)
- 4 decimal places
- 6 decimal places
- 8 decimal places

## Technical Details

- **Language**: Java
- **GUI Framework**: Swing
- **Layout Managers**: BorderLayout, GridLayout, FlowLayout
- **Calculation Method**: Direct computation with error handling
- **History Storage**: In-memory ArrayList with GUI display

## Future Enhancements

- Conversion calculator (units, currencies)
- More scientific functions (Bessel functions, etc.)
- Scientific notation support
- Graphing capabilities
- Data history export (CSV, JSON)
- Custom keyboard shortcuts
- Plugin system for custom functions

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
