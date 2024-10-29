import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);


        Dog myDog = new Dog("Biscuit", "Poodle", "M", 3);
        System.out.println(myDog);
        System.out.println(myDog.eat());
        System.out.println(myDog.poop());
        System.out.println(myDog.sleep());

        System.out.println("\n");

        Dragon kopter = new Dragon("Kopter", "Epic", "M", 2100);
        System.out.println(kopter);
        System.out.println(kopter.eat());
        System.out.println(kopter.poop());
        System.out.println(kopter.sleep());

        System.out.println("\n");

        Cat Toast = new Cat("Toast", "Calico", "F", 4);
        System.out.println(Toast);
        System.out.println(Toast.eat());
        System.out.println(Toast.poop());
        System.out.println(Toast.sleep());
    }
}
