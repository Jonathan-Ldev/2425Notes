import java.util.Scanner;

public class LoopinStrings {
    public static void main(String[] args) {
        //Strings are a type of sequence data
        /*   Sequence - Collection of data built together
         *      -Strings
         *      -Arrays
         *      -ArrayList
         *      -List
         *      -Dictionaries (Python)
         *      -Tuples
         * BIG TAKE AWAY - you can iterate through this data
         */


         //count the number of certain char in a string
         //find all of the /s/s and replace them with a single /s
         //enter the word banana and return the word bnn
         //replace items in a string:
         //      ie: "I like potatoes with a side of potato sauce","potato","poop"
         //Compress a string
         //  ie: "aabccccaaa" -> "a2b1c4a3"
         //Convert a string into eac characters's binary
         //      ie: "bab" -> 98 97 98 in binary

         /*
          *  NO NO methods and NO No cheat codes
          * String.replaceAll String.replace
          * StringBuilder
          */
    Scanner ui = new Scanner(System.in);
    String help = "giggling";
    int i = help.length();
    int count = 0;
    for(i=help.length();i!=0;i--){
        if(help.charAt(i-1) == 103){
            count++;
        }
    }
    System.out.println("g -> " +count);

    

    }
}
