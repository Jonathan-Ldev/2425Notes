public class Kirby extends GoodGuys {
    public Kirby(){
        super("Kirby", 90, 10, 3);
    }
    @Override
    public void specialAbility(){
        System.out.println(name+" Bonks you with a hammer, dealing 15 damage");
    }
}
