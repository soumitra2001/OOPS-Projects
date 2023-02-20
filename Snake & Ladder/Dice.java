public class Dice {
    static int noOfDice;

    // Dice(int noOfDice){
    //     this.noOfDice=noOfDice;
    // }

    public static int rollDice(){
        int max=6,min=1,num=0;
        for(int i=0;i<noOfDice;i++){
            num+=(int)(Math.random()*(max-min)+1);
        }

        return num;
    }
}
