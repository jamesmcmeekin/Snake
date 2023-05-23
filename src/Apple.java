import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import vars.GlobalVariables;

public class Apple {
    private int xPos, yPos;
    private Random rand;

    public Apple(Random rand) {
        this.rand = rand;
        newApple();
    }

    public void newApple() {
        xPos = rand.nextInt(GlobalVariables.getScreenWidth() / GlobalVariables.getGridSize())
                * GlobalVariables.getGridSize();
        yPos = rand.nextInt(GlobalVariables.getScreenHeight() / GlobalVariables.getGridSize())
                * GlobalVariables.getGridSize();
        System.out.println("xPos " + xPos + "yPos " + yPos);
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
