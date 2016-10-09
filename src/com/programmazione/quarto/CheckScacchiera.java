package com.programmazione.quarto;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckScacchiera {

	
	public CheckScacchiera(){
		FileReader f = null;
		try {
			
			f=new FileReader("scacchiera.txt");
		} catch (FileNotFoundException e) {
			
			//ci sono problemi con i file scacchiera.txt
			System.exit(13); 
			e.printStackTrace();
		}
		
	}	
}
	

