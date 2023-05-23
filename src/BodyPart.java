import vars.GlobalVariables;

public class BodyPart {
    private int xPos, yPos;

    public BodyPart() {

    }

    public BodyPart(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
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
