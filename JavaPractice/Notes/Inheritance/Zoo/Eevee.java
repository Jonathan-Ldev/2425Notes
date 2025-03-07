public class Eevee extends Animal implements Walking{
    public Eevee(){
        super("Potato","fluffy creature of questionable race and future");
    }
    @Override
    public String makeNoise() {
        return "vee";
    }
    @Override
    public String walk(){
        return "Eevee walks around cautious of all water";
    }
}