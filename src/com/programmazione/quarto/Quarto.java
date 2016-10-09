package com.programmazione.quarto;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Alessandro Peretti
 *
 */
public class Quarto {
	
	/**
	 * 
	 * Rappresenta il main del programma. 
	 * 1) Controlla il file pedine;
	 * 2) controlla il file scacchiera;
	 * 3) per ogni pedina dal file pedine.txt richiama il metodo Posizione che posizionerà in una cella vuota della scacchiera la mia pedina che sto muovendo.
	 * 
	 */
	public static void main(String[] args) {
		
		// Controllo il file pedine.txt
		CheckPedine controllopedine = new CheckPedine();
		//Controllo del file scacchiera.txt
		CheckScacchiera controlloscacchiera = new CheckScacchiera();
		
		ArrayList<String> pedine = controllopedine.getPedine();
		
		//for (int i= 0; i<pedine.size()-1; i++) System.out.println(pedine.get(i));
		//System.exit(1);
		
		//Inizializzo e creo la scacchiera
		Scacchiera scacchiera = new Scacchiera();
		
		//Mi creo due numeri random attraverso la classe Java Random
		Random randomX = new Random();
		Random randomY = new Random();
		for (int i = 0; i < (pedine.size()-1); i++){
			//Trasforma la pedina che è una stringa in un oggetto di tipo Pedina con le seguenti caratteristiche: altezza, colore, forma e volume.
			Parser parser = new Parser(pedine.get(i));
			
			//System.out.println(parser.getPedina().getAltezzaToString()+ parser.getPedina().getColoreToString()+ parser.getPedina().getFormaToString()+parser.getPedina().getVolumeToString());
			//posiziona una pedina sulla scacchiera
			int x = randomX.nextInt(4);
			int y = randomY.nextInt(4);
			
			//System.out.println("x= "+ x + " y = " + y);
			
			//posiziono la pedina in una casella vuota della scacchiera
			scacchiera.Posiziona(parser.getPedina(), x, y);
			
			
		}
	}

}
