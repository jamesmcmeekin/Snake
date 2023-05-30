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

    public void newApple(ArrayList<BodyPart> snake, ArrayList<Apple> pommes) {
        int newXPos = rand.nextInt(GlobalVariables.getScreenWidth() / GlobalVariables.getGridSize())
                * GlobalVariables.getGridSize();
        int newYPos = rand.nextInt(GlobalVariables.getScreenHeight() / GlobalVariables.getGridSize())
                * GlobalVariables.getGridSize();
        for (int i = 0; i < snake.size(); i++) {
            if (snake.get(i).getXPos() == newXPos && snake.get(i).getYPos() == newYPos) {
                newApple(snake, pommes);
            }
        }
        for (int i = 0; i < pommes.size(); i++) {
            if (newXPos == pommes.get(i).getXPos() && newYPos == pommes.get(i).getYPos()) {
                System.out.println(pommes);
                newApple(snake, pommes);
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
