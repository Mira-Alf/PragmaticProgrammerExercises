package me.aparna.countingcharacters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUICountingCharacters {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new CountingFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setLocation(100, 100);
            frame.setTitle("Counting Characters");
            frame.setResizable(true);
        });
    }
}

class CountingFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 250;
    private static final int DEFAULT_HEIGHT = 250;

    private JPanel countingPanel;
    private JLabel countCharactersLabel;
    private JTextField countCharactersText;
    private JLabel outputLabel;
    private KeyListener keyListener;

    public CountingFrame() {
        setFrameSize();
        countingPanel = new JPanel();
        countCharactersLabel = new JLabel("Enter the input string:");
        countCharactersText = new JTextField("", 50);
        outputLabel = new JLabel("The number of characters is ");
        keyListener = new CountingFrame.KeyListener();
        countingPanel.add(countCharactersLabel);
        countingPanel.add(countCharactersText);
        countingPanel.add(outputLabel);
        countCharactersText.addKeyListener(keyListener);
        add(countingPanel);
    }

    private void setFrameSize() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //setSize(screenWidth/2, screenHeight/2);
    }

    class KeyListener extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            CountingCharacters countingCharacters = new CountingCharacters();
            countingCharacters.setInputString(countCharactersText.getText());
            outputLabel.setText(countingCharacters.getOutputString());
        }
    }
}
