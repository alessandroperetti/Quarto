package com.programmazione.quarto;
/**
 * 
 */

/**
 * @author Alessandro Peretti*
 */
public class Pedina {
	
	    //attributi, per il momento non so se devo il modficatore è private o public
	   public int altezza;
	   public int colore;
	   public int forma;
	   public int volume;
	   
	   //Costruttore per l'oggetto pedina
	   
	   public Pedina(int altezza,int colore,int forma,int volume)
	   {  
	        this.altezza = altezza;
	        this.colore = colore;
	        this.forma = forma;
	        this.volume = volume;
	   }
	//Metodo di trasformazione altezza da int a String
	   
	public String getAltezzaToString() {
			if (altezza == 1 )return "A";
			else return "B";
	}   
	
	public String getColoreToString() {
		if (colore == 1 )return "W";
		else return "N";
	} 
	
	public String getFormaToString() {
		if (forma == 1 )return "T";
		else return "Q";
	}
	
	public String getVolumeToString() {
		if (volume == 1 )return "F";
		else return "P";
	} 
	
	
	public int getAltezza() {		   
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	public int getColore() {
		return colore;
	}

	public void setColore(int colore) {
		this.colore = colore;
	}

	public int getForma() {
		return forma;
	}

	public void setForma(int forma) {
		this.forma = forma;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

}
