import java.io.*;
import java.util.*;

public class PasswordManager {
    private static Map<String, List<Account>> categories = new HashMap<>();
    private static final String FILENAME = "password_manager.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        loadFromFile();

        boolean running = true;
        while (running) {
            System.out.println("Password Manager Menu:");
            System.out.println("1. Add User");
            System.out.println("2. Add Account");
            System.out.println("3. Add Account to Existing Category");
            System.out.println("4. Delete Account");
            System.out.println("5. View Categories");
            System.out.println("6. Modify Account");
            System.out.println("7. Generate Password");
            System.out.println("8. Exit");
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
                    addAccountToCategory();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:
                    viewCategories();
                    break;
                case 6:
                    modifyAccount();
                    break;
                case 7:
                    System.out.println("Generated Password: " + generatePassword());
                    break;
                case 8:
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
        System.out.println("User " + username + " added.");
    }

    public static void addAccount() {
        System.out.print("Enter category name: ");
        String category = scanner.nextLine();

        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Account account = new Account(accountName, username, password);
        categories.putIfAbsent(category, new ArrayList<>());
        categories.get(category).add(account);
        System.out.println("Account added to category " + category);
    }

    public static void addAccountToCategory() {
        System.out.print("Enter existing category name: ");
        String category = scanner.nextLine();

        if (!categories.containsKey(category)) {
            System.out.println("Category does not exist.");
            return;
        }

        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Account account = new Account(accountName, username, password);
        categories.get(category).add(account);
        System.out.println("Account added to category " + category);
    }

    public static void deleteAccount() {
        System.out.print("Enter category name: ");
        String category = scanner.nextLine();

        if (!categories.containsKey(category)) {
            System.out.println("Category does not exist.");
            return;
        }

        System.out.print("Enter account name to delete: ");
        String accountName = scanner.nextLine();

        List<Account> accounts = categories.get(category);
        accounts.removeIf(account -> account.getName().equals(accountName));
        System.out.println("Account " + accountName + " deleted.");
    }

    public static void viewCategories() {
        System.out.println("Categories:");
        for (String category : categories.keySet()) {
            System.out.println("- " + category);
            for (Account account : categories.get(category)) {
                System.out.println("   " + account);
            }
        }
    }

    public static void modifyAccount() {
        System.out.print("Enter category name: ");
        String category = scanner.nextLine();

        if (!categories.containsKey(category)) {
            System.out.println("Category does not exist.");
            return;
        }

        System.out.print("Enter account name to modify: ");
        String accountName = scanner.nextLine();

        List<Account> accounts = categories.get(category);
        for (Account account : accounts) {
            if (account.getName().equals(accountName)) {
                System.out.print("Enter new username: ");
                String newUsername = scanner.nextLine();
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();
                account.setUsername(newUsername);
                account.setPassword(newPassword);
                System.out.println("Account modified.");
                return;
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
        for (String category : categories.keySet()) {
            writer.write("Category: " + category + "\n");
            for (Account account : categories.get(category)) {
                writer.write(account.toString() + "\n");
            }
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
            } else {
                String[] parts = line.split(", ");
                Account account = new Account(parts[0], parts[1], parts[2]);
                categories.get(currentCategory).add(account);
            }
        }
        reader.close();
    }

    // Account class to represent each account
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