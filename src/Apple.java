import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.ArrayList;
import vars.GlobalVariables;

public class Apple {
    private int xPos = -1;
    private int yPos = -1;
    private Random rand;

    public Apple(Random rand) {
        this.rand = rand;
    }

    public void newApple(ArrayList<BodyPart> snake, ArrayList<Apple> pommes, Head head) {
        int newXPos, newYPos;
        boolean snakeCollision = false;
        boolean appleCollision = false;
        boolean headCollision = false;
        while (true) {
            snakeCollision = false;
            appleCollision = false;
            headCollision = false;
            newXPos = rand.nextInt(GlobalVariables.getGridHeight())
                    * GlobalVariables.getGridSize();
            newYPos = rand.nextInt(GlobalVariables.getGridHeight())
                    * GlobalVariables.getGridSize();
            for (int i = 0; i < snake.size(); i++) {
                if (snake.get(i).getXPos() == newXPos && snake.get(i).getYPos() == newYPos) {
                    snakeCollision = true;
                    break;
                }
            }
            for (int i = 0; i < pommes.size(); i++) {
                if (newXPos == pommes.get(i).getXPos() && newYPos == pommes.get(i).getYPos()) {
                    appleCollision = true;
                    break;
                }
            }
            if (head.getXPos() == newXPos && head.getYPos() == newYPos) {
                headCollision = true;
            }
            if (!snakeCollision && !appleCollision && !headCollision) {
                break;
            }
        }
        xPos = newXPos;
        yPos = newYPos;
    }

    public void drawApple(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(xPos, yPos, GlobalVariables.getGridSize(), GlobalVariables.getGridSize());
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public String toString() {
        return "xpos " + xPos + ". ypos " + yPos;
    }
}
