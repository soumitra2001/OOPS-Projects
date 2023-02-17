import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board plyGround = new Board(3);
        System.out.print("Enter 1st player name: ");
        Player p1 = new Player(sc.next());
        System.out.print("Enter 2st player name: ");
        Player p2 = new Player(sc.next());

        Game ttt = new Game(plyGround, new Player[] { p1, p2 });
        ttt.play();
    }
}
