public class Pikachu extends Animal implements Walking{
    public Pikachu(){
        super("Pika", "Electric Mouse?");
    }

    @Override
    public String makeNoise(){
        return "Pika Pika!";
    }
    @Override
    public String walk(){
        return "Pikachu walks around with an electric zip in their step";
    }
}
