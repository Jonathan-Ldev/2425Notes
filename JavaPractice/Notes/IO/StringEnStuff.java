public class StringEnStuff {
    /*
     * Data Types
     *      Primitive - initial or the first - boolean, integers, characters, double/floats
     *      Non - Primitive - not native - Strings, Arraus, ArrayList, List
     * 
     *  #1 way to tell if it is a pri/non-pri is the Captilization
     * 
     * String name = "bob";     -> name is not a var, it is an object
     * int x = 4;   -> x is now the object x
     */


     int x = 4;             //int is primitive
     Integer x2 = 4;        //Integer is non-primitive - this guy has methods

     double gpa = 4.0;      //This is literally a number
     Double gpa2 = 4.0;     //This can convert and check for things


     public static void main(String[] args){
        String name = "jim";
        //char letter = "j"; " " are for strings
        char letter = 'j'; // ' ' are for characters

        int age = 40;
        boolean old = true;
        double pi = 3.14;
        // float fpi = 3.14;    instead of float use double

        String email = "jintheDestroyer9000@aol.com";
        String password = new String();
        password = "funpassword";

        //first I want the username - grab everything up to the @ sign
        //substring() -> hrabs a sib portio of a string
        String username = email.substring(0,19);
        String domain = email.substring(20);
        System.out.println(username);
        System.out.println(domain);

        //let's find the @ symbol
        int atLoc = email.indexOf("@");     //find the string in the string obj
        username = email.substring(0, atLoc);

        //here's the email input -> jimmy.bob@evsck12.com
        //add stu. between the @ and evsck12.com

        String email2 = "jimmy.bob@evsck12.com";
        int Loc = email2.indexOf("@");
        String first = email2.substring(0,Loc+1);
        String last = email2.substring(Loc+1);
        String email3 = first+"stu."+last;
        System.out.println(email3);

}



}