package vars;

public class GlobalVariables {
    private static final int SCREEN_WIDTH = 1000;
    private static final int SCREEN_HEIGHT = 1000;
    private static final int GRID_SIZE = 50;
    private static final int GRID_HEIGHT = GlobalVariables.getScreenHeight() / GRID_SIZE;
    private static final int GRID_WIDTH = GlobalVariables.getScreenWidth() / GRID_SIZE;
    private static final int DELAY = 150;
    private static char direction;

    public static int getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public static int getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    public static char getDirection() {
        return direction;
    }

    public static void setDirection(char c) {
        direction = c;
    }

    public static int getGridSize() {
        return GRID_SIZE;
    }

    public static int getGridHeight() {
        return GRID_HEIGHT;
    }

    public static int getGridWidth() {
        return GRID_WIDTH;
    }
    public static int getDelay() {
        return DELAY;
    }
}
