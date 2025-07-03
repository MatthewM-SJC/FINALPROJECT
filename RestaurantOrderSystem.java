import java.util.ArrayList;

public class RestaurantOrderSystem {
    static ArrayList<String> pendingOrders = new ArrayList<>();
    static String[] completedOrders = new String[100];
    static int completedIndex = 0;

    public static void main(String[] args) {
        pendingOrders = FileHandler.loadList("pending.txt");
        ArrayList<String> loadedCompleted = FileHandler.loadList("completed.txt");
        for (String order : loadedCompleted) {
            if (completedIndex < completedOrders.length) {
                completedOrders[completedIndex++] = order;
            }
        }

        int choice;
        do {
            showMenu();
            choice = InputValidator.getIntInput("Choose an option: ");
            switch (choice) {
                case 1 -> addOrder();
                case 2 -> completeOrder();
                case 3 -> viewOrders();
                case 4 -> exitAndSave();
                default -> System.out.println("Invalid option. Try again.");
            }
        } while (choice != 4);
    }

    public static void showMenu() {
        System.out.println("\nRestaurant Order System");
        System.out.println("1. Add New Order");
        System.out.println("2. Complete an Order");
        System.out.println("3. View All Orders");
        System.out.println("4. Exit");
    }

    public static void addOrder() {
        String order = InputValidator.getStringInput("Enter new order: ");
        pendingOrders.add(order);
        System.out.println("Order added.");
    }

    public static void completeOrder() {
        if (pendingOrders.isEmpty()) {
            System.out.println("No pending orders to complete.");
            return;
        }

        System.out.println("\nPending Orders:");
        for (int i = 0; i < pendingOrders.size(); i++) {
            System.out.println(i + ": " + pendingOrders.get(i));
        }

        int index = InputValidator.getIntInput("Enter the index of the order to complete: ");
        try {
            String completed = pendingOrders.remove(index);
            if (completedIndex < completedOrders.length) {
                completedOrders[completedIndex++] = completed;
                System.out.println("Order completed.");
            } else {
                System.out.println("Completed order storage full.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index.");
        }
    }

    public static void viewOrders() {
        System.out.println("\nPending Orders:");
        if (pendingOrders.isEmpty()) {
            System.out.println("None");
        } else {
            for (String order : pendingOrders) {
                System.out.println("- " + order);
            }
        }

        System.out.println("\nCompleted Orders:");
        boolean any = false;
        for (String order : completedOrders) {
            if (order != null) {
                System.out.println("- " + order);
                any = true;
            }
        }
        if (!any) System.out.println("None");
    }

    public static void exitAndSave() {
        FileHandler.saveList(pendingOrders, "pending.txt");
        ArrayList<String> completedList = new ArrayList<>();
        for (String order : completedOrders) {
            if (order != null) completedList.add(order);
        }
        FileHandler.saveList(completedList, "completed.txt");
        System.out.println("Orders saved. Goodbye!");
    }
}