import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListRay {
    public static void main(String[] args) {
        /*
         * SQL 4 main methods - CRUD
         *     Create - or add items
         *     Read - printing
         *     Update
         *     Delete - removing items
         */

         //int[] numbers = new int[10];
         //int[] numbers = {0,1,2,3,4,5,6,7,8,9};

         //ArrayList<Type> objectName = new ArrayList<Type>();
         //ArrayList<Integer> numbers = new ArrayList<Integer>();
         ArrayList<String> students = new ArrayList<String>();

         System.out.println(students); //Arrays printed memory location

         //ADD data to an ArrayList - add as many as you want
         students.add("Jin");
         students.add("Ethan");
         students.add("Morgan");
         students.add("Schafer");
         students.add("Sushi");

         System.out.println(students);

         //get one item
         System.out.println(students.get(1));

         //UPDATE data in our ArrayList
         students.set(0, "Claire");
         System.out.println(students);
         //students.set(5, "Harper"); set does not add
         
         //DELETE data from our ArrayList
         students.remove("Morgan"); //find the first occurence 
         students.remove(1);
         System.out.println(students);
         students.clear(); //clears thre entire ArrayList
         System.out.println(students);

         //LENGTH of the list
         System.out.println(students.size());

         //CREATE obj and preload with data
         ArrayList<String> classroom = new ArrayList<String>(Arrays.asList("Wren","Kenneth","Elsner"));

         //print each object in classroom
         for(int i=0;i<classroom.size();i++){
            classroom.get(i);
         }
         //classroom.get(0).indexOf("e");

         ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>();
         //An ArrayList of ArrayList of String called board
          ArrayList<String> row3 = new ArrayList<>(Arrays.asList("1","2","3"));
          ArrayList<String> row2 = new ArrayList<>(Arrays.asList("4","5","6"));
          ArrayList<String> row1 = new ArrayList<>(Arrays.asList("7","8","9"));
          board.add(row1);
          board.add(row2);
          board.add(row3);
          
          System.out.println(board);
          // 987
          // 654
          // 321
          for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                System.out.print(board.get(row).get(col)+"\s");
            }
            System.out.println();
          }

    }
}
