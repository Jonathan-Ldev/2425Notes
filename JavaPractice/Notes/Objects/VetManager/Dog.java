public class Dog {
    
    private String name, breed, gender;
    private int age;
    
    
    
    public Dog(){
        this.name="";
        this.breed="";
        this.gender="";
        this.age=0;
    }

    public Dog(String name, String breed, String gender, int age){
        this.name=name;
        this.breed=breed;
        this.gender=gender;
        this.age=age;
    }

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

    public String eat(){
        return name+" has been bugging you for 5 minutes, you finally feed them";
    }
    public String sleep(){
        return "It is time to sleep, naturally "+name+" jumps onto your bed instead of sleeping in their own, you have given up at this point";
    }
    public String poop(){
        return "You take "+name+" for a walk, along the way he poops on someone's lawn, naturally you don't clean it up, it's their problem now";
    }
    
    @Override
    public String toString(){
        return "Name: " +name+ 
               "\nBreed: " +breed+
               "\nGender: " +gender+
               "\nAge: " +age;
    }


}
