public class Cat {
        private String name, breed, gender;
        private int age;
        
        
        
        public Cat(){
            this.name="";
            this.breed="";
            this.gender="";
            this.age=0;
        }
    
        public Cat(String name, String breed, String gender, int age){
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
            return "Time to feed "+name+"! ... They do not care.";
        }
        public String sleep(){
            return "Time to sleep! "+name+" has tried to suffocate you for the 6th time this month, silly you.";
        }
        public String poop(){
            return name+ " has pooped on your desk, unfortunately you cannot bring youself to say anthing to them";
        }
        
        @Override
        public String toString(){
            return "Name: " +name+ 
                   "\nBreed: " +breed+
                   "\nGender: " +gender+
                   "\nAge: " +age;
        }
    }
    

