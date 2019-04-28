import java.util.ArrayList; 

public class NullDinerMenu {
    private ArrayList<MenuItem> appetizers = new ArrayList<MenuItem>();
    private ArrayList<MenuItem> sandwiches = new ArrayList<MenuItem>();
    private ArrayList<MenuItem> burgers = new ArrayList<MenuItem>();
    private ArrayList<MenuItem> drinks = new ArrayList<MenuItem>();
    private ArrayList<MenuItem> desserts = new ArrayList<MenuItem>();

    public NullDinerMenu() {
        fillMenu();
    }

    public void fillMenu() {
        //appetizers
        appetizers.add(new MenuItem("Appetizer", "Chicken Tenders", 2.99)); // #0
        appetizers.add(new MenuItem("Appetizer", "Onion Rings", 2.99)); //#1
        appetizers.add(new MenuItem("Appetizer", "Mozzarella Sticks", 2.99)); //#2

        // sandwiches
        sandwiches.add(new MenuItem("Sandwich", "Null Reuben", 6.99)); // #0
        sandwiches.add(new MenuItem("Sandwich", "Tuna Sandwich", 6.99)); // #1

        // burgers
        burgers.add(new MenuItem("Burger", "Null Burger", 7.99)); // #0

        // drinks
        drinks.add(new MenuItem("Drink", "Nullka Cola", 1.25)); // #0

        // desserts
        desserts.add(new MenuItem("Dessert", "Cherry Pie", 2.99)); // #0
    }

    public MenuItem getAppetizer(int itemNum) { // get an appetizer
        return appetizers.get(itemNum);
    }

    public MenuItem getSandwich(int itemNum) {
        return sandwiches.get(itemNum);
    }

    public MenuItem getBurger(int itemNum) {
        return burgers.get(itemNum);
    }

    public MenuItem getDrink(int itemNum) {
        return drinks.get(itemNum);
    }

    public MenuItem getDessert(int itemNum) {
        return desserts.get(itemNum);
    }
}