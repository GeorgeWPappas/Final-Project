import java.util.Scanner;

public class NullDiner {
    public static void main(String[] args) {

        NullDinerMenu menu = new NullDinerMenu();
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO NULL DINER!");
        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        Order order = new Order(name);

        NullDinerFrame myFrame = new NullDinerFrame(order, menu);
        myFrame.setVisible(true);

        while (order.getCheckoutStatus() == false) {
            System.out.println(order);
            String keepGoing;
            //System.out.println("Press enter to add an item or click checkout: ");
            sc.nextLine();
            keepGoing = sc.nextLine();

            try {
                if (order.getCheckoutStatus() == true) { break; }
                
                /*
                System.out.println("Choose a category:\n");
                System.out.println("[0 APPETIZERS] [1 SANDWICHES] [2 BURGERS] [3 DRINKS] [4 DESSERTS]");
                int chooseCat = sc.nextInt();

                if (chooseCat==0) {
                    System.out.println("Enter item number (see menu): ");
                    int itemNum = sc.nextInt();
                    MenuItem orderedItem = menu.getAppetizer(itemNum);
                    order.addItem(orderedItem);
                    order.calcTotal();
                    order.calcTax();
                    order.calcSubtotal();
                } else if (chooseCat==1) {
                    System.out.println("Enter item number (see menu): ");
                    int itemNum = sc.nextInt();
                    MenuItem orderedItem = menu.getSandwich(itemNum);
                    order.addItem(orderedItem);
                    order.calcTotal();
                    order.calcTax();
                    order.calcSubtotal();
                } else if (chooseCat==2) {
                    System.out.println("Enter item number (see menu): ");
                    int itemNum = sc.nextInt();
                    MenuItem orderedItem = menu.getBurger(itemNum);
                    order.addItem(orderedItem);
                    order.calcTotal();
                    order.calcTax();
                    order.calcSubtotal();
                } else if (chooseCat==3) {
                    System.out.println("Enter item number (see menu): ");
                    int itemNum = sc.nextInt();
                    MenuItem orderedItem = menu.getDrink(itemNum);
                    order.addItem(orderedItem);
                    order.calcTotal();
                    order.calcTax();
                    order.calcSubtotal();
                } else if (chooseCat==4) {
                    System.out.println("Enter item number (see menu): ");
                    int itemNum = sc.nextInt();
                    MenuItem orderedItem = menu.getDessert(itemNum);
                    order.addItem(orderedItem);
                    order.calcTotal();
                    order.calcTax();
                    order.calcSubtotal();
                } else {
                    System.out.println("Invalid category number. Please enter 0,1,2,3,or 4");
                } */
            } catch (Exception e) {
                System.out.println("Item not found.");
            }
        }
        
        System.out.println("HERE'S YOUR RECEIPT... ENJOY!");
        System.out.println(order);

        myFrame.setVisible(false);
        myFrame.dispose();
        sc.close();
    }
}