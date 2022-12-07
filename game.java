import java.util.Random;
public class game {
	public static void main(String[] args) {
		Random ran = new Random(System.currentTimeMillis());

		String[][] arr = {{"SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ","SK"}, {"CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK"}, {"HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "HK"}, {"DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK"}}; 	
	
		int k, n;

		String[] deckBC = new String[52]; // before cutted
		String[] deckAC = new String[52]; // after cutted

		String[] deckPC = new String[4]; // deck of computer
		String[] deckUS = new String[4]; // deck of user

		String[] deckT = new String[4]; // deck of board


		int cut;

		for (int i = 0;i < 52; i++) {
			boolean found = false;
			while(!found) {
				k = ran.nextInt(4) ;
				n = ran.nextInt(13);
				if(arr[k][n].equals("_")) {
					found = false;
					continue;
				}
				deckBC[i] = arr[k][n];
				arr[k][n] = "_";
				found = true;
				
			}
			
		}


		
		/*for (int i = 0;i<deckBC.length;i++) {
			System.out.println(deck[i]);
		}*/


		System.out.println("cutting the deck ...");

		cut = ran.nextInt(52);

		int x = cut;

		int y = cut;

		int z = cut;

		System.out.println("cutting ...");
		System.out.println("cutted from: " + cut);

		int L = deckBC.length;


		for(int i = 0;i<L - 1 - z;i++) {
			deckAC[i] = deckBC[x + 1];
			x++;
		}

		for(int i = 0;i < y + 1;i++) {
			deckAC[L-1-y] = deckBC[i];
			L++;

		// first player is PC 

		}
		System.out.println();
		/*System.out.println("before cut");
		System.out.println();
		for (int i = 0;i<deckBC.length;i++) {
			System.out.println(deckBC[i]);
		}*/

		/*System.out.println();
		System.out.println("after cut: ");
		System.out.println();
		for (int i = 0;i<deckAC.length;i++) {
			System.out.println(deckAC[i]);
		}*/

		int J = deckAC.length - 1; //last value of deckAC

		int counterE = 0;

		for(int i = 0;i<deckUS.length;i++) {
			deckPC[i] = deckAC[J];
			J--;
			deckUS[i] = deckAC[J];
			J--;
		}

		for(int i = 0;i<deckT.length;i++) {
			deckT[i] = deckAC[J];
			J--;
		}

		System.out.println("the card at the top of the deck: -> " + deckT[3]);

		System.out.println("Users cards: " );
		for(int i = 0;i<deckUS.length;i++) {
			System.out.println(deckUS[i]);
		}		


		int counterB = 0;



		for(int i = 0;i<deckUS.length;i++) { // this is for the landing the blank spaces;
			deckUS[i] = "_";
			deckPC[i] = "_"; 
			deckT[i] = "_";
		
		}

		for(int i = 0;i<deckUS.length;i++) {	
			if(deckUS[i].equals("_")) {
				counterB++;
			}
		}

		if(counterB == 4) { // do not forget the reset the counter we do not want to go infinity 
			for(int i = 0;i<deckUS.length;i++) {
				deckPC[i] = deckAC[J];
				J--;
				deckUS[i] = deckAC[J];
				J--;
			}
		}
		

	}

	
     
}






















