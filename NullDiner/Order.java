import java.util.ArrayList;
import java.text.NumberFormat;

public class Order {
    private String customerName;
    private ArrayList<MenuItem> orderList = new ArrayList<MenuItem>();
    private NumberFormat nf = NumberFormat.getCurrencyInstance();
    private double total;
    private Boolean checkedOut;

    public Order(String nameIn) {
        this.customerName = nameIn;
        this.checkedOut = false;
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
        total = 0;
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
        String printOrder = "\nName: " + customerName + "\n";
        for (MenuItem item : orderList) {
            printOrder = printOrder + orderList.indexOf(item) + " " + item;
        }

        printOrder += "\nTotal: " + nf.format(total) + "\n";

        return printOrder;
    }

}