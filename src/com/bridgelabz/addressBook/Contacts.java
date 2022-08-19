package com.bridgelabz.addressBook;

import java.util.Scanner;

/*
 * @author SHREYASH JADHAV
 */
public class Contacts {

	String firstName, lastName, address, city, state, email;
	int zipCode;
	long phoneNumber;
	
	public void addContact() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\nEnter First Name : ");
		firstName = scan.nextLine();
		
		System.out.print("Enter Last Name : ");
		lastName = scan.nextLine();
		
		System.out.print("Enter Address : ");
		address = scan.nextLine();
		
		System.out.print("Enter City : ");
		city = scan.nextLine();
		
		System.out.print("Enter State : ");
		state = scan.nextLine();
		
		System.out.print("Enter Zip code : ");
		zipCode = scan.nextInt();
		
		System.out.print("Enter Phone Number : ");
		phoneNumber = scan.nextLong();
		
		System.out.print("Enter Email : ");
		email = scan.next();
	}
	
	public void displayContact() {
		
		System.out.println("Full Name    : " + firstName + " " + lastName);
		
		System.out.println("Address      : " + address);
		 
		System.out.println("City         : " + city);
		 
		System.out.println("State        : " + state);
		
		System.out.println("Zip Code     : " + zipCode);
		
		System.out.println("Phone Number : " + phoneNumber);
		
		System.out.println("Email        : " + email);
		
	}
	
}