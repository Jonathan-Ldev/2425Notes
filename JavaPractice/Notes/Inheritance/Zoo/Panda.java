public class Panda extends Animal implements Walking{

    public Panda(){
        super("Po","Fluffy Furious Hungry Kung Fu Fighting Master!");
    }
    
    @Override
    public String makeNoise(){
        return "Kung Fu Fighting!";
    }
    @Override
    public String walk(){
        return "Panda does kung fu jumps all around you";
    }

}
