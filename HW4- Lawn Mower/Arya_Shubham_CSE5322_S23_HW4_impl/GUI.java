import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GUI extends JPanel implements ActionListener {

    public int rows = 5, cols = 5;
    public int squareSize = 50;
    private JButton startButton, stopButton;
    public Controller controller;
    
    public GUI() {
        JFrame frame = new JFrame("HW4 GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new DimensionUIResource(cols * squareSize, rows * squareSize + 65));
        frame.setMaximumSize(new DimensionUIResource(cols * squareSize, rows * squareSize + 65));

        JPanel buttonsPanel = buttonsPanel();

        frame.add(this, BorderLayout.CENTER);
        frame.add(buttonsPanel, BorderLayout.NORTH);
        frame.setVisible(true);
        this.setBackground(Color.green);

        controller = new Controller(this);
    }

    private JPanel buttonsPanel() {
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(startButton);
        buttonsPanel.add(stopButton);
        buttonsPanel.setBackground(new Color(240, 236, 236));
        return buttonsPanel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        controller.cutGrass(g2d); // this is to show the original uncut lawn state
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            controller.startButtonAction();
        } else if (e.getSource() == stopButton) {
            controller.stopButtonAction();
        } 
    }

    public static void main(String[] args) {
        new GUI();
    }

}
