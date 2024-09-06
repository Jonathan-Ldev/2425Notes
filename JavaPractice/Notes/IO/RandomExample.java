import java.util.Random;
public class RandomExample {
    public static void main(String[] args) {

        ////////////////    METHOD 1    ////////////////////
        
        //Math.random() -> generate a decimal btwn 0 - .9999999999999999
        double randomness = Math.random();
        System.out.println(randomness);

        //Grab a random number btwn 0-10
        //           (int) will cast the number to the right as a integer value
        int number = (int)(randomness*10);
        System.out.println(number);

        //0-100 is that value there
        number = (int)(randomness*100);
        System.out.println(number);
        //50-100 is that value there
        number = 50+(int)(randomness*(100-50));
        System.out.println(number);

        ////////////////    METHOD 2    ////////////////////
        //import java.util.Random;
        //randy is an obj of Random
        Random randy = new Random();

        //Random # btwn 0-10
        int randomInt = randy.nextInt(0,10);
        double randomDouble = randy.nextDouble(0,10);

        System.out.println(randomInt);
        System.out.println(randomDouble);
    }
}
