import java.util.ArrayList;
import java.util.Scanner;

class Item {
    String name;
    double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {

        ArrayList<Item> cart = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ONLINE SHOPPING CART =====");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Search Item");
            System.out.println("4. Display Cart");
            System.out.println("5. Calculate Total Price");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();  // buffer clear

            switch (choice) {

                case 1:
                    System.out.print("Enter item name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter item price: ");
                    double price = sc.nextDouble();
                    cart.add(new Item(name, price));
                    System.out.println("Item added successfully!");
                    break;

                case 2:
                    System.out.print("Enter item name to remove: ");
                    String rname = sc.nextLine();
                    boolean removed = false;

                    for (int i = 0; i < cart.size(); i++) {
                        if (cart.get(i).name.equalsIgnoreCase(rname)) {
                            cart.remove(i);
                            removed = true;
                            System.out.println("Item removed successfully!");
                            break;
                        }
                    }
                    if (!removed) System.out.println("Item not found!");
                    break;

                case 3:
                    System.out.print("Enter item name to search: ");
                    String sname = sc.nextLine();
                    boolean found = false;

                    for (Item item : cart) {
                        if (item.name.equalsIgnoreCase(sname)) {
                            System.out.println("Item found: " + item.name + " - Rs. " + item.price);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Item not found!");
                    break;

                case 4:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        System.out.println("\nItems in Cart:");
                        for (Item item : cart) {
                            System.out.println(item.name + " - Rs. " + item.price);
                        }
                    }
                    break;

                case 5:
                    double total = 0;
                    for (Item item : cart) {
                        total += item.price;
                    }
                    System.out.println("Total Price: Rs. " + total);
                    break;

                case 6:
                    System.out.println("Thank you for using Shopping Cart!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
