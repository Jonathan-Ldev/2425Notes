import java.util.Scanner;

public class Battle {
    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);

        //Build Pokemon
        Pokemon myPokeMan = new Pokemon("5600","Fire",4500,"The Sun","432,450","1.989*10^30","SolarBeam",1200,"Flamethrower",900,"Sun");
        Pokemon Charizard = new Pokemon("9", "Fire", 120, "Charizard","6,2","170","Flamethrower",90,"Wing Attack",60,"aaa");

        //Welcome to the battle
        System.out.println("A wild battle appears!");

        //Your pokemon: <poke name> HP: <poke hp>
        System.out.println("Your Pokemon: "+myPokeMan.getName()+"\n\tHP: "+myPokeMan.getHP());
        System.out.println("Opponent's Pokemon: "+Charizard.getName()+"\n\tHP: "+Charizard.getHP());

        //Battle Loop
        while(Charizard.getHP()>0 || myPokeMan.getHP()>0){
            //Introduce the attack options
            System.out.println("Choose an attack for "+myPokeMan.getName());
            System.out.println("1. "+myPokeMan.getAttack1Name()+"\tDamage: "+myPokeMan.getAttack1dmg());
            System.out.println("2. "+myPokeMan.getAttack2Name()+"\tDamage: "+myPokeMan.getAttack2dmg());
            int choice = ui.nextInt();

            //Attach Switch Statement - this is a condition loop aka glorified if statement loop
            int damage = 0;
            switch(choice){
                case 1:
                    damage = myPokeMan.getAttack1dmg();
                    System.out.println(myPokeMan.getName()+" used: "+myPokeMan.getAttack1Name());
                    break;
                case 2:
                    damage = myPokeMan.getAttack2dmg();
                    System.out.println(myPokeMan.getName()+" used: "+myPokeMan.getAttack2Name());
                    break;
                default:
                    System.out.println("You lose a turn");
                    continue;
            }
            //Apply damage
            Charizard.setHP(Charizard.getHP() - damage);
            System.out.println("Opponent's Pokemon: "+Charizard.getName()+"\n\tHP: "+Charizard.getHP());

            //Check if pokemon has not fainted
            if(Charizard.getHP()<=0){
                System.out.println(Charizard.getName()+" fainted!");
                break;
            }
        }


        ui.close();
    }
}
