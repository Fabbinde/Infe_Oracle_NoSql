package de.htwg.infe.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import de.htwg.infe.db.BlogController;
import de.htwg.infe.db.OracleDb;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bitte Host angeben:");
		String host = readLine();
		System.out.println("Bitte Port angeben:");
		String port = readLine();
		System.out.println("Bitte Store angeben:");
		String store = readLine();
		
		OracleDb db = new OracleDb(host, port, store);
		
		BlogController controller = new BlogController(db);
		controller.runExample();
		
		System.out.println("Beendet");
		
		
	}
	
	public static String readLine() {
		String s = "";
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    s = bufferRead.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return s;
	}

}
