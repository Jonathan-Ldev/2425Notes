public class Bowser extends BadGuys {
    public Bowser() {
        super("Bowser", 120, 18, 10);
    }
    @Override
    public void specialAbility() {
        System.out.println(name + " breathes fire, dealing 18 damage to all opponents!");
    }
}