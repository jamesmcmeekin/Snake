import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.ArrayList;
import vars.GlobalVariables;

public class Apple {
    private int xPos, yPos;
    private Random rand;

    public Apple(Random rand) {
        this.rand = rand;
    }

    public void newApple(ArrayList<BodyPart> snake) {
        xPos = rand.nextInt(GlobalVariables.getScreenWidth() / GlobalVariables.getGridSize())
                * GlobalVariables.getGridSize();
        yPos = rand.nextInt(GlobalVariables.getScreenHeight() / GlobalVariables.getGridSize())
                * GlobalVariables.getGridSize();
        for(int i = 0; i < snake.size(); i++) {
            if(snake.get(i).getXPos() == xPos && snake.get(i).getYPos() == yPos) {
                newApple(snake);
            }
        }
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
}
