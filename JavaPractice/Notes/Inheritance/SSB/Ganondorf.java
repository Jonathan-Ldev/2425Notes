public class Ganondorf extends BadGuys {
    public Ganondorf() {
        super("Ganondorf", 100, 10, 10);
    }
    @Override
    public void specialAbility() {
        System.out.println(name + " Turns into Ganon and deals 10 damage");
    }
}
