import java.util.*;
import vars.GlobalVariables;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String difficulty = "";
        System.out.print("wsg bro do u want ez med or radiant diffucutly? ");
        difficulty = s.next();
        if (difficulty.charAt(0) == 'e' || difficulty.charAt(0) == 'E') {
            GlobalVariables.setDelay(150);
            System.out.println("booooooooo");
        } else if (difficulty.charAt(0) == 'm' || difficulty.charAt(0) == 'M') {
            GlobalVariables.setDelay(75);
        } else if(difficulty.charAt(0) == 'r' || difficulty.charAt(0) == 'R') {
            GlobalVariables.setDelay(1);
        } else {
            System.out.println("since you cant read instructions, i will set the difficulty to ez for you.");
            GlobalVariables.setDelay(150);;
        }
        System.out.print("numba of apples? ");
        GlobalVariables.setApples(s.nextInt());
        Window window = new Window();

    }
}