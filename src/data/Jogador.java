package data;

import java.util.ArrayList;

public class Jogador {

	ArrayList<Carta> deck = new ArrayList<Carta>(5);
	int cor;
	
	
	
	public Jogador(int cor) {
		this.cor = cor;
		for(int i=0;i<5;i++) {
			deck.add(new Carta(cor)) ;
			
		}
	}
	
	ArrayList<Carta> getDeck() {
		return deck;
	}
	
	int getCor() {
		return cor;
	}
	
	Carta getCarta(int carta) {
		
		return deck.get(carta);
	}
	
	void removeCarta(int carta) {
		
		deck.remove(carta);
	}
}
