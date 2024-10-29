import java.util.ArrayList;
import java.util.Scanner;
public class VetManager {
    // ArrayLists to hold different types of animals
    private static ArrayList<Dog> dogs = new ArrayList<>();
    private static ArrayList<Cat> cats = new ArrayList<>();
    private static ArrayList<Dragon> dragons = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            switch (choice) {
                case 1:
                    addAnimal(scanner);
                    break;
                case 2:
                    viewAnimals();
                    break;
                case 3:
                    modifyAnimal(scanner);
                    break;
                case 4:
                    removeAnimal(scanner);
                    break;
                case 5:
                    //saveAndClose();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
    private static void printMenu() {
        System.out.println("\n--- Vet Management System ---");
        System.out.println("1. Add Animal");
        System.out.println("2. View Animals");
        System.out.println("3. Modify Animal");
        System.out.println("4. Remove Animal");
        System.out.println("5. Save and Close");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addAnimal(Scanner scanner){
        //ask for species
        System.out.println("Choose a species: \n\t1. Dog\t2. Cat\t3. Dragon");
        int type = scanner.nextInt();

        //ask for name, breed, gender, age
        System.out.println("Enter the name. breed, gender, age seperated by a new line");
        String n = scanner.next();
        String b = scanner.next();
        String g = scanner.next();
        int a = scanner.nextInt();

        //create the animal
        switch(type){
            case 1:
                dogs.add(new Dog(n,b,g,a));
                break;
            case 2:
                cats.add(new Cat(n,b,g,a));
                break;
            case 3:
                dragons.add(new Dragon(n,b,g,a));
                break;
        }

        //add the animal to the appropriate ArrayList

        System.out.println("Animal Succesfully added!");
        

    }

    private static void viewAnimals(){
        System.out.println("\n------ DOGS ------");
        //for each loop
        for(Dog dog:dogs){
            System.out.println(dog);
        }
    }

    private static void modifyAnimal(Scanner scanner){
         //choose the species...   boy, wouldn't this be nice to have a search f(x)
         System.out.println("Choose a species: \n\t1. Dog\t2. Cat\t3. Dragon");
         int type = scanner.nextInt();
         switch (type){
             case 1:
                 //choose the animal
                 System.out.println("Which doggy? (name)");
                 for(Dog dog:dogs){
                     System.out.println(dog);
                 }
                 String name = scanner.next();
                 //choose the property
                 System.out.println("Choose a property: \n\t1. Name\t2. Breed\t3. Gender\t4. Age");
                 type = scanner.nextInt();
                 switch (type){
                     case 1:
                         //update info
                         String newInfo = scanner.next();
                         //find an object in an ArrayList
                         for(Dog dog:dogs){
                             if (dog.getName().equals(name)){
                                 //set the new data
                                 dog.setName(newInfo);
                             }
                         }
                         break;
                     case 2:
                         break;
                     case 3:
                         break;
                 }
                 break;
             case 2:
                 break;
             case 3:
                 break;
         }
     }
        
    private static void removeAnimal(Scanner scanner){
        System.out.println("Choose a species: \n\t1. Dog\t2. Cat\t3. Dragon");
        int type = scanner.nextInt();
        if(type==1){
            System.out.println("Which doggy? (name)");
                for(Dog dog:dogs){
                    System.out.println(dog);
                 }
            String name = scanner.next();
            for(Dog dog:dogs){
                if(dog.getName().equals(name)){
                    dogs.remove(dog);
                }
            }
        }
        System.out.println("Animal Removed");
     }
}

