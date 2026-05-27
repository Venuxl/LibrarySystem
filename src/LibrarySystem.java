import java.util.Scanner;

public class LibrarySystem {
    static Scanner scanner = new Scanner(System.in);

    // staff data
    static String[] staffIDs = {"ST001", "ST002"};
    static String[] staffPasswords = {"admin123", "library456"};

    // member data
    static String[] memberIDs = {"M001", "M002"};
    static String[] memberNames = {"Thuto Letaba", "Godswill Okoro"};
    static String[] memberPINs = {"1234", "5678"};
    // Book data
    static String[] bookIDs = {"B001", "B002", "B003", "B004", "B005", "B006"};
    static String[] bookTitles = {"The Great Gatsby", "To Kill a Mockingbird", "Phantasma", "Hamlet", "The Alchemist", "1984" };
    static String[] bookAuthors = {"F. Scott Fitzgerald", "Harper Lee", "Kaylie Smith", "William Shakespeare", "Paulo Coelho", "George Orwell"};
    static String[] bookGenres = {"Fiction", "Fiction", "Fantasy", "Plays, & Memoirs", "Modern Fiction","Literary Classics "};
    static boolean[] bookAvailable = {true, true, true, false, true, false};

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println(" Soweto Central Public Library");
        System.out.println("=================================");
        mainMenu();
    }

    // main menu
    static void mainMenu() {
        int choice;
        do {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Login as Staff");
            System.out.println("2. Login as Member");
            System.out.println("3. Exit");
            System.out.println("Enter Choice: ");
            choice = scanner.nextInt();

            if (choice == 1) staffLogin();
            else if (choice == 2) memberLogin();
            else if (choice == 3) System.out.println("Goodbye!");
            else System.out.println("Invalid choice.");

        } while (choice != 3);
    }
        // member login
        static void memberLogin() {
            System.out.println("Enter Member ID: ");
            String id = scanner.next();
            System.out.println("Enter PIN: ");
            String pin = scanner.next();

            for (int i = 0; i < memberIDs.length; i++) {
                if (memberIDs[i].equals(id) && memberPINs[i].equals(pin)) {
                    System.out.println("Welcome, " + memberNames[i] + "!");
                    memberMenu(i);
                    return;
                }
            }
            System.out.println("Invalid ID or PIN.");

        }
        // member menu
        static void memberMenu(int index) {
            int choice;
            do {
                System.out.println("\n--- MEMBER MENU ---");
                System.out.println("1. View Available Books");
                System.out.println("2. Logout");
                System.out.println("Enter choice: ");
                choice = scanner.nextInt();

                if (choice == 1) viewbooks();
                else if (choice == 2) System.out.println("Logging out...");
                else System.out.println("Invalid choice.");
            } while (choice != 2);

        }


        static boolean staffLogin () {
            System.out.println("Enter Employee ID: ");
            String id = scanner.next();
            System.out.println("Enter Password: ");
            String password = scanner.next();

            for (int i = 0; i < staffIDs.length; i++) {
                if (staffIDs[i].equals(id) && staffPasswords[i].equals(password)) {
                    System.out.println("Welcome, Staff Member " + id + "!");
                    staffMenu(id);
                    return true;
                }
            }
            System.out.println("Invalid credentials. Access denied. ");
            return false;
    }
    // staff menu
    static void staffMenu(String id) {
        int choice;
        do {
            System.out.println("\n--- STAFF MENU ---");
            System.out.println("1. View All Books");
            System.out.println("2. Add New Book");
            System.out.println("3. Logout");
            System.out.println("Enter choice");
            choice = scanner.nextInt();

            if (choice == 1) viewbooks();
            else if (choice == 2) addBook();
            else if (choice == 3) System.out.println("Logging out...");
            else System.out.println("Invalid choice.");

        } while (choice != 3);

    }
    // viewing books
    static void viewbooks() {
        System.out.println("\n--- BOOK CATALOGUE ---");
        for (int i = 0; i < bookIDs.length; i++) {
            String status = bookAvailable[i] ? "Available" : "Borrowed";
            System.out.println(bookIDs[i] + " | " + bookTitles[i] + " | " + bookAuthors[i] + " | " + bookGenres[i] + " | " + status);
        }

    }
    // book entry
    static void addBook() {
        scanner.nextLine();
        System.out.println("Enter Book ID: ");
        String id = scanner.nextLine();
        System.out.println("Enter Title: ");
        String title  = scanner.nextLine();
        System.out.println("Enter Author: ");
        String author  = scanner.nextLine();
        System.out.println("Enter Genre: ");
        String genre  = scanner.nextLine();

            for (int i = 0; i < bookIDs.length;  i++) {
                if (bookIDs[i] == null) {
                    bookIDs[i] = id;
                    bookTitles[i] = title;
                    bookAuthors[i] = author;
                    bookGenres[i] = genre;
                    bookAvailable[i] = true;
                    System.out.println("Book added successfully!");
                    return;
                }
            }
            System.out.println("Catalogue is full.");
        }
    }

