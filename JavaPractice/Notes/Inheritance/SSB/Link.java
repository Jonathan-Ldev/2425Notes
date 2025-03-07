public class Link extends GoodGuys{
    public Link(){
        super("Link", 120, 10, 10);
    }
    @Override
    public void specialAbility(){
        System.out.println(name+" Fires a Bomb Arrow, dealing 15 damage");
    }
}
