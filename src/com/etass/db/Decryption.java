package com.etass.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Decryption {

	static String name;

	public boolean decryption(int op, String x, String key) {
		boolean flag = false;
		String toBeSaved = "";
		String theText;
		int choice = op;
		name = x;
		if (choice == 1) {

			// Get a file using a buffered reader and file input stream
			// and stick it in to a byte array
			// --------------------------------------------------------
			try {
				byte[] theFile = getFile(name);

		

				Encryption encryption = new Encryption(theFile, key);

				// encrypt file
				// ------------

				encryption.decrypt();

				// get encrypted file bytes and save it
				// ------------------------------------

				toBeSaved = saveFile(encryption.getFileBytes());

				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (choice == 2) {

			// Basically the reverse of the (choice == 1) clause above
			// -------------------------------------------------------
			try {
				byte[] theFile = getFile(name);

				Encryption encryption = new Encryption(theFile, key);
				encryption.decrypt();

				toBeSaved = saveFile(encryption.getFileBytes());

				flag = true;
			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
			}
		}

		else if (choice == 4) {
			System.out.println("GOOD DAY!");
			System.exit(0);
		}

		else if (choice == 3) {
			String output = "\n\nImportant info on key choice: \n\n"
					+ "The longer the key, the better. This program\n"
					+ "implements a key expansion algorithm that given\n"
					+ "an average length of user-entered key is almost\n"
					+ "analagous to the one-time pad encryption method\n\n"
					+ "For example: Use key length of 1: 128bit encryption\n\n"
					+ "             Use key length of 2: 256bit encryption\n\n"
					+ "             Use key length of 8: 1024bit encryption\n\n"
					+ "             etc...\n\n\n";

		}
		return flag;
	}

	/****************************/
	/* L o a d i n a f i l e */
	/****************************/

	public static byte[] getFile(String name) {

		byte[] readFromFile = null;
		String txt = name;
		try {
			FileInputStream in = new FileInputStream(txt);
			readFromFile = new byte[in.available()];
			in.read(readFromFile);
			in.close();
		} catch (IOException e) {
			System.out.println("\nSorry - file not found!\n");
		}
		return readFromFile;
	}

	/**************************/
	/* S a v e a f i l e */
	/**************************/

	public static String saveFile(byte[] toSave) {

		String txt;
		
		txt = "E:/Rajesh143/sweet/raj" + (String) new File(name).getName();
		try {
			FileOutputStream out = new FileOutputStream(txt);
			out.write(toSave);
			out.close();

		} catch (IOException e) {
			System.out
					.println("Sorry, but there seems to have been a problem\n"
							+ "saving your file. Perhaps your hard-drive is full\n"
							+ "or the write permissions need to be changed\n");
		}
		return txt;
	}
}