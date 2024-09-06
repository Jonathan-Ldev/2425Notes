import java.util.Scanner;
public class SciFi {
    public static void main(String[] args){
        Scanner ui = new Scanner(System.in);
        System.out.println("What is your First Name?");
        String first = ui.nextLine();
        System.out.println("What is your Last Name?");
        String last = ui.nextLine();
        System.out.println("What City would you like to live in?");
        String city = ui.nextLine();
        System.out.println("What school are you going to attend after high school?");
        String school = ui.nextLine();
        System.out.println("What is your favorite pet's name, if you don't have a pet, What is your favorite appetizer");
        String pet = ui.nextLine();
        System.out.println("What is your favorite sibling's name, if you don't have a sibling, what is your favorite mythical creature");
        String sibling = ui.nextLine();
        
        System.out.println("User Info to Generate From");
        System.out.print(" \tFirst: "+first+" \n \tLast: "+last+" \n \tCity: "+city+" \n \tSchool: "+school+" \n \tPet/App: "+pet+" \n \tSib/Myth: "+sibling+"");
    ui.close();
    }
}

      /*
         * Take in the following info from the user
         * First name
         * last name
         * city they would like to live in
         * school - they are going to attend after high school
         * favorite pet's name or favorite appetizer
         * favorite sibling's name and if no siblings fav mythical character
         * 
         * Print out the info in a nice organized chart like this
         *              First: bob
         *              last: bob
         *              city: Boonville 
         *              school: help
         *              pet: ahhhhh
         *              sib: f[ueqiwf[uh]]
         * 
         */