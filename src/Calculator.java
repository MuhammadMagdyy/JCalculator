import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Calculator extends JFrame implements KeyListener {
    
    int boardWidth = 1200;
    int boardHeight = 900;

    // Theme colors - Vibrant and Modern
    Color darkBg = new Color(15, 15, 25);
    Color darkPanel = new Color(25, 35, 50);
    Color lightBg = new Color(245, 247, 250);
    Color lightPanel = new Color(235, 240, 248);
    
    // Vibrant accent colors for enhanced UI
    Color vibrantOrange = new Color(255, 120, 0);
    Color vibrantPurple = new Color(147, 51, 234);
    Color vibrantBlue = new Color(59, 130, 246);
    Color vibrantGreen = new Color(34, 197, 94);
    Color vibrantPink = new Color(236, 72, 153);
    Color vibrantCyan = new Color(34, 211, 238);
    Color vibrantRed = new Color(239, 68, 68);
    Color vibrantTeal = new Color(20, 184, 166);
    Color vibrantYellow = new Color(251, 191, 36);
    Color vibrantIndigo = new Color(99, 102, 241);
    
    // GUI Components
    JLabel displayLabel = new JLabel();
    JTextPane historyPane = new JTextPane();
    JLabel memoryLabel = new JLabel("Memory: 0");
    JComboBox<String> angleMode = new JComboBox<>(new String[]{"Degrees", "Radians", "Gradians"});
    JComboBox<Integer> decimalPlaces = new JComboBox<>(new Integer[]{2, 4, 6, 8});
    JTabbedPane tabbedPane = new JTabbedPane();
    
    // Conversion units
    Map<String, Double> lengthConversions = new HashMap<>();
    Map<String, Double> weightConversions = new HashMap<>();
    Map<String, Double> temperatureOffsets = new HashMap<>();
    Map<String, Double> currencyRates = new HashMap<>();

    // Button arrays
    String[] topSymbols = {"AC", "+/-", "%"};
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] scientificFunctions = {"sin", "cos", "tan", "log", "ln", "x²", "x^y", "√", "π", "e", "!"};
    String[] advancedFunctions = {"asin", "acos", "atan", "sinh", "cosh", "tanh"};
    String[] besselFunctions = {"J0", "J1", "Y0", "Y1"};
    
    // Calculation history with timestamps
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
    boolean shouldClearDisplay = false;
    
    // Scientific notation
    boolean useScientificNotation = false;
    
    // Custom keyboard shortcuts
    Map<Character, String> customShortcuts = new HashMap<>();

    Calculator() {
        setTitle("Advanced Scientific Calculator Pro");
        setSize(boardWidth, boardHeight);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        addKeyListener(this);
        setFocusable(true);
        
        // Initialize conversions
        initializeConversions();
        initializeCustomShortcuts();
        
        // Create menu bar
        createMenuBar();

        // Create tabbed interface
        tabbedPane.addTab("Calculator", createCalculatorTab());
        tabbedPane.addTab("Conversions", createConversionTab());
        tabbedPane.addTab("Settings", createSettingsTab());
        
        add(tabbedPane, BorderLayout.CENTER);
        
        // Create bottom panel with history export
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton exportJSON = new JButton("Export JSON");
        JButton exportCSV = new JButton("Export CSV");
        JButton clearHistory = new JButton("Clear History");
        
        exportJSON.addActionListener(e -> exportHistoryAsJSON());
        exportCSV.addActionListener(e -> exportHistoryAsCSV());
        clearHistory.addActionListener(e -> {
            history.clear();
            updateHistoryDisplay();
        });
        
        bottomPanel.add(exportJSON);
        bottomPanel.add(exportCSV);
        bottomPanel.add(clearHistory);
        add(bottomPanel, BorderLayout.SOUTH);
        
        applyTheme();
        setVisible(true);
    }
    
    private void initializeConversions() {
        // Length conversions (to meters)
        lengthConversions.put("m", 1.0);
        lengthConversions.put("km", 1000.0);
        lengthConversions.put("cm", 0.01);
        lengthConversions.put("mm", 0.001);
        lengthConversions.put("mi", 1609.34);
        lengthConversions.put("yd", 0.9144);
        lengthConversions.put("ft", 0.3048);
        lengthConversions.put("in", 0.0254);
        
        // Weight conversions (to kg)
        weightConversions.put("kg", 1.0);
        weightConversions.put("g", 0.001);
        weightConversions.put("mg", 0.000001);
        weightConversions.put("lb", 0.453592);
        weightConversions.put("oz", 0.0283495);
        weightConversions.put("t", 1000.0);
        
        // Currency rates (example - rates as of 2026)
        currencyRates.put("USD", 1.0);
        currencyRates.put("EUR", 0.92);
        currencyRates.put("GBP", 0.79);
        currencyRates.put("JPY", 149.5);
        currencyRates.put("CAD", 1.36);
        currencyRates.put("AUD", 1.53);
        currencyRates.put("CHF", 0.88);
        currencyRates.put("CNY", 7.24);
        currencyRates.put("EGP", 30.65);
    }
    
    private void initializeCustomShortcuts() {
        customShortcuts.put('q', "sqrt");
        customShortcuts.put('s', "sin");
        customShortcuts.put('c', "cos");
        customShortcuts.put('t', "tan");
        customShortcuts.put('l', "log");
        customShortcuts.put('n', "ln");
        customShortcuts.put('f', "!");
    }
    
    private JPanel createCalculatorTab() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Display
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);
        displayLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        displayPanel.add(displayLabel, BorderLayout.CENTER);
        
        // Settings panel
        JPanel settingsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        angleMode.addActionListener(e -> currentAngleMode = (String)angleMode.getSelectedItem());
        decimalPlaces.setSelectedItem(2);
        decimalPlaces.addActionListener(e -> decimalPrecision = (Integer)decimalPlaces.getSelectedItem());
        
        JCheckBox scientificNotationCheck = new JCheckBox("Scientific Notation");
        scientificNotationCheck.addActionListener(e -> {
            useScientificNotation = scientificNotationCheck.isSelected();
            updateDisplay();
        });
        
        settingsPanel.add(new JLabel("Angle:"));
        settingsPanel.add(angleMode);
        settingsPanel.add(new JLabel("Decimal Places:"));
        settingsPanel.add(decimalPlaces);
        settingsPanel.add(scientificNotationCheck);
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(displayPanel, BorderLayout.CENTER);
        topPanel.add(settingsPanel, BorderLayout.SOUTH);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        // Center panel with buttons and history
        JPanel centerPanel = new JPanel(new BorderLayout());
        
        JPanel buttonsPanel = new JPanel(new GridLayout(8, 6, 5, 5));
        buttonsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        // Create all buttons
        String[][] buttonLabels = {
            {topSymbols[0], topSymbols[1], topSymbols[2], "Bessel", "Conversion", "Export"},
            {"7", "8", "9", "÷", "sin", "asin"},
            {"4", "5", "6", "×", "cos", "acos"},
            {"1", "2", "3", "-", "tan", "atan"},
            {"0", ".", "=", "+", "√", "^2"},
            {"log", "ln", "!", "π", "e", "x^y"},
            {"sinh", "cosh", "tanh", "J0", "J1", "M+"},
            {"M-", "MR", "MC", "Y0", "Y1", "Hist"}
        };
        
        for (String[] row : buttonLabels) {
            for (String label : row) {
                JButton btn = createButton(label);
                buttonsPanel.add(btn);
            }
        }
        
        // Memory display
        memoryLabel.setFont(new Font("Arial", Font.BOLD, 14));
        memoryLabel.setHorizontalAlignment(JLabel.CENTER);
        memoryLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(buttonsPanel, BorderLayout.CENTER);
        leftPanel.add(memoryLabel, BorderLayout.SOUTH);
        
        centerPanel.add(leftPanel, BorderLayout.WEST);
        
        // History panel with enhanced display
        JPanel historyPanel = new JPanel(new BorderLayout());
        historyPanel.setBorder(new TitledBorder("Calculation History"));
        historyPane.setEditable(false);
        historyPane.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane historyScroll = new JScrollPane(historyPane);
        historyPanel.add(historyScroll, BorderLayout.CENTER);
        
        centerPanel.add(historyPanel, BorderLayout.CENTER);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        return mainPanel;
    }
    
    private JPanel createConversionTab() {
        JPanel conversionPanel = new JPanel();
        conversionPanel.setLayout(new BoxLayout(conversionPanel, BoxLayout.Y_AXIS));
        conversionPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        conversionPanel.setBackground(isDarkMode ? darkPanel : lightPanel);
        conversionPanel.setOpaque(true);
        
        // Length conversion
        JPanel lengthPanel = createConversionSubPanel("Length Conversion", 
            new String[]{"m", "km", "cm", "mm", "mi", "yd", "ft", "in"}, 
            lengthConversions, "Length");
        
        // Weight conversion
        JPanel weightPanel = createConversionSubPanel("Weight Conversion", 
            new String[]{"kg", "g", "mg", "lb", "oz", "t"}, 
            weightConversions, "Weight");
        
        // Temperature conversion
        JPanel tempPanel = createTemperatureConversionPanel();
        
        // Currency conversion
        JPanel currencyPanel = createConversionSubPanel("Currency Conversion", 
            new String[]{"USD", "EUR", "GBP", "JPY", "CAD", "AUD", "CHF", "CNY", "EGP"}, 
            currencyRates, "Currency");
        
        conversionPanel.add(lengthPanel);
        conversionPanel.add(Box.createVerticalStrut(5));
        conversionPanel.add(weightPanel);
        conversionPanel.add(Box.createVerticalStrut(5));
        conversionPanel.add(tempPanel);
        conversionPanel.add(Box.createVerticalStrut(5));
        conversionPanel.add(currencyPanel);
        conversionPanel.add(Box.createVerticalGlue());
        
        JScrollPane scrollPane = new JScrollPane(conversionPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(scrollPane, BorderLayout.CENTER);
        return wrapper;
    }
    
    private JPanel createConversionSubPanel(String title, String[] units, 
                                           Map<String, Double> conversionMap, String type) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder(title));
        panel.setBackground(isDarkMode ? darkPanel : lightPanel);
        panel.setOpaque(true);
        panel.setMaximumSize(new Dimension(1200, 100));
        panel.setPreferredSize(new Dimension(1200, 90));
        
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        inputPanel.setBackground(isDarkMode ? darkPanel : lightPanel);
        inputPanel.setOpaque(true);
        JTextField inputField = new JTextField(12);
        inputField.setFont(new Font("Arial", Font.PLAIN, 12));
        JComboBox<String> fromUnit = new JComboBox<>(units);
        JComboBox<String> toUnit = new JComboBox<>(units);
        toUnit.setSelectedIndex(1);
        fromUnit.setFont(new Font("Arial", Font.PLAIN, 11));
        toUnit.setFont(new Font("Arial", Font.PLAIN, 11));
        
        JLabel resultLabel = new JLabel("Result: 0");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 13));
        resultLabel.setForeground(vibrantGreen);
        
        JButton convertBtn = new JButton("Convert");
        convertBtn.setFont(new Font("Arial", Font.BOLD, 11));
        convertBtn.setBackground(vibrantBlue);
        convertBtn.setForeground(Color.WHITE);
        convertBtn.setFocusPainted(false);
        convertBtn.setBorderPainted(false);
        convertBtn.setOpaque(true);
        convertBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        convertBtn.addActionListener(e -> {
            try {
                double value = Double.parseDouble(inputField.getText());
                String from = (String)fromUnit.getSelectedItem();
                String to = (String)toUnit.getSelectedItem();
                
                double result;
                if (type.equals("Length") || type.equals("Weight")) {
                    double baseValue = value * conversionMap.get(from);
                    result = baseValue / conversionMap.get(to);
                } else { // Currency - rates are relative to USD
                    double usdValue = value / conversionMap.get(from);
                    result = usdValue * conversionMap.get(to);
                }
                resultLabel.setText("Result: " + formatNumber(result));
                resultLabel.setForeground(vibrantGreen);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
                resultLabel.setForeground(vibrantRed);
            }
        });
        
        inputPanel.add(new JLabel("Value:"));
        inputPanel.add(inputField);
        inputPanel.add(new JLabel("From:"));
        inputPanel.add(fromUnit);
        inputPanel.add(new JLabel("To:"));
        inputPanel.add(toUnit);
        inputPanel.add(convertBtn);
        inputPanel.add(resultLabel);
        
        panel.add(inputPanel, BorderLayout.NORTH);
        return panel;
    }
    
    private JPanel createTemperatureConversionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(isDarkMode ? darkPanel : lightPanel);
        panel.setOpaque(true);
        panel.setBorder(new TitledBorder("Temperature Conversion"));
        
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        inputPanel.setBackground(isDarkMode ? darkPanel : lightPanel);
        inputPanel.setOpaque(true);
        JTextField inputField = new JTextField(15);
        inputField.setFont(new Font("Arial", Font.PLAIN, 12));
        String[] tempUnits = {"Celsius", "Fahrenheit", "Kelvin"};
        JComboBox<String> fromTemp = new JComboBox<>(tempUnits);
        JComboBox<String> toTemp = new JComboBox<>(tempUnits);
        toTemp.setSelectedIndex(1);
        fromTemp.setFont(new Font("Arial", Font.PLAIN, 11));
        toTemp.setFont(new Font("Arial", Font.PLAIN, 11));
        JLabel resultLabel = new JLabel("Result: 0");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 13));
        resultLabel.setForeground(vibrantGreen);
        
        JButton convertBtn = new JButton("Convert");
        convertBtn.setFont(new Font("Arial", Font.BOLD, 11));
        convertBtn.setBackground(vibrantBlue);
        convertBtn.setForeground(Color.WHITE);
        convertBtn.setFocusPainted(false);
        convertBtn.setBorderPainted(false);
        convertBtn.setOpaque(true);
        convertBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        convertBtn.addActionListener(e -> {
            try {
                double value = Double.parseDouble(inputField.getText());
                String from = (String)fromTemp.getSelectedItem();
                String to = (String)toTemp.getSelectedItem();
                double result = convertTemperature(value, from, to);
                resultLabel.setText("Result: " + formatNumber(result));
                resultLabel.setForeground(vibrantGreen);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
                resultLabel.setForeground(vibrantRed);
            }
        });
        
        inputPanel.add(new JLabel("Value:"));
        inputPanel.add(inputField);
        inputPanel.add(new JLabel("From:"));
        inputPanel.add(fromTemp);
        inputPanel.add(new JLabel("To:"));
        inputPanel.add(toTemp);
        inputPanel.add(convertBtn);
        inputPanel.add(resultLabel);
        
        panel.add(inputPanel, BorderLayout.NORTH);
        return panel;
    }
    
    private double convertTemperature(double value, String from, String to) {
        // Convert to Celsius first
        double celsius;
        if (from.equals("Celsius")) {
            celsius = value;
        } else if (from.equals("Fahrenheit")) {
            celsius = (value - 32) * 5/9;
        } else { // Kelvin
            celsius = value - 273.15;
        }
        
        // Convert from Celsius to target
        if (to.equals("Celsius")) {
            return celsius;
        } else if (to.equals("Fahrenheit")) {
            return celsius * 9/5 + 32;
        } else { // Kelvin
            return celsius + 273.15;
        }
    }
    
    private JPanel createSettingsTab() {
        JPanel settingsPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        settingsPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // Keyboard shortcuts customization
        JPanel shortcutsPanel = new JPanel(new BorderLayout());
        shortcutsPanel.setBorder(new TitledBorder("Custom Keyboard Shortcuts"));
        JTextArea shortcutsText = new JTextArea(6, 40);
        shortcutsText.setText("q = sqrt\ns = sin\nc = cos\nt = tan\nl = log\nn = ln\nf = !");
        shortcutsText.setEditable(true);
        shortcutsPanel.add(new JScrollPane(shortcutsText), BorderLayout.CENTER);
        
        JButton saveShortcutsBtn = new JButton("Save Shortcuts");
        saveShortcutsBtn.addActionListener(e -> {
            // Parse and save custom shortcuts
            String[] lines = shortcutsText.getText().split("\n");
            for (String line : lines) {
                if (line.contains("=")) {
                    String[] parts = line.split("=");
                    if (parts.length == 2) {
                        char key = parts[0].trim().charAt(0);
                        String func = parts[1].trim();
                        customShortcuts.put(key, func);
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Shortcuts saved!");
        });
        JPanel shortcutsBtnPanel = new JPanel();
        shortcutsBtnPanel.add(saveShortcutsBtn);
        shortcutsPanel.add(shortcutsBtnPanel, BorderLayout.SOUTH);
        
        // Theme settings
        JPanel themePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        themePanel.setBorder(new TitledBorder("Theme Settings"));
        JCheckBox darkModeCheck = new JCheckBox("Dark Mode", isDarkMode);
        darkModeCheck.addActionListener(e -> {
            isDarkMode = darkModeCheck.isSelected();
            applyTheme();
        });
        themePanel.add(darkModeCheck);
        
        // Display format
        JPanel displayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        displayPanel.setBorder(new TitledBorder("Display Format"));
        JCheckBox sciNotationCheck = new JCheckBox("Scientific Notation", useScientificNotation);
        sciNotationCheck.addActionListener(e -> {
            useScientificNotation = sciNotationCheck.isSelected();
            updateDisplay();
        });
        displayPanel.add(sciNotationCheck);
        
        // About
        JPanel aboutPanel = new JPanel(new BorderLayout());
        aboutPanel.setBorder(new TitledBorder("About"));
        JLabel aboutText = new JLabel(
            "<html>Advanced Scientific Calculator Pro v2.5<br>" +
            "Features: 20+ Scientific Functions, Unit Conversions, History Export,<br>" +
            "Bessel Functions, Custom Shortcuts, Real-time Syntax Highlighting<br>" +
            "© 2026 Muhammad Magdy</html>"
        );
        aboutPanel.add(aboutText, BorderLayout.WEST);
        
        // Help
        JPanel helpPanel = new JPanel(new BorderLayout());
        helpPanel.setBorder(new TitledBorder("Keyboard Shortcuts"));
        JTextArea helpText = new JTextArea(5, 40);
        helpText.setText("Enter: Calculate\nBackspace: Clear\nCustom shortcuts configured in Keyboard Shortcuts section");
        helpText.setEditable(false);
        helpPanel.add(new JScrollPane(helpText), BorderLayout.CENTER);
        
        settingsPanel.add(shortcutsPanel);
        settingsPanel.add(themePanel);
        settingsPanel.add(displayPanel);
        settingsPanel.add(aboutPanel);
        settingsPanel.add(helpPanel);
        
        JScrollPane scrollPane = new JScrollPane(settingsPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(scrollPane, BorderLayout.CENTER);
        return wrapper;
    }
    
    private JButton createButton(String label) {
        JButton btn = new JButton(label);
        btn.setFont(new Font("Arial", Font.BOLD, 13));
        btn.setOpaque(true);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setRolloverEnabled(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Set colors based on button type and theme
        if (label.equals("=")) {
            btn.setBackground(vibrantGreen);
            btn.setForeground(Color.WHITE);
        } else if (label.equals("AC") || label.equals("+/-") || label.equals("%")) {
            btn.setBackground(isDarkMode ? vibrantRed : vibrantRed);
            btn.setForeground(Color.WHITE);
        } else if (label.equals("÷") || label.equals("×") || label.equals("-") || label.equals("+")) {
            btn.setBackground(vibrantOrange);
            btn.setForeground(Color.WHITE);
        } else if (Arrays.asList(scientificFunctions).contains(label) || 
                   Arrays.asList(advancedFunctions).contains(label) ||
                   label.equals("Bessel") || label.equals("Conversion")) {
            btn.setBackground(vibrantBlue);
            btn.setForeground(Color.WHITE);
        } else if (label.equals("M+") || label.equals("M-") || label.equals("MR") || label.equals("MC")) {
            btn.setBackground(vibrantPurple);
            btn.setForeground(Color.WHITE);
        } else if (label.equals("Hist") || label.equals("Export")) {
            btn.setBackground(vibrantCyan);
            btn.setForeground(Color.WHITE);
        } else if (Arrays.asList(besselFunctions).contains(label) || label.equals("J0") || 
                   label.equals("J1") || label.equals("Y0") || label.equals("Y1")) {
            btn.setBackground(vibrantPink);
            btn.setForeground(Color.WHITE);
        } else if (label.matches("[0-9.]")) {
            btn.setBackground(isDarkMode ? new Color(60, 60, 70) : new Color(200, 200, 210));
            btn.setForeground(isDarkMode ? vibrantCyan : vibrantIndigo);
        } else {
            btn.setBackground(vibrantTeal);
            btn.setForeground(Color.WHITE);
        }
        
        // Add hover effect
        Color originalBg = btn.getBackground();
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(brighten(originalBg));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(originalBg);
            }
        });
        
        btn.addActionListener(e -> handleButtonClick(label));
        
        return btn;
    }
    
    private Color brighten(Color color) {
        int r = Math.min(255, color.getRed() + 40);
        int g = Math.min(255, color.getGreen() + 40);
        int b = Math.min(255, color.getBlue() + 40);
        return new Color(r, g, b);
    }
    
    private void handleButtonClick(String label) {
        if (label.equals("AC")) {
            A = "0";
            B = null;
            operator = null;
            shouldClearDisplay = false;
            updateDisplay();
        } else if (label.equals("+/-")) {
            if (!A.equals("0")) {
                A = A.startsWith("-") ? A.substring(1) : "-" + A;
                updateDisplay();
            }
        } else if (label.equals("=")) {
            calculate();
            shouldClearDisplay = true;
        } else if (label.equals("M+")) {
            try {
                memory += Double.parseDouble(A);
                memoryLabel.setText("Memory: " + formatNumber(memory));
            } catch (NumberFormatException e) {}
        } else if (label.equals("M-")) {
            try {
                memory -= Double.parseDouble(A);
                memoryLabel.setText("Memory: " + formatNumber(memory));
            } catch (NumberFormatException e) {}
        } else if (label.equals("MR")) {
            A = formatNumber(memory);
            updateDisplay();
        } else if (label.equals("MC")) {
            memory = 0;
            memoryLabel.setText("Memory: 0");
        } else if (label.equals("Bessel")) {
            showBesselFunctionDialog();
        } else if (label.equals("Conversion")) {
            tabbedPane.setSelectedIndex(1);
        } else if (label.equals("Export")) {
            showExportDialog();
        } else if (label.equals("Hist")) {
            tabbedPane.setSelectedIndex(0);
        } else if (isOperator(label)) {
            if (operator != null && B != null) {
                calculate();
                B = A;
            } else {
                B = A;
            }
            operator = label;
            shouldClearDisplay = true;
            updateDisplay();
        } else if (Arrays.asList(scientificFunctions).contains(label) || 
                   Arrays.asList(advancedFunctions).contains(label) ||
                   Arrays.asList(besselFunctions).contains(label)) {
            handleScientificFunction(label);
        } else {
            if (shouldClearDisplay) {
                A = label;
                shouldClearDisplay = false;
            } else if (A.equals("0") && !label.equals(".")) {
                A = label;
            } else {
                A += label;
            }
            updateDisplay();
        }
    }
    
    private void handleScientificFunction(String func) {
        try {
            double val = Double.parseDouble(A);
            double result = 0;
            boolean calculated = false;
            
            switch (func) {
                case "sin": result = Math.sin(convertAngle(val)); calculated = true; break;
                case "cos": result = Math.cos(convertAngle(val)); calculated = true; break;
                case "tan": result = Math.tan(convertAngle(val)); calculated = true; break;
                case "asin": 
                    if (val >= -1 && val <= 1) {
                        result = convertAngleBack(Math.asin(val));
                        calculated = true;
                    } else {
                        displayLabel.setText("Domain Error");
                        return;
                    }
                    break;
                case "acos":
                    if (val >= -1 && val <= 1) {
                        result = convertAngleBack(Math.acos(val));
                        calculated = true;
                    } else {
                        displayLabel.setText("Domain Error");
                        return;
                    }
                    break;
                case "atan": result = convertAngleBack(Math.atan(val)); calculated = true; break;
                case "sinh": result = Math.sinh(val); calculated = true; break;
                case "cosh": result = Math.cosh(val); calculated = true; break;
                case "tanh": result = Math.tanh(val); calculated = true; break;
                case "log": 
                    if (val > 0) {
                        result = Math.log10(val);
                        calculated = true;
                    } else {
                        displayLabel.setText("Domain Error");
                        return;
                    }
                    break;
                case "ln":
                    if (val > 0) {
                        result = Math.log(val);
                        calculated = true;
                    } else {
                        displayLabel.setText("Domain Error");
                        return;
                    }
                    break;
                case "√":
                    if (val >= 0) {
                        result = Math.sqrt(val);
                        calculated = true;
                    } else {
                        displayLabel.setText("Domain Error");
                        return;
                    }
                    break;
                case "x²": result = val * val; calculated = true; break;
                case "!": result = factorial((int)val); calculated = true; break;
                case "π": A = formatNumber(Math.PI); updateDisplay(); return;
                case "e": A = formatNumber(Math.E); updateDisplay(); return;
                case "J0": result = besselJ0(val); calculated = true; break;
                case "J1": result = besselJ1(val); calculated = true; break;
                case "Y0": result = besselY0(val); calculated = true; break;
                case "Y1": result = besselY1(val); calculated = true; break;
            }
            
            if (calculated) {
                A = formatNumber(result);
                addToHistory(val + " " + func + " = " + A);
                updateDisplay();
            }
        } catch (NumberFormatException e) {
            displayLabel.setText("Error");
        }
    }
    
    // Bessel functions (simplified implementations)
    private double besselJ0(double x) {
        double t = Math.abs(x);
        if (t < 8.0) {
            double y = t * t;
            return (57568490574.0 + y * (-13362590354.0 + y * (651619640.7
                    + y * (-11214424.18 + y * (77392.33017 + y * (-184.9052456)))))) 
                    / (57568490411.0 + y * (1029532985.0 + y * (9494680.718
                    + y * (59272.64853 + y * (267.8532712 + y * 1.0)))));
        } else {
            double z = 8.0 / t;
            double y = z * z;
            double xx = t - 0.785398164;
            return Math.sqrt(0.636619772 / t) * (Math.cos(xx) * (1.0 + y * (-0.1098628627e-2
                    + y * (0.2734510407e-4 + y * (-0.2073370639e-5 + y * 0.2093887211e-6))))
                    - z * Math.sin(xx) * (0.04687499995 + y * (-0.2002690873e-3
                    + y * (0.8449199096e-5 + y * (-0.88228987e-6 + y * 0.105787412e-6)))));
        }
    }
    
    private double besselJ1(double x) {
        double t = Math.abs(x);
        if (t < 8.0) {
            double y = t * t;
            return t * (72362614232.0 + y * (-7895059235.0 + y * (242396853.1
                    + y * (-2972611.439 + y * (15704.48260 + y * (-30.16036606)))))) 
                    / (144725228442.0 + y * (2300535178.0 + y * (18583304.74
                    + y * (99447.43394 + y * (376.9991397 + y * 1.0)))));
        } else {
            double z = 8.0 / t;
            double y = z * z;
            double xx = t - 2.356194491;
            return Math.sqrt(0.636619772 / t) * (Math.cos(xx) * (1.0 + y * (0.183105e-2
                    + y * (-0.3516396496e-4 + y * (0.2457520174e-5 + y * (-0.240337019e-6)))))
                    - z * Math.sin(xx) * (0.04687499995 + y * (-0.2002690873e-3
                    + y * (0.8449199096e-5 + y * (-0.88228987e-6 + y * 0.105787412e-6)))));
        }
    }
    
    private double besselY0(double x) {
        if (x < 8.0) {
            double y = x * x;
            double ans1 = -2957821389.0 + y * (7709578966.0 + y * (-512359803.6
                    + y * (10087292.398 + y * (-86327.92757 + y * 228.4622733))));
            double ans2 = 40076544269.0 + y * (745249964.86 + y * (7189466.438
                    + y * (47447.26470 + y * (226.1030244 + y * 1.0))));
            return (ans1 / ans2) + 0.636619772 * besselJ0(x) * Math.log(x);
        } else {
            double z = 8.0 / x;
            double y = z * z;
            double xx = x - 0.785398164;
            return Math.sqrt(0.636619772 / x) * (Math.sin(xx) * (1.0 + y * (-0.1098628627e-2
                    + y * (0.2734510407e-4 + y * (-0.2073370639e-5 + y * 0.2093887211e-6))))
                    + z * Math.cos(xx) * (0.04687499995 + y * (-0.2002690873e-3
                    + y * (0.8449199096e-5 + y * (-0.88228987e-6 + y * 0.105787412e-6)))));
        }
    }
    
    private double besselY1(double x) {
        if (x < 8.0) {
            double y = x * x;
            double ans1 = x * (-0.4900604943e13 + y * (0.1275274390e13
                    + y * (-0.5153438139e11 + y * (0.7349264551e9
                    + y * (-0.4237922726e7 + y * 0.8511937935e4)))));
            double ans2 = 0.2499580570e14 + y * (0.4244419664e12
                    + y * (0.3733650367e10 + y * (0.2245904002e8
                    + y * (0.1020426050e6 + y * (0.3549632885e3 + y)))));
            return (ans1 / ans2) + 0.636619772 * (besselJ1(x) * Math.log(x) - 1.0 / x);
        } else {
            double z = 8.0 / x;
            double y = z * z;
            double xx = x - 2.356194491;
            return Math.sqrt(0.636619772 / x) * (Math.sin(xx) * (1.0 + y * (0.183105e-2
                    + y * (-0.3516396496e-4 + y * (0.2457520174e-5 + y * (-0.240337019e-6)))))
                    + z * Math.cos(xx) * (0.04687499995 + y * (-0.2002690873e-3
                    + y * (0.8449199096e-5 + y * (-0.88228987e-6 + y * 0.105787412e-6)))));
        }
    }
    
    private void showBesselFunctionDialog() {
        String[] functions = {"J0", "J1", "Y0", "Y1"};
        String selected = (String) JOptionPane.showInputDialog(
            null, "Select Bessel Function:", "Bessel Functions",
            JOptionPane.QUESTION_MESSAGE, null, functions, functions[0]);
        
        if (selected != null) {
            handleScientificFunction(selected);
        }
    }
    
    private void showExportDialog() {
        String[] options = {"JSON", "CSV", "Cancel"};
        int choice = JOptionPane.showOptionDialog(null,
            "Export history as:", "Export History",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, options, options[0]);
        
        if (choice == 0) {
            exportHistoryAsJSON();
        } else if (choice == 1) {
            exportHistoryAsCSV();
        }
    }
    
    private void exportHistoryAsJSON() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (!file.getName().endsWith(".json")) {
                    file = new File(file.getAbsolutePath() + ".json");
                }
                
                FileWriter writer = new FileWriter(file);
                writer.write("{\n");
                writer.write("  \"calculations\": [\n");
                
                for (int i = 0; i < history.size(); i++) {
                    writer.write("    {\n");
                    writer.write("      \"index\": " + (i+1) + ",\n");
                    writer.write("      \"calculation\": \"" + escapeJson(history.get(i)) + "\",\n");
                    writer.write("      \"timestamp\": \"" + LocalDateTime.now().format(
                        DateTimeFormatter.ISO_DATE_TIME) + "\"\n");
                    writer.write("    }" + (i < history.size() - 1 ? "," : "") + "\n");
                }
                
                writer.write("  ]\n");
                writer.write("}\n");
                writer.close();
                JOptionPane.showMessageDialog(null, "History exported to " + file.getName());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Export failed: " + e.getMessage());
        }
    }
    
    private void exportHistoryAsCSV() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (!file.getName().endsWith(".csv")) {
                    file = new File(file.getAbsolutePath() + ".csv");
                }
                
                FileWriter writer = new FileWriter(file);
                writer.write("Index,Calculation,Timestamp\n");
                
                for (int i = 0; i < history.size(); i++) {
                    writer.write((i+1) + ",\"" + history.get(i) + "\",\"" 
                        + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + "\"\n");
                }
                
                writer.close();
                JOptionPane.showMessageDialog(null, "History exported to " + file.getName());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Export failed: " + e.getMessage());
        }
    }
    
    private String escapeJson(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n");
    }
    
    private void calculate() {
        if (B != null && operator != null && !A.equals("0")) {
            try {
                double numA = Double.parseDouble(A);
                double numB = Double.parseDouble(B);
                double result = 0;
                boolean valid = true;
                
                switch (operator) {
                    case "+": result = numB + numA; break;
                    case "-": result = numB - numA; break;
                    case "×": result = numB * numA; break;
                    case "÷":
                        if (numA != 0) result = numB / numA;
                        else {
                            displayLabel.setText("Error: Division by zero");
                            valid = false;
                        }
                        break;
                }
                
                if (valid) {
                    A = formatNumber(result);
                    addToHistory(numB + " " + operator + " " + numA + " = " + A);
                    updateDisplay();
                    operator = null;
                    B = null;
                }
            } catch (NumberFormatException e) {
                displayLabel.setText("Error");
            }
        }
    }
    
    private boolean isOperator(String label) {
        return label.equals("+") || label.equals("-") || label.equals("×") || label.equals("÷");
    }
    
    private double convertAngle(double angle) {
        if (currentAngleMode.equals("Degrees")) {
            return Math.toRadians(angle);
        } else if (currentAngleMode.equals("Gradians")) {
            return Math.toRadians(angle * 0.9);
        }
        return angle;
    }
    
    private double convertAngleBack(double radians) {
        if (currentAngleMode.equals("Degrees")) {
            return Math.toDegrees(radians);
        } else if (currentAngleMode.equals("Gradians")) {
            return Math.toDegrees(radians) / 0.9;
        }
        return radians;
    }
    
    private double factorial(int n) {
        if (n < 0 || n > 170) return Double.NaN;
        if (n <= 1) return 1;
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    private void addToHistory(String entry) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        history.add("[" + timestamp + "] " + entry);
        updateHistoryDisplay();
    }
    
    private void updateHistoryDisplay() {
        historyPane.setText("");
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        
        for (String entry : history) {
            try {
                if (entry.contains("=")) {
                    String[] parts = entry.split("=");
                    StyleConstants.setForeground(attrs, isDarkMode ? Color.WHITE : Color.BLACK);
                    historyPane.getDocument().insertString(historyPane.getDocument().getLength(), 
                        parts[0] + "= ", attrs);
                    
                    StyleConstants.setForeground(attrs, vibrantGreen);
                    StyleConstants.setBold(attrs, true);
                    historyPane.getDocument().insertString(historyPane.getDocument().getLength(), 
                        parts[1] + "\n", attrs);
                }
            } catch (Exception e) {}
        }
        
        historyPane.setCaretPosition(historyPane.getDocument().getLength());
    }
    
    private String formatNumber(double num) {
        if (Double.isInfinite(num) || Double.isNaN(num)) {
            return "Error";
        }
        
        if (useScientificNotation) {
            return String.format("%.2e", num);
        }
        
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(decimalPrecision);
        df.setGroupingUsed(true);
        return df.format(num);
    }
    
    private void updateDisplay() {
        try {
            double val = Double.parseDouble(A);
            displayLabel.setText(formatNumber(val));
        } catch (NumberFormatException e) {
            displayLabel.setText(A);
        }
    }
    
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        // Theme menu
        JMenu themeMenu = new JMenu("Theme");
        JMenuItem darkMode = new JMenuItem("Dark Mode");
        JMenuItem lightMode = new JMenuItem("Light Mode");
        
        darkMode.addActionListener(e -> {
            isDarkMode = true;
            applyTheme();
        });
        lightMode.addActionListener(e -> {
            isDarkMode = false;
            applyTheme();
        });
        
        themeMenu.add(darkMode);
        themeMenu.add(lightMode);
        
        // Help menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                "Advanced Scientific Calculator Pro v2.5\n\n" +
                "Features:\n" +
                "• 23+ Scientific Functions\n" +
                "• Bessel Functions (J0, J1, Y0, Y1)\n" +
                "• Unit Conversions (Length, Weight, Temperature)\n" +
                "• Currency Conversion\n" +
                "• Scientific Notation Support\n" +
                "• History Export (JSON, CSV)\n" +
                "• Custom Keyboard Shortcuts\n" +
                "• Syntax Highlighting\n" +
                "• Memory Functions (M+, M-, MR, MC)\n" +
                "• Multiple Angle Modes\n" +
                "• Decimal Precision Settings\n\n" +
                "© 2026 Muhammad Magdy");
        });
        helpMenu.add(about);
        
        menuBar.add(themeMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }
    
    private void applyTheme() {
        Color bgColor = isDarkMode ? darkBg : lightBg;
        Color textColor = isDarkMode ? vibrantCyan : vibrantIndigo;
        Color panelColor = isDarkMode ? darkPanel : lightPanel;
        
        displayLabel.setBackground(bgColor);
        displayLabel.setForeground(textColor);
        
        historyPane.setBackground(panelColor);
        historyPane.setForeground(textColor);
        
        memoryLabel.setForeground(isDarkMode ? vibrantYellow : vibrantOrange);
        memoryLabel.setFont(new Font("Arial", Font.BOLD, 15));
        
        tabbedPane.setBackground(panelColor);
        tabbedPane.setForeground(textColor);
        
        // Update all panels with vibrant theme
        getContentPane().setBackground(bgColor);
        
        updateHistoryDisplay();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        
        if (Character.isDigit(key) || key == '.') {
            handleButtonClick(String.valueOf(key));
        } else if (key == '+' || key == '-' || key == '*' || key == '/') {
            String op = key == '*' ? "×" : key == '/' ? "÷" : String.valueOf(key);
            handleButtonClick(op);
        } else if (key == '\n') {
            handleButtonClick("=");
        } else if (key == '\b') {
            handleButtonClick("AC");
        } else if (customShortcuts.containsKey(key)) {
            handleButtonClick(customShortcuts.get(key));
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e) {}
}


