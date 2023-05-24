import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

import javax.swing.JPanel;
import keys.CustomKeyAdapter;
import vars.GlobalVariables;

public class SnakeGame extends JPanel implements ActionListener {
    private boolean isRunning = false;
    private Random rand;
    private Head head;
    private ArrayList<BodyPart> snake = new ArrayList<BodyPart>();
    private Apple apple;
    private Timer timer;

    public SnakeGame() {
        this.getGraphics();
        rand = new Random();
        apple = new Apple(rand);
        this.setPreferredSize(new Dimension(GlobalVariables.getScreenWidth(), GlobalVariables.getScreenHeight()));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new CustomKeyAdapter());
        initSnake();
        startGame();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);

    }

    private void draw(Graphics g) {
        // draw the grid
        if (isRunning) {
            g.setColor(Color.white);
            for (int i = 0; i < GlobalVariables.getGridHeight(); i++) {
                for (int j = 0; j < GlobalVariables.getGridWidth(); j++) {
                    g.drawRect(GlobalVariables.getGridSize() * j, GlobalVariables.getGridSize() * i,
                            GlobalVariables.getGridSize(), GlobalVariables.getGridSize());
                }
            }
            // draw the snake
            g.setColor(Color.GREEN);
            g.fillRect(head.getXPos(), head.getYPos(), GlobalVariables.getGridSize(),
                    GlobalVariables.getGridSize());
            for (int i = 0; i < snake.size(); i++) {
                g.fillRect(snake.get(i).getXPos(), snake.get(i).getYPos(), GlobalVariables.getGridSize(),
                        GlobalVariables.getGridSize());
                System.out.println(
                        "snake block " + i + "xpos " + snake.get(i).getXPos() + " ypos: " + snake.get(i).getYPos());
            }
            // draw da apple
            apple.drawApple(g);
        } else {
            gameOver();
        }
    }

    private void startGame() {
        isRunning = true;
        apple.newApple();
        timer = new Timer(GlobalVariables.getDelay(), this);
        timer.start();
    }

    public void move() {
        for (int i = snake.size() - 1; i > 0; i--) {
            snake.get(i).setXPos(snake.get(i - 1).getXPos());
            snake.get(i).setYPos(snake.get(i - 1).getYPos());
        }
        snake.get(0).setXPos(head.getXPos());
        snake.get(0).setYPos(head.getYPos());
        

        switch (GlobalVariables.getDirection()) {
            case 'U':
                head.moveUp();
                break;
            case 'D':
                head.moveDown();
                break;
            case 'L':
                head.moveLeft();
                break;
            case 'R':
                head.moveRight();
                break;
        }
    }

    // check if head is on the same grid as apple.
    public void checkApple() {
        if (head.getXPos() == apple.getXPos() && head.getYPos() == apple.getYPos()) {
            apple.newApple();
            addPart();
        }
    }

    // check if the snake collides with anypart of the body, or the head is past any
    // of the borders
    public void checkCollisions() {
        // left of screen
        if (head.getXPos() < 0) {
            isRunning = false;
            System.out.print("bad1");
        }
        // right of screen
        if (head.getXPos() > GlobalVariables.getScreenWidth()) {
            isRunning = false;
            System.out.print("bad2");
        }
        // above screen
        if (head.getYPos() < 0) {
            isRunning = false;
            System.out.print("bad3");
        }
        // below screen
        if (head.getYPos() > GlobalVariables.getScreenHeight()) {
            isRunning = false;
            System.out.print("bad4");
        }
        // colliededededededededededed w snake
        for (int i = snake.size() - 1; i >= 0; i--) {
            if (head.getXPos() == snake.get(i).getXPos() && head.getYPos() == snake.get(i).getYPos()) {
                isRunning = false;
                System.out.print("head xpos " + head.getXPos() + " body part " + i + " xPos "
                        + snake.get(i).getXPos() + ". Head ypos " + head.getYPos() + " body part " + i
                        + " ypos " + snake.get(i).getYPos());
            }
        }
        if (!isRunning) {
            gameOver();
        }
    }

    // create a game over screen that displays the number of apples eaten, and a
    // funny message
    public void gameOver() {
        System.out.println("uh oh");
    }

    // import world.satelite
    public void actionPerformed(ActionEvent e) {
        if (isRunning) {
            checkCollisions();
            move();
            checkApple();

        }
        repaint();
    }

    public void addPart() {
        snake.add(new BodyPart(snake.get(snake.size() - 1).getXPos(), snake.get(snake.size() - 1).getYPos()));
    }

    public void initSnake() {
        head = new Head(400, 400);
        snake.add(new BodyPart(450, 400));
        snake.add(new BodyPart(500, 400));
    }

}
