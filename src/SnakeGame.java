import java.awt.*;
import java.util.Random;
import java.util.ArrayList;

import javax.swing.JPanel;
import keys.CustomKeyAdapter;
import vars.GlobalVariables;

public class SnakeGame extends JPanel {
    private boolean isRunning;
    private Random rand;
    private ArrayList<Snake> snake = new ArrayList<Snake>();
    private Apple apple;
    private Graphics g;
    public SnakeGame() {
        g = this.getGraphics();
        rand = new Random();
        this.setPreferredSize(new Dimension(GlobalVariables.getScreenWidth(), GlobalVariables.getScreenHeight()));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new CustomKeyAdapter());
        startGame();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {

    }
    private void startGame() {
        apple = new Apple(rand, g);
        isRunning = true;
    }
}
