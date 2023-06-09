package vars;

import java.lang.System;

public class GlobalVariables {
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 800;
    private static final int GRID_SIZE = 50;
    private static final int GRID_HEIGHT = GlobalVariables.getScreenHeight() / GRID_SIZE;
    private static final int GRID_WIDTH = GlobalVariables.getScreenWidth() / GRID_SIZE;
    private static int delay = 150;
    private static char direction = 'L';
    private static int apples = 1;
    private static long RoundStartTime = System.currentTimeMillis();

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
        return delay;
    }

    public static void setDelay(int d) {
        delay = d;
    }

    public static int getApples() {
        return apples;
    }

    public static void setApples(int a) {
        apples = a;
    }

    public static long getRoundStartTime() {
        return RoundStartTime;
    }

    public static void setRoundStartTime(long r) {
        RoundStartTime = r;
    }
}
