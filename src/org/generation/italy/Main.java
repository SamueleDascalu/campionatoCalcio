package org.generation.italy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String risposta, nomeSquadraCasa, nomeSquadraFuori, punteggio;
		int punteggioCasa=0, punteggioFuori=0;
		
		HashMap<String, Integer> squadre = new HashMap<String, Integer>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put("roma",0);
				put("lazio",0);
				put("inter",0);
				put("milan",0);
				put("napoli",0);
			}
		};
		
		ArrayList<String> listaPartite = new ArrayList<String>();
		ArrayList<String> listaPunteggi = new ArrayList<String>();
		
		do {
			System.out.println("Le squadre classificate sono: "+"\n");
			
			for(String squadra : squadre.keySet()) {
				System.out.println(squadra);
			}
			
			System.out.println();
			
			do {
				System.out.print("Inserisci il nome della squadra in casa: ");
				nomeSquadraCasa = scanner.nextLine().toLowerCase();
				
				if(squadre.containsKey(nomeSquadraCasa)) {
					System.out.print("Inserisci il numero di gol segnati: ");
					punteggioCasa = Integer.parseInt(scanner.nextLine());
				} else {
					System.out.println("Squadra inesistente.");
				}
			}while(!squadre.containsKey(nomeSquadraCasa));
			
			do {
				System.out.print("Inserisci il nome della squadra fuori casa: ");
				nomeSquadraFuori = scanner.nextLine().toLowerCase();
				
				if(squadre.containsKey(nomeSquadraCasa)) {
					System.out.print("Inserisci il numero di gol segnati: ");
					punteggioFuori = Integer.parseInt(scanner.nextLine());
				} else {
					System.out.println("Squadra inesistente.");
				}
			}while(!squadre.containsKey(nomeSquadraFuori));
			
			listaPartite.add(nomeSquadraCasa+"-"+nomeSquadraFuori);
			punteggio = punteggioCasa+" - "+punteggioFuori;
			listaPunteggi.add(punteggio);
			
			if(punteggioCasa>punteggioFuori) {
				squadre.put(nomeSquadraCasa, squadre.get(nomeSquadraCasa)+3);
			} else if(punteggioCasa<punteggioFuori) {
				squadre.put(nomeSquadraFuori, squadre.get(nomeSquadraFuori)+3);
			} else if(punteggioCasa==punteggioFuori) {
				squadre.put(nomeSquadraCasa, squadre.get(nomeSquadraCasa)+1);
				squadre.put(nomeSquadraFuori, squadre.get(nomeSquadraFuori)+1);
			}
			
			System.out.print("Vuoi inserire un'altra partita (s/n)? ");
			risposta = scanner.nextLine();
		} while(risposta.equals("s"));
		
		System.out.println("Le partite giocate sono: ");
		
		for(int i=0; i<listaPartite.size(); i++) {
			System.out.println(listaPartite.get(i)+": "+listaPunteggi.get(i));
		}
		
		System.out.println("Questa é la classifica del campionato:");
		
		//ordinare la classifica in base ai punteggi interi
		for(Map.Entry<String, Integer> entry:squadre.entrySet()) {
			System.out.println(entry.getKey()+entry.getValue());
		}
		
		scanner.close();
	}

}
