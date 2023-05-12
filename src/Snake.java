import vars.GlobalVariables;

public class Snake {
    private int xPos, yPos;
    public Snake(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    public int getRow() {
        return xPos;
    }
    public int getCol() {
        return yPos;
    }
    public void draw() {

    }
    public void moveUp() {
        yPos -= GlobalVariables.getGridSize();
    }
    public void moveDown() {
        yPos += GlobalVariables.getGridSize();
    }
    public void moveLeft() {
        xPos -= GlobalVariables.getGridSize();
    }
    public void moveRight() {
        xPos += GlobalVariables.getGridSize();

    }
}
