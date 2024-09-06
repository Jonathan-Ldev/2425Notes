import java.util.Scanner;
import java.util.Random;

public class GAN2 {
    public static void main(String[] args) {
        Random randy = new Random();
        int secret = randy.nextInt(0,11);
        System.out.println(secret);
        
        Scanner ui = new Scanner(System.in);
        System.out.println("Number between 1-10:");
        int num = ui.nextInt();
        if (num < secret){
            System.out.println("Too Low");
        } 
        else if (num > secret){
            System.out.println("Too High");
        }
        else{
            System.out.println("Correct!");
        }
        
        
        
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
