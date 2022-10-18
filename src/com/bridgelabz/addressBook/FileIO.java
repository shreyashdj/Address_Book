package com.bridgelabz.addressBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * @author SHREYASH JADHAV
 */
public class FileIO {
	
	public String readAddressBook() throws IOException {
		/*
         * 1) Read the file
         */
		File file = new File("C:\\Users\\Shreyash Jadhav\\Desktop\\bridgelabz\\RFP 175 Eclipse\\Address_Book\\AddressBook.txt");

        /*
         * 2) Create the object for input stream
         */
        InputStream inputStream = null;
		
			inputStream = new FileInputStream(file);
        /*
         * 3) Create object of InputStreamReader
         */
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        /*
         * 4) Create BufferedReader gateway
         */
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        /*
         * 5) Create StringBuilder (not string as strings are immutable)
         */
        StringBuilder stringBuilder = new StringBuilder();

        /*
         * 6) Create result String
         */
        String result;

        /*
         * 7) Read the data line by line and compare
         */
			while ((result = bufferedReader.readLine()) != null) {

			    /*
			     * 8) Put the data into stringBuilder
			     */
			    stringBuilder.append(result).append("\n");
			}
        /*
         * 9) Close stringBuilder
         */
			bufferedReader.close();
        /*
         * 10) Print data
         */
        return stringBuilder.toString();
	}
	
	public void writeAddressBook(String message) throws IOException {
		String messageFromFile = readAddressBook();
        /*
         * Do modifications on your message got from the file
         */
		String finalMessage = messageFromFile + message;
		
        FileWriter fileWriter;
	
			fileWriter = new FileWriter("C:\\Users\\Shreyash Jadhav\\Desktop\\bridgelabz\\RFP 175 Eclipse\\Address_Book\\AddressBook.txt");
		
			fileWriter.write(finalMessage);
		
			fileWriter.close();
	}

}
