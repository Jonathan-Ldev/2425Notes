import java.text.DecimalFormat;
import java.util.Scanner;

public class ComboMenurev4 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        boolean keepOrdering = true;
        double trueSubTotal = 0;
        double trueTax = 0;
        double trueTotal = 0;
        String finalOrder = "";
        String finSubTotal = "";
        String finTax = "";
        String finTotal = "";
        int orderNumber = 0;
        // keep sending orders while this stays true
        while(keepOrdering = true){
            orderNumber += 1;
            String order = "";
            double total = 0;
            Scanner ui = new Scanner(System.in);
            //ask for sandiwch and what size
            System.out.println("Would you like a sandwich? (1 for yes, 2 for no)");
            int sandwich = ui.nextInt();
            if(sandwich == 1){
                System.out.println("What kind of sandwich? (1 for chicken $5.25, 2 for tofu $5.75, 3 for beef $6.25, 4 for no sandwich)");
                int kind = ui.nextInt();
                if(kind == 1){
                    order += "chicken sandwich";
                    total += 5.25;
                }
                else if(kind == 2){
                    order += "tofu sandwich";
                    total += 5.75;
                }
                else if(kind == 3){
                    order += "hamburger";
                    total += 6.25;
                }
                else{
                    order += "no sandwich";
                }
            }
            else{
                order += "no sandwich";
            }

            //ask for fries and what size
            System.out.println("Would you Like some fries? (1 for yes, 2 for no)");
            int fries = ui.nextInt();
            if(fries == 1){
                System.out.println("What size fries would you want? (1 for small $1, 2 for medium $1.75, 3 for large $2.25)");
                int size = ui.nextInt();
                if(size == 1){
                    order += ", small fries";
                    total += 1;
                }
                else if(size == 2){
                    order += ", medium fries";
                    total += 1.75;
                }
                else if(size == 3){
                    order += ", large fries";
                    total += 2.25;
                }
                else{
                    order += ", no fries";
                }
            }
            else{
                order += ", no fries";
            }
            
            //ask for drink and what size
            System.out.println("Would you like a drink? (1 for yes, 2 for no)");
            int drink = ui.nextInt();
            if(drink == 1){
                System.out.println("What size drink would you want? (1 for small $1, 2 for medium $1.50, 3 for large $2)");
                int size = ui.nextInt();
                if(size == 1){
                    order += ", small drink";
                    total += 1;
                }
                else if(size == 2){
                    order += ", medium drink";
                    total += 1.50;
                }
                else if(size == 3){
                    System.out.println("Do you want to upgrade to a child size for only .38 cents more? (1 for yes, 2 for no)");
                    int child = ui.nextInt();
                    if(child == 1){
                        order += ", child drink";
                        total += 2.38;
                    }
                    else if(child == 2){
                        order += ", large drink";
                        total += 2;
                    }
                    else{
                        System.out.println("well no drink for you then");
                        order += ", no drink";
                    }
                }
                else{
                    order += ", no drink";
                }
            }
            else{
                order +=  ", no drink";
            }

            //ask for ketchup and how many
            System.out.println("would you like some ketchup with that? (1 for yes, 2 for no)");
            int ketchup = ui.nextInt();
            if(ketchup == 1){
                System.out.println("how many ketchup packets would you like, $.25 per packet");
                int amount = ui.nextInt();
                order += (", "+amount+" ketchup packets");
                //take amount of packets time .25 for price
                total += amount*.25;
            }
            else{
                order += ", no ketchup packets";
            }

            //if all three == yes, minus 1 from the cost
            if(sandwich == 1){
                if(fries == 1){
                    if(drink == 1){
                        total -= 1;
                    }
                }
            }

            trueSubTotal += total;
            double tax = total*.07;
            trueTax += tax;
            total = tax+total;
            trueTotal += total;
            String orderTotal = df.format(total);
            finalOrder += ("Order "+orderNumber+": "+order+" "+orderTotal+"\n");

            System.out.println("Do you want to place another order (1 for yes, 2 for no)");
                int again = ui.nextInt();
                if(again == 1){
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                }
                else{
                    break;
                }

            }
            
        finSubTotal = df.format(trueSubTotal);
        finTax = df.format(trueTax);
        finTotal = df.format(trueTotal);


        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("Subtotal: "+finSubTotal);
        System.out.println("Tax: "+finTax);
        System.out.println(finalOrder+ "your total is "+finTotal);


        
    }

}
