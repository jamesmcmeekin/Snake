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
        appleX = rand.nextInt(GlobalVariables.getScreenWidth() / GlobalVariables.getGridSize()) * GlobalVariables.getGridSize();
        appleY = rand.nextInt(GlobalVariables.getScreenHeight() / GlobalVariables.getGridSize()) * GlobalVariables.getGridSize();
    }
    public void drawApple() {
        g.setColor(Color.red);
        g.fillOval(appleX, GlobalVariables.getGridSize(), appleY, GlobalVariables.getGridSize());
    }
}
