public abstract class Character {
    public String name;
    public int health;
    public int attack;
    public int defense;
    public Character(String name, int health, int attack, int defense){
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public boolean isAlive(){
        return health>0;
    }
    public void takeDamage(int damage){
        int damageTaken = Math.max(damage-defense,0);
        health-= damageTaken;
        System.out.println(name+" took "+damageTaken+" damage.");
    }
    public abstract void specialAbility();

}
