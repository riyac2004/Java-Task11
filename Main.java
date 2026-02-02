import java.io.*;
import java.util.Scanner;

public class Main {

    static final String FILE_NAME = "userdata.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== User Data Storage System =====");
            System.out.println("1. Add User Data");
            System.out.println("2. View All Records");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addUserData(sc);
                    break;
                case 2:
                    readUserData();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 3);

        sc.close();
    }

    // Method to add user data to file
    static void addUserData(Scanner sc) {
        try {
            File file = new File(FILE_NAME);

            // Create file if it does not exist
            if (!file.exists()) {
                file.createNewFile();
            }

            // Open file in append mode
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();

            // Write data in readable format
            bw.write("Name  : " + name);
            bw.newLine();
            bw.write("Email : " + email);
            bw.newLine();
            bw.write("Phone : " + phone);
            bw.newLine();
            bw.write("----------------------------");
            bw.newLine();

            bw.close();
            fw.close();

            System.out.println("User data saved successfully!");

        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }
    }

    // Method to read user data from file
    static void readUserData() {
        try {
            File file = new File(FILE_NAME);

            if (!file.exists()) {
                System.out.println("No records found. File does not exist.");
                return;
            }

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("\n===== Stored User Records =====");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }
}
