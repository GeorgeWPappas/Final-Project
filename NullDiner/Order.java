import java.util.ArrayList;
import java.text.NumberFormat;

public class Order {
    private String customerName;
    private ArrayList<MenuItem> orderList = new ArrayList<MenuItem>();
    private NumberFormat nf = NumberFormat.getCurrencyInstance();
    private double total;
    private Boolean checkedOut = false;

    public Order(String nameIn) {
        this.customerName = nameIn;
    }

    public MenuItem getItem(int itemNumber) {
        return orderList.get(itemNumber);
    }

    public void addItem(MenuItem item) {
        orderList.add(item);
    }

    public void removeItem(MenuItem item) {
        orderList.remove(item);
    }

    public int getOrderSize() {
        return orderList.size();
    }

    public double calcTotal() {
        for (MenuItem item : orderList) {
            total += item.getPrice();
        }
        return total;
    }

    public Boolean getCheckoutStatus() {
        return checkedOut;
    }

    public Boolean checkout() {
        checkedOut = true;
        return checkedOut;
    }

    public String toString() {
        String printOrder = "Name: " + customerName + "\n";
        for (MenuItem item : orderList) {
            printOrder += item;
        }

        printOrder += "\nTotal: " + nf.format(calcTotal());

        return printOrder;
    }

}