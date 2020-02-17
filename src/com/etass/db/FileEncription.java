package com.etass.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import org.omg.CORBA.Request;



public class FileEncription {
	static String name;
	static int id;

	public boolean DBST(int op, int id, String x, String key) {
		this.id=id;
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

				// Ask the user for a key - this is what will encrypt the file
				// I can't be arsed with all that buffered reader shit
				// its too much hacking. JOptionPane is much easier
				// It also adds to user security since having non
				// terminal style input prevents some capturing programs
				// from stealing the data
				// -----------------------------------------------------------

				// This is an update from previous versions
				// Decided it would be easier to put
				// encryption stuff in to a class
				// ----------------------------------------

				Encryption encryption = new Encryption(theFile, key);

				// encrypt file
				// ------------

				encryption.encrypt();

				// get encrypted file bytes and save it
				// ------------------------------------

				toBeSaved = saveFile(encryption.getFileBytes());
                  System.out.println("choice1=============>"+toBeSaved);
                 /* 
                 Fileencrptdao fd=new Fileencrptdao();
              		fd.encrypt(toBeSaved,id);
              	*/
				flag = true;
			} catch (Exception e) {
				flag = false;
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
				System.out.println("choice2=============>"+toBeSaved);
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
			JOptionPane.showMessageDialog(null, output, "information",
					JOptionPane.ERROR_MESSAGE);
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
	/**
	 * @throws SQLException ************************/

	public static String saveFile(byte[] toSave) throws SQLException {
		String txt;
		//System.out.println("id===="+id);

		txt = "E:/Rajesh143/sweet/" + (String) new File(name).getName();
		 
        /*Fileencrptdao fd=new Fileencrptdao();
     		fd.encrypt(txt,id);
     	*/
		
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
