import java.text.NumberFormat;

public class MenuItem {
    private String itemType;
    private String itemName;
    private double price;
    private NumberFormat nf = NumberFormat.getCurrencyInstance();

    public MenuItem(String itemTypeIn, String itemNameIn, double priceIn) {
        this.itemType = itemTypeIn;
        this.itemName = itemNameIn;
        this.price = priceIn;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return itemName + ",    " + nf.format(price) + "\n";
    }

    // to-do: have item descriptions
}