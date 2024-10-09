public class Main {
    public static void main(String[] args) {
        String strObj = new String();
        String strObj2 = "bob";

        //DataType objName = new Constructer();
        Pokemon testPokemon = new Pokemon();
        Pokemon myPokeMan = new Pokemon("5600","Fire",4500,"The Sun","432,450","1.989*10^30","SolarBeam",1200,"Flamethrower",900,"Sun");
        Pokemon Charizard = new Pokemon("9", "Fire", 120, "Charizard","6,2","170","Flamethrower",90,"Wing Attack",60,"aaa");

        System.out.println(myPokeMan);
        System.out.println();
        System.out.println(Charizard);
        System.out.println();
        

        //reset names of pokemon
        testPokemon.setName("Snorlax");
        testPokemon.setAttack1Name("Body Slam");
        testPokemon.setAttack1dmg(80);
        testPokemon.setAttack2Name("Rest");
        testPokemon.setAttack2dmg(0);
        System.out.println(testPokemon);
    }
}
