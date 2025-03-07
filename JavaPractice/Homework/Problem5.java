import java.text.DecimalFormat;
import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        double side = 0;
        double half = 0;
        double height = 0;
        double radius = 0;
        double area = 0;
        String end = "";
        // formatting found at https://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java
        DecimalFormat df = new DecimalFormat("#.#####");

        System.out.print("Enter the length of the side: ");
        side = ui.nextDouble();
        // check if greater than 0
        if(side <= 0){
            System.out.println("The Side length should be greater than 0");
        }
        // code for calculations
        else{
            half = side/2;
            height = ((Math.pow(side, 2))-(Math.pow(half, 2)));
            height = Math.sqrt(height);
            radius = height/3;
            area = (Math.pow(radius, 2)*(3.1416));
            end = df.format(area);
            System.out.println("The area of the circle is: "+end);
        }
        

    }
}