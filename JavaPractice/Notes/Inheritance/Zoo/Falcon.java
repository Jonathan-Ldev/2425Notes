public class Falcon extends Bird implements Flying{
    public Falcon(){
        super();
    }
    @Override
    public String poop(){
        return "Make it rain";
    }
    @Override
    public String fly(){
        return "Falps their Wings";
    }
}
