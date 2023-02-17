import java.util.*;

class Player {
    String name;
    char symbol;
    static int noOfPlayer = 0;

    public Player(String name) {
        if (noOfPlayer < 2) {
            this.name = name;
            this.symbol = noOfPlayer == 0 ? 'X' : 'O';
            noOfPlayer++;
        } else
            System.out.println("Players are already filled🙂");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player's name: ").append(this.name).append("\n").append("Player's Symbol: ").append(this.symbol);

        return sb.toString();
    }
}
