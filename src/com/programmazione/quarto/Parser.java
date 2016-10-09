package com.programmazione.quarto;

public class Parser {
	
	private int altezza;
	private int colore;
	private int forma;
	private int volume;
	private Pedina p = null;
	
	
	public Parser(String pedina){
		
		 String char1 = pedina.substring(0,1);  
         String char2 = pedina.substring(1,2);
         String char3 = pedina.substring(2,3);
         String char4 = pedina.substring(3,4);
         
         // controllo per altezza
         if(char1.equals("A"))
         {
               altezza = 1;
         
         }else
         {
               altezza = 0;
         }
         // controllo per colore     
         if(char2.equals("W"))
         {
               colore = 1;
         
         }else
         {
               colore = 0;
         }
         //controllo per forma
         if(char3.equals("T"))
         {          
               forma = 1;
         
         }else
         {
               forma = 0;
         }
         // controllo per volume
          
         if(char4.equals("F"))
         {
                volume = 1;
          
         }else
         {
                volume = 0;
         }
         Pedina p = new Pedina(altezza,colore,forma,volume);
         this.p = p;
    }
       
    public Pedina getP() {
		return p;
	}

	public void setP(Pedina p) {
		this.p = p;
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

	public Pedina getPedina(){
            return p;
	}	

}
