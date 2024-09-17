import java.util.Scanner;
public class FunFunctions {
    public static void main(String[] args) {
        //Abstraction - say jump() and a lot of things happen


        int a = 2;
        int b = 2;
        add(2,2);

        Scanner ui = new Scanner(System.in);
        String email = ui.nextLine();
        String username = validEmail(email);
        ui.close();

        //check if user typed in a correct formatted email - only need @symbol
        
             
    }

    private static String validEmail(String e){
        Scanner ui = new Scanner(System.in);
        while(!e.contains("@")){
            e = ui.nextLine();
        }
        ui.close();
        System.out.println("Hello! "+e.substring(0, e.indexOf("@")));
        return e.substring(0, e.indexOf("@"));
        
    }

    private static void add(int a,int b){
        System.out.println(a+b);
    }
    /*
     * private vs public
     *  - private -> can only be accessed in the scope that it is defined in,
     *     For example, add can only be used in the FunFunctions class
     *  - public -> can be accessed by other classes in the program
     *      for example, public static void main(String[] args) is public for every 
     *      class to access to run the start situation
     * 
     * static vs non-static
     *  - static -> function or method that can be ran without an object
     *  - non-static -> required an object to do
     * 
     * void vs Data Type
     *  - void functions means that the function is not returning information back
     *      into the line of code the function was called in
     *          email.substring(0,email.indexOf("@"))
     *              indexOf returns the position of @
     *          email.substring(0,8);
     *  - Data Type -> what is the type of data you are returning 
     */

     /*
      * Rule of Thumbs for f(x)
            Who needs access to the method? public or private
            Do I need an object to use this method? static or non-static
            Will I have different data types

            methods and functions are verbs
                names of functions shouldn't be nouns
      */

    public static String convertMoney(int m){
        return "$"+m+".00";
    }
    public static String convertMoney(double m){
        return "$"+m;
    }
    /*
     * synchronous programming - Python or Bash -> start line 1 and go to the end
     * asynchronous programming - Java -> compile everything and run things whenever
     */



}
