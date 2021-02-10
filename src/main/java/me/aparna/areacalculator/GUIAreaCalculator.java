package me.aparna.areacalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIAreaCalculator {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new CalculatorFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setLocation(100, 100);
            frame.setTitle("Area Calculator");
            frame.setResizable(true);
        });
    }
}

class CalculatorFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 250;
    private static final int DEFAULT_HEIGHT = 250;
    private JPanel calculatorPanel;
    private JLabel exceptionLabel;
    private JLabel lengthLabel;
    private JLabel breadthLabel;
    private JTextField lengthText;
    private JTextField breadthText;
    private JLabel unitLabel;
    private ButtonGroup unitGroup;
    private JRadioButton meterButton;
    private JRadioButton feetButton;
    private JLabel areaLabel;
    private CalculatorFrame.KeyListener keyListener;
    private ItemActionListener itemActionListener;

    public CalculatorFrame() {
        setFrameSize();
        calculatorPanel = new JPanel();
        calculatorPanel.add((exceptionLabel = new JLabel("")));
        areaLabel = new JLabel("");
        keyListener = new CalculatorFrame.KeyListener();
        itemActionListener = new ItemActionListener();
        addLengthFields();
        addBreadthFields();
        addUnitFields();
        calculatorPanel.add(areaLabel);
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

    private void addUnitFields() {
        unitGroup = new ButtonGroup();
        meterButton = new JRadioButton("Meter(m)");
        feetButton = new JRadioButton("Feet(f)");
        unitGroup.add(meterButton);
        unitGroup.add(feetButton);
        meterButton.addItemListener(itemActionListener);
        feetButton.addItemListener(itemActionListener);
        meterButton.setSelected(true);
        unitLabel = new JLabel("Enter the unit of the dimension:");
        calculatorPanel.add(unitLabel);
        calculatorPanel.add(meterButton);
        calculatorPanel.add(feetButton);
    }

    private void addLengthFields() {
        lengthLabel = new JLabel("What is the length of the room?");
        lengthText = new JTextField("0", 20);
        lengthText.addKeyListener(keyListener);
        calculatorPanel.add(lengthLabel);
        calculatorPanel.add(lengthText);
    }

    private void addBreadthFields() {
        breadthLabel = new JLabel("What is the breadth of the room?");
        breadthText = new JTextField("0", 20);
        breadthText.addKeyListener(keyListener);
        calculatorPanel.add(breadthLabel);
        calculatorPanel.add(breadthText);
    }

    private void changeAction() {
        try {
            int length = UpgradedAreaCalculator.validateResult("length", lengthText.getText());
            int breadth = UpgradedAreaCalculator.validateResult("breadth", breadthText.getText());
            Unit unit = meterButton.isSelected() ? Unit.METRE : Unit.FEET;
            UpgradedAreaCalculator calculator = new UpgradedAreaCalculator();
            calculator.setDimensions(unit, length, breadth);
            areaLabel.setText(calculator.getOutput());
            exceptionLabel.setText("No Exception");
        } catch(RuntimeException re) {
            areaLabel.setText("");
            exceptionLabel.setText(re.getMessage());
        }
    }

    class KeyListener extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            changeAction();
        }
    }

    class ItemActionListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            changeAction();
        }
    }



}
