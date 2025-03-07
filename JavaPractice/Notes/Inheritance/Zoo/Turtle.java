public class Turtle extends Animal implements Walking{

    public Turtle(){
        super("Oogway","Master of Kung Fu, Faster than a Rabbit, and not mutated");
    }
    @Override
    public String makeNoise() {
        return "\"Yesterday is history, Tomorrow is a mystery, but Today is a gift\" -Master Oogway";
    }
    @Override
    public String walk(){
        return "Oogway walks with great wisdom";
    }
    
}