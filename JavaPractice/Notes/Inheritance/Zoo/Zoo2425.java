import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Scanner;
    
public class Zoo2425
    {
    public static void main(String[] args) throws InterruptedException 
    {
          //List of animals
          //ArrayList can only accept Animal objects
          ArrayList<Animal> animals = new ArrayList<Animal>();

          System.out.println("Welcome to the Zoo!\n");
          System.out.print("Building the cages");
          delayDots();
          System.out.print("Populating the animals");
          populateAnimals(animals);
          delayDots();
          System.out.print("Hiring zookeepers");
          delayDots();

          Scanner in = new Scanner(System.in);
          System.out.println("\nYou are standing in a wondrous zoo. What would you like to do?");
          System.out.println("Type help to find out what you can do.\n");
          String text = in.nextLine();
          String msg = "";
          while(!text.equals("leave"))
          {
               switch(text)
               {
                    case "help" : 
                    msg = "So far we can visit cages, listen, look up, look down, look around, leave \n"+
                    "and ask for help.";
                    break;
                    case "visit cages" : 
                    msg = visitCages(animals);
                    break;
                    case "look down":
                    msg = lookDown(animals);
                    break;
                    case "look up":
                    msg = lookUp(animals);
                    break;
                    case "look around":
                    msg = lookAround(animals);
                    break;
                    case "drones":
                    msg = seeTheBirds(animals);
                    break;
                    case "listen":
                    msg = listen(animals);
                    break;
                    default : msg = "You flail helplessly with indecision.";
               }
               System.out.println("\n" + msg);
               delayDots(3);
               System.out.println("\nYou are standing in a wondrous zoo. What would you like to do?\n");
               text = in.nextLine();
          }
          //in line if statement
          System.out.println(Math.random() < .5 ? "\nHave a nice day!  Hope you come back!" : "\nAn escaped lion eats you on your way out.  Sorry!");
     }
     
     public static String seeTheBirds(List<Animal> animals){
          String msg = "";
          for(Animal a: animals){
               if(a instanceof Bird){
                    Bird b = (Bird) a;
                    msg+=a.getName()+"\n\t"+b.poop()+"\n";
               }
          }
          return msg;
     }
     
     public static String listen(List<Animal> animals){
          String msg = "";
          for(Animal a: animals){
               msg+=a.getName()+":\n\t"+a.makeNoise()+"\n";
          }
          if(msg.length()==0){
               return "Need to go buy some animals...";
          }
          else{return msg;}
     }
          
     public static String lookDown(List<Animal> animals){
          String msg="";
          return msg;
     }
     
     public static String lookUp(List<Animal> animals){
          //should pull all of the animals that can fly
          String msg="";
          for(Animal a: animals){
               if(a instanceof Flying){
                    Flying f = (Flying) a;
                    msg+=a.getName()+":\n\t"+f.fly()+"\n";
               }
          }
          return msg;
     }
     
     public static String lookAround(List<Animal> animals){
          String msg="";
          for(Animal a: animals){
               if(a instanceof Walking){
                    Walking w = (Walking) a;
                    msg+=a.getName()+":\n\t"+w.walk()+"\n";
               }
          }
          return msg;
     }
     
     public static String visitCages(List<Animal> animals){
          String msg = "";
          for(Animal a: animals){
               msg+=a.getName()+":\n\t"+a.getDesc()+"\n";
          }
          if(msg.length()==0){
               return "Need to go buy some animals...";
          }
          else{return msg;}
     }

     /**
          * This prints an ellipses with 1 second between each period
          * It then moves to the next line.
          */
     public static void delayDots(int dotAmount) throws InterruptedException 
     {
          for (int i=0; i<dotAmount; i++) {
               TimeUnit.SECONDS.sleep(1);
               System.out.print(".");
          }
          System.out.println();
     }

     /**
          * This prints an ellipses with 1 second between each period
          * It then moves to the next line.
          */
     public static void delayDots() throws InterruptedException 
     {
          delayDots(0);
     }

     /**
          * This is where we will all collaborate.
          * Construct your animal and add it to the List
          * @param animals the list containing all the zoo animals
          */
     public static void populateAnimals(List<Animal> animals)
     {
          Panda p = new Panda();
          animals.add(p);
          animals.add(new Pikachu());
          animals.add(new Dragon());
          animals.add(new Goose());
          animals.add(new Swan());
          animals.add(new Platypus());
          animals.add(new Tiger());
          animals.add(new Eevee());
          animals.add(new Cat());
          animals.add(new RomTheVacuousSpider());
          animals.add(new Whale());
          animals.add(new Crab());
          animals.add(new Cod());
          animals.add(new Capybara());
          animals.add(new Turtle());
          animals.add(new BayleTheDread());
          animals.add(new Leviathan());
          animals.add(new Falcon());

          /*
          *  Polymorphism - Able to make an object of one type be defined as an object of another type
          *         1. Makes the type more general in case you need other methods and characters
          *              Shape tri = new Triangle(name, size)
          *         2. Code reusability - able to pass in default parameters
          *              Sword longSword inherits the strength and material while inheriting the Pike methods.
          */

     }
}