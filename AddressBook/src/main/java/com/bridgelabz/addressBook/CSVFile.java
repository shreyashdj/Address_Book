package com.bridgelabz.addressBook;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author SHREYASH JADHAV
 */
public class CSVFile {
	private static final String filePath = "C:\\Users\\Shreyash Jadhav\\Desktop\\bridgelabz\\RFP 175 Intellij\\Address_Book\\AddressBook.csv";

	/**
	 *	created readCSV method to read csv file
	 */
	public static void readCSV() throws IOException, CsvValidationException {

		writeCSV();
		Reader reader = Files.newBufferedReader(Paths.get(filePath));
		CSVReader csvReader = new CSVReader(reader);
		String [] nextRecord;
		while ((nextRecord = csvReader.readNext()) != null ) {
			for (String cell : nextRecord) {
				System.out.print(cell +"\n");
			}
			System.out.println();
		}
	}
	/**
	 *	created writeCSV method to write csv file
	 */
	public static void writeCSV() throws IOException {

		String list = AddressBook.addressBookList.toString();
		Writer writer = Files.newBufferedWriter(Paths.get(filePath));
		CSVWriter csvWriter = new  CSVWriter(writer);
		String[] record = list.split("][},]");
		csvWriter.writeNext(record, false);
		writer.close();
	}
}
