# JCalculator Pro - Ultra Vibrant Edition

An advanced professional-grade scientific GUI calculator application built in Java using Swing. Features a stunning multi-tab interface with vibrant color-coded buttons, dark/light theme customization, unit conversion, Bessel functions, history export, custom keyboard shortcuts, scientific notation, and extensive mathematical operations. **NOW WITH EGYPTIAN POUND (EGP) SUPPORT!**

## Features

### 🎨 Enhanced Visual Design
- **Vibrant Color Palette** - Beautiful, modern UI with 10+ vibrant accent colors
  - Vibrant Green for equals (✓ calculations)
  - Vibrant Orange for operators with hover effects
  - Vibrant Blue for scientific functions
  - Vibrant Purple for memory functions
  - Vibrant Cyan for special functions
  - Vibrant Pink for Bessel functions
  - Vibrant Red for clear functions
  - Vibrant Yellow, Teal, Indigo for enhanced contrast
- **Interactive Button Effects** - Smooth hover effects that brighten on interaction
- **Premium Typography** - Monospaced fonts for display, bold Arial for buttons
- **Gradient Displays** - Beautiful gradient-based display panel background
- **Modern Theme** - Completely redesigned dark and light modes

### Core Functionality
- **Clean GUI Interface** - User-friendly graphical interface built with Java Swing with tabbed navigation
- **Color-Coded Buttons** - 
  - **Red** for utility functions (AC, +/-, %)
  - **Orange** for operators (÷, ×, -, +) with brightness hover
  - **Blue** for scientific functions
  - **Purple** for memory functions (M+, M-, MR, MC)
  - **Green** for equals (=)
  - **Pink** for Bessel functions
  - **Cyan** for history and export functions
  - **Dark Gray/Light Gray** for number buttons
- **Display** - Premium display with gradient background, cyan text in dark mode, indigo text in light mode
- **Tabbed Interface** - Calculator, Conversions, and Settings tabs for organized feature access
- **Hover Effects** - All buttons brighten on mouse hover for better interactivity

### Arithmetic Operations
- Basic arithmetic: Addition, subtraction, multiplication, and division
- Percentage calculations
- Sign toggle (+/-)
- Division by zero error handling

### Scientific Functions (23+ Functions)
- **Trigonometric**: sin, cos, tan (with angle mode support)
- **Inverse Trigonometric**: arcsin (asin), arccos (acos), arctan (atan)
- **Hyperbolic**: sinh, cosh, tanh
- **Logarithmic**: log (base 10), ln (natural logarithm)
- **Power Functions**: x², x^y (custom exponent)
- **Root Functions**: √ (square root)
- **Advanced**: ! (factorial for positive integers)
- **Bessel Functions**: J0, J1, Y0, Y1 (pink colored buttons)
- **Mathematical Constants**: π (pi), e (Euler's number)

### Advanced Features
1. **Theme Customization** - Switch between vibrant dark mode and vibrant light mode via Theme menu
2. **Calculation History** - Visible scrollable pane showing all calculations with syntax highlighting and timestamps
3. **Memory Functions** - M+ (add), M- (subtract), MR (recall), MC (clear) with purple buttons
4. **Angle Modes** - Select between Degrees, Radians, and Gradians for trigonometric functions
5. **Decimal Precision** - Choose to display 2, 4, 6, or 8 decimal places
6. **Scientific Notation** - Toggle scientific notation display (e.g., 1.23e+05)
7. **Keyboard Support** - Type numbers and operations directly from keyboard with custom shortcuts

### Conversion Calculator
- **Unit Conversions**:
  - Length: meters, kilometers, centimeters, millimeters, miles, yards, feet, inches
  - Weight: kilograms, grams, milligrams, pounds, ounces, tonnes
  - Temperature: Celsius, Fahrenheit, Kelvin
- **Currency Conversion**: USD, EUR, GBP, JPY, CAD, AUD, CHF, CNY, **EGP (Egyptian Pound)**

### Data Export & History
- **Export Calculation History as JSON** - Complete history with timestamps in JSON format
- **Export Calculation History as CSV** - Spreadsheet-compatible format
- **Real-time History Display** - All calculations visible with green color-coded results
- **Clear History** - Reset history at any time

### Custom Settings & Configuration
- **Custom Keyboard Shortcuts** - Configure custom shortcuts for functions (e.g., q=sqrt, s=sin, etc.)
- **Display Formatting** - Toggle scientific notation, adjust decimal places
- **Theme Settings** - Vibrant Dark/Light mode configuration
- **Keyboard Shortcuts Reference** - Built-in help for all keyboard shortcuts

### Enhanced Display Features
- **Syntax Highlighting** - Calculation history with color-coded operations and results
- **Multi-line History** - Timestamped calculations with full equation display
- **Error Messages** - Clear error handling for domain errors (sqrt of negative, log of zero, etc.)

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

### Bessel Function Examples

#### Bessel Function of the First Kind (J0)
1. Click `Bessel` button
2. Select `J0` from dialog
3. Enter value `0.5`
4. Result: `0.9385` (J0(0.5) ≈ 0.9385)

#### Bessel Function of the Second Kind (Y0)
1. Click `Bessel` button
2. Select `Y0` from dialog
3. Enter value `1`
4. Result: `0.6366` (Y0(1) ≈ 0.6366)

### Unit Conversion Examples

#### Length Conversion (Miles to Kilometers)
1. Click `Conversions` tab
2. Enter `5` in the length conversion field
3. Select `mi` (Miles) in "From" dropdown
4. Select `km` (Kilometers) in "To" dropdown
5. Click `Convert`
6. Result: `8.05` km

#### Weight Conversion (Pounds to Kilograms)
1. Click `Conversions` tab
2. Enter `150` in the weight conversion field
3. Select `lb` (Pounds) in "From" dropdown
4. Select `kg` (Kilograms) in "To" dropdown
5. Click `Convert`
6. Result: `68.04` kg

#### Temperature Conversion (Celsius to Fahrenheit)
1. Click `Conversions` tab
2. Enter `25` in the temperature conversion field
3. Select `Celsius` in "From" dropdown
4. Select `Fahrenheit` in "To" dropdown
5. Click `Convert`
6. Result: `77` °F

#### Currency Conversion (EUR to USD)
1. Click `Conversions` tab
2. Enter `100` in the currency conversion field
3. Select `EUR` (Euros) in "From" dropdown
4. Select `USD` (US Dollars) in "To" dropdown
5. Click `Convert`
6. Result: `108.70` USD (approximate, rates may vary)

#### Currency Conversion (USD to EGP - Egyptian Pound) ✨ NEW
1. Click `Conversions` tab
2. Enter `100` in the currency conversion field
3. Select `USD` (US Dollars) in "From" dropdown
4. Select `EGP` (Egyptian Pound) in "To" dropdown
5. Click `Convert`
6. Result: `3065` EGP (Egyptian Pound conversion at rate 1 USD = 30.65 EGP)

### Scientific Notation Examples

#### Display Number in Scientific Notation
1. Check `Scientific Notation` checkbox in Settings
2. Enter `1000000`
3. Display shows: `1.00e+06`

#### Toggle Back to Standard Notation
1. Uncheck `Scientific Notation` checkbox
2. Display shows: `1000000.00`

### Exporting Calculation History

#### Export History as JSON
1. Perform several calculations (e.g., 5+3, 10×4, etc.)
2. Click `Export JSON` button
3. Choose save location
4. File is saved with all calculations and timestamps in JSON format

#### Export History as CSV
1. Perform several calculations
2. Click `Export CSV` button
3. Choose save location
4. File is saved as spreadsheet-compatible CSV with index, calculation, and timestamp

#### Clear History
1. Click `Clear History` button
2. All calculation entries are removed from history panel

### Custom Keyboard Shortcuts

#### Configure Custom Shortcuts
1. Click `Settings` tab
2. Find "Custom Keyboard Shortcuts" section
3. Edit shortcut mappings (e.g., change `q = sqrt` to `r = sqrt`)
4. Click `Save Shortcuts`
5. Use custom shortcut (e.g., press `r` for square root)

#### Using Custom Shortcuts
1. After configuring shortcuts, press the key (e.g., `q`)
2. Function executes immediately (e.g., sqrt function)
3. Press `s` for sin, `c` for cos, `t` for tan, etc.

### Settings Configuration
#### Adjust Decimal Precision
1. In Settings tab, find "Display Format" section
2. Select desired decimal places from dropdown
3. All subsequent calculations display with selected precision

#### Switch Display Theme
1. In Settings tab, check/uncheck "Dark Mode"
2. All interface elements update immediately with vibrant colors
3. Dark Mode OFF = Light Mode with vibrant indigo and orange tones

### Visual Enhancement Features

#### Interactive Button Hover Effects
1. Hover your mouse over any calculator button
2. Button brightens by +40 RGB values
3. Cursor changes to hand pointer for interactivity
4. Each category of buttons has distinct vibrant colors

#### Vibrant Color Categories
- **Red buttons** for clearing (AC, +/-, %)
- **Orange buttons** for operators with hover brightening
- **Blue buttons** for scientific functions
- **Purple buttons** for memory operations
- **Green button** for equals (calculation results)
- **Pink buttons** for Bessel functions
- **Cyan buttons** for history and export functions
- **Gray buttons** for number input

#### Display with Gradient Background
1. Display panel features a beautiful gradient background
2. Text color changes based on theme (Cyan in dark, Indigo in light)
3. Monospaced font for better number readability
4. Large 65pt font for easy visibility

#### View Keyboard Shortcuts Reference
1. In Settings tab, find "Keyboard Shortcuts" section
2. See all available keyboard shortcuts and custom shortcuts
3. Reference table shows key combinations and their functions

## Project Structure

### App.java
Entry point that initializes and displays the Calculator.

### Calculator.java
Main calculator class (900+ lines) containing:
- **GUI Components**: JFrame, JPanel, JTabbedPane, JButton, JTextPane (for syntax highlighting)
- **Tabbed Interface**: Calculator tab, Conversions tab, Settings tab
- **Scientific Functions**: 23+ functions including trigonometric, hyperbolic, logarithmic, power, Bessel
- **Unit Conversions**: Length (8 units), Weight (6 units), Temperature (3 types), Currency (8 currencies)
- **Memory Management**: M+, M-, MR, MC operations with persistent display
- **History Management**: Timestamped calculations with color-coded syntax highlighting
- **Export Functionality**: JSON and CSV export with file dialogs
- **Theme System**: Dark/Light mode with real-time theme application
- **Keyboard Support**: Full keyboard input with custom shortcuts configuration
- **Scientific Notation**: Toggle-able scientific notation display
- **Bessel Functions**: Full implementation of J0, J1, Y0, Y1 functions
- **Error Handling**: Domain checking for mathematical operations
- **Angle Conversion**: Support for Degrees, Radians, Gradians with automatic conversion

## Color Scheme - Vibrant & Modern

### Dark Mode (Ultra Vibrant)
- **Display Background**: Deep navy blue (#0F0F19) with gradient
- **Display Text**: Vibrant Cyan (#22D3EE)
- **History Results**: Vibrant Green (#22C55E) with bold styling
- **Clear Buttons (AC, +/-, %)**: Vibrant Red (#EF4444)
- **Operator Buttons** (+, -, ×, ÷): Vibrant Orange (#FF7800)
- **Scientific Buttons**: Vibrant Blue (#3B82F6)
- **Memory Buttons** (M+, M-, MR, MC): Vibrant Purple (#9333EA)
- **Equals Button**: Vibrant Green (#22C55E)
- **Bessel Buttons** (J0, J1, Y0, Y1): Vibrant Pink (#EC4891)
- **Special Buttons** (History, Export): Vibrant Cyan (#22D3EE)
- **Number Buttons** (0-9, .): Dark Gray (#3C3C46)
- **Panel Background**: Deep Navy (#191933)

### Light Mode (Ultra Vibrant)
- **Display Background**: Light blue (#F5F7FA) with gradient
- **Display Text**: Vibrant Indigo (#6366F1)
- **History Results**: Vibrant Green (#22C55E) with bold styling
- **Clear Buttons**: Vibrant Red (#EF4444)
- **Operator Buttons**: Vibrant Orange (#FF7800)
- **Scientific Buttons**: Vibrant Blue (#3B82F6)
- **Memory Buttons**: Vibrant Purple (#9333EA)
- **Equals Button**: Vibrant Green (#22C55E)
- **Bessel Buttons**: Vibrant Pink (#EC4891)
- **Special Buttons**: Vibrant Cyan (#22D3EE)
- **Number Buttons** (0-9, .): Light Gray (#C8C8D2)
- **Panel Background**: Very Light (#F5F7FA)

### Hover Effects
- All buttons brighten by +40 RGB values on mouse hover
- Smooth interactive feedback
- Hand cursor appears on button hover

## Window Size & Layout

- **Default Width**: 1200 pixels
- **Default Height**: 900 pixels
- **Layout**: Multi-tab interface with BorderLayout
- **Button Grid**: 8 rows × 6 columns (48 total buttons including new features)
- **History Panel**: Scrollable with syntax highlighting
- **Conversion Panel**: Tab-based organization for different conversion types
- **Settings Panel**: Scrollable with configurable options

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

The calculator includes comprehensive error handling for:
- **Division by zero** - Shows error message and prevents calculation
- **Square root of negative numbers** - Domain error displayed
- **Logarithm of non-positive numbers** - Domain error displayed
- **Inverse trig domain violations** - asin/acos only accept [-1, 1]
- **Invalid factorial inputs** - Only non-negative integers up to 170
- **Invalid number formats** - Prevents non-numeric input
- **Bessel function singularities** - Handled gracefully

## Available Scientific Functions

### Trigonometric Functions (in selected angle mode)
- **sin(x)** - Sine of angle x
- **cos(x)** - Cosine of angle x
- **tan(x)** - Tangent of angle x

### Inverse Trigonometric Functions
- **asin(x)** - Inverse sine (arcsin), domain: [-1, 1], result in angle mode
- **acos(x)** - Inverse cosine (arccos), domain: [-1, 1], result in angle mode
- **atan(x)** - Inverse tangent (arctan), result in angle mode

### Hyperbolic Functions
- **sinh(x)** - Hyperbolic sine
- **cosh(x)** - Hyperbolic cosine
- **tanh(x)** - Hyperbolic tangent

### Logarithmic Functions
- **log(x)** - Base 10 logarithm, domain: x > 0
- **ln(x)** - Natural logarithm (base e), domain: x > 0

### Power & Root Functions
- **x²** - Square of a number
- **x^y** - Raise x to power y (base^exponent)
- **√x** - Square root of x, domain: x ≥ 0
- **x!** - Factorial of x (positive integers only, max 170)

### Bessel Functions
- **J0(x)** - Bessel function of the first kind, order 0
- **J1(x)** - Bessel function of the first kind, order 1
- **Y0(x)** - Bessel function of the second kind, order 0
- **Y1(x)** - Bessel function of the second kind, order 1

### Mathematical Constants
- **π** ≈ 3.14159265359 (Pi)
- **e** ≈ 2.71828182846 (Euler's number)

## Conversion Functions

### Length Conversions
- Meters (m), Kilometers (km), Centimeters (cm), Millimeters (mm)
- Miles (mi), Yards (yd), Feet (ft), Inches (in)

### Weight/Mass Conversions
- Kilograms (kg), Grams (g), Milligrams (mg)
- Pounds (lb), Ounces (oz), Tonnes (t)

### Temperature Conversions
- Celsius (°C), Fahrenheit (°F), Kelvin (K)
- Automatic conversion between all temperature scales

### Currency Conversions
- **Major Currencies**: USD, EUR, GBP, JPY, CAD, AUD, CHF, CNY
- **Middle East**: EGP (Egyptian Pound) ✨ NEW!
- Real-time rate support (rates as of 2026)

## Technical Specifications

- **Language**: Java 25+
- **GUI Framework**: Java Swing with JTextPane for syntax highlighting
- **Layout Managers**: BorderLayout, GridLayout, FlowLayout, JSplitPane
- **Components**: JFrame, JPanel, JButton, JTextPane, JComboBox, JTabbedPane, JTextArea
- **Compilation**: `javac -d bin src/App.java src/Calculator.java`
- **Execution**: `java --enable-preview -cp bin App`
- **Number Formatting**: DecimalFormat with configurable precision
- **History Storage**: ArrayList<String> with real-time GUI update
- **Memory System**: Single double variable with persistent display
- **Theme System**: Runtime switching between Dark and Light modes
- **Export Format**: JSON (with timestamps) and CSV (spreadsheet-compatible)

## Performance Characteristics

- **Startup Time**: < 1 second
- **Calculation Speed**: Instant (< 10ms for most operations)
- **History Limit**: Limited only by available memory
- **File Export**: < 1 second for typical history sizes
- **Theme Switch**: Instant UI update

## Known Limitations

- Bessel functions are approximations (accurate to ~8 decimal places)
- Maximum factorial input is 170 (due to floating-point limits)
- Currency rates are static (requires manual update for current rates)
- No graphing capabilities (planned for future version)
- No plugin system (core functions only)

## File Structure

```
Calculator/
├── src/
│   ├── App.java           - Entry point (20 lines)
│   └── Calculator.java    - Main application (900+ lines)
├── bin/                   - Compiled .class files
└── README.md              - This documentation
```

## Building & Running

### Prerequisites
- Java Development Kit (JDK) 25 or higher
- Terminal or command prompt
- No external dependencies required

### Compilation
```bash
javac -d bin src/App.java src/Calculator.java
```

### Execution
```bash
java --enable-preview -cp bin App
```

### Creating JAR (Optional)
```bash
jar cvfe Calculator.jar App -C bin .
java -jar Calculator.jar
```

## System Requirements

- **Operating System**: Windows, macOS, Linux (any with JDK 25+)
- **Java Version**: JDK 25 or higher with `--enable-preview` flag
- **Memory**: Minimum 100 MB RAM available
- **Display**: Minimum 1024×768 resolution recommended
- **Screen Size**: Full window supports up to 4K displays

## Version History

- **v2.6** (January 2026) - Ultra Vibrant Edition: 10+ vibrant color scheme, interactive hover effects, Egyptian Pound (EGP) currency support, gradient displays
- **v2.5** (January 2026) - Major expansion with Bessel functions, conversions, export, custom shortcuts
- **v2.0** (January 2026) - Complete rewrite with advanced features
- **v1.2** (January 2026) - Added keyboard support and scientific functions
- **v1.0** (January 2026) - Initial release with basic calculator functions

---

**Last Updated**: January 21, 2026
**Repository**: https://github.com/MuhammadMagdyy/JCalculator
**Latest Version**: v2.6 - Ultra Vibrant Edition
**Status**: Production Ready ✓
