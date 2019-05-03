import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container; 
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

import java.util.ArrayList;

class ItemTile extends JPanel /* implements MouseListener */{
    private MenuItem item = null;

    private Boolean isAppetizer = false;
    public void setAppetizer() { isAppetizer = true; }

    private Boolean isSandwich = false;
    public void setSandwich() { isSandwich = true; }

    private Boolean isBurger = false;
    public void setBurger() { isBurger = true; }

    private Boolean isDrink = false;
    public void setDrink() { isDrink = true; }

    private Boolean isDessert = false;
    public void setDessert() { isDessert = true; }

    ItemTile() {
        super();
    }

    ItemTile(MenuItem itemIn) {
        super();
        item = itemIn;
        
        /*
        if (item != null) {
            addMouseListener(this); 
        }  */
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        if (isAppetizer) {
            g.setColor(new Color(255,140,0)); // Sets Appetizer to Orange.
        } else if (isSandwich) {
            g.setColor(new Color(175,31,36)); // Sets Sandwich to Red.
        } else if (isBurger) {
            g.setColor(new Color(11,91,170)); // Stes Burger to Blue.
        } else if (isDrink) {
            g.setColor(new Color(255,255,0)); // Sets Drink to Yellow.
        } else if (isDessert) {
            g.setColor(new Color(0,204,0)); // Sets Dessert to Green.
        }

        g.fillRect (10, 10, panelWidth-20, panelHeight-20);

        g.setColor(new Color(0,0,0)); // Sets Text to Black.

        final int fontSize=18;
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        int stringX = (panelWidth/2)-60;
        int stringY = (panelHeight/2)+30;
        
        if (item != null) {
            String printedName = item.toString();
            g.drawString(printedName,stringX,stringY);
        }
    }

    /*
    public void mousePressed(MouseEvent me) {
        System.out.println("test");
        //JOptionPane.showMessageDialog(new JFrame(), contactInSeat, contactInSeat.getPreferredName(), JOptionPane.PLAIN_MESSAGE);
    } */

    /*
    public void mouseReleased(MouseEvent me) {}
    public void mouseClicked(MouseEvent me) {}
    public void mouseExited(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {} */
}

public class NullDinerFrame extends JFrame {
    // arraylists to hold tiles on the menu
    private ArrayList<ItemTile> appTileList;
    private ArrayList<ItemTile> sandTileList;
    private ArrayList<ItemTile> burgTileList;
    private ArrayList<ItemTile> drinkTileList;
    private ArrayList<ItemTile> dessTileList;

    private Order order;
    private NullDinerMenu menu;

    NullDinerFrame(Order orderIn, NullDinerMenu menuIn) {
        order = orderIn;    
        menu = menuIn;

        setBounds(200,200,1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JPanel itemGridPanel = new JPanel();
        contentPane.add(itemGridPanel, BorderLayout.CENTER);
        itemGridPanel.setLayout(new GridLayout(5,3));

        JButton checkoutButton = new JButton("Checkout");
        buttonPanel.add(checkoutButton);
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    
                order.checkout();
                System.out.println("CHECKING OUT... Press enter to continue.");
                buttonPanel.remove(checkoutButton);
                setVisible(false);
                dispose();
            }
        });

        // Fills out the frame with menu items
        appTileList = new ArrayList<ItemTile>();
        for (int i=0; i<menu.getAppArray().size(); i++) {
            MenuItem ap = menu.getAppetizer(i);
            ItemTile appTile = new ItemTile(ap);

            appTile.addMouseListener(new MouseListener() {
                public void mousePressed(MouseEvent me) {
                    order.getOrderList().add(ap);
                    System.out.println("Item added.");
                    order.calcTotal();
                    order.calcTax();
                    order.calcSubtotal();
                    System.out.println(order);
                }

                public void mouseReleased(MouseEvent me) {}
                public void mouseClicked(MouseEvent me) {}
                public void mouseExited(MouseEvent me) {}
                public void mouseEntered(MouseEvent me) {} 
            });

            appTile.setAppetizer();
            appTileList.add(appTile);
            itemGridPanel.add(appTile);
        }

        sandTileList = new ArrayList<ItemTile>();
        for (int i=0; i<menu.getSandArray().size(); i++) {
            MenuItem s = menu.getSandwich(i);
            ItemTile sandTile = new ItemTile(s);

            sandTile.addMouseListener(new MouseListener() {
                public void mousePressed(MouseEvent me) {
                    order.getOrderList().add(s);
                    System.out.println("Item added.");
                    order.calcTotal();
                    order.calcTax();
                    order.calcSubtotal();
                    System.out.println(order);
                }

                public void mouseReleased(MouseEvent me) {}
                public void mouseClicked(MouseEvent me) {}
                public void mouseExited(MouseEvent me) {}
                public void mouseEntered(MouseEvent me) {} 
            });

            sandTile.setSandwich();
            sandTileList.add(sandTile);
            itemGridPanel.add(sandTile);
        }

        burgTileList = new ArrayList<ItemTile>();
        for (int i=0; i<menu.getBurgArray().size(); i++) {
            MenuItem b = menu.getBurger(i);
            ItemTile burgTile = new ItemTile(b);

            burgTile.addMouseListener(new MouseListener() {
                public void mousePressed(MouseEvent me) {
                    order.getOrderList().add(b);
                    System.out.println("Item added.");
                    order.calcTotal();
                    order.calcTax();
                    order.calcSubtotal();
                    System.out.println(order);
                }

                public void mouseReleased(MouseEvent me) {}
                public void mouseClicked(MouseEvent me) {}
                public void mouseExited(MouseEvent me) {}
                public void mouseEntered(MouseEvent me) {} 
            });

            burgTile.setBurger();
            burgTileList.add(burgTile);
            itemGridPanel.add(burgTile);
        }

        drinkTileList = new ArrayList<ItemTile>();
        for (int i=0; i<menu.getDrinkArray().size(); i++) {
            MenuItem dr = menu.getDrink(i);
            ItemTile drinkTile = new ItemTile(dr);

            drinkTile.addMouseListener(new MouseListener() {
                public void mousePressed(MouseEvent me) {
                    order.getOrderList().add(dr);
                    System.out.println("Item added.");
                    order.calcTotal();
                    order.calcTax();
                    order.calcSubtotal();
                    System.out.println(order);
                }

                public void mouseReleased(MouseEvent me) {}
                public void mouseClicked(MouseEvent me) {}
                public void mouseExited(MouseEvent me) {}
                public void mouseEntered(MouseEvent me) {} 
            });

            drinkTile.setDrink();
            drinkTileList.add(drinkTile);
            itemGridPanel.add(drinkTile);
        }

        dessTileList = new ArrayList<ItemTile>();
        for (int i=0; i<menu.getDessArray().size(); i++) {
            MenuItem ds = menu.getDessert(i);
            ItemTile dessTile = new ItemTile(ds);

            dessTile.addMouseListener(new MouseListener() {
                public void mousePressed(MouseEvent me) {
                    order.getOrderList().add(ds);
                    System.out.println("Item added.");
                    order.calcTotal();
                    order.calcTax();
                    order.calcSubtotal();
                    System.out.println(order);
                }

                public void mouseReleased(MouseEvent me) {}
                public void mouseClicked(MouseEvent me) {}
                public void mouseExited(MouseEvent me) {}
                public void mouseEntered(MouseEvent me) {} 
            });

            dessTile.setDessert();
            dessTileList.add(dessTile);
            itemGridPanel.add(dessTile);
        }
    }
}