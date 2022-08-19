package com.bridgelabz.addressBook;

/*
 * @author SHREYASH JADHAV
 */
public class AddressBook {

	public static void main(String[] args) {

		System.out.println(" Welcome to Address Book Prgram");
		
		Contacts person1 = new Contacts();
		
		person1.addContact();
		
		System.out.println();
		
		person1.displayContact();
		
	}

}
