/******************************************************************************
 * Copyright (C) 2019 Eric Pogue.
 * 
 * This file is liscensed under the BSD-3-Clause
 * 
 * You may use any part of the file as long as you give credit in your 
 * source code.
 * 
 *****************************************************************************/

class NullDinerMenuContact extends HttpRequest implements Runnable {
    //------------------------------------------------------------------------
    // GWP: Wont be needed but to keep origional code working for now.
    private String itemName;
    public String getitemName() { return itemName; }

    private String itemPrice;
    public String getitemPrice() { return itemPrice; }

    private boolean customizeOption;
    public boolean getcustomizeOption() { return customizeOption; }
    
    private int itemNumber; 
    public int getItemNumber() { return itemNumber; }


    NullDinerMenuContact(String urlIn) {
        super(urlIn);

        itemName = "";
        itemPrice = "";
        customizeOption = false;
        itemNumber = 0;
    }

    public Boolean Load() {
        Boolean returnValue = false;
        System.out.println("Loading: " + requestURL);
        if (super.readURL()) {
            Parse(); 
            returnValue = true;
        }
        return returnValue;
    }

    public void Parse() {
        for (String s : urlContent) {
            String[] subString = s.split("\"");

            if (subString.length > 3) {
                if (subString[1].equals("itemName")) {
                    itemName = subString[3];
                }
                if (subString[1].equals("itemPrice")) {
                    itemPrice = subString[3];
                }
                /*if (subString[1].equals("customizeOption")) {
                    customizeOption = subString[3];
                }*/
                if (subString[1].equals("itemNumber")) {
                    try {
                        itemNumber = 0; 
                        if (!subString[3].equals("")) {
                            itemNumber = Integer.parseInt(subString[3]);
                        }
                    }
                    catch (Exception e) {
                        System.out.println("Exception: " + e);
                    }
                }
            }
        }    
    }

    public String toString() {
        String returnString = "itemName: " + itemName + "\n";
        returnString = returnString + "itemPrice: " + itemPrice + "\n";
        returnString = returnString + "customizeOption: " + customizeOption + "\n";
        returnString = returnString + "seatNumber: " + itemNumber + "\n";
        returnString = returnString + super.toString();

        return returnString;
    }

    public void run() {
        Load();
    }
}