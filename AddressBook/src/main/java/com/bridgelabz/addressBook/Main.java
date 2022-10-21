package com.bridgelabz.addressBook;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

/**
 * @author - SHREYASH JADHAV
 */
public class Main {
    /**
     *	created main method to run program
     */
    public static void main(String[] args) {
        /*
         *  printing welcome message
         *  created object of class Dictionary & class Print & class Sort
         *	used do-while loop and switch-case to make console for activities like
         *	Add AddressBook, Add Contact, Edit Contact, Delete, Print, Sort,
         *  Read AddressBook File, Read CSV file, Exit
         */
        System.out.println(" Welcome to Address Book Program");
        Dictionary dictionary = new Dictionary();
        Print print = new Print();
        Sort sort = new Sort();
        FileIO fileIO = new FileIO();
        try {
			fileIO.updateAddressBook();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        int option;		// variable to store value of console options
        do {
            System.out.println("\n *** Available Options *** ");
            System.out.println(" 1. Add AddressBook \n 2. Add Contact \n 3. Edit Contact" +
                    " \n 4. Delete \n 5. Print \n 6. Sort \n 7. Read AddressBook File" +
                    " \n 8. Read CSV file \n 10. Exit");
            System.out.print(" Enter option to perform activity : ");
            option = dictionary.scan.nextInt();
            switch (option) {
                case 1 -> dictionary.addAddressBook();
                case 2 -> dictionary.addContact();
                case 3 -> dictionary.editContact();
                case 4 -> dictionary.delete();
                case 5 -> print.print();
                case 6 -> sort.sort();
                case 7 -> {
                			try {System.out.println("\n" + fileIO.readAddressBook());
                			} catch (IOException e){
                				e.printStackTrace();}
                }
                case 8 -> {
                    try {
                        CSVFile.readCSV();
                    } catch (IOException | CsvValidationException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 9 -> System.out.println("\n Exited Successfully");
                default -> System.out.print("\n Option not Available \n");
            }
        } while(option != 9);
    }
}