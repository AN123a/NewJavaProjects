package tnsiftasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    private String isbn;
    private String title;
    private String author;
    private double price;

    public Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}

class Bookstore {
    private Map<String, Book> bookInventory;
    private Map<String, Integer> shoppingCart;

    public Bookstore() {
        this.bookInventory = new HashMap<>();
        this.shoppingCart = new HashMap<>();
    }

    public void registerBook(String isbn, String title, String author, double price) {
        Book newBook = new Book(isbn, title, author, price);
        bookInventory.put(isbn, newBook);
        System.out.println("Book registered successfully.");
    }

    public void searchBook(String isbn) {
        if (bookInventory.containsKey(isbn)) {
            Book foundBook = bookInventory.get(isbn);
            System.out.println("Book Details:");
            System.out.println("ISBN: " + foundBook.getIsbn());
            System.out.println("Title: " + foundBook.getTitle());
            System.out.println("Author: " + foundBook.getAuthor());
            System.out.println("Price: $" + foundBook.getPrice());
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0.0;
        for (Book book : bookInventory.values()) {
            totalRevenue += book.getPrice();
        }
        return totalRevenue;
    }

    public void addToShoppingCart(String isbn, int quantity) {
        if (bookInventory.containsKey(isbn)) {
            shoppingCart.put(isbn, shoppingCart.getOrDefault(isbn, 0) + quantity);
            System.out.println("Book added to the shopping cart.");
        } else {
            System.out.println("Book with ISBN " + isbn + " not found in the inventory.");
        }
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (Map.Entry<String, Integer> entry : shoppingCart.entrySet()) {
            String isbn = entry.getKey();
            int quantity = entry.getValue();
            Book book = bookInventory.get(isbn);
            totalCost += book.getPrice() * quantity;
        }
        return totalCost;
    }
}

public class test_case6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bookstore bookstore = new Bookstore();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Register a new book");
            System.out.println("2. Search for a book");
            System.out.println("3. Calculate total revenue");
            System.out.println("4. Add books to shopping cart");
            System.out.println("5. Calculate total cost in shopping cart");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();

                    bookstore.registerBook(isbn, title, author, price);
                    break;
                case 2:
                    System.out.print("Enter ISBN to search: ");
                    isbn = scanner.nextLine();
                    bookstore.searchBook(isbn);
                    break;
                case 3:
                    double totalRevenue = bookstore.calculateTotalRevenue();
                    System.out.println("Total Revenue: $" + totalRevenue);
                    break;
                case 4:
                    System.out.print("Enter ISBN to add to the shopping cart: ");
                    isbn = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    bookstore.addToShoppingCart(isbn, quantity);
                    break;
                case 5:
                    double totalCost = bookstore.calculateTotalCost();
                    System.out.println("Total Cost in Shopping Cart: $" + totalCost);
                    break;
                case 6:
                    System.out.println("Exiting the program. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            scanner.close();
        }
    }
}
