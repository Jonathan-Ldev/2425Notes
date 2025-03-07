public class Cod extends Animal {
    public Cod(){
        super("Cod","A fish that is not a cat");
    }

    @Override
    public String makeNoise() {
        return "blub blub";
    }
    
}
