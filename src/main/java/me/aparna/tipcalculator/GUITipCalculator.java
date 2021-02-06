package me.aparna.tipcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUITipCalculator {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new CalculatorFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setLocation(100, 100);
            frame.setTitle("Tip Calculator");
            frame.setResizable(true);
        });
    }
}

class CalculatorFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 250;
    private static final int DEFAULT_HEIGHT = 250;
    private JPanel calculatorPanel;
    private JLabel exceptionLabel;
    private JLabel billAmountLabel;
    private JLabel tipPercentageLabel;
    private JLabel tipAmountLabel;
    private JLabel totalAmountLabel;
    private JTextField billAmountText;
    private JTextField tipPercentageText;
    private KeyListener keyListener;

    public CalculatorFrame() {
        setFrameSize();
        calculatorPanel = new JPanel();
        calculatorPanel.add((exceptionLabel = new JLabel("No Exception")));
        keyListener = new KeyListener();
        addBillAmountFields();
        addTipPercentageFields();
        addTipAmountFields();
        addTotalAmountFields();
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

    private void addBillAmountFields() {
        billAmountLabel = new JLabel("Please enter the bill amount:");
        billAmountText = new JTextField("0.00", 20);
        billAmountText.addKeyListener(keyListener);
        calculatorPanel.add(billAmountLabel);
        calculatorPanel.add(billAmountText);
    }

    private void addTipPercentageFields() {
        tipPercentageLabel = new JLabel("Please enter the tip percentage:");
        tipPercentageText = new JTextField("0", 20);
        tipPercentageText.addKeyListener(keyListener);
        calculatorPanel.add(tipPercentageLabel);
        calculatorPanel.add(tipPercentageText);
    }

    private void addTipAmountFields() {
        tipAmountLabel = new JLabel("The tip amount is $0.00");
        calculatorPanel.add(tipAmountLabel);
    }

    private void addTotalAmountFields() {
        totalAmountLabel = new JLabel("The total amount is $0.00");
        calculatorPanel.add(totalAmountLabel);
    }

    class KeyListener extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            try {
                double billAmount = BasicTipCalculator.validateResult("billAmount", billAmountText.getText()).doubleValue();
                int tipPercentage = BasicTipCalculator.validateResult("tipPercentage", tipPercentageText.getText()).intValue();
                BasicTipCalculator calculator = new BasicTipCalculator();
                calculator.setInputs(billAmount, tipPercentage);
                calculator.calculateTotal();
                tipAmountLabel.setText("The tip amount is "+calculator.getTip());
                totalAmountLabel.setText("The total amount is "+calculator.getTotal());
                exceptionLabel.setText("No Exception");
            } catch(RuntimeException re) {
                exceptionLabel.setText(re.getMessage());
                tipAmountLabel.setText("The tip amount is ");
                totalAmountLabel.setText("The total amount is ");
            }
        }
    }

}


