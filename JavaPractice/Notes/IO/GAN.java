import java.util.Scanner;

public class GAN {
    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        System.out.println("Number between 1-10:");
        double num = ui.nextDouble();
        if (num < 7){
            System.out.println("Too Low");
        } 
        else if (num > 7){
            System.out.println("Too High");
        }
        else if (num == 7){
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
