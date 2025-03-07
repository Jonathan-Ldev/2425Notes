public class Goose extends Bird implements Walking{
    public Goose() {
        super("GoGo", "Bird that runs behind you");
    }
    @Override
    public String poop (){
        return "Artillery From Above!!!";
    }

    @Override
    public String makeNoise() {
        return "Honk";
    }
    @Override
    public String walk(){
        return "The Goose runs at you with malicious intent";
    }
}