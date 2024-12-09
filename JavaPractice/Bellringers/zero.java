import java.util.Scanner;

public class zero {
    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);

        int one = 0;
        int two = 0;
        int confirm = 0;
        String keep = "yes";

        System.out.println("Input the first number");
        one = ui.nextInt();
        System.out.println("Input the second number");
        two = ui.nextInt();



        while(keep == "yes"){
            if (two == 0){
                System.out.println("Can't divide by 0 input second number again");
                two = ui.nextInt();
                if (two == 0){
                    System.out.println("Can't divide by 0 input second number again");
                    two = ui.nextInt();
                    if (two == 0){
                        System.out.println("This will crash the program, try again");
                        two = ui.nextInt();
                        if (two == 0){
                            System.out.println("Erm this will still crash the program, are you really sure (1 for yes/2 for no)");
                            confirm = ui.nextInt();
                            if (confirm == 1){
                                System.out.println(one/two);
                            }
                            else {
                                System.out.println("Ok... give me a number that isn't 0 bub");
                                two = ui.nextInt();
                                if (two == 0){
                                    System.out.print("\033[H\033[2J");  
                                    System.out.flush();  
                                    System.out.println("Ok wise guy");

                                }
                            }
                        }
                    }
                }
            }
            else{
                System.out.println("Your numbers equal: "+one/two);
                keep = "no";
            }
        }
    }
}
