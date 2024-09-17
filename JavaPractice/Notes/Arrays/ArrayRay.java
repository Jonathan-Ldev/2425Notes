import java.lang.reflect.Array;

public class ArrayRay {
    public static void main(String[] args) {
        /*
        * Primitive - doubles, char, ints, booleans
        * Non-Primitive - Strings, Lists, Arrays, ArrayList, Objects, Maps, Json, Humans
        * 
        * Sequences - multiple piece of data spliced together 
        *     - Strings
        *     - Arrays
        *     - ArrayList
        *     - Maps, Json, List, Collections, Tuples
        *     - Linked List
        */

        //Pythonic -> listy = [0,1,2,3,4,5,6,7,8,9]

        int[] listy = {0,1,2,3,4,5,6,7,8,9};
        int[] numbers = {0,1,2,3,4,5,6,7};
        //int[] objectName = {} you just said  this arrat is filled with int
        double[] doubleNumbers = {0,1,2,3.14,4,5};
        String[] words = {"Hello"," ","World","4"};
        char[] alpha = {'a','b','c'};

        //Grocery List
        String[] cart = new String[5]; 
        double[] cost = new double[5];

        //array data type is immutable as in cannot change length or data after created
        System.out.println(listy);
        for(int i=0; i<listy.length;i++){
            System.out.print(listy[i]+"\s");
        }
        for(int i=0; i<cart.length;i++){
            System.out.print(cart[i]+"\s");
        }
        for(int i=0; i<cost.length;i++){
            System.out.print(cost[i]+"\s");
        }

        //add an item
        //pythonic -> cart.append("eggs")
        cart[0] = "eggs";
        cart[1] = "Tortilla Chips";
        cart[2] = "Strawberries";
        cart[3] = "SPAM";
        cart[4] = "Mac N Cheese";
        
        //add cost to the cost array
        Scanner ui = new Scanner(System.in);
        for(int i=0;i<cost.length;i++){
            cost[i]=ui.nextDouble();
        }

        //cart and cost are parallel arrays - item 1 in both list are related
        printHorizontal(cart);
        System.out.println(Arrays.toString(cart));
        printVertical(cart);

        //remove an item from an Array
        cart[2]="Attack Helicopter";

        //increase the cart size
        int[] newCart = new String[cart.length +1]; //you could MemoryOverflow
        //now move the old cart to the new
        for(int i=0;i<cart.length;i++){
            newCart[i]=cart[i];
        }

        //ArrayIndexOutofBounds error - fixed with algorithm above
        cart[6] = "Blueberry Pomegranate Sparkling Water";

        //grid of numbers -> nest Arrays
        /*
         *  [[1 , 2],
         *  [3 , 4]]
         */
        int[][] grid = {
            {1,2},
            {3,4}
        };
        //item row 3 col 2 
        r2c2 = grid[1][1];

        //if you want to print all of the items
        for(int r;r<grid.length;r++){
            for(int c;c<grid.length;c++){
                System.out.println(grid[r][c]);
            }
        }
        
    }
    private static void printHorizontal(String[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\s");
        }
        System.out.println();
    }
    private static void printHorizontal(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\s");
        }
        System.out.println();
    }
    private static void printVertical(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+"\s");
        }
        System.out.println();
    }
    private static void printVertical(String[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+"\s");
        }
        System.out.println();
    }
}
