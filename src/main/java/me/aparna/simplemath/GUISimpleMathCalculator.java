package me.aparna.simplemath;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUISimpleMathCalculator {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new CalculatorFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setLocation(100, 100);
            frame.setTitle("Simple Math Calculator");
            frame.setResizable(true);
        });
    }
}

class CalculatorFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 250;
    private static final int DEFAULT_HEIGHT = 250;
    private JPanel calculatorPanel;
    private JLabel exceptionLabel;
    private JLabel number1Label;
    private JLabel number2Label;
    private JTextField number1Text;
    private JTextField number2Text;

    private JLabel sumLabel;
    private JLabel diffLabel;
    private JLabel prodLabel;
    private JLabel quotLabel;
    private KeyListener keyListener;

    public CalculatorFrame() {
        setFrameSize();
        calculatorPanel = new JPanel();
        calculatorPanel.add((exceptionLabel = new JLabel("")));
        keyListener = new KeyListener();
        addNumberOneFields();
        addNumberTwoFields();
        sumLabel = new JLabel("");
        diffLabel = new JLabel("");
        prodLabel = new JLabel("");
        quotLabel = new JLabel("");
        calculatorPanel.add(sumLabel);
        calculatorPanel.add(diffLabel);
        calculatorPanel.add(prodLabel);
        calculatorPanel.add(quotLabel);
        add(calculatorPanel);
    }

    private void setFrameSize() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //setSize(screenWidth/2, screenHeight/2);
    }

    private void addNumberOneFields() {
        number1Label = new JLabel("What is the first number?");
        number1Text = new JTextField("0", 20);
        number1Text.addKeyListener(keyListener);
        calculatorPanel.add(number1Label);
        calculatorPanel.add(number1Text);
    }

    private void addNumberTwoFields() {
        number2Label = new JLabel("What is the second number?");
        number2Text = new JTextField("0", 20);
        number2Text.addKeyListener(keyListener);
        calculatorPanel.add(number2Label);
        calculatorPanel.add(number2Text);
    }

    class KeyListener extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            try {
                int number1 = SimpleMathCalculator.validateResult("number1", number1Text.getText()).intValue();
                int number2 = SimpleMathCalculator.validateResult("number2", number2Text.getText()).intValue();
                SimpleMathCalculator calculator = new SimpleMathCalculator();
                calculator.setInputs(number1, number2);
                calculator.performOperations();
                sumLabel.setText(String.format("%d + %d = %d", number1, number2, calculator.getSum()));
                diffLabel.setText(String.format("%d - %d = %d", number1, number2, calculator.getDiff()));
                prodLabel.setText(String.format("%d * %d = %d", number1, number2, calculator.getProd()));
                quotLabel.setText(String.format("%d / %d = %d", number1, number2, calculator.getQuot()));
                exceptionLabel.setText("No Exception");
            } catch(RuntimeException re) {
                exceptionLabel.setText(re.getMessage());
                sumLabel.setText("");
                diffLabel.setText("");
                prodLabel.setText("");
                quotLabel.setText("");
            }
        }
    }

}