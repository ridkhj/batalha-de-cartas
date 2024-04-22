package data;

import java.util.ArrayList;

public class Printer {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	void printJogador(String expressão,int cor) {
		
		if(cor %2==0) {
			System.out.print(ANSI_BLUE + expressão + ANSI_BLUE);
		}else {
			System.out.print(ANSI_RED + expressão + ANSI_RED);
		}
		
		
	}
	
	void printReset(String expressão) {
		
		System.out.print(ANSI_RESET + expressão + ANSI_RESET);
		
	}
	
	void imprimir_deck(ArrayList<Carta> deck) {
		
		
		int tamanhoDeck = deck.size();
		
		if(tamanhoDeck == 0) {
			
			System.out.println("sem cartas no deck");
			
		}else if(tamanhoDeck == 1) {
			int tamanhoCarta = deck.get(0).cartaFinal.length;
			for(int i=0; i< tamanhoCarta ;i++ ) {
			
				printJogador(deck.get(0).cartaFinal[i] + " ", deck.get(0).cor);
				printReset(" ");
				System.out.println();
			}
		}else {
			int tamanhoCarta = deck.get(0).cartaFinal.length;
			for(int i=0; i< tamanhoCarta ;i++ ) {
				for(int j = 0;j < tamanhoDeck ; j++) {
					
					
						printJogador(deck.get(j).cartaFinal[i] + " ", deck.get(j).cor);
						printReset(" ");
					
				}
				System.out.println();
			}
		}
		
	}

}

