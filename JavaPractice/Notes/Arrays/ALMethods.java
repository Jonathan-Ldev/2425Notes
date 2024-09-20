import java.util.ArrayList;
public class ALMethods {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        int[] ia = {1, 5, 9, 7, 4, 8, 2, 3, 6, 0, 9};
        // Fill the ArrayList with values from the array
        arrList = createArrayList(ia);
        // Test the methods
        System.out.println("Min: " + minIntAL(arrList));
        System.out.println("Max: " + maxIntAL(arrList));
        System.out.println("Average: " + aveIntAL(arrList));
        System.out.println("Sum: " + sumIntAL(arrList));
        System.out.println("Standard Deviation: " + stdDev(arrList));
        System.out.println("Count of 9: " + count(arrList, 9));
        System.out.println("List without duplicates: " + removeDuplicates(arrList));
    }
    private static int minIntAL(ArrayList<Integer> arrList) {
        if (arrList.isEmpty()) return Integer.MAX_VALUE; // or throw an exception
        int min = arrList.get(0);
        for (int num : arrList) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
    private static int maxIntAL(ArrayList<Integer> arrList) {
        int max = arrList.get(0);
        int num = 0;
        for (int i = 0; i<arrList.size();i++) {
            num = arrList.get(i);
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    private static double aveIntAL(ArrayList<Integer> arrList) {
        if (arrList.isEmpty()) return 0; // or throw an exception
        double sum = sumIntAL(arrList);
        return sum / arrList.size();
    }
    private static int sumIntAL(ArrayList<Integer> arrList) {
        int sum = 0;
        for (int num : arrList) {
            sum += num;
        }
        return sum;
    }
    private static double stdDev(ArrayList<Integer> arrList) {
        if (arrList.isEmpty()) return 0; // or throw an exception
        double mean = aveIntAL(arrList);
        double sum = 0;
        for (int num : arrList) {
            sum += Math.pow(num - mean, 2);
        }
        return Math.sqrt(sum / arrList.size());
    }
    // Count the number of occurrences of the item in the ArrayList
    private static int count(ArrayList<Integer> arrList, int item) {
        int count = 0;
        for (int num : arrList) {
            if (num == item) {
                count++;
            }
        }
        return count;
    }
    private static ArrayList<Integer> removeDuplicates(ArrayList<Integer> arrList) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int num : arrList) {
            if (!temp.contains(num)) {
                temp.add(num);
            }
        }
        return temp;
    }
    // Create ArrayList from an array
    private static ArrayList<Integer> createArrayList(int[] iarr) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int num : iarr) {
            temp.add(num);
        }
        return temp;
    }
}











