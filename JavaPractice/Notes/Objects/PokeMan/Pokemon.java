//imports

public class Pokemon {
    //field variables or global variables for the class
    //private -> because other files do not need to access these variables
    private String name,ht,wt,attack1Name,attack2Name,id,type,picture;
    private int hp,attack1dmg,attack2dmg;

    //Constructors - what is needed to have an object of this class
    //no-arg Constructor
    public Pokemon(){
        this.id="";
        this.type="";
        this.hp=0;
        this.name="";
        this.ht="";
        this.wt="";
        this.attack1Name="";
        this.attack1dmg=0;
        this.attack2Name="";
        this.attack2dmg=0;
        this.picture="";
    }
    public Pokemon(String id, String type, int hp, String name, String ht, String wt, String a1n, int a1d, String a2n, int a2d, String pic){
        //this.fieldVariableName = localVariableNameFromConstructor;
        this.id=id;
        this.type=type;
        this.hp=hp;
        this.name=name;
        this.ht=ht;
        this.wt=wt;
        this.attack1Name=a1n;
        this.attack1dmg=a1d;
        this.attack2Name=a2n;
        this.attack2dmg=a2d;
        this.picture=pic;
    }
    //getters and setters aka acccessors and mutators
    public String getID(){
        return this.id;
    }
    public void setID(String newID){
        this.id = newID;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public String getType(){
        return this.type;
    }
    public void setType(String newType){
        this.type = newType;
    }
    public int getHP(){
        return this.hp;
    }
    public void setHP(int newHP){
        this.hp = newHP;
    }
    public String getHeight(){
        return this.ht;
    }
    public void setHeight(String newHeight){
        this.ht = newHeight;
    }
    public String getAttack1Name(){
        return this.attack1Name;
    }
    public void setAttack1Name(String newAttack1Name){
        this.attack1Name = newAttack1Name;
    }
    public int getAttack1dmg(){
        return this.attack1dmg;
    }
    public void setAttack1dmg(int newAttack1dmg){
        this.attack1dmg = newAttack1dmg;
    }
    public String getAttack2Name(){
        return this.attack2Name;
    }
    public void setAttack2Name(String newAttack2Name){
        this.attack2Name = newAttack2Name;
    }
    public int getAttack2dmg(){
        return this.attack2dmg;
    }
    public void setAttack2dmg(int newAttack2dmg){
        this.attack2dmg = newAttack2dmg;
    }
    //methods for the object

    //toString method
    // toString method to display Pokémon information
    @Override //decorator - over writing the toString f(x) from the super class
    public String toString() {
        return "Index: " + id +
               "\nName: " + name +
               "\nType: " + type +
               "\nHP: " + hp +
               "\nHeight: " + ht + " m" +
               "\nWeight: " + wt + " kg" +
               "\nAttack 1: " + attack1Name + " (Power: " + attack1dmg + ")" +
               "\nAttack 2: " + attack2Name + " (Power: " + attack2dmg + ")";
    }
}
