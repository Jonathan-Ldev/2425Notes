import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordManager {
    private static Map<String, List<User.Account>> categories = new HashMap<>();
    private static ArrayList<String> users = new ArrayList<>();
    private static ArrayList<String> passwords = new ArrayList<>();
    private static final String FILENAME = "password_manager.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        loadFromFile();
        String currentUser;

        if (users.isEmpty()){
            System.out.println("Please create an Account to get started");
            String username = scanner.next();
            new User(username);
            users.add(username);
            System.out.println("Enter an Account Password, Password must have 8 characters, a special character, and a number");
            String password = scanner.next();
            while(true){
                if (Password_Validation(password) == true){
                    break;
                }
                else{
                    System.out.println("Please include 8 characters, a special character, and a number");
                    password = scanner.next();
                }
                
            }
            passwords.add(password);
            currentUser = username;
        }



        boolean running = true;
        while (running) {
            System.out.println("Password Manager Menu:");
            System.out.println("1. Add User");
            System.out.println("2. Add Account");
            System.out.println("3. Delete Account");
            System.out.println("4. View Categories");
            System.out.println("5. Modify Account");
            System.out.println("6. Generate Password");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    addAccount();
                    break;
                case 3:
                    deleteAccount();
                    break;
                case 4:
                    viewCategories();
                    break;
                case 5:
                    modifyAccount();
                    break;
                case 6:
                    System.out.println("Generated Password: " + generatePassword());
                    break;
                case 7:
                    running = false;
                    saveToFile();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void addUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        new User(username);
        users.add(username);
        System.out.println("Enter an Account Password");
        String password = scanner.next();
        while(true){
            if (Password_Validation(password) == true){
                break;
            }
            else{
                System.out.println("Please include 8 characters, a special character, and a number");
                password = scanner.next();
            }
            
        }
        passwords.add(password);
        System.out.println("User " + username + " added.");
    }

    public static void addAccount() {

        System.out.print("Enter which account this is for: ");
        System.out.println(users);
        String accountName = scanner.nextLine();

        if (!users.contains(accountName)){
            System.out.println("Error Try again");
            return;
        }
        System.out.println("Enter Password please");
        String accPassword = scanner.next();
        while(true){
            if (Password_Validation(accPassword) == true){
                break;
            }
            else{
                System.out.println("Please include 8 characters, a special character, and a number");
                accPassword = scanner.next();
            }
            
        }
        if(!accPassword.equals(passwords.get(users.indexOf(accountName)))){
            System.out.println("Wrong Password");
            return;
        }

        System.out.print("Enter category name: ");
        String category = scanner.next();

       
        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        User.Account account = new User.Account(accountName, username, password);
        categories.putIfAbsent(category, new ArrayList<>());
        categories.get(category).add(account);
        System.out.println("Account added to category " + category);
    }


    public static void deleteAccount() {
        String temp = "";

        System.out.println("Enter which user this is for");
        System.out.println(users);
        String user = scanner.next();

        if (!users.contains(user)){
            System.out.println("Error Try again");
            return;
        }

        System.out.println("Enter Password please");
        String accPassword = scanner.next();
        if(!accPassword.equals(passwords.get(users.indexOf(user)))){
            System.out.println("Wrong Password");
            return;
        }
        
        
        System.out.print("Enter category name: ");
        String category = scanner.next();

        if (!categories.containsKey(category)) {
            System.out.println("Category does not exist.");
            return;
        }


        for (String single : categories.keySet()) {
            for (User.Account account : categories.get(single)) {
                if (account.toString().contains(user) && single.toString().contains(category))
                System.out.println(account);
                temp +=account;
            }
        }

        
        System.out.print("Enter account name to delete: ");
        String accountName = scanner.next();
        
        if (temp.contains(accountName)){
            List<User.Account> accounts = categories.get(category);
        accounts.removeIf(account -> account.getUsername().equals(accountName));
        System.out.println("Account " + accountName + " deleted.");
        }
        else{
            System.out.println("Problem Deleting Account");
        }
        
    }

    public static void viewCategories() {

        System.out.println("Enter which user this is for");
        System.out.println(users);
        String user = scanner.next();

        if (!users.contains(user)){
            System.out.println("Error Try again");
            return;
        }

        System.out.println("Enter Password please");
        String accPassword = scanner.next();
        if(!accPassword.equals(passwords.get(users.indexOf(user)))){
            System.out.println("Wrong Password");
            return;
        }
        
        for (String category : categories.keySet()) {
            System.out.println("- " + category);
            for (User.Account account : categories.get(category)) {
                if (account.toString().contains(user))
                System.out.println(account);
            }
        }

       
    }

    public static void modifyAccount() {
        String temp = "";

        System.out.println("Enter which user this is for");
        System.out.println(users);
        String user = scanner.next();

        if (!users.contains(user)){
            System.out.println("Error Try again");
            return;
        }

        System.out.println("Enter Password please");
        String accPassword = scanner.next();
        if(!accPassword.equals(passwords.get(users.indexOf(user)))){
            System.out.println("Wrong Password");
            return;
        }
        System.out.print("Enter category name: ");
        String category = scanner.next();

        if (!categories.containsKey(category)) {
            System.out.println("Category does not exist.");
            return;
        }

        for (String single : categories.keySet()) {
            for (User.Account account : categories.get(category)) {
                if (account.toString().contains(user) && single.toString().contains(category))
                System.out.println(account);
                temp +=account;
            }
        }

        System.out.print("Enter account name to modify: ");
        String accountName = scanner.next();

        if (temp.contains(accountName)){
            List<User.Account> accounts = categories.get(category);
            for (User.Account account : accounts) {
                if (account.getName().equals(accountName)) {
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.next();
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.next();
                    while(true){
                        if (Password_Validation(newPassword) == true){
                            break;
                        }
                        else{
                            System.out.println("Please include 8 characters, a special character, and a number");
                            newPassword = scanner.next();
                        }
                        
                    }
                    account.setUsername(newUsername);
                    account.setPassword(newPassword);
                    System.out.println("Account modified.");
                    return;
                }
            }
        }
        System.out.println("Account not found.");
    }

    public static String generatePassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }
        return password.toString();
    }

    public static void saveToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));
        int i = 0;
        for (String category : categories.keySet()) {
            writer.write("Category: " + category + "\n");
            for (User.Account account : categories.get(category)) {
                writer.write(account.toString() + "\n");
            }
        }
        for (String username:users){
            writer.write("User: "+username+", "+passwords.get(i)+"\n");
            i++;
        }

        writer.close();
    }

    public static void loadFromFile() throws IOException {
        File file = new File(FILENAME);
        if (!file.exists()) return;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        String currentCategory = null;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Category: ")) {
                currentCategory = line.substring(10);
                categories.putIfAbsent(currentCategory, new ArrayList<>());
            } 
            
            else if(line.startsWith("User: ")){
                String[] parts = line.split(",");
                users.add(parts[0].replace("User: ", ""));
                passwords.add(parts[1].strip());
            }
            
            else {
                String[] parts = line.split(", ");
                User.Account account = new User.Account(parts[0], parts[1], parts[2]);
                categories.get(currentCategory).add(account);
            }
        }
        System.out.println("Current Users: "+users);
        reader.close();
    }

    public static boolean Password_Validation(String password) 
{
    // Where I got the code to check the password
    // https://stackoverflow.com/questions/1795402/check-if-a-string-contains-a-special-character
    if(password.length()>=8)
    {
        Pattern letter = Pattern.compile("[a-zA-z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        //Pattern eight = Pattern.compile (".{8}");


           Matcher hasLetter = letter.matcher(password);
           Matcher hasDigit = digit.matcher(password);
           Matcher hasSpecial = special.matcher(password);

           return hasLetter.find() && hasDigit.find() && hasSpecial.find();

    }
    else
        return false;

}

    // Account class to represent each account
    static class User{
        private String username;
        public User(String username){
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        static class Account {
            private String name;
            private String username;
            private String password;
    
            public Account(String name, String username, String password) {
                this.name = name;
                this.username = username;
                this.password = password;
            }
    
            public String getName() {
                return name;
            }

            public String getUsername(){
                return username;
            }
    
            public void setUsername(String username) {
                this.username = username;
            }
    
            public void setPassword(String password) {
                this.password = password;
            }
    
            @Override
            public String toString() {
                return name + ", " + username + ", " + password;
            }
        }
    }
    
}