import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        int player = 0;
        int cycle = 0;
        int uScore = 0;
        int cScore = 0;
        int draw = 0;
        System.out.println("Welcome to Zombie-Human-Snake");
        
        boolean keepGoing = true;
        while(keepGoing == true){
            cycle +=1;
            //Don't know why but checking for letters doesn't seme to be working so I have to use numbers
            System.out.print("User, enter your choice (1=Z, 2=H, 3=S): ");
            player = ui.nextInt();
            System.out.println(player);
            // code for checking what choice the player chose
            if(player == 1){
                System.out.println("You chose Zombie");
            }
            else if(player == 2){
                System.out.println("You chose Human");
            }
            else if(player == 3){
                System.out.println("You chose Snake");
            }

            //cycle determines what the computer chose
            if(cycle == 1){
                System.out.println("Computer chose Zombie");
            }
            else if(cycle == 2){
                System.out.println("Computer chose Human");
            }
            else if(cycle == 3){
                System.out.println("Computer chose Snake");
            }

            //Checking who won
            if (player == cycle){
                System.out.println("It was a draw");
                draw +=1;
            }
            else if(player == 1 && cycle == 2){
                System.out.println("Computer Won!");
                cScore +=1;
            }
            else if(player == 1 && cycle == 3){
                System.out.println("You Won!");
                uScore+=1;
            }
            else if(player == 2 && cycle == 1){
                System.out.println("You Won!");
                uScore+=1;
            }
            else if(player == 2 && cycle == 3){
                System.out.println("Computer Won!");
                cScore+=1;
            }
            else if(player == 3 && cycle == 1){
                System.out.println("Computer Won!");
                cScore+=1;
            }
            else if(player == 3 && cycle == 2){
                System.out.println("You Won!");
                uScore+=1;
            }

            //Printing out the Scoreboard
            System.out.println("Scoreboard:");
            System.out.println("---------------------------------------------");
            System.out.println("User: "+uScore);
            System.out.println("Computer: "+cScore);
            System.out.println("Ties: "+draw);

            //Asking to play again
            System.out.println("Do you wish to play again? (1=Y, 2=N)");
            if(ui.nextInt() == 1){
                keepGoing = true;
                if(cycle == 3){
                    cycle = 0;
                }
            }
            else{
                keepGoing = false;
            }
            

        }
        
    }
}
