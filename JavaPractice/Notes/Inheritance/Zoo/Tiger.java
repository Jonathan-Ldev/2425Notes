public class Tiger extends Animal implements Walking{
    public Tiger(){
        super("Fluff","Big fluffy violent cat");
    }
    @Override
    public String makeNoise() {
         return "ROAR!!";
    }
    @Override
    public String walk(){
        return "Stay out of its way";
    }
}