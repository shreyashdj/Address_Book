package com.bridgelabz.addressBook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author - SHREYASH JADHAV
 */
public class AddressBook {
    /**
     *  created scan object of class Scanner
     *  declared variable contactList of type ArrayList<Contact>
     *  created addressBookList object of class HashMap<String, ArrayList<Contact>>
     */
    Scanner scan = new Scanner(System.in);
    ArrayList<Contact> contactList;
    static HashMap<String, ArrayList<Contact>> addressBookList = new HashMap<>();
    /**
     *  created addDetails method to add contact details
     *  taking parameters => String firstName, String lastName, ArrayList<Contact> contactList 
     */
    public void addDetails(String firstName, String lastName, ArrayList<Contact> contactList) {
        /*
         *  created contact object of class Contact
         *  taking user input to set contact details
         *  then adding contact to contactList
         *  created object of class FileIO
         *  call method writeAddressBook and pass String representation of contact object
         */
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        System.out.print(" Enter Address    : ");
        contact.setAddress(scan.next());
        System.out.print(" Enter City Name  : ");
        contact.setCity(scan.next());
        System.out.print(" Enter State Name : ");
        contact.setState(scan.next());
        System.out.print(" Enter Zip code   : ");
        contact.setZipCode(scan.next());
        System.out.print(" Enter Phone No.  : ");
        contact.setPhoneNumber(scan.next());
        System.out.print(" Enter Email Id   : ");
        contact.setEmailId(scan.next());
        contactList.add(contact);
        FileIO fileIO = new FileIO();
        try {
			fileIO.writeAddressBook(contact.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    /**
     *	created editDetails method to edit details of contact
     *	taking parameter => contact of type Contact
     */
    public void editDetails(Contact contact) {
        /*
         *	If parameter contact is not null then run do-while loop till exit option entered
         *	In loop using switch case we give separate options to edit different contact details
         *	If contact parameter is null print "Contact Not Found"
         */
        if (contact != null) {
            int option;
            do {
                System.out.println("\n *** Available Options to Change *** ");
                System.out.println(" 1. Name \n 2. Address \n 3. City \n 4. State "
                        + "\n 5. Zip code \n 6. Phone No. \n 7. Email Id \n 8. Exit");
                System.out.print(" Enter option : ");
                option = scan.nextInt();
                switch (option) {
                    case 1 -> {
                        System.out.print("\n Enter First Name : ");
                        String firstName = scan.next();
                        System.out.print(" Enter Last Name  : ");
                        String lastName = scan.next();
                        if(searchContact(firstName, lastName) == null) {
                            contact.setFirstName(firstName);
                            contact.setLastName(lastName);
                        } else {
                            System.out.println("\n Contact Already Available");
                        }

                    } case 2 -> {
                        System.out.print("\n Enter Address    : ");
                        contact.setAddress(scan.next());
                    } case 3 -> {
                        System.out.print("\n Enter City Name  : ");
                        contact.setCity(scan.next());
                    } case 4 -> {
                        System.out.print("\n Enter State Name : ");
                        contact.setState(scan.next());
                    } case 5 -> {
                        System.out.print("\n Enter Zip code   : ");
                        contact.setZipCode(scan.next());
                    } case 6 -> {
                        System.out.print("\n Enter Phone No.  : ");
                        contact.setPhoneNumber(scan.next());
                    } case 7 -> {
                        System.out.print("\n Enter Email Id   : ");
                        contact.setEmailId(scan.next());
                    } case 8 -> {
                        System.out.println("\n Contact Edited Successfully");
                    } default -> System.out.println("\n Invalid Option");
                }
            }while(option != 8);

        } else {
            System.out.println("\n Contact Not Found");
        }
    }
    /**
     *  created deleteContact method to delete contact
     *  taking parameter => contact of type Contact
     */
    public void deleteContact(Contact contact) {
        /*
         * 	if parameter contact is not null
         *  then delete contact from contactList.
         *  else print "Contact Not Found"
         */
        if (contact != null) {
            contactList.remove(contact);
            System.out.println("\n Contact Deleted Successfully");
        } else {
            System.out.println("\n Contact not found!");
        }
    }
    /**
     *  created searchContact method to search contact by name
     *  taking parameters => String firstName, String lastName
     */
    public Contact searchContact(String firstName, String lastName) {
        /*
         *	taking user input of first name of contact
         *	Iterating addressBookList (HashMap) and one by one taking contactList (ArrrayList)
         *	and for each contact of contactList matching firstName of contact
         *	if it matches then return contact else return null
         */
        for(Map.Entry<String, ArrayList<Contact>> temp : addressBookList.entrySet()){
            contactList = temp.getValue();
            for(Contact contact : contactList) {
                if(contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                    return contact;
                }
            }
        }
        return null;
    }
}