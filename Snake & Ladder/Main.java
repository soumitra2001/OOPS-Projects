import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Dice.noOfDice=1;
        HashMap<String,Jumper> hm=new HashMap<>();
        hm.put("6",new Jumper(new Coordinates(9, 5), new Coordinates(6, 6)));
        hm.put("97", new Jumper(new Coordinates(0, 1), new Coordinates(9, 9)));
        hm.put("21", new Jumper(new Coordinates(7, 0), new Coordinates(0, 9)));
        hm.put("64", new Jumper(new Coordinates(3, 3), new Coordinates(7, 4)));
        Board board=new Board(10,hm);
        Player[] players=new Player[]{new Player("Supriya", "$"),new Player("Som", "@")};

        Game game = new Game(board, players);
        game.play();

    }
}
