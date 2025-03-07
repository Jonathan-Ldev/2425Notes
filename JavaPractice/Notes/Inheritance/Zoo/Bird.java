public abstract class Bird extends Animal{
    //a subclass of Animal - so animals that extends Bird are no longer Animals
    public Bird(){
        super("Bird Thing", "Drone");
    }

public Bird(String name, String description){
    super(name,description);
}

    public abstract String poop();

    @Override
    public String makeNoise(){
        return "tweet tweet";
    }
}
