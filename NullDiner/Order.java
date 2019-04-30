import java.util.ArrayList;
import java.text.NumberFormat;

public class Order {
    private String customerName;
    private ArrayList<MenuItem> orderList = new ArrayList<MenuItem>();
    private NumberFormat nf = NumberFormat.getCurrencyInstance();
    private double total;
    private double tax;
    private double subtotal;
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

    /*public int getOrderSize() {
        return orderList.size();
    } */

    public void calcTotal() {
        total = 0; // reset the total
        for (MenuItem item : orderList) {
            total += item.getPrice();
        }
    }

    public void calcTax() {
        calcTotal();
        tax = total * 0.0625;
    }

    public void calcSubtotal() {
        subtotal = tax + total;
    }

    public Boolean getCheckoutStatus() {
        return checkedOut;
    }

    public Boolean checkout() {
        checkedOut = true;
        return checkedOut;
    }

    public String toString() {
        String printOrder = "\n**************************\nName: " + customerName + "\n**************************\n";
        for (MenuItem item : orderList) {
            printOrder += item;
        }

        printOrder += "**************************\nTotal: " + nf.format(total);
        printOrder += "\nTax: " + nf.format(tax);
        printOrder += "\nSubtotal: " + nf.format(subtotal) + "\n**************************\n";

        return printOrder;
    }

}