package me.aparna.tipcalculator;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUITipCalculatorWithSlider {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new CalculatorFrameWithSlider();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setLocation(100, 100);
            frame.setTitle("Tip Calculator");
            frame.setResizable(true);
        });
    }
}

class CalculatorFrameWithSlider extends JFrame {
    private static final int DEFAULT_WIDTH = 250;
    private static final int DEFAULT_HEIGHT = 250;
    private JPanel calculatorPanel;
    private JLabel exceptionLabel;
    private JLabel billAmountLabel;
    private JLabel tipPercentageLabel;
    private JLabel tipAmountLabel;
    private JLabel totalAmountLabel;
    private JTextField billAmountText;
    private JSlider tipPercentageSlider;
    private KeyListener keyListener;
    private SliderChangeListener changeListener;

    public CalculatorFrameWithSlider() {
        setFrameSize();
        calculatorPanel = new JPanel();
        calculatorPanel.add((exceptionLabel = new JLabel("No Exception")));
        keyListener = new KeyListener();
        changeListener = new SliderChangeListener();
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
        tipPercentageSlider = new JSlider(5, 20, 5);
        // paint the ticks and tarcks
        tipPercentageSlider.setPaintTrack(true);
        tipPercentageSlider.setPaintTicks(true);
        tipPercentageSlider.setPaintLabels(true);

        // set spacing
        tipPercentageSlider.setMajorTickSpacing(2);
        tipPercentageSlider.setMinorTickSpacing(1);
        tipPercentageSlider.addChangeListener(changeListener);
        calculatorPanel.add(tipPercentageLabel);
        calculatorPanel.add(tipPercentageSlider);
    }

    private void addTipAmountFields() {
        tipAmountLabel = new JLabel("The tip amount is $0.00");
        calculatorPanel.add(tipAmountLabel);
    }

    private void addTotalAmountFields() {
        totalAmountLabel = new JLabel("The total amount is $0.00");
        calculatorPanel.add(totalAmountLabel);
    }

    private void updateLabels() {
        try {
            double billAmount = BasicTipCalculator.validateResult("billAmount", billAmountText.getText()).doubleValue();
            int tipPercentage = BasicTipCalculator.validateResult("tipPercentage", String.valueOf(tipPercentageSlider.getValue())).intValue();
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

    class KeyListener extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            updateLabels();
        }
    }

    class SliderChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            updateLabels();
        }
    }
}
