public class Swan extends Bird{
    public Swan(){
        super("Swan","Long Neck, swims and has a beak");
    }
    @Override
    public String poop(){
        return "White Rain";
    }

    @Override
    public String makeNoise() {
        return "Ca Caw";
    }
}