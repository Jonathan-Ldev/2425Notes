import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<GoodGuys>  GoodGuys = new ArrayList();
        GoodGuys.add(new Pikachu());
        GoodGuys.add(new Mario());
        GoodGuys.add(new Kirby());
        GoodGuys.add(new Link());

        // Display all good guys
        System.out.println("Available Good Characters:");
        for (GoodGuys goodGuy : GoodGuys) {
            System.out.println("- " + goodGuy.getName());
        }
        // Player chooses a character
        System.out.println("\nChoose your character:");
        System.out.println("1. Pikachu");
        System.out.println("2. Mario");
        System.out.println("3. Kirby");
        System.out.println("4. Link");
        int choice = scanner.nextInt();
        GoodGuys player;
        if (choice == 1) {
            player = new Pikachu();
        } else if (choice == 2) {
            player = new Mario();
        } else if (choice == 3){
            player = new Kirby();
        } else {
            player = new Link();
        }

        System.out.println("You chose " + player.getName() + "!");
        // Encounter an enemy
        BadGuys enemy = new MetaKnight();
        System.out.println("A wild " + enemy.getName() + " appears!");
        // Combat loop
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\nYour health: " + player.getHealth());
            System.out.println(enemy.getName() + "'s health: " + enemy.getHealth());
            System.out.println("1. Attack");
            System.out.println("2. Special Ability");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    System.out.println(player.getName() + " attacks " + enemy.getName() + " for " + player.attack + " damage.");
                    enemy.takeDamage(player.attack);
                    break;
                case 2:
                    player.specialAbility();
                    //just changed the characters so that their moves say they did 5 additional damage and added 5 damage to the take damage formula
                    enemy.takeDamage(player.attack+5);
                    break;
                default:
                    System.out.println("Invalid action.");
            }
            if (enemy.isAlive()) {
                System.out.println(enemy.getName() + " attacks " + player.getName() + " for " + enemy.attack + " damage.");
                player.takeDamage(enemy.attack);
            }
        }
        if (player.isAlive()) {
            System.out.println("You defeated " + enemy.getName() + "!");
        } else {
            System.out.println("You were defeated by " + enemy.getName() + ". Game over.");
        }
    }
}











