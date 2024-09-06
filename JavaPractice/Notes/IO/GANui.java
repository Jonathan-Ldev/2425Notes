import java.util.Scanner;
import java.util.Random;

public class GANui {
    public static void main(String[] args) {
        //Model Section - "global" variables and object creation
        Random randy = new Random();
        int secret = randy.nextInt(0,11);
        
        
        //Controller - this is where user input
        Scanner ui = new Scanner(System.in);
        System.out.println("Number between 1-10:");
        
        String guess = ui.nextLine();

        //It would be nice to clean our user input
        //See if it is an int
        //did they type in letters?
        //entering nothing 
        if (guess.contains(".")){
            System.out.println("Only whole numbers please");
        }
        else if(guess.matches("[^0-9]+")){
            System.out.println("Input a whole number please");
        }
        else if(guess.isBlank()){
            System.out.println("Input a whole number between 1-10 please");
        }
        else{
        
        //Calculations
            int cleanGuess = Integer.parseInt(guess);    //converts / parses a string back to an integer
            if (cleanGuess < secret){
                System.out.println("Too Low");
            } 
            else if (cleanGuess > secret){
                System.out.println("Too High");
            }
            else{
                System.out.println("Correct!");
            }
        }
        ui.close();
        
        
        
        /*
         * Ask the user for a number between 0-10
         *   If the value is higher than 7, say so
         *   If the value is lower than 7, say so
         *   If the value is equal to 7, say Hooray you got it!
         *  
         *   Once you complete this version,
         *        generate a random number instead of 7
         */
   } 
}
