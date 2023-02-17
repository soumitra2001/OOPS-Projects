import java.util.*;

class Board {
    int size;
    char[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new char[this.size][this.size];
        char ch = '1';
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++)
                board[i][j] = ch++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++)
                sb.append(board[i][j]).append("\t");
            sb.append("\n");
        }
        return sb.toString();
    }

}
