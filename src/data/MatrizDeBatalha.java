package data;

import java.util.Scanner;

public class MatrizDeBatalha {

	private Carta[][] matriz;
	int indexUltimaCartaJogada= 0;
	int quantidadeDeCartas;
	String[] cartaVazia = { "       ", "       ", "       ", "       ", "       ", "       ", "       " };
	Printer printer = new Printer();
	public static Scanner reader = new Scanner(System.in);

	public MatrizDeBatalha() {
		matriz = new Carta[3][3];
		inicializarMatriz();
	}

	private void inicializarMatriz() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matriz[i][j] = null;
			}
		}
	}
	
	boolean isFull() {
		int cont =0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(matriz[i][j] != null) cont ++;
			}
		}
		
		return cont >=9;
	}

	public void exibirMatrixVazia() {

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 7; k++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(cartaVazia[k]);
					if (j < 2) {
						System.out.print(" # ");
					}
					;
				}
				System.out.println();

			}
			if (i < 2) {
				System.out.println("###########################");
			}

		}

	}

	public void exibirMatriz() {

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 7; k++) {
				for (int j = 0; j < 3; j++) {
					compararCarta();
					if (matriz[i][j] != null) {

						printer.printJogador(matriz[i][j].cartaFinal[k], matriz[i][j].getCor());
						printer.printReset("");

					} else {
						System.out.print(cartaVazia[k]);
					}

					if (j < 2) {
						System.out.print(" # ");
					}
					;
				}
				System.out.println();

			}
			if (i < 2) {
				System.out.println("###########################");
			}

		}
	}

	public Carta getValor(int linha, int coluna) {
		return matriz[linha][coluna];
	}

	void setUltimaJogada(int posicao) {

		indexUltimaCartaJogada = posicao;
	}

	Boolean setValor(Carta valor, int posicao) {

		int linha, coluna;
		linha = (posicao - 1) / 3;
		coluna = (posicao - 1) % 3;
		
		
		if (matriz[linha][coluna] == null) {
			
			setUltimaJogada(posicao);
			matriz[linha][coluna] = valor;

			return true;

		} else {

			return false;
		}
	}

	void getVencedor() {
		int vermelho=0;
		int azul=0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(matriz[i][j] != null) {
					if(matriz[i][j].getCor()%2==0) {
						azul++;
					}else {
						vermelho++;
					}
				}
			}
		}
		
		if(vermelho > azul) {
			printer.printJogador("JOGADOR VERMELHO VENCEU", 1);
		}else {
			printer.printJogador("JOGADOR AZUL VENCEU", 2);
		}
	}

	int getLinha(int p) {
		return (p - 1) / 3;
	}

	int getColuna(int p) {
		return (p - 1) % 3;
	}

	void compararCarta() {
		if(indexUltimaCartaJogada != 0) {
			int p = indexUltimaCartaJogada;
			Carta carta = matriz[getLinha(p)][getColuna(p)];
			Carta carta2;

			if (p > 3) {
				carta2 = matriz[getLinha(p - 3)][getColuna(p - 3)];
				if (carta2 != null) {
					if (carta.upN > carta2.downN) {
						carta2.setCor(carta.getCor());
					}
				}

			}
			if (p < 7) {
				carta2 = matriz[getLinha(p + 3)][getColuna(p + 3)];
				if (carta2 != null) {
					if (carta.downN > carta2.upN) {
						carta2.setCor(carta.getCor());
					}
				}
				// verifica em baixo
			}
			if ((p % 3 == 0) || p == 2 || p == 5 || p == 8) {
				carta2 = matriz[getLinha(p - 1)][getColuna(p - 1)];
				if (carta2 != null) {
					if (carta.leftN > carta2.rightN) {
						carta2.setCor(carta.getCor());
					}

				}
				// verfica a esquerda
			}
			if (p % 3 != 0) {
				carta2 = matriz[getLinha(p + 1)][getColuna(p + 1)];
				if (carta2 != null) {
					if (carta.rightN > carta2.leftN) {
						carta2.setCor(carta.getCor());
					}

				}
				 // verifica a direita
			}
		}
		
	}

}
