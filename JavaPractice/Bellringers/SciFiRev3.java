import java.util.Scanner;
import java.util.Random;
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


    Random randy = new Random();

    int Lof = first.length();
    int num = randy.nextInt(0,Lof);
    String SciFiFirst = first.substring(num,Lof);
    int Loc = last.length();
    num = randy.nextInt(0,Loc);
    String SciFiLast = last.substring(num,Loc);
    String SciFiFirstName = SciFiFirst+SciFiLast;
    int Lof2 = city.length();
    num = randy.nextInt(0,Lof2);
    String SciLastFirst = city.substring(num,Lof2);
    int Loc2 = school.length();
    num = randy.nextInt(0,Loc2);
    String SciLastLast = school.substring(num,Loc2);
    String SciFiLastName = SciLastFirst+SciLastLast;
    int Lof3 = pet.length();
    num = randy.nextInt(0,Lof3);
    String SciOriginFirst = pet.substring(num,Lof3);
    int Loc3 = sibling.length();
    num = randy.nextInt(0,Loc3);
    String SciOriginLast = sibling.substring(num,Loc3);
    String SciFiOrigin = SciOriginFirst+SciOriginLast;
    System.out.println("Sci-Fi First Name: "+SciFiFirstName+"");
    System.out.println("Sci-Fi Last Name: "+SciFiLastName+"");
    System.out.println("Sci-Fi Origin: "+SciFiOrigin+"");
    System.out.println("Howdy "+SciFiFirstName+" "+SciFiLastName+" From "+SciFiOrigin+"");
    

    }

}

      