import java.util.*;

class Game {
    Board board;
    Player[] player;
    int turn;
    int noOfMove;
    String zeroPattern;
    String crossPattern;
    static Scanner sc = new Scanner(System.in);

    public Game(Board board, Player[] player) {
        this.board = board;
        this.player = player;
        this.turn = 0;
        this.noOfMove = 0;
        this.zeroPattern = "";
        this.crossPattern = "";
        for (int i = 0; i < board.size; i++) {
            zeroPattern += "O";
            crossPattern += "X";
        }
    }

    public void play() {
        System.out.println(board);
        while (noOfMove < board.size * board.size) {
            noOfMove++;
            int[] idxs = getIndex();
            int rn = idxs[0], cn = idxs[1];
            board.board[rn][cn] = player[turn].symbol;
            if (noOfMove >= 2 * board.size - 1 && checkIfTheGameIsEnded()) {
                System.out.println(board);
                System.out.println(player[turn].name + " has win🥳!!");
                return;
            }
            turn = (turn + 1) % 2;
            System.out.println(board);
        }
        System.out.println("Both players will need to play again");
    }

    public int[] getIndex() {
        while (true) {
            System.out.print(player[turn].name + "'s turn, give index: ");
            int idx = sc.nextInt() - 1;
            int rn = idx / board.size, cn = idx % board.size;
            if ((rn < 0 || cn < 0) || (rn >= board.size || cn >= board.size)) {
                System.out.println("Index out of bound");
                continue;
            }
            if (board.board[rn][cn] != (char) (idx + 1 + '0')) {
                System.out.println("Position already filled, try again");
                continue;
            }
            return new int[] { rn, cn };
        }
    }

    public boolean checkIfTheGameIsEnded() {
        // rows
        StringBuilder sb;
        for (int i = 0; i < board.size; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < board.size; j++)
                sb.append(board.board[i][j]);
            if (getResult(sb))
                return true;
        }
        // columns
        for (int i = 0; i < board.size; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < board.size; j++)
                sb.append(board.board[j][i]);
            if (getResult(sb))
                return true;
        }
        // Major Diago
        int i = 0, j = 0;
        sb = new StringBuilder();
        while (i < board.size) {
            sb.append(board.board[i++][j++]);
        }
        if (getResult(sb))
            return true;
        // Minor Diago
        i = 0;
        j = board.size - 1;
        sb = new StringBuilder();
        while (i < board.size) {
            sb.append(board.board[i++][j--]);
        }
        if (getResult(sb))
            return true;

        return false;
    }

    public boolean getResult(StringBuilder sb) {
        if (sb.toString().equals(zeroPattern) || sb.toString().equals(crossPattern))
            return true;
        return false;
    }
}
