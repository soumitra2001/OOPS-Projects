
public class Player {
    String name;
    String symbol;

    Player(String name,String symbol){
        this.name=name;
        this.symbol=symbol;
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Name: ").append(this.name).append("Symbol: ").append(this.symbol);
        return sb.toString();
    }

}
