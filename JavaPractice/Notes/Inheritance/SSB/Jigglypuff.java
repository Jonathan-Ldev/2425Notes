public class Jigglypuff extends BadGuys {
    public Jigglypuff() {
        super("Jigglypuff", 60, 10, 4);
    }
    @Override
    public void specialAbility() {
        System.out.println(name + " uses Sing, putting the opponent to sleep for a turn!");
    }
}