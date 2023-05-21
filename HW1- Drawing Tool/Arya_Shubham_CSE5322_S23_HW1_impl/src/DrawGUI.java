import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawGUI extends JFrame {
    private DrawController controller;
    JButton circleButton;
    JButton squareButton;
    JButton triangleButton;
    private Shape currentShape = new Circle(); // By default, users should have Circle selected 

    public DrawGUI() {
        int screenSize = 600;
        setTitle("HW1 GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(screenSize, screenSize);
        setMinimumSize(new Dimension(screenSize, screenSize));
        setMaximumSize(new Dimension(screenSize, screenSize));
        setLocationRelativeTo(null);

        JPanel panel = setupButtonPanel();
        panel.setBackground(Color.WHITE);
        add(panel, BorderLayout.WEST); 

        controller = new DrawController(this);

        setButtonTapActions();

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                controller.drawShape(currentShape, e.getPoint());
            }
        });

        setVisible(true);
    }

    private JPanel setupButtonPanel() {
        circleButton = new JButton("Circle");
        squareButton = new JButton("Box");
        triangleButton = new JButton("Triangle");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(circleButton);
        panel.add(squareButton);
        panel.add(triangleButton);
        return panel;
    }

    private void setButtonTapActions() {
        circleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentShape = new Circle();
            }
        });
        squareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentShape = new Box();
            }
        });
        triangleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentShape = new Triangle();
            }
        });
    }

    public static void main(String[] args) {
        new DrawGUI();
    }
}
