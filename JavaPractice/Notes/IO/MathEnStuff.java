import java.util.Scanner;

public class MathEnStuff {
    public static void main(String[] args){
        //Build a program that takes in users hourly rate
        //       then outputs the yearly salary
        //       a user can assume they work 2000 hours a year
        
        Scanner ui = new Scanner(System.in);
        System.out.println("What is your hourly rate?");
        double rate = ui.nextDouble();
        System.out.printf("yearly pay: $%2.2f%n", rate*2000);
        
        ui.close();

        /*
         * Primitive and Non-Primitive Data Type
         *      Primitive - Characters, Booleans, Integer, Double
         *      Non-Primitve - Strings, Arrays, ArrayList, List, Objects in general
         */

         double money = 3.99;
         Double momoney = 3.99;     //DO NOT USE THIS METHOD TO CREATE A double OBJ

         int x = 4;
         Integer y = 5; //DO NOT USE THIS METHOD TO CREATE AN int OBJ

        //Math Shortcuts
        //python increase by 1 -> x+=1
        x++;    //this adds 1
        x--;    //this subs 1
        x+=2;   //this adds 2
        x-=2;   //this subs 2
        x/=2;   //this divs 2
        x*=2;   //this mult 2

        //python exponents you could **
        //^ represents bitwise calculation
        Math.pow(2,2);
        x=x*x;

        int x1,x2,y1,y2;
        x1=0;
        x2=4;
        y1=0;
        y2=4;
        //distance formula - go

        double ex = (x2-x1);
        double why = (y2-y1);
        ex = ex*ex;
        why = why*why;
        double num = ex+why;
        double answer = Math.sqrt(num);
        System.out.println(answer);

    }
}
