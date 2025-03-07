public class MetaKnight extends BadGuys {
    public MetaKnight() {
        super("Meta Knight", 70, 14, 7);
    }
    @Override
    public void specialAbility() {
        System.out.println(name + " uses Mach Tornado, dealing 14 damage to the opponent!");
    }
}