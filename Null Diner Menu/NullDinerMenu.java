/******************************************************************************
 * Copyright (C) 2019 Eric Pogue.
 * 
 * This file and the NullDinerMenuLite applciation is liscensed under the 
 * BSD-3-Clause.
 * 
 * You may use any part of the file as long as you give credit in your 
 * source code.
 * 
 * This application utilizes the HttpRequest.java library developed by 
 * Eric Pogue
 * 
 *****************************************************************************/
 
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

import java.util.ArrayList;

class ContactTile extends JPanel {
    private NullDinerMenuContact itemInMenu = null;


    ContactTile() {
        super();
    }

    ContactTile(NullDinerMenuContact itemInMenuIn) {
        super();
        itemInMenu = itemInMenuIn;
    }

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
}

class NullDinerMenuFrame extends JFrame implements ActionListener {
    private ArrayList<ContactTile> tileList;
    int test = 0;

    public NullDinerMenuFrame() {
        setBounds(200,200,1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JPanel contactGridPanel = new JPanel();
        contentPane.add(contactGridPanel, BorderLayout.CENTER);
        contactGridPanel.setLayout(new GridLayout(4,8));        

        JButton checkoutButton = new JButton("Check Out");
        buttonPanel.add(checkoutButton);
        checkoutButton.addActionListener(this);

        NullDinerMenuModel ndmM = new NullDinerMenuModel();
        ndmM.LoadIndex();
        ndmM.LoadContactsThreaded();

        System.out.println("Printing Menu Item:");
        System.out.println(ndmM);

        tileList = new ArrayList<ContactTile>();
        if ((test%2) == 0) {
            for (int i=1; i<33; i++) {
                NullDinerMenuContact itemInMenu = ndmM.findItemInMenu(i);
                if (itemInMenu != null) {
                    System.out.println(itemInMenu);
                }

                ContactTile tile = new ContactTile(itemInMenu);

                tileList.add(tile);
                contactGridPanel.add(tile);
            }
        } else {
            for (int i=32; i>0; i--) {
                NullDinerMenuContact itemInMenu = ndmM.findItemInMenu(i);
                if (itemInMenu != null) {
                    System.out.println(itemInMenu);
                }

                ContactTile tile = new ContactTile(itemInMenu);

                tileList.add(tile);
                contactGridPanel.add(tile);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

        System.out.println("Checking out");
        

        repaint();
    }

}

public class NullDinerMenu {
    public static void main(String[] args) {
        System.out.println("NullDinerMenu Starting...");

        NullDinerMenuFrame myNullDinerMenuFrame = new NullDinerMenuFrame();
        myNullDinerMenuFrame.setVisible(true);
    }
}