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

### Basic Arithmetic Calculations

#### Addition
1. Click `5`
2. Click `+`
3. Click `3`
4. Click `=`
5. Result: `8`

#### Subtraction
1. Click `10`
2. Click `-`
3. Click `4`
4. Click `=`
5. Result: `6`

#### Multiplication
1. Click `7`
2. Click `×`
3. Click `8`
4. Click `=`
5. Result: `56`

#### Division
1. Click `20`
2. Click `÷`
3. Click `4`
4. Click `=`
5. Result: `5`

### Percentage Calculations

#### Calculate Percentage
1. Click `200`
2. Click `%`
3. Result: `2` (200 ÷ 100)

#### Calculate Percentage of a Number
1. Click `50`
2. Click `+`
3. Click `10`
4. Click `%`
5. Click `=`
6. Result: `55` (50 + 10% of 50)

### Sign Toggle

#### Negate a Number
1. Click `42`
2. Click `+/-`
3. Result: `-42`

### Scientific Function Examples

#### Trigonometric (Sine)
1. Set Angle Mode to `Degrees`
2. Click `90`
3. Click `sin`
4. Result: `1` (sin(90°) = 1)

#### Logarithm (Base 10)
1. Click `100`
2. Click `log`
3. Result: `2` (log₁₀(100) = 2)

#### Natural Logarithm
1. Click `2.718`
2. Click `ln`
3. Result: `1` (approximately ln(e) = 1)

#### Square Root
1. Click `16`
2. Click `√`
3. Result: `4`

#### Square (x²)
1. Click `5`
2. Click `x²`
3. Result: `25`

#### Power (x^y)
1. Click `2`
2. Click `x^y`
3. Click `3`
4. Click `=`
5. Result: `8` (2³ = 8)

#### Factorial
1. Click `5`
2. Click `!`
3. Result: `120` (5! = 120)

#### Inverse Sine (arcsin)
1. Set Angle Mode to `Degrees`
2. Click `0.5`
3. Click `asin`
4. Result: `30` (arcsin(0.5) = 30°)

#### Hyperbolic Functions (sinh)
1. Click `1`
2. Click `sinh`
3. Result: `1.1753` (sinh(1) ≈ 1.1753)

### Using Mathematical Constants

#### Using Pi (π)
1. Click `π`
2. Display shows: `3.14159...`
3. Click `×` to multiply with π

#### Using Euler's Number (e)
1. Click `e`
2. Display shows: `2.71828...`
3. Click `÷` to divide by e

### Memory Function Examples

#### Add to Memory (M+)
1. Enter and calculate: `50 + 30 = 80`
2. Click `M+`
3. Memory label shows: `Memory: 80`

#### Add Another Value to Memory
1. Enter and calculate: `20 + 10 = 30`
2. Click `M+`
3. Memory label shows: `Memory: 110`

#### Recall from Memory (MR)
1. Click `MR`
2. Display shows: `110` (the sum stored in memory)

#### Subtract from Memory (M-)
1. Enter: `50`
2. Click `M-`
3. Memory label shows: `Memory: 60` (110 - 50)

#### Clear Memory (MC)
1. Click `MC`
2. Memory label shows: `Memory: 0`

### Angle Mode Examples

#### Degrees Mode (Default)
1. Set Angle Mode to `Degrees`
2. Click `45`
3. Click `sin`
4. Result: `0.707` (sin(45°) ≈ 0.707)

#### Radians Mode
1. Set Angle Mode to `Radians`
2. Click `1.5708`
3. Click `sin`
4. Result: `1` (sin(π/2) = 1)

#### Gradians Mode
1. Set Angle Mode to `Gradians`
2. Click `50`
3. Click `sin`
4. Result: `0.707` (sin(50 grad) ≈ 0.707)

### Decimal Precision Settings

#### Set to 2 Decimal Places (Default)
1. Select `2` from Decimal Places dropdown
2. Result displays: `3.14`

#### Set to 4 Decimal Places
1. Select `4` from Decimal Places dropdown
2. Result displays: `3.1416`

#### Set to 8 Decimal Places
1. Select `8` from Decimal Places dropdown
2. Result displays: `3.14159265`

### Keyboard Input Examples

#### Quick Addition with Keyboard
1. Press `5`
2. Press `+`
3. Press `3`
4. Press `Enter`
5. Result: `8`

#### Clear with Keyboard
1. Click any number
2. Press `Backspace`
3. Display clears to `0`
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

### Basic Arithmetic Calculations

#### Addition
1. Click `5`
2. Click `+`
3. Click `3`
4. Click `=`
5. Result: `8`

#### Subtraction
1. Click `10`
2. Click `-`
3. Click `4`
4. Click `=`
5. Result: `6`

#### Multiplication
1. Click `7`
2. Click `×`
3. Click `8`
4. Click `=`
5. Result: `56`

#### Division
1. Click `20`
2. Click `÷`
3. Click `4`
4. Click `=`
5. Result: `5`

### Percentage Calculations

#### Calculate Percentage
1. Click `200`
2. Click `%`
3. Result: `2` (200 ÷ 100)

#### Calculate Percentage of a Number
1. Click `50`
2. Click `+`
3. Click `10`
4. Click `%`
5. Click `=`
6. Result: `55` (50 + 10% of 50)

### Sign Toggle

#### Negate a Number
1. Click `42`
2. Click `+/-`
3. Result: `-42`

### Scientific Function Examples

#### Trigonometric (Sine)
1. Set Angle Mode to `Degrees`
2. Click `90`
3. Click `sin`
4. Result: `1` (sin(90°) = 1)

#### Logarithm (Base 10)
1. Click `100`
2. Click `log`
3. Result: `2` (log₁₀(100) = 2)

#### Natural Logarithm
1. Click `2.718`
2. Click `ln`
3. Result: `1` (approximately ln(e) = 1)

#### Square Root
1. Click `16`
2. Click `√`
3. Result: `4`

#### Square (x²)
1. Click `5`
2. Click `x²`
3. Result: `25`

#### Power (x^y)
1. Click `2`
2. Click `x^y`
3. Click `3`
4. Click `=`
5. Result: `8` (2³ = 8)

#### Factorial
1. Click `5`
2. Click `!`
3. Result: `120` (5! = 120)

#### Inverse Sine (arcsin)
1. Set Angle Mode to `Degrees`
2. Click `0.5`
3. Click `asin`
4. Result: `30` (arcsin(0.5) = 30°)

#### Hyperbolic Functions (sinh)
1. Click `1`
2. Click `sinh`
3. Result: `1.1753` (sinh(1) ≈ 1.1753)

### Using Mathematical Constants

#### Using Pi (π)
1. Click `π`
2. Display shows: `3.14159...`
3. Click `×` to multiply with π

#### Using Euler's Number (e)
1. Click `e`
2. Display shows: `2.71828...`
3. Click `÷` to divide by e

### Memory Function Examples

#### Add to Memory (M+)
1. Enter and calculate: `50 + 30 = 80`
2. Click `M+`
3. Memory label shows: `Memory: 80`

#### Add Another Value to Memory
1. Enter and calculate: `20 + 10 = 30`
2. Click `M+`
3. Memory label shows: `Memory: 110`

#### Recall from Memory (MR)
1. Click `MR`
2. Display shows: `110` (the sum stored in memory)

#### Subtract from Memory (M-)
1. Enter: `50`
2. Click `M-`
3. Memory label shows: `Memory: 60` (110 - 50)

#### Clear Memory (MC)
1. Click `MC`
2. Memory label shows: `Memory: 0`

### Angle Mode Examples

#### Degrees Mode (Default)
1. Set Angle Mode to `Degrees`
2. Click `45`
3. Click `sin`
4. Result: `0.707` (sin(45°) ≈ 0.707)

#### Radians Mode
1. Set Angle Mode to `Radians`
2. Click `1.5708`
3. Click `sin`
4. Result: `1` (sin(π/2) = 1)

#### Gradians Mode
1. Set Angle Mode to `Gradians`
2. Click `50`
3. Click `sin`
4. Result: `0.707` (sin(50 grad) ≈ 0.707)

### Decimal Precision Settings

#### Set to 2 Decimal Places (Default)
1. Select `2` from Decimal Places dropdown
2. Result displays: `3.14`

#### Set to 4 Decimal Places
1. Select `4` from Decimal Places dropdown
2. Result displays: `3.1416`

#### Set to 8 Decimal Places
1. Select `8` from Decimal Places dropdown
2. Result displays: `3.14159265`

### Keyboard Input Examples

#### Quick Addition with Keyboard
1. Press `5`
2. Press `+`
3. Press `3`
4. Press `Enter`
5. Result: `8`

#### Clear with Keyboard
1. Click any number
2. Press `Backspace`
3. Display clears to `0`

### Theme Switching

#### Switch to Light Mode
1. Click menu `Theme`
2. Click `Light Mode`
3. Calculator switches to light colors for better visibility

#### Switch Back to Dark Mode
1. Click menu `Theme`
2. Click `Dark Mode`
3. Calculator returns to dark theme

## Project Structure

```
Calculator/
├── src/
│   ├── App.java           - Entry point of the application
│   └── Calculator.java    - Main calculator logic and GUI
├── bin/                   - Compiled output files
├── lib/                   - Dependencies (if any)
└── README.md              - This file
```

### App.java
Entry point that initializes and displays the Calculator.

### Calculator.java
Main calculator class containing:
- GUI components (JFrame, JLabel, JPanel)
- 36 button layout (6×6 grid) with color coding
- Event listeners for button clicks and keyboard input
- Advanced calculator logic with 23+ scientific functions
- Theme management system (Dark/Light modes)
- Real-time calculation history display
- Memory functionality (M+, M-, MR, MC)
- Angle mode converter (Degrees/Radians/Gradians)
- Decimal precision formatter (2, 4, 6, 8 places)

## Color Scheme

### Dark Mode (Default)
- **Display Background**: Black (#1C1C1C)
- **Display Text**: White
- **Top Buttons** (Clear, Delete, %): Light Gray (#DDD4D2)
- **Operator Buttons** (+, -, ×, ÷): Orange (#FF9500)
- **Scientific Buttons**: Blue (#6496C8)
- **Number Buttons** (0-9, .): Dark Gray (#505050)
- **Frame Background**: Black (#1C1C1C)

### Light Mode
- **Display Background**: White
- **Display Text**: Black
- **Top Buttons**: Gray (#E0E0E0)
- **Operator Buttons**: Orange (#FF9500)
- **Scientific Buttons**: Light Blue (#87CEEB)
- **Number Buttons**: Light Gray (#F5F5F5)
- **Frame Background**: White

## Available Scientific Functions

### Trigonometric Functions
- **sin(x)** - Sine of angle x
- **cos(x)** - Cosine of angle x
- **tan(x)** - Tangent of angle x
- **asin(x)** - Inverse sine (arcsin)
- **acos(x)** - Inverse cosine (arccos)
- **atan(x)** - Inverse tangent (arctan)

### Hyperbolic Functions
- **sinh(x)** - Hyperbolic sine
- **cosh(x)** - Hyperbolic cosine
- **tanh(x)** - Hyperbolic tangent

### Logarithmic Functions
- **log(x)** - Base 10 logarithm
- **ln(x)** - Natural logarithm (base e)

### Power & Root Functions
- **x²** - Square of a number
- **x^y** - Raise x to power y
- **√x** - Square root of x
- **x!** - Factorial of x (positive integers only)

### Mathematical Constants
- **π** ≈ 3.14159265359
- **e** ≈ 2.71828182846

## Window Size & Layout

- **Default Width**: 900 pixels
- **Default Height**: 800 pixels
- **Button Grid**: 6 rows × 6 columns (36 total buttons)
- **Layout**: BorderLayout with split pane for buttons and history
- **Display**: Large JLabel showing current calculation
- **History Panel**: Scrollable JTextArea showing all calculations

## Error Handling

The calculator includes robust error handling for:
- **Division by zero** - Shows error message and resets
- **Square root of negative numbers** - Shows error message and prevents calculation
- **Logarithm of non-positive numbers** - Shows error and prevents calculation
- **Invalid factorial inputs** - Only accepts positive integers up to reasonable limit
- **Invalid number formats** - Prevents non-numeric input
- **Domain errors** - Inverse trig functions (asin, acos) limited to [-1, 1]

## Technical Details

- **Framework**: Java Swing with AWT events
- **JDK Version**: 25+ with `--enable-preview` flag
- **Compilation**: `javac -d bin src/App.java src/Calculator.java`
- **Execution**: `java --enable-preview -cp bin App`
- **Number Formatting**: DecimalFormat with configurable precision
- **History Storage**: In-memory ArrayList with automatic GUI update
- **Memory System**: Single double variable with persistent display

## Future Enhancements

- Conversion calculator (units, currencies)
- More advanced functions (Bessel functions, etc.)
- Scientific notation support
- Graphing capabilities
- Data history export (CSV, JSON)
- Custom keyboard shortcuts configuration
- Plugin system for custom functions
- Syntax highlighting for calculations
- Multi-line calculation history
