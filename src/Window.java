import javax.swing.JFrame;

public class Window extends JFrame {
    public Window() {
        this.add(new SnakeGame());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
