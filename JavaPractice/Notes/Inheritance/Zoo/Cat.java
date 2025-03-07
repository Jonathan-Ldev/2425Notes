public class Cat extends Animal implements Walking{
    public Cat(){
        super("Kitty","Meow");
    }

    @Override
    public String makeNoise(){
        return "Meow";
    }
    @Override
    public String walk(){
        return "The cat falls from 5 ft above and just keeps walking like nothing happened";
    }
}