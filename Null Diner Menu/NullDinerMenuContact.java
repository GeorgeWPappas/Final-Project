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
    private String itemName;
    public String getItemName() { return itemName; }

    private String itemPrice;
    public String getItemPrice() {return itemPrice; }

    private String preferredName;
    public String getPreferredName() {return preferredName; }

    private String email;
    public String getEmail() {return email; }
    
    private int seatLocation; 
    public int getSeat() { return seatLocation; }

    NullDinerMenuContact(String urlIn) {
        super(urlIn);

        itemName = "";
        itemPrice = "";
        preferredName = "";
        email = "";
        seatLocation = 0;
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
                if (subString[1].equals("preferredName")) {
                    preferredName = subString[3];
                }
                if (subString[1].equals("email")) {
                    email = subString[3];
                }
                if (subString[1].equals("seatLocation")) {
                    try {
                        seatLocation = 0; 
                        if (!subString[3].equals("")) {
                            seatLocation = Integer.parseInt(subString[3]);
                        }
                    }
                    catch (Exception e) {
                        System.out.println("Exception: " + e);
                    }
                }
            }
        }    
    }

    public void Validate() {
        if (urlContent.size() < 1) {
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: No content loaded\n");
            return; // Returning from the middle of a method is controversial.
        }

        if (itemName.length() == 0) {
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: First Name (\"itemName\") required but not found\n\n");
            System.out.println("Contact's last name : " + itemPrice);
            System.out.println("Contact's email: " + email + "\n");
            System.out.println(this);
        } else if (itemPrice.length() == 0) {
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: Last Name (\"itemPrice\") required but not found\n\n");
            System.out.println("Contact's first name : " + itemName);
            System.out.println("Contact's email: " + email + "\n");
            System.out.println(this);          
        } else {
            System.out.println("Validating: " + requestURL + "... Passed!");
        }
    }

    public String toString() {
        String returnString = "itemName: " + itemName + "\n";
        returnString = returnString + "itemPrice: " + itemPrice + "\n";
        returnString = returnString + "preferredName: " + preferredName + "\n";
        returnString = returnString + "email: " + email + "\n";
        returnString = returnString + "seatNumber: " + seatLocation + "\n";
        returnString = returnString + super.toString();

        return returnString;
    }

    public void run() {
        Load();
    }
}