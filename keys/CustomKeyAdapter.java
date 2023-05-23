package keys;

import java.awt.event.*;

import vars.GlobalVariables;

public class CustomKeyAdapter extends KeyAdapter {
    public void keyPressed(KeyEvent k) {
        switch (k.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (GlobalVariables.getDirection() != 'D') {
                    GlobalVariables.setDirection('U');
                }
                break;
            case KeyEvent.VK_DOWN:
                if (GlobalVariables.getDirection() != 'U') {
                    GlobalVariables.setDirection('D');
                }
                break;
            case KeyEvent.VK_LEFT:
                if (GlobalVariables.getDirection() != 'R') {
                    GlobalVariables.setDirection('L');
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (GlobalVariables.getDirection() != 'L') {
                    GlobalVariables.setDirection('R');
                }
                break;
        }

    }
}
