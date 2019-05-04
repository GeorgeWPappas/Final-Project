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
            String keepGoing;
            keepGoing = sc.nextLine();

            try {
                if (order.getCheckoutStatus() == true) { break; }
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