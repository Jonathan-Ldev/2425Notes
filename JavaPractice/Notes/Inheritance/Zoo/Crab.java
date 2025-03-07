public class Crab extends Animal implements Walking{
    public Crab(){
        super("Eugene","Loves money");
    }
    @Override
    public String makeNoise() {
        return "Money.. Money";
    }
    @Override
    public String walk(){
        return "Crab Rave";
    }
}