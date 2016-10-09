package com.programmazione.quarto;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Scacchiera {
	
	private FileWriter w = null;
	 private BufferedWriter b = null;
	 
	private Pedina [][] scacchiera = new Pedina[4][4];
	
	public Scacchiera(){
	    
		for (int i = 0; i <=3; i++){
			for (int j = 0; j <=3 ; j++){
				scacchiera[i][j] = null;
			//	System.out.println("Scacchiera[i][j] " +scacchiera[i][j]);
			}
		}
		//System.exit(1);
	}
	
	
	
	public void Posiziona(Pedina pedina, int x, int y){
		
		try {
			w=new FileWriter("scacchiera.txt",false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    b=new BufferedWriter(w);
	    
		//Se nella posizione non c'è già una pedina allora la posso posizionare
		if(scacchiera[x][y] == null){
			// Allora posso posizionare la pedina in quelle coordinate
			scacchiera[x][y]= pedina;
			
			
			//Stampo matrice scacchiera su file.		
			String riga;
			for (int i = 0; i<4; i++ ){
				riga = "";
				
				for (int j=0; j<4; j++){
					
					if(scacchiera[i][j] == null){
						riga = riga + "* ; ";
						continue;
					}					
					if (scacchiera[i][j].getAltezza()==1) riga = riga +"A";
					else riga = riga+"B";
					
					if (scacchiera[i][j].getColore()==1) riga = riga +"W";
					else riga = riga+"N";
					
					if (scacchiera[i][j].getForma()==1) riga = riga +"T";
					else riga = riga+"Q";
					
					if (scacchiera[i][j].getVolume()==1) riga = riga +"F";
					else riga = riga+"P";
					
					riga = riga + " ; ";
					
				}
				riga = riga +"\n";
				//Scrivo su file la prima riga che equivale alle prime quattro posizioni della scacchiera
				try {
					System.out.println(riga);
					b.write(riga);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				b.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else{
			
			//posiziona la pedina nella prima posizione libera che trovo
			int check1 =0;
			int check2 =0;
			for(int i = 0; i<4; i++ ){
				
				if (check1==1)break;
				
				for (int j = 0; j<4; j++){
					
					if (scacchiera[i][j] == null){
						scacchiera[i][j] = pedina;
						check1 = 1;
						check2 = 1;
						break;
						
					}
				}
			}
			
			//Stampo matrice scacchiera su file.
			String riga;
			for (int i = 0; i<4; i++ ){
				riga = "";
				
				for (int j=0; j<4; j++){
					
					if(scacchiera[i][j] == null){
						riga = riga + "* ; ";
						continue;
					}					
					if (scacchiera[i][j].getAltezza()==1) riga = riga +"A";
					else riga = riga+"B";
					
					if (scacchiera[i][j].getColore()==1) riga = riga +"W";
					else riga = riga+"N";
					
					if (scacchiera[i][j].getForma()==1) riga = riga +"T";
					else riga = riga+"Q";
					
					if (scacchiera[i][j].getVolume()==1) riga = riga +"F";
					else riga = riga+"P";
					
					riga = riga + " ; ";
					
				}
				riga = riga +"\n";
				//Scrivo su file la prima riga che equivale alle prime quattro posizioni della scacchiera
				try {
					System.out.println(riga);
					b.write(riga);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (check1==0 && check2 == 0){
				
				JOptionPane.showMessageDialog(null, "Nessuna mossa consentita, PAREGGIO");
				try {
					b.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.exit(2);
			}
		try {
			b.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		}
		
		CheckTurnInVertical();
		CheckTurnInHorizontal();
		CheckTurnInDiagonal();
		
	}
	
	
	// Controlla, una volta che è stata inserita nella scacchiera la pedina, se qualcuno ha vinto o pareggiato in verticale. 
	public void CheckTurnInVertical(){
		
		Pedina p1 = null;
		Pedina p2 = null;
		Pedina p3 = null;
		Pedina p4 = null;
		
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		
		for (int j = 0; j<=3; j++ ){
			flag1 = false;
			flag2 = false;
			flag3 = false;
			flag4 = false;
			for (int i = 0; i<=3; i++){
				if (scacchiera[i][j] == null) break;
				
				if (i == 0){
					p1 = scacchiera[i][j]; 
					flag1 = true; 
				}
				if (i == 1){
					p2 = scacchiera[i][j]; 
					flag2 = true;
				}
				if (i == 2){
					p3 = scacchiera[i][j]; 
					flag3 = true;
				}
				if (i == 3){
					p4 = scacchiera[i][j]; 
					flag4 = true;
				}
				
				if (flag1==true && flag2==true && flag3==true && flag4==true){
					//ho 4 pedine in colonna quindi procedo al controllo delle 4 caratteristiche
					
						//Controllo pedina per altezza
						if(p1.getAltezza()== p2.getAltezza()){
							if (p2.getAltezza()== p3.getAltezza()){
								if(p3.getAltezza()== p4.getAltezza()){
									// Ci sono 4 pedine alte o 4 basse in fila
									if (p4.getAltezza() == 1)  JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine alte in fila");
									else JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine basse in fila");
									System.exit(1);
									
								}
							}					
						}
						

						//Controllo pedina per colore
						if(p1.getColore()== p2.getColore()){
							if (p2.getColore()== p3.getColore()){
								if(p3.getColore()== p4.getColore()){
									// Ci sono 4 pedine nere o 4 bianche in fila
									if (p4.getColore() == 1)  JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine bianche in fila ");
									else JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine nere in fila");
									System.exit(1);
									
								}
							}					
						}
						
						//Controllo pedina per forma
						if(p1.getForma()== p2.getForma()){
							if (p2.getForma()== p3.getForma()){
								if(p3.getForma()== p4.getForma()){
									// Ci sono 4 pedine tonde o 4 quadrate in fila
									if (p4.getForma() == 1)  JOptionPane.showMessageDialog(null,"VITTORIA! 4 Pedine tonde in fila");
									else JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine quadrate in fila");
									System.exit(1);
									
								}
							}					
						}
						
						//Controllo pedina per volume
						if(p1.getVolume()== p2.getVolume()){
							if (p2.getVolume()== p3.getVolume()){
								if(p3.getVolume()== p4.getVolume()){
									// Ci sono 4 pedine bucate o 4 piene in fila
									if (p4.getVolume() == 1) JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine bucate in fila");
									else JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine piene in fila");
									System.exit(1);
									
								}
							}					
						}
						
				}		
			}
		}
		// Nessuna configurazione verticale di pedine. Si procede al turno successivo
	
	}
	
	public void CheckTurnInHorizontal(){

		Pedina p1 = null;
		Pedina p2 = null;
		Pedina p3 = null;
		Pedina p4 = null;
		
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		
		for (int i = 0; i<=3; i++ ){
			flag1 = false;
			flag2 = false;
			flag3 = false;
			flag4 = false;
			for (int j = 0; j<=3; j++){
				if (scacchiera[i][j] == null) break;
				
				if (j == 0){
					p1 = scacchiera[i][j];
					flag1 = true; 
				}
				if (j == 1){
					p2 = scacchiera[i][j];
					flag2 = true;
				}
				if (j == 2){
					p3 = scacchiera[i][j];
					flag3 = true;
				}
				if (j == 3){
					p4 = scacchiera[i][j];
					flag4 = true;
				}
				
				if (flag1==true && flag2==true && flag3==true && flag4==true){
					//ho 4 pedine in riga quindi procedo al controllo delle 4 caratteristiche
					
						//Controllo pedina per altezza
						if(p1.getAltezza()== p2.getAltezza()){
							if (p2.getAltezza()== p3.getAltezza()){
								if(p3.getAltezza()== p4.getAltezza()){
									// Ci sono 4 pedine alte o 4 basse in fila
									if (p4.getAltezza() == 1)  JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine alte in fila");
									else JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine basse in fila");
									System.exit(1);
									
								}
							}					
						}
						

						//Controllo pedina per colore
						if(p1.getColore()== p2.getColore()){
							if (p2.getColore()== p3.getColore()){
								if(p3.getColore()== p4.getColore()){
									// Ci sono 4 pedine nere o 4 bianche in fila
									if (p4.getColore() == 1) JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine bianche in fila");
									else JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine nere in fila");
									System.exit(1);
									
								}
							}					
						}
						
						//Controllo pedina per forma
						if(p1.getForma()== p2.getForma()){
							if (p2.getForma()== p3.getForma()){
								if(p3.getForma()== p4.getForma()){
									// Ci sono 4 pedine tonde o 4 quadrate in fila
									if (p4.getForma() == 1) JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine tonde in fila");
									else JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine quadrate in fila");
									System.exit(1);
									
								}
							}					
						}
						
						//Controllo pedina per colore
						if(p1.getVolume()== p2.getVolume()){
							if (p2.getVolume()== p3.getVolume()){
								if(p3.getVolume()== p4.getVolume()){
									// Ci sono 4 pedine bucate o 4 piene in fila
									if (p4.getVolume() == 1)  JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine bucate in fila ");
									else JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine piene in fila");
									System.exit(1);
									
								}
							}					
						}
						
				}		
			}
		}
		// Nessuna configurazione orizzontale di pedine. Si procede al turno successivo
	}

	public void CheckTurnInDiagonal(){

		Pedina p1 = null;
		Pedina p2 = null;
		Pedina p3 = null;
		Pedina p4 = null;
		
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		
		for (int i = 0; i<=3; i++ ){
			flag1 = false;
			flag2 = false;
			flag3 = false;
			flag4 = false;
			for (int j = 0; j<=3; j++){
				if (scacchiera[i][j] == null) break;
				if (i==j){
				
					if (j == 0){
						p1 = scacchiera[i][j];
						flag1 = true; 
					}
					if (j == 1){
						p2 = scacchiera[i][j];
						flag2 = true;
					}
					if (j == 2){
						p3 = scacchiera[i][j];
						flag3 = true;
					}
					if (j == 3){
						p4 = scacchiera[i][j];
						flag4 = true;
					}
				
					if (flag1==true && flag2==true && flag3==true && flag4==true){
					//ho 4 pedine in diagonale quindi procedo al controllo delle 4 caratteristiche
					
						//Controllo pedina per altezza
						if(p1.getAltezza()== p2.getAltezza()){
							if (p2.getAltezza()== p3.getAltezza()){
								if(p3.getAltezza()== p4.getAltezza()){
									// Ci sono 4 pedine alte o 4 basse in fila
									if (p4.getAltezza() == 1)  JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine alte in fila");
									else JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine basse in fila");
									System.exit(1);
									
								}
							}					
						}
						

						//Controllo pedina per colore
						if(p1.getColore()== p2.getColore()){
							if (p2.getColore()== p3.getColore()){
								if(p3.getColore()== p4.getColore()){
									// Ci sono 4 pedine nere o 4 bianche in fila
									if (p4.getColore() == 1) JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine bianche in fila");
									else JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine nere in fila");
									System.exit(1);
									
								}
							}					
						}
						
						//Controllo pedina per forma
						if(p1.getForma()== p2.getForma()){
							if (p2.getForma()== p3.getForma()){
								if(p3.getForma()== p4.getForma()){
									// Ci sono 4 pedine tonde o 4 quadrate in fila
									if (p4.getForma() == 1)  JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine tonde in fila");
									else JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine quadrate in fila");
									System.exit(1);
									
								}
							}					
						}
						
						//Controllo pedina per colore
						if(p1.getVolume()== p2.getVolume()){
							if (p2.getVolume()== p3.getVolume()){
								if(p3.getVolume()== p4.getVolume()){
									// Ci sono 4 pedine bucate o 4 piene in fila
									if (p4.getVolume() == 1) JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine bucate in fila");
									else JOptionPane.showMessageDialog(null, "VITTORIA! 4 Pedine piene in fila");
									System.exit(1);
									
								}
							}					
						}
					}	
						
				}		
			}
		}
		// Nessuna configurazione orizzontale di pedine. Si procede al turno successivo
	}



		
}
