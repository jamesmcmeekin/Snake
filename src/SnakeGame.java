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
        apple = new Apple(rand, g);
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
        isRunning = true;
        apple.newApple();
    }
    public void move() {
        for(int i = snake.size(); i > 0; i--) {
            snake.set(i, snake.get(i-1));
        }
        switch(GlobalVariables.getDirection()) {
            case 'U':
            snake.get(0).moveUp();
            break;
            case 'D':
            snake.get(0).moveDown();
            break;
            case 'L':
            snake.get(0).moveLeft();
            break;
            case 'R':
            snake.get(0).moveRight();
        }
    }
    //check if head is on the same grid as apple.
    public void checkApple() {

    }
    //check if the snake collides with anypart of the body, or the head is past any of the borders
    public void checkCollisions() {

    }
    //create a game over screen that displays the number of apples eaten, and a funny message
    public void gameOver() {

    }
    //
    public void run() {
        if(isRunning) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
        
    }

}
