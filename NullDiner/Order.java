import java.util.ArrayList;

public class Order {
private String customerName;
private ArrayList<MenuItem> orderList = new ArrayList<MenuItem>();

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

public String toString() {
    String printOrder = "";
    for (MenuItem item : orderList) {
        printOrder += item;
    }
    return printOrder;
}

}