import java.util.Scanner;

public class NullDiner {
    public static void main(String[] args) {
        NullDinerMenu menu = new NullDinerMenu();
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO NULL DINER!");
        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        Order order = new Order(name);

        while (order.getOrderSize() < 5) {
            System.out.println("Enter item number: ");
            int itemNum = sc.nextInt();
            MenuItem orderedItem = menu.getAppetizer(itemNum);
            order.addItem(orderedItem);
        }
        
        System.out.println(order);

    }
}