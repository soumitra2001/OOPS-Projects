public class Jumper {
    String name;
    Coordinates start;
    Coordinates end;

    Jumper(Coordinates start,Coordinates end){
        this.start=start;
        this.end=end;
        this.name=start.rn > end.rn ? "Snake" : "Ladder";
    }

}
