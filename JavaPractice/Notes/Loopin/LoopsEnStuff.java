public class LoopsEnStuff {
    public static void main(String[] args) {
        //two main loops to tackle... pretty much anything  FOR and WHILE
        //both loops are built from a conditional statement

        /////////////////////// While Loops ////////////////////
        // iterator varibale
        // while(condition is true){
        // do this algorithm
        // iterate your iterator variable
        // }

        //print out 0-9
        int i = 0;
        while(i<10){
            System.out.println(i);
            i++;
        }



        //print out 0-9 a different way... aka change your conditional statement
        i = 0;
        while(i != 10){
            System.out.println(i);
            i++;
        }
        //print out even numbers btwn 0-20
        i = 0;
        while(i < 21){
            if(i%2 == 0){
                System.out.println(i);
                i++;
            }
            else{
                i++;
            }
        }

        //print out prime numbers btwn 0-1000
        i = 0;
        

        //print out the palindromes btwn 0-10000
        //print out 1000 to -1000 by 50
        i = 1000;
        while(i!=-1050){
            System.out.println(i);
            i = i - 50;
        }
        //print out the alphabet

        //////////////////////// FOR LOOPS /////////////////////////////
        //      Basic for loop structure
        // for(iterator variable; condition is true; iterate your iterator variable;){
        //      do this algorithm;
        //}
        //      for each loop

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        //print out 0-9
        int a = 0;
        for (a=0;a!=10;a++){
            System.out.print(a);
        }
        System.out.println();
        //print out 9-0
        for (a=9; a>=0;a--){
            System.out.print(a);
        }
        //print out 0-20 but odds
        System.out.println();
        for(a=1;a<=20;a+=2){
            System.out.print(a);
        }
        System.out.println();
        //2,1,0,2,1,0,2,1,0
        //nested loop or the double for loop
        int b = 0;
        for(a=0;a<3;a++){
            for (b=2;b>=0;b--){
                if(a==2 && b==0){
                    System.out.print(b);
                }
                else{System.out.print(b+",");
                }
            }
        }
        System.out.println();
        int c = 0;
        for(a=0;a!=10;a++){
            for(b=0;b!=10;b++){
                if(a==0){
                    System.out.print("0"+c+" ");
                    c++;
                }
                else{
                System.out.print(c + " ");
                c++;
                }
            }
            System.out.println();
        }
    }
}
