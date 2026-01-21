import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.*;
import java.text.DecimalFormat;

public class Calculator {
    
    int boardWidth = 900;
    int boardHeight = 800;

    // Theme colors
    Color darkBg = new Color(28,28,28);
    Color darkPanel = new Color(40,40,40);
    Color lightBg = new Color(240,240,240);
    Color lightPanel = new Color(230,230,230);
    
    Color customLightGray = new Color(221,212,210);
    Color customDarkGray = new Color(80,80,80);
    Color customOrange = new Color(255,149,0);

    // GUI Components
    JFrame frame = new JFrame("Advanced Scientific Calculator");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JTextArea historyArea = new JTextArea();
    JLabel memoryLabel = new JLabel("Memory: 0");
    JComboBox<String> angleMode = new JComboBox<>(new String[]{"Degrees", "Radians", "Gradians"});
    JComboBox<Integer> decimalPlaces = new JComboBox<>(new Integer[]{2, 4, 6, 8});

    // Button arrays
    String[] topSymbols = {"AC", "+/-", "%"};
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] scientificFunctions = {"sin", "cos", "tan", "log", "ln", "x²", "x^y", "√", "π", "e", "!"};
    String[] advancedFunctions = {"asin", "acos", "atan", "sinh", "cosh", "tanh"};
    
    // Calculation history
    ArrayList<String> history = new ArrayList<>();
    
    // Theme state
    boolean isDarkMode = true;
    
    // Calculator state
    String A = "0";
    String B = null;
    String operator = null;
    double memory = 0;
    String currentAngleMode = "Degrees";
    int decimalPrecision = 2;

    Calculator() {
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create menu bar
        createMenuBar();

        // Create top panel with display and settings
        JPanel topPanel = new JPanel(new BorderLayout());
        
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);
        displayLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        
        // Settings panel
        JPanel settingsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        angleMode.addActionListener(e -> currentAngleMode = (String)angleMode.getSelectedItem());
        decimalPlaces.setSelectedItem(2);
        decimalPlaces.addActionListener(e -> decimalPrecision = (Integer)decimalPlaces.getSelectedItem());
        
        settingsPanel.add(new JLabel("Angle:"));
        settingsPanel.add(angleMode);
        settingsPanel.add(new JLabel("Decimal Places:"));
        settingsPanel.add(decimalPlaces);
        
        topPanel.add(displayPanel, BorderLayout.CENTER);
        topPanel.add(settingsPanel, BorderLayout.SOUTH);
        frame.add(topPanel, BorderLayout.NORTH);

        // Create main content panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Buttons panel
        buttonsPanel.setLayout(new GridLayout(6,6));
        
        // Memory panel
        JPanel memoryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        memoryLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        memoryPanel.add(memoryLabel);
        JButton mClear = new JButton("MC");
        JButton mRecall = new JButton("MR");
        JButton mAdd = new JButton("M+");
        JButton mSubtract = new JButton("M-");
        
        mClear.addActionListener(e -> { memory = 0; updateMemoryLabel(); });
        mRecall.addActionListener(e -> { try { displayLabel.setText(formatNumber(memory)); } catch(Exception ex) {} });
        mAdd.addActionListener(e -> { try { memory += Double.parseDouble(displayLabel.getText()); updateMemoryLabel(); } catch(Exception ex) {} });
        mSubtract.addActionListener(e -> { try { memory -= Double.parseDouble(displayLabel.getText()); updateMemoryLabel(); } catch(Exception ex) {} });
        
        memoryPanel.add(mClear);
        memoryPanel.add(mRecall);
        memoryPanel.add(mAdd);
        memoryPanel.add(mSubtract);

        // History panel
        historyArea.setEditable(false);
        historyArea.setLineWrap(true);
        historyArea.setWrapStyleWord(true);
        historyArea.setFont(new Font("Arial", Font.PLAIN, 11));
        JScrollPane historyScroll = new JScrollPane(historyArea);
        historyScroll.setPreferredSize(new Dimension(250, 400));
        
        // Create all buttons
        String[] allFunctions = {
            "AC", "+/-", "%", "÷", "sin", "cos",
            "7", "8", "9", "×", "tan", "log",
            "4", "5", "6", "-", "ln", "x²",
            "1", "2", "3", "+", "x^y", "√",
            "0", ".", "=", "π", "e", "!",
            "asin", "acos", "atan", "sinh", "cosh", "tanh"
        };
        
        for(String func : allFunctions) {
            createButton(func);
        }
        
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        mainPanel.add(memoryPanel, BorderLayout.SOUTH);
        
        // Right panel for history
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(new JLabel("Calculation History"), BorderLayout.NORTH);
        rightPanel.add(historyScroll, BorderLayout.CENTER);
        
        // Split pane for buttons and history
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, mainPanel, rightPanel);
        splitPane.setDividerLocation(550);
        
        frame.add(splitPane, BorderLayout.CENTER);

        // Add keyboard support
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isDigit(keyChar) || keyChar == '.' || keyChar == '+' || keyChar == '-' || keyChar == '*' || keyChar == '/') {
                    simulateButtonClick(String.valueOf(keyChar));
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    simulateButtonClick("=");
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    simulateButtonClick("AC");
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
            @Override
            public void keyTyped(KeyEvent e) {}
        });
        frame.setFocusable(true);
        
        applyTheme();
        frame.setVisible(true);
    }

    void createButton(String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setFocusable(false);
        button.setOpaque(true);
        button.setBorder(new LineBorder(Color.BLACK));
        
        applyButtonStyle(button, label);
        buttonsPanel.add(button);
        button.addActionListener(e -> handleButtonClick(label));
    }

    void applyButtonStyle(JButton button, String label) {
        if(Arrays.asList(topSymbols).contains(label)) {
            button.setBackground(customLightGray);
            button.setForeground(Color.BLACK);
        } else if(Arrays.asList(rightSymbols).contains(label)) {
            button.setBackground(customOrange);
            button.setForeground(Color.WHITE);
        } else if(Arrays.asList(scientificFunctions).contains(label) || Arrays.asList(advancedFunctions).contains(label)) {
            button.setBackground(new Color(100, 150, 200));
            button.setForeground(Color.WHITE);
        } else {
            button.setBackground(customDarkGray);
            button.setForeground(Color.WHITE);
        }
    }

    void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        // Theme menu
        JMenu themeMenu = new JMenu("Theme");
        JMenuItem darkItem = new JMenuItem("Dark Mode");
        JMenuItem lightItem = new JMenuItem("Light Mode");
        
        darkItem.addActionListener(e -> { isDarkMode = true; applyTheme(); });
        lightItem.addActionListener(e -> { isDarkMode = false; applyTheme(); });
        
        themeMenu.add(darkItem);
        themeMenu.add(lightItem);
        
        // Help menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, 
            "Advanced Scientific Calculator v2.0\n\nFeatures:\n- Basic arithmetic\n- Trigonometric functions\n- Logarithmic functions\n- Memory functions\n- Calculation history\n- Theme customization"));
        helpMenu.add(aboutItem);
        
        menuBar.add(themeMenu);
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);
    }

    void applyTheme() {
        Color bgColor = isDarkMode ? darkBg : lightBg;
        Color fgColor = isDarkMode ? Color.WHITE : Color.BLACK;
        Color panelColor = isDarkMode ? darkPanel : lightPanel;
        
        displayLabel.setBackground(bgColor);
        displayLabel.setForeground(fgColor);
        buttonsPanel.setBackground(panelColor);
        historyArea.setBackground(panelColor);
        historyArea.setForeground(fgColor);
        frame.getContentPane().setBackground(panelColor);
        memoryLabel.setForeground(fgColor);
    }

    void handleButtonClick(String label) {
        try {
            if(Arrays.asList(rightSymbols).contains(label)) {
                handleOperator(label);
            } else if(Arrays.asList(topSymbols).contains(label)) {
                handleTopSymbol(label);
            } else if(Arrays.asList(scientificFunctions).contains(label) || Arrays.asList(advancedFunctions).contains(label)) {
                handleScientificFunction(label);
            } else {
                handleNumberInput(label);
            }
        } catch(Exception e) {
            displayLabel.setText("Error");
        }
    }

    void handleOperator(String op) {
        if(op.equals("=")) {
            if(operator != null && operator.equals("x^y")) {
                handleExponent();
            } else if(A != null && operator != null) {
                B = displayLabel.getText();
                double numA = Double.parseDouble(A);
                double numB = Double.parseDouble(B);
                double result = 0;
                boolean validOperation = true;
                
                if(operator.equals("+")) result = numA + numB;
                else if(operator.equals("-")) result = numA - numB;
                else if(operator.equals("×")) result = numA * numB;
                else if(operator.equals("÷")) {
                    if(numB != 0) result = numA / numB;
                    else { displayLabel.setText("Error: Division by 0"); validOperation = false; }
                }
                
                if(validOperation) {
                    String resultStr = formatNumber(result);
                    displayLabel.setText(resultStr);
                    addToHistory(numA + " " + operator + " " + numB + " = " + resultStr);
                    clearAll();
                }
            }
        } else if("+-×÷".contains(op)) {
            if(operator == null) {
                A = displayLabel.getText();
                displayLabel.setText("0");
            }
            operator = op;
        }
    }

    void handleTopSymbol(String symbol) {
        if(symbol.equals("AC")) {
            clearAll();
            displayLabel.setText("0");
        } else if(symbol.equals("+/-")) {
            double numDisplay = Double.parseDouble(displayLabel.getText());
            numDisplay *= -1;
            displayLabel.setText(formatNumber(numDisplay));
        } else if(symbol.equals("%")) {
            double numDisplay = Double.parseDouble(displayLabel.getText());
            numDisplay /= 100;
            displayLabel.setText(formatNumber(numDisplay));
        }
    }

    void handleNumberInput(String num) {
        if(num.equals(".")) {
            if(!displayLabel.getText().contains(".")) {
                displayLabel.setText(displayLabel.getText() + ".");
            }
        } else if("0123456789".contains(num)) {
            if(displayLabel.getText().equals("0")) {
                displayLabel.setText(num);
            } else {
                displayLabel.setText(displayLabel.getText() + num);
            }
        }
    }

    void handleScientificFunction(String function) {
        try {
            double numDisplay = Double.parseDouble(displayLabel.getText());
            double result = 0;
            String resultStr = "";
            
            double angle = convertAngle(numDisplay);
            
            switch(function) {
                case "sin":
                    result = Math.sin(angle);
                    resultStr = "sin(" + numDisplay + ") = " + formatNumber(result);
                    break;
                case "cos":
                    result = Math.cos(angle);
                    resultStr = "cos(" + numDisplay + ") = " + formatNumber(result);
                    break;
                case "tan":
                    result = Math.tan(angle);
                    resultStr = "tan(" + numDisplay + ") = " + formatNumber(result);
                    break;
                case "asin":
                    if(numDisplay >= -1 && numDisplay <= 1) {
                        result = Math.asin(numDisplay);
                        result = convertAngleBack(result);
                        resultStr = "arcsin(" + numDisplay + ") = " + formatNumber(result);
                    } else {
                        displayLabel.setText("Error: arcsin domain [-1,1]");
                        return;
                    }
                    break;
                case "acos":
                    if(numDisplay >= -1 && numDisplay <= 1) {
                        result = Math.acos(numDisplay);
                        result = convertAngleBack(result);
                        resultStr = "arccos(" + numDisplay + ") = " + formatNumber(result);
                    } else {
                        displayLabel.setText("Error: arccos domain [-1,1]");
                        return;
                    }
                    break;
                case "atan":
                    result = Math.atan(numDisplay);
                    result = convertAngleBack(result);
                    resultStr = "arctan(" + numDisplay + ") = " + formatNumber(result);
                    break;
                case "sinh":
                    result = Math.sinh(numDisplay);
                    resultStr = "sinh(" + numDisplay + ") = " + formatNumber(result);
                    break;
                case "cosh":
                    result = Math.cosh(numDisplay);
                    resultStr = "cosh(" + numDisplay + ") = " + formatNumber(result);
                    break;
                case "tanh":
                    result = Math.tanh(numDisplay);
                    resultStr = "tanh(" + numDisplay + ") = " + formatNumber(result);
                    break;
                case "log":
                    if(numDisplay > 0) {
                        result = Math.log10(numDisplay);
                        resultStr = "log(" + numDisplay + ") = " + formatNumber(result);
                    } else {
                        displayLabel.setText("Error: log of non-positive");
                        return;
                    }
                    break;
                case "ln":
                    if(numDisplay > 0) {
                        result = Math.log(numDisplay);
                        resultStr = "ln(" + numDisplay + ") = " + formatNumber(result);
                    } else {
                        displayLabel.setText("Error: ln of non-positive");
                        return;
                    }
                    break;
                case "√":
                    if(numDisplay >= 0) {
                        result = Math.sqrt(numDisplay);
                        resultStr = "√(" + numDisplay + ") = " + formatNumber(result);
                    } else {
                        displayLabel.setText("Error: sqrt of negative");
                        return;
                    }
                    break;
                case "x²":
                    result = numDisplay * numDisplay;
                    resultStr = "(" + numDisplay + ")² = " + formatNumber(result);
                    break;
                case "π":
                    displayLabel.setText(formatNumber(Math.PI));
                    addToHistory("π = " + formatNumber(Math.PI));
                    return;
                case "e":
                    displayLabel.setText(formatNumber(Math.E));
                    addToHistory("e = " + formatNumber(Math.E));
                    return;
                case "!":
                    if(numDisplay >= 0 && numDisplay == (int)numDisplay) {
                        result = factorial((int)numDisplay);
                        resultStr = numDisplay + "! = " + formatNumber(result);
                    } else {
                        displayLabel.setText("Error: Invalid factorial");
                        return;
                    }
                    break;
                case "x^y":
                    A = String.valueOf(numDisplay);
                    operator = "x^y";
                    displayLabel.setText("0");
                    return;
            }
            
            displayLabel.setText(formatNumber(result));
            addToHistory(resultStr);
        } catch(NumberFormatException e) {
            displayLabel.setText("Error: Invalid input");
        }
    }

    double convertAngle(double value) {
        if(currentAngleMode.equals("Degrees")) {
            return Math.toRadians(value);
        } else if(currentAngleMode.equals("Radians")) {
            return value;
        } else { // Gradians
            return Math.toRadians(value * 0.9);
        }
    }

    double convertAngleBack(double radians) {
        if(currentAngleMode.equals("Degrees")) {
            return Math.toDegrees(radians);
        } else if(currentAngleMode.equals("Radians")) {
            return radians;
        } else { // Gradians
            return Math.toDegrees(radians) / 0.9;
        }
    }

    void handleExponent() {
        if(A != null && operator != null && operator.equals("x^y")) {
            double base = Double.parseDouble(A);
            double exponent = Double.parseDouble(displayLabel.getText());
            double result = Math.pow(base, exponent);
            String resultStr = base + "^" + exponent + " = " + formatNumber(result);
            displayLabel.setText(formatNumber(result));
            addToHistory(resultStr);
            clearAll();
        }
    }

    long factorial(int n) {
        if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;
        long result = 1;
        for(int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    String formatNumber(double num) {
        if(num % 1 == 0) {
            return String.format("%.0f", num);
        }
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(decimalPrecision);
        return df.format(num);
    }

    void updateMemoryLabel() {
        memoryLabel.setText("Memory: " + formatNumber(memory));
    }

    void clearAll() {
        A = "0";
        B = null;
        operator = null;
    }

    void addToHistory(String calculation) {
        history.add(calculation);
        historyArea.append(calculation + "\n");
        historyArea.setCaretPosition(historyArea.getDocument().getLength());
    }

    void simulateButtonClick(String value) {
        if("+-×÷".contains(value)) {
            if(operator == null) {
                A = displayLabel.getText();
                displayLabel.setText("0");
            }
            operator = value.equals("+") ? "+" : value.equals("-") ? "-" : value.equals("*") ? "×" : "÷";
        } else if(value.equals("=")) {
            handleButtonClick("=");
        } else if(value.equals("AC")) {
            clearAll();
            displayLabel.setText("0");
        } else if(Character.isDigit(value.charAt(0)) || value.equals(".")) {
            if(displayLabel.getText().equals("0") && !value.equals(".")) {
                displayLabel.setText(value);
            } else if(!value.equals(".") || !displayLabel.getText().contains(".")) {
                displayLabel.setText(displayLabel.getText() + value);
            }
        }
    }
}


