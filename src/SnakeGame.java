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
    private ArrayList<BodyPart> snake = new ArrayList<BodyPart>();;
    private Timer timer;
    private ArrayList<Apple> pommes;
    private int score = 0;
    private boolean hasWon;

    public SnakeGame() {
        this.getGraphics();
        rand = new Random();
        pommes = new ArrayList<Apple>();
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
        if (isRunning) {
            // draw the snake
            g.setColor(Color.GREEN);
            g.fillRect(head.getXPos(), head.getYPos(), GlobalVariables.getGridSize(),
                    GlobalVariables.getGridSize());

            for (int i = 0; i < snake.size(); i++) {

                g.setColor(new Color(50, 205, 50));
                g.fillRect(snake.get(i).getXPos(), snake.get(i).getYPos(), GlobalVariables.getGridSize(),
                        GlobalVariables.getGridSize());
            }
            // draw da apple
            for (int i = 0; i < pommes.size(); i++) {
                pommes.get(i).drawApple(g);
            }
            g.setColor(Color.CYAN);
            // da textttttttgttt4ttt4t43t4t4343tt43ttt34
            Font font = new Font("Frutiger ", 1, 50);
            g.setFont(font);
            g.drawString("Score: " + score, 300, 50);
        } else {
            gameOver(g);
        }
    }

    private void startGame() {
        isRunning = true;
        if (GlobalVariables.getApples() > GlobalVariables.getGridHeight() * GlobalVariables.getGridWidth()) {
            GlobalVariables
                    .setApples(GlobalVariables.getGridHeight() * GlobalVariables.getGridWidth() - (snake.size() + 1));
        }
        for (int i = 0; i < GlobalVariables.getApples(); i++) {
            pommes.add(new Apple(rand));

        }

        for (int i = 0; i < pommes.size(); i++) {
            pommes.get(i).newApple(snake, pommes, head);
        }

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
        checkCollisions();
    }

    // check if head is on the same grid as apple.
    public void checkApples() {
        for (int i = 0; i < pommes.size(); i++) {
            if (head.getXPos() == pommes.get(i).getXPos() && head.getYPos() == pommes.get(i).getYPos()) {
                if (GlobalVariables.getApples() < GlobalVariables.getGridHeight() * GlobalVariables.getGridWidth()
                        - (snake.size())) {
                    pommes.get(i).newApple(snake, pommes, head);

                } else {
                    pommes.remove(i);
                }
                score++;
                addPart();

            }
        }
        hasWon = checkWon();
    }

    // check if the snake collides with anypart of the body, or the head is past any
    // of the borders
    public void checkCollisions() {
        // left of screen
        if (head.getXPos() < 0) {
            isRunning = false;
        }
        // right of screen
        if (head.getXPos() > GlobalVariables.getScreenWidth() - GlobalVariables.getGridSize()) {
            isRunning = false;
        }
        // above screen
        if (head.getYPos() < 0) {
            isRunning = false;
        }
        // below screen
        if (head.getYPos() > GlobalVariables.getScreenHeight() - GlobalVariables.getGridSize()) {
            isRunning = false;
        }
        // colliededededededededededed w snake
        for (int i = snake.size() - 1; i >= 0; i--) {
            if (head.getXPos() == snake.get(i).getXPos() && head.getYPos() == snake.get(i).getYPos()) {
                isRunning = false;
            }
        }
        if (!isRunning) {
            timer.stop();
        }
    }

    // create a game over screen that displays the number of apples eaten, and a
    // funny message
    public void gameOver(Graphics g) {
        if (hasWon) {
            timer.stop();
            won(g);
        } else {
            String[] insults = { "ur so trash",
                    "give up already",
                    "you cant even beat snake?",
                    "consider not dying",
                    "maybe you are too old for games...",
                    "if you ate trash, it would be cannibalism",
                    "room temperature iq",
                    "if u added an eye to your head you would be a cyclops",
                    "congrats you got a participation trophy",
                    "do u eat crayons all day?",
                    "must be hereditary",
                    "its impossible to underestimate you",
                    "you are the reason toothepaste has instructions",
                    "you have the skill of a wet sock",
                    "you know that glue is not edible, right?",
                    "your brain must've been formed by spare parts",
                    "you are a walking dumpster of dissapointment",
                    "you must be a bone marrow baby",
                    "you effortlessly fail to meet expectations",
                    "you are out of your depth even in a parking lot puddle.",
                    "you have reached rock bottom, yet still manage to dig deeper",
                    "people will follow you out of morbid curiosity." };

            g.setColor(Color.red);
            g.setFont(new Font("Frutiger", Font.BOLD, 30));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Final Score: " + score,
                    (GlobalVariables.getScreenWidth() - metrics.stringWidth("Final Score: " + score)) / 2,
                    g.getFont().getSize());
            String insult = insults[rand.nextInt(insults.length)];
            g.drawString(insult, (GlobalVariables.getScreenWidth() - metrics.stringWidth(insult)) / 2,
                    GlobalVariables.getScreenHeight() / 2);
        }

    }

    // import world.satelite
    public void actionPerformed(ActionEvent e) {
        if (isRunning) {
            GlobalVariables.setRoundStartTime(System.currentTimeMillis());
            checkCollisions();
            move();
            checkApples();
        }
        repaint();
    }

    public void addPart() {
        snake.add(new BodyPart(snake.get(snake.size() - 1).getXPos(), snake.get(snake.size() - 1).getYPos()));
    }

    public boolean checkWon() {
        if (score + 2 == GlobalVariables.getGridHeight() * GlobalVariables.getGridWidth()) {
            isRunning = false;
            hasWon = true;
            return true;
        }
        return false;

    }

    public void won(Graphics g) {
        g.setColor(Color.green);
        g.setFont(new Font("Frutiger", Font.BOLD, 50));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("congrats you beat the game",
                (GlobalVariables.getScreenWidth() - metrics.stringWidth("congrats you beat the game")) / 2,
                GlobalVariables.getScreenHeight() / 2);
    }

    public void initSnake() {
        head = new Head(400, 400);
        snake.add(new BodyPart(450, 400));
        snake.add(new BodyPart(500, 400));
    }

}
