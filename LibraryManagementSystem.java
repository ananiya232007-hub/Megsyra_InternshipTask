package library;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== DIGITAL LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;

                case 2:
                    searchBook();
                    break;

                case 3:
                    displayBooks();
                    break;

                case 4:
                    issueBook();
                    break;

                case 5:
                    returnBook();
                    break;

                case 6:
                    System.out.println("Thank you for using Library Management System!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);
    }

    public static void addBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, name, author));

        System.out.println("Book Added Successfully!");
    }

    public static void searchBook() {

        System.out.print("Enter Book ID to Search: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.bookId == id) {
                book.displayBook();
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    public static void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No Books Available!");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }
    }

    public static void issueBook() {

        System.out.print("Enter Book ID to Issue: ");
        int id = sc.nextInt();

        for (Book book : books) {

            if (book.bookId == id) {

                if (!book.isIssued) {
                    book.isIssued = true;
                    System.out.println("Book Issued Successfully!");
                } else {
                    System.out.println("Book Already Issued!");
                }

                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    public static void returnBook() {

        System.out.print("Enter Book ID to Return: ");
        int id = sc.nextInt();

        for (Book book : books) {

            if (book.bookId == id) {

                if (book.isIssued) {
                    book.isIssued = false;
                    System.out.println("Book Returned Successfully!");
                } else {
                    System.out.println("Book is Already Available!");
                }

                return;
            }
        }

        System.out.println("Book Not Found!");
    }
}
