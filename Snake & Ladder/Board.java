import java.util.*;

class Board{
    int size;
    String[][] board;
    HashMap<String, Jumper> jumpers;
    

    Board(int size,HashMap<String, Jumper> jumpers){
        this.size=size;
        this.jumpers=jumpers;
        this.board=new String[this.size][this.size];
        int k=1;
        for(int i=this.size-1;i>=0;i--){
            if(i%2==0){
                for(int j=this.size-1;j>=0;j--)board[i][j]=k++ + "";
            }else{
                for(int j=0;j<this.size;j++)board[i][j]=k++ + "";
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<this.size;i++){
            for(int j=0;j<this.size;j++)sb.append(board[i][j]).append("\t");
            sb.append("\n\n");
        }

        return sb.toString();
    }
}
