//Pikachu is a GoodGuys as in Pikachu's parent class is GoodGuys
public class Pikachu extends GoodGuys{
    public Pikachu(){
        super("Pikachu", 80, 15, 5);
    }
    @Override
    public void specialAbility(){
        System.out.println(name+" Unleashes a super-powered Thunderbolt, dealing 20 damage");
    }
}
