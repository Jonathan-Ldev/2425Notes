import java.util.Scanner;

//Abstract Super class, so everything here is abstract
public abstract class Animal {
     private String name, desc;

     public Animal(){}
          // Scanner in = new Scanner(System.in);
          // this.name = in.nextLine();
          // this.desc = in.nextLine();
     // }

     public Animal(String name, String description){
          this.name = name;
          this.desc = description;
     }
     //getters and setters
     public String getName(){
          return name;
     }
     public String getDesc(){
          return desc;
     }
     
     //this forces anything that extends Animal to create a makeNoise() f(x);
     public abstract String makeNoise();

}
