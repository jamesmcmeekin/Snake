import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import vars.GlobalVariables;
public class Apple {
    private int appleX, appleY;
    private Random rand;
    private Graphics g;
    public Apple(Random rand, Graphics g) {
        this.rand = rand;
        this.g = g;
        newApple();
    }
    public void newApple() {
        appleX = rand.nextInt(GlobalVariables.getScreenWidth());
        appleY = rand.nextInt(GlobalVariables.getScreenHeight());
    }
    public void drawApple() {
        g.fillOval(appleX, GlobalVariables.getGridSize(), appleY, GlobalVariables.getGridSize());
    }
}
