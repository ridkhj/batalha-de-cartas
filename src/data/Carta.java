package data;

import java.util.Random;

public class Carta {

	int upN;
	int downN;
	int leftN;
	int rightN;
	int cor;
	
	String[] cartaFinal = new String[7];
	String[] cartaVazia = {"       ","       ","       ","       ", "       ","       ","       "};
	
	Carta(int cor) {
		this.cor = cor;
		upN = randomizar();
		downN = randomizar();
		leftN = randomizar();
		rightN = randomizar();
		
		String[] cartaArray = { "-------", "|  " + getNumber(upN) + "  |", "|     |",
				"|" + getNumber(leftN) + "   " + getNumber(rightN) + "|", "|     |", "|  " + getNumber(downN) + "  |",
				"-------" };
		
		for(int i=0; i< cartaFinal.length;i++) {
			cartaFinal[i] = cartaArray[i];
		}
	}

	
	int randomizar() {
		Random rand = new Random();
		return rand.nextInt(10) + 1;

	}

	private String getNumber(int number) {
		if (number == 10)
			return "A";

		return Integer.toString(number);
	}

	public String toCard() {

		String carta = String.format("#######\n#  %s  #\n#     #\n#%s   %s#\n#     #\n#  %s  #\n#######",

				getNumber(upN), getNumber(leftN), getNumber(rightN), getNumber(downN));

		return carta;
	}
	
	int getCor() {
		return cor;
	}
	
	void setCor(int cor) {
		this.cor = cor;
	}

}
