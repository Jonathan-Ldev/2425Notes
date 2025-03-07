import java.util.Scanner;

public class Problem8 {
    public static void main(String[] args) {
        int sValue = 0;
        String input = "";
        int letter = 0;
        int i = 0;
        
        Scanner ui = new Scanner(System.in);

        //asking for inputs
        // java was being dumb with ui.nextline so I couldn't get the looping to work
        System.out.println("Enter the secret message:");
        input = ui.nextLine();
        System.out.println("Enter the shift value:");
        sValue = ui.nextInt();
        
        
        System.out.println("The encoded message is: "+CaesarCipher(input, sValue));

        
    }

    public static String CaesarCipher (String message, int offset) {
        //took this algorithm and tweaked it a bit to make it just a function and not a class. https://www.baeldung.com/java-caesar-cipher
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}
