import java.util.ArrayList;

public class coffeeShop {
    private String name;
    private ArrayList<String> menu;
    private ArrayList<String> orders;

    public coffeeShop(String name, ArrayList<String> menu) {
        this.name = name;
        this.menu = menu;
        this.orders = new ArrayList<String>();
    }

    public void addOrder(String order) {
        this.orders.add(order);
        System.out.println("Added order: " + order);
    }

    public void fulfillOrder() {
        try {
            String order = orders.remove(0);
            System.out.println("Fulfilled order: " + order);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No orders to fulfill.");
        }
    }

    public void listOrders() {
        if (orders.size() > 0) {
            System.out.println("Current orders:");
            for (String order : orders) {
                System.out.println("- " + order);
            }
        } else {
            System.out.println("No orders.");
        }
    }

    public double dueAmount() {
        double total = 0;
        for (String order : orders) {
            String[] parts = order.split(", ");
            try {
                total += Double.parseDouble(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid order format: " + order);
            }
        }
        return total;
    }

    public String cheaperItem() {
        String cheapest = "";
        double cheapestPrice = Double.MAX_VALUE;
        for (String item : menu) {
            String[] parts = item.split(", ");
            double price = Double.parseDouble(parts[1]);
            if (price < cheapestPrice) {
                cheapest = parts[0];
                cheapestPrice = price;
            }
        }
        return cheapest;
    }

    public void drinksOnly() {
        System.out.println("Drinks only:");
        for (String item : menu) {
            String[] parts = item.split(", ");
            if (parts[2].equals("drink")) {
                System.out.println("- " + item);
            }
        }
    }

    public void foodOnly() {
        System.out.println("Food only:");
        for (String item : menu) {
            String[] parts = item.split(", ");
            if (parts[2].equals("food")) {
                System.out.println("- " + item);
            }
        }
    }
}
