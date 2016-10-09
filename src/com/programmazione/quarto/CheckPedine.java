package com.programmazione.quarto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe per il controllo del file pedine.txt.
 * 1) Controllo esistenza file pedine.txt
 * 2)Controllo numero di pedine
 * 3)Se esistono pedine che si ripetono
 * 
 * 
 * @author Alessandro Peretti
 *
 */
public class CheckPedine {
	
	
	//Ottengo pedine
	public ArrayList<String> getPedine() {
		return pedine;
	}
	  
	private String p1 = "AWTP";
	private String p2 = "AWTF";
	private String p3 = "AWQP";
	private String p4 = "AWQF";
	private String p5 = "ANTP";
	private String p6 = "ANTF";
	private String p7 = "ANQP";
	private String p8 = "ANQF";
	private String p9 = "BWTP";
	private String p10 = "BWTF";
	private String p11 = "BWQP";
	private String p12 = "BWQF";
	private String p13 = "BNTP";
	private String p14 = "BNTF";
	private String p15 = "BNQP";
	private String p16 = "BNQF";
    
	private ArrayList<String> pedine =new ArrayList<String>();
	  
	public CheckPedine(){ // costruttore
		// apertura e lettura  per il controllo del  file
		FileReader f = null;
		int count = 0;
		try {
			f=new FileReader("pedine.txt");
		} catch (FileNotFoundException e) {
			// Auto-generated catch block
			System.exit(11); //ci sono problemi con i file pedine.txt
			e.printStackTrace();
			
		}
		BufferedReader b;
		b=new BufferedReader(f);
		
		while (true){
			
			//Aggiunta delle pedine all'interno dell'ArrayList
			try {
				pedine.add(b.readLine());
				
				//System.out.println(riga);
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			if (pedine.get(count)==null) break;
			count ++;
			//System.out.println(riga);
		}
		
		// controlo se il numero di pedine e' compreso tra 1 e 16
		if( count>=1 && count<= 16){
			System.out.println("il numero di pedine è corretto ed equivale a: " + count);
		}else{
			//numero di pedine  errate. Uscita con codice 12
			System.exit(12);
		}
		
		//controllo se sono presenti pedine doppioni
		for(int i=0; i< pedine.size()-1; i++){
			for(int j=i+1; j<pedine.size()-1; j++){
				if(pedine.get(i).equals(pedine.get(j))){
					System.out.println("Pedina doppione");
					System.exit(12);
				}	
			}
		}
		int controllo =0;
		//Controllo se ci sono caratteristiche dicotomiche non conformi alle tipologie di pedine (Ex. AAWF  tipo pedina non ammissibile).
		for(int i=0; i < (pedine.size()-1);i++){
			
			if (pedine.get(i).equals(p1) || pedine.get(i).equals(p2) || pedine.get(i).equals(p3) || pedine.get(i).equals(p4) || pedine.get(i).equals(p5) || pedine.get(i).equals(p6) || pedine.get(i).equals(p7) || pedine.get(i).equals(p8) || pedine.get(i).equals(p9) || pedine.get(i).equals(p10) || pedine.get(i).equals(p11) || pedine.get(i).equals(p12) || pedine.get(i).equals(p13) || pedine.get(i).equals(p14) || pedine.get(i).equals(p15)|| pedine.get(i).equals(p16)){
				// La pedina è ammissibile quindi procedo al controllo delle altre.
				controllo = 1;
			}
			if (controllo ==0){
				System.out.println("Pedina non ammissibile");
				System.exit(12);
	
			}
			controllo =0;
			
		}
		System.out.println("Pedine corrette. Let's start!!");
				
	}
	
}
