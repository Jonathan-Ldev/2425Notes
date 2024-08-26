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
        System.out.print(" \tFirst: "+first+" \n \tLast: "+last+" \n \tCity: "+city+" \n \tSchool: "+school+" \n \tPet/App: "+pet+" \n \tSib/Myth: "+sibling+" \n");
    ui.close();


    String SciFiFirst = first.substring(0,2);
    int Loc = last.length();
    String SciFiLast = last.substring(Loc-2);
    String SciFiFirstName = SciFiFirst+SciFiLast;
    String SciLastFirst = city.substring(0,4);
    int Loc2 = school.length();
    String SciLastLast = school.substring(Loc2-3);
    String SciFiLastName = SciLastFirst+SciLastLast;
    String SciOriginFirst = pet.substring(0,3);
    int Loc3 = sibling.length();
    String SciOriginLast = sibling.substring(Loc3-2);
    String SciFiOrigin = SciOriginFirst+SciOriginLast;
    System.out.println("Sci-Fi First Name: "+SciFiFirstName+"");
    System.out.println("Sci-Fi Last Name: "+SciFiLastName+"");
    System.out.println("Sci-Fi Origin: "+SciFiOrigin+"");
    System.out.println("Howdy "+SciFiFirstName+" "+SciFiLastName+" From "+SciFiOrigin+"");
    

    }

}

      /*
         rev 2
            SciFiFirstName = first two let of First and last two let of Lasgt
            SciFiLastName = first 4 let of city and last 3 let of school
            SciFiOrigin = first 3 let of pet and last 2 let of sib
         */