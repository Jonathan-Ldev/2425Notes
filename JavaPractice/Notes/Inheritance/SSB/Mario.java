public class Mario extends GoodGuys {
    public Mario(){
        super("Mario", 100, 13, 8);
    }
    @Override
    public void specialAbility(){
        System.out.println(name+" Launches a Fireball, dealing 18 damage");
    }
}
