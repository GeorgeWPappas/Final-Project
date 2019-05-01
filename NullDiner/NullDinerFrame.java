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


    ItemTile() {
        super();
    }

    /*ItemTile(NullDinerMenuContact itemInMenuIn) {
        super();
        itemInMenu = itemInMenuIn;
    }*/

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();


        g.setColor(new Color(23,95,210)); // This RGB are for the seats.

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
    private ArrayList<ItemTile> tileList;

    NullDinerFrame(Order order) {
        setBounds(200,200,1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JPanel itemGridPanel = new JPanel();
        contentPane.add(itemGridPanel, BorderLayout.CENTER);
        itemGridPanel.setLayout(new GridLayout(4,8));

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

        tileList = new ArrayList<ItemTile>();
        String itemInMenu = null;
 
        for (int i=1; i<33; i++) {
            //NullDinerMenuContact itemInMenu = ndmM.findItemInMenu(i);
            if (itemInMenu != null) {
                System.out.println();
            }

            ItemTile tile = new ItemTile();

            tileList.add(tile);
            itemGridPanel.add(tile);
        }
    }
}