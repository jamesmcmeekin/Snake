import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import vars.GlobalVariables;

public class Apple {
    private int xPos, yPos;
    private Random rand;
    private Graphics g;

    public Apple(Random rand, Graphics g) {
        this.rand = rand;
        this.g = g;
        newApple();
    }

    public void newApple() {
        xPos = rand.nextInt(GlobalVariables.getScreenWidth() / GlobalVariables.getGridSize())
                * GlobalVariables.getGridSize();
        yPos = rand.nextInt(GlobalVariables.getScreenHeight() / GlobalVariables.getGridSize())
                * GlobalVariables.getGridSize();
    }

    public void drawApple() {
        g.setColor(Color.red);
        g.fillOval(xPos, GlobalVariables.getGridSize(), yPos, GlobalVariables.getGridSize());
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }
}
