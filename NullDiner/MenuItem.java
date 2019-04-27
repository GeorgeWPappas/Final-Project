public class MenuItem {
    private String itemType;
    private String itemName;
    private double price;

    public MenuItem(String itemTypeIn, String itemNameIn, double priceIn) {
        this.itemType = itemTypeIn;
        this.itemName = itemNameIn;
        this.price = priceIn;
    }

    public String toString() {
        return itemName + ",    $" + price + "\n";
    }
}