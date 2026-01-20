import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.*;

public class Calculator {
    
    
        int boardWidth = 360;
        int boardHeight = 540;

        Color customLightGray = new Color(221,212,210);
        Color customDarkGray = new Color(80,80,80);
        Color customBlack = new Color(28,28,28);
        Color customOrange = new Color(255,149,0);

        String[] buttonValues = {
        "AC", "+/-", "%", "÷", 
        "7", "8", "9", "×", 
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "="
        };
        String[] rightSymbols = {"÷", "×", "-", "+", "="};
        String[] topSymbols = {"AC", "+/-", "%"};

        JFrame frame = new JFrame("Calculator");
        JLabel displayLabel = new JLabel();
        JPanel displayPanel = new JPanel();

        JPanel buttonsPanel = new JPanel();

        // Calculation history
        ArrayList<String> history = new ArrayList<>();
        JTextArea historyArea = new JTextArea();

        // A+B , A-B , A*B , A/B
        String A= "0";
        String B= null;
        String operator= null;

        Calculator()
        {
            frame.setSize(boardWidth, boardHeight);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            displayLabel.setBackground(customBlack);
            displayLabel.setForeground(Color.WHITE);
            displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));
            displayLabel.setHorizontalAlignment(JLabel.RIGHT);
            displayLabel.setText("0");
            displayLabel.setOpaque(true);

            displayPanel.setLayout(new BorderLayout());
            displayPanel.add(displayLabel);
            frame.add(displayPanel, BorderLayout.NORTH);

            buttonsPanel.setLayout(new GridLayout(5,4));
            buttonsPanel.setBackground(customBlack);
            frame.add(buttonsPanel);

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

            for (int i =0 ; i<buttonValues.length; i++)
            {

                JButton button = new JButton();
                String buttonValue = buttonValues[i];
                button.setFont(new Font("Arial", Font.PLAIN, 30));
                button.setText(buttonValue);
                button.setFocusable(false);
                button.setOpaque(true);
                button.setBorder(new LineBorder(customBlack));
                if(Arrays.asList(topSymbols).contains(buttonValue))
                {
                    button.setBackground(customLightGray);
                    button.setForeground(Color.BLACK);
                }
                else if (Arrays.asList(rightSymbols).contains(buttonValue))
                {
                    button.setBackground(customOrange);
                    button.setForeground(Color.WHITE);
                }
                else
                {
                    button.setBackground(customDarkGray);
                    button.setForeground(Color.WHITE);
                }
                buttonsPanel.add(button);

                button.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JButton button = (JButton) e.getSource();
                        String buttonValue = button.getText();
                        if(Arrays.asList(rightSymbols).contains(buttonValue))
                        {
                            if(buttonValue.equals("="))
                            {
                                if(A != null && operator != null)
                                {
                                    B = displayLabel.getText();
                                    double numA = Double.parseDouble(A);
                                    double numB = Double.parseDouble(B);
                                    double result = 0;
                                    boolean validOperation = true;
                                    
                                    if(operator.equals("+"))
                                    {
                                        result = numA + numB;
                                    }
                                    else if(operator.equals("-"))
                                    {
                                        result = numA - numB;
                                    }
                                    else if(operator.equals("×"))
                                    {
                                        result = numA * numB;
                                    }
                                    else if(operator.equals("÷"))
                                    {
                                        if(numB != 0)
                                        {
                                            result = numA / numB;
                                        }
                                        else
                                        {
                                            displayLabel.setText("Error: Division by 0");
                                            validOperation = false;
                                        }
                                    }
                                    
                                    if(validOperation) {
                                        String resultStr = removeZeroDecimal(result);
                                        displayLabel.setText(resultStr);
                                        // Add to history
                                        addToHistory(numA + " " + operator + " " + numB + " = " + resultStr);
                                        clearAll();
                                    }
                                }
                                
                            }
                            else if ("+-×÷".contains(buttonValue))
                            {
                                if(operator == null)
                                {
                                    A = displayLabel.getText();
                                    displayLabel.setText("0");
                                    B="0";
                                }
                                operator = buttonValue;
                            }
                        }
                        else if (Arrays.asList(topSymbols).contains(buttonValue))
                        {
                            if(buttonValue.equals("AC"))
                            {
                                clearAll();
                                displayLabel.setText("0");
                            }
                            else if (buttonValue.equals("+/-"))
                            {
                                
                                double numDisplay = Double.parseDouble(displayLabel.getText());
                                numDisplay *= -1;
                                displayLabel.setText(removeZeroDecimal(numDisplay));
                            }
                            
                            else if (buttonValue.equals("%"))
                            {
                                double numDisplay = Double.parseDouble(displayLabel.getText());
                                numDisplay /= 100;
                                displayLabel.setText(removeZeroDecimal(numDisplay));
                            }
                        }
                        else if(buttonValue.equals("√"))
                        {
                            double numDisplay = Double.parseDouble(displayLabel.getText());
                            if(numDisplay >= 0)
                            {
                                double result = Math.sqrt(numDisplay);
                                displayLabel.setText(removeZeroDecimal(result));
                                addToHistory("√(" + numDisplay + ") = " + removeZeroDecimal(result));
                            }
                            else
                            {
                                displayLabel.setText("Error: Negative number");
                            }
                        }
                        else{
                            if(buttonValue.equals("."))
                            {
                                if(!displayLabel.getText().contains(buttonValue))
                                {
                                    displayLabel.setText(displayLabel.getText() + buttonValue);
                                }
                            }
                            else if ("0123456789".contains(buttonValue))
                            {
                                if(displayLabel.getText().equals("0"))
                                {
                                    displayLabel.setText(buttonValue);
                                }
                                else
                                {
                                    displayLabel.setText(displayLabel.getText() + buttonValue);
                                }
                            }
                        }
                        
                    }
                });
            }
            frame.setVisible(true);
        }
        void clearAll(){
                A= "0";
                B= null;
                operator= null;
            }

        String removeZeroDecimal(double numDisplay)
        {
                if(numDisplay % 1 ==0)
                {
                    return Integer.toString((int)numDisplay);
                }
                else
                {
                    return Double.toString(numDisplay);
                }
        }

        // Add calculation to history
        void addToHistory(String calculation) {
            history.add(calculation);
            System.out.println("Calculation: " + calculation);
        }

        // Simulate button click for keyboard input
        void simulateButtonClick(String value) {
            if("+-×÷".contains(value)) {
                if(operator == null) {
                    A = displayLabel.getText();
                    displayLabel.setText("0");
                }
                operator = value.equals("+") ? "+" : value.equals("-") ? "-" : value.equals("*") ? "×" : "÷";
            } else if(value.equals("=")) {
                if(A != null && operator != null) {
                    B = displayLabel.getText();
                    double numA = Double.parseDouble(A);
                    double numB = Double.parseDouble(B);
                    double result = 0;
                    
                    if(operator.equals("+")) result = numA + numB;
                    else if(operator.equals("-")) result = numA - numB;
                    else if(operator.equals("×")) result = numA * numB;
                    else if(operator.equals("÷")) {
                        if(numB != 0) result = numA / numB;
                        else {
                            displayLabel.setText("Error: Division by 0");
                            return;
                        }
                    }
                    
                    String resultStr = removeZeroDecimal(result);
                    displayLabel.setText(resultStr);
                    addToHistory(numA + " " + operator + " " + numB + " = " + resultStr);
                    clearAll();
                }
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
    

