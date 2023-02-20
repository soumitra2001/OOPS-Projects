
public class Game {
    Board board;
    Player[] players;
    int turn;
    boolean[] isAllowed;
    Coordinates[] positions;
    String[] preCellName;

    Game(Board board, Player[] players) {
        this.board = board;
        this.players = players;
        this.turn = 0;
        this.isAllowed = new boolean[players.length];
        this.preCellName=new String[players.length];
        for(int i=0;i<players.length;i++)this.preCellName[i]="1";
        this.positions = new Coordinates[players.length];
        for (int i = 0; i < positions.length; i++)
            this.positions[i] = new Coordinates(board.size - 1, 0);
    }

    public void play() {
        while (true) {
            int num = Dice.rollDice();
            if (!isAllowed[turn] && (num == 1 || num == 6)) {
                isAllowed[turn] = true;
                turn = (turn + 1) % players.length;
                continue;
            }
            Coordinates newCord = getNewPositon(num);
            if (newCord.rn < 0) {
                board.board[0][0]=players[turn].symbol;
                System.out.println(board);
                System.out.println(players[turn].name + " has won the match (*_*)");
                return;
            }
            board.board[positions[turn].rn][positions[turn].cn]=preCellName[turn];
            preCellName[turn]=board.board[newCord.rn][newCord.cn];
            board.board[newCord.rn][newCord.cn] = players[turn].symbol;
            positions[turn] = newCord;
            turn = (turn + 1) % players.length;
            System.out.println(board);
        }
    }

    public Coordinates getNewPositon(int num) {
        int rn = positions[turn].rn, cn = positions[turn].cn;
        while (num-- > 0) {
            if (rn % 2 == 0) {
                if (cn == 0)
                    rn--;
                else
                    cn--;
            } else {
                if (cn == board.board.length - 1)
                    rn--;
                else
                    cn++;
            }
        }

        if (rn < 0)
            return new Coordinates(rn, cn);
        if (board.jumpers.containsKey(board.board[rn][cn])) {
            if (board.jumpers.get(board.board[rn][cn]).start.rn > board.jumpers.get(board.board[rn][cn]).end.rn) {
                System.out.println(players[turn].name + " Got a Ladder");
            } else {
                System.out.println(players[turn].name + " was bitten by Snake");
            }
            return board.jumpers.get(board.board[rn][cn]).end;
        }

        return new Coordinates(rn, cn);
    }
}
