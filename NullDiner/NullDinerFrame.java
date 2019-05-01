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

class ItemTile extends JPanel implements MouseListener {
    //private NullDinerMenuContact itemInMenu = null;

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

    /*ItemTile(NullDinerMenuContact itemInMenuIn) {
        super();
        itemInMenu = itemInMenuIn;
        if(contactInSeat != null) {
            addMouseListener(this);
        }
    }*/

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

        g.setColor(new Color(146,255,59)); // This RGB are for the names.

        final int fontSize=18;
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        int stringX = (panelWidth/2)-60;
        int stringY = (panelHeight/2)+30;
        
        /*if (itemInMenu != null) {
            String printedName = itemInMenu.getPreferredName();
            g.drawString(printedName,stringX,stringY);
        }*/
    }

    public void mousePressed(MouseEvent me) {
        //JOptionPane.showMessageDialog(new JFrame(), contactInSeat, contactInSeat.getPreferredName(), JOptionPane.PLAIN_MESSAGE);
    }

    public void mouseReleased(MouseEvent me) {}
    public void mouseClicked(MouseEvent me) {}
    public void mouseExited(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {}
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
            }
        });

        // to-do: - Add tiles that add item to order
        // - have a jpanel or jpanels that display and update the customer's order everytime
        // a change is made
        // - be able to remove items by clicking on the ordered item

        appTileList = new ArrayList<ItemTile>();
        for (MenuItem app : menu.getAppArray()) {
            ItemTile appTile = new ItemTile();
            appTile.setAppetizer();
            appTileList.add(appTile);
            itemGridPanel.add(appTile);
        }

        sandTileList = new ArrayList<ItemTile>();
        for (MenuItem s : menu.getSandArray()) {
            ItemTile sandTile = new ItemTile();
            sandTile.setSandwich();
            sandTileList.add(sandTile);
            itemGridPanel.add(sandTile);
        }

        burgTileList = new ArrayList<ItemTile>();
        for (MenuItem b : menu.getBurgArray()) {
            ItemTile burgTile = new ItemTile();
            burgTile.setBurger();
            burgTileList.add(burgTile);
            itemGridPanel.add(burgTile);
        }

        drinkTileList = new ArrayList<ItemTile>();
        for (MenuItem dr : menu.getDrinkArray()) {
            ItemTile drinkTile = new ItemTile();
            drinkTile.setDrink();
            drinkTileList.add(drinkTile);
            itemGridPanel.add(drinkTile);
        }

        dessTileList = new ArrayList<ItemTile>();
        for (MenuItem des : menu.getDessArray()) {
            ItemTile dessTile = new ItemTile();
            dessTile.setDessert();
            dessTileList.add(dessTile);
            itemGridPanel.add(dessTile);
        }

        // String itemInMenu = null;

        /*
        for (int i=0; i<15; i++) {
            //NullDinerMenuContact itemInMenu = ndmM.findItemInMenu(i);
            if (itemInMenu != null) {
                System.out.println();
            }

            ItemTile tile = new ItemTile();

            if ((i==0)||(i==1)||(i==2)) {
                tile.setAppetizer();
            }
            if ((i==3)||(i==4)||(i==5)) {
                tile.setSandwich();
            }
            if ((i==6)||(i==7)||(i==8)) {
                tile.setBurger();
            }
            if ((i==9)||(i==10)||(i==11)) {
                tile.setDrink();
            }
            if ((i==12)||(i==13)||(i==14)) {
                tile.setDessert();
            }

            tileList.add(tile);
            itemGridPanel.add(tile);
        } */
    }
}