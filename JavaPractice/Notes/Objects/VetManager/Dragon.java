import java.util.ArrayList;

public class Dragon {
    private String name, breed, gender;
    private int age;
    ArrayList<String> tricks = new ArrayList<String>();
    
    
    public Dragon(){
        this.name="";
        this.breed="";
        this.gender="";
        this.age=0;
    }

    public Dragon(String name, String breed, String gender, int age){
        this.name=name;
        this.breed=breed;
        this.gender=gender;
        this.age=age;
    }

    //getters and setters
    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public String getBreed(){
        return this.breed;
    }
    public void setBreed(String newBreed){
        this.breed = newBreed;
    }
    public String getGender(){
        return this.gender;
    }
    public void setGender(String newGender){
        this.gender = newGender;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int newAge){
        this.age = newAge;
    }
    public void getTricks(){
        System.out.println(this.tricks);
    }

    //functions
    public String eat(){
        return name+" has almost scorched your house, time to feed them";
    }
    public String sleep(){
        return "It is time to sleep, naturally "+name+" flys onto your bed instead of sleeping in their own, you have given up at this point, let's hope you aren't gonna have to buy a 5th mattress this month";
    }
    public String poop(){
        return "You take "+name+" for a walk, along the way he torches someone's lawn, naturally you run away, it's their problem now";
    }
    public void train(String newTrick){
        tricks.add(newTrick);
    }
    
    @Override
    public String toString(){
        return "Name: " +name+ 
               "\nBreed: " +breed+
               "\nGender: " +gender+
               "\nAge: " +age;
    }
}
