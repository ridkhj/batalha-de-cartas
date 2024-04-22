package data;

import java.util.Scanner;

public class Main {
	
	static Printer printer = new Printer();
	public static Scanner reader = new Scanner(System.in);
	Carta carta1 = new Carta(1);
	static MatrizDeBatalha batalha = new MatrizDeBatalha();
	static Jogador jogador1 = new Jogador(1);
	static Jogador jogador2 = new Jogador(2);
	
	public static void main(String[] args) {
		
		int jogar = 0, vez =0;
		
		while(!batalha.isFull()) {
			
		System.out.println("deseja parar? [-1]");
		jogar = reader.nextInt();
		if(jogar == -1) return;
		
		if(vez%2==0) {
			jogarCarta(jogador1,batalha);
		}else {
			jogarCarta(jogador2,batalha);
		}
		vez++;
		
	
		}
		batalha.exibirMatriz();
		batalha.getVencedor();
	}
	
	static void jogarCarta(Jogador jogador, MatrizDeBatalha matriz) {
		
		matriz.exibirMatriz();
		printer.imprimir_deck(jogador.getDeck());
		Carta cartaJogada = null;
		int linha, coluna, posicao,indexCartaAtual;
		
		do {
			do {
				
			System.out.println("Escolha uma carta do deck para jogar. [1 - 5]");
			indexCartaAtual = reader.nextInt()-1;
		
			}while(indexCartaAtual > jogador.deck.size());
			
			cartaJogada = jogador.getCarta(indexCartaAtual);
			System.out.println("Escolha uma posição 1-9");
	        posicao = reader.nextInt();
	        
			
		}while(!matriz.setValor(cartaJogada, posicao));
		jogador.removeCarta(indexCartaAtual); 
			
	}
}	

