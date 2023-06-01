public class Head extends BodyPart {
    public Head(int xPos, int yPos) {
        super(xPos, yPos);
    }

    public void moveUp() {
        setYPos(getYPos() - vars.GlobalVariables.getGridSize());
    }

    public void moveDown() {
        setYPos(getYPos() + vars.GlobalVariables.getGridSize());
    }

    public void moveLeft() {
        setXPos(getXPos() - vars.GlobalVariables.getGridSize());
    }

    public void moveRight() {
        setXPos(getXPos() + vars.GlobalVariables.getGridSize());

    }
}
