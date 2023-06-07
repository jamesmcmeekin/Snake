package keys;

import java.awt.event.*;

import vars.GlobalVariables;

public class CustomKeyAdapter extends KeyAdapter {
    private static long cooldown = 0;
    private static long lastDirectionChange = -1;

    public void keyPressed(KeyEvent k) {
        if (System.currentTimeMillis() - lastDirectionChange >= cooldown) {
            switch (k.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (GlobalVariables.getDirection() != 'D') {
                        GlobalVariables.setDirection('U');
                        lastDirectionChange = System.currentTimeMillis();
                        cooldown = GlobalVariables.getDelay() - (lastDirectionChange - GlobalVariables.getRoundStartTime());
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (GlobalVariables.getDirection() != 'U') {
                        GlobalVariables.setDirection('D');
                        lastDirectionChange = System.currentTimeMillis();
                        cooldown = GlobalVariables.getDelay() - (lastDirectionChange - GlobalVariables.getRoundStartTime());
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (GlobalVariables.getDirection() != 'R') {
                        GlobalVariables.setDirection('L');
                        lastDirectionChange = System.currentTimeMillis();
                        cooldown = GlobalVariables.getDelay() - (lastDirectionChange - GlobalVariables.getRoundStartTime());
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (GlobalVariables.getDirection() != 'L') {
                        GlobalVariables.setDirection('R');
                        lastDirectionChange = System.currentTimeMillis();
                        cooldown = GlobalVariables.getDelay() - (lastDirectionChange - GlobalVariables.getRoundStartTime());
                    }
                    break;
            }

        }
    }

}
