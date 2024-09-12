import java.util.Scanner;

public class ManyBottles {
    public static void main(String[] args) {
        int i = 0;
        Scanner ui = new Scanner(System.in);
        System.out.println("What is your favorite Soda: ");
        String soda = ui.nextLine();
        for(i=99;i!=0;i--){
            System.out.println(+i+ " bottles of " +soda+ " on the wall \n" +i+ " bottles of " +soda+ "\nTake one down pass it around\n" +(i-1)+ " bottles of " +soda+ " on the wall...");
            String na = ui.nextLine();
            // Clearing Screen Code https://www.javatpoint.com/how-to-clear-screen-in-java
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
        }

    }
}
