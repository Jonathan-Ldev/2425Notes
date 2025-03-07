import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList of animals
        ArrayList<Animal> farmAnimals = new ArrayList<>();
        farmAnimals.add(new Cow());
        farmAnimals.add(new Dog());
        farmAnimals.add(new Pig());

        // Old MacDonald song loop
        System.out.println("Old MacDonald had a farm, E-I-E-I-O!");
        for (Animal animal : farmAnimals) {
            System.out.println("And on his farm he had a " + animal.getName() + ", E-I-E-I-O!");
            System.out.println("With a " + animal.makeNoise() + " " + animal.makeNoise() + " here and a " + animal.makeNoise() + " " + animal.makeNoise() + " there,");
            System.out.println("Here a " + animal.makeNoise() + ", there a " + animal.makeNoise() + ", everywhere a " + animal.makeNoise() + " " + animal.makeNoise() + ".");
            System.out.println("Old MacDonald had a farm, E-I-E-I-O!");
            System.out.println();
        }
    }
}