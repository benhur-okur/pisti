import java.util.Scanner;
import java.util.Random;
public class game {
	public static void main(String[] args) {



		Scanner sc = new Scanner(System.in);
		Random ran = new Random(System.currentTimeMillis());

		String[][] arr = {{"SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "SX", "SJ", "SQ","SK"}, {"CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CX", "CJ", "CQ", "CK"}, {"HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "HX", "HJ", "HQ", "HK"}, {"DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DX", "DJ", "DQ", "DK"}}; // i did multidimensional array cause there are 4 units which are: clubs hearts spades, diamonds 	
	
		int k, n;

		String[] deckBC = new String[52]; // before cutted
		String[] deckAC = new String[52]; // after cutted

		String[] deckPC = new String[4]; // deck of computer
		String[] deckUS = new String[4]; // deck of user

		String[] deckTI = new String[52]; // initial deck of table which provides four cards;

		String[] jokers = new String[4];

		jokers[0] = arr[0][10]; // these are the "jack" which is get whole cards int the table;
		jokers[1] = arr[1][10];
		jokers[2] = arr[2][10];
		jokers[3] = arr[3][10];



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


		for(int i = 0;i<L - 1 - z;i++) { // this two parts are obtaining the bottoms to hte up parts
			deckAC[i] = deckBC[x + 1];
			x++;
		}

		for(int i = 0;i < y + 1;i++) {
			deckAC[L-1-y] = deckBC[i];
			L++;

		// first player is PC 

		}
		System.out.println();
		System.out.println("before cut");
		System.out.println();
		for (int i = 0;i<deckBC.length;i++) {
			System.out.println(deckBC[i]);
		}

		System.out.println();
		System.out.println("after cut: ");
		System.out.println();
		for (int i = 0;i<deckAC.length;i++) {
			System.out.println(deckAC[i]);
		}


		//--------------------------------
	  	
		int J = deckAC.length - 1; //last value of deckAC

		cardDeal(deckUS, deckPC, deckAC, J);

		System.out.println();

		initialTable(deckTI, deckAC, J);
			

		info(deckUS, deckPC, deckTI, J);

		fight(deckUS, deckPC, deckTI, J);

	}


	public static void cardDeal(String[] deckUS, String[] deckPC, String[] deckAC, int J) { // dealing cards to user;

		for(int i = 0;i<deckUS.length;i++) {
		deckUS[i] = "-";
		deckPC[i] = "-";		}

		int counter = 0;		

		// take it into a method ***
		
		for(int i = 0;i<deckUS.length;i++) {
			if(deckUS[i].equals("-")) {
				counter++;
			}
		}

		if(counter == 4) {
			for(int i = 0;i<deckUS.length;i++) {
				deckPC[i] = deckAC[J];
				J--;
				deckUS[i] = deckAC[J];
				J--;
			}
		}
		System.out.println();
		System.out.println("users deck: ");
		for(String i : deckUS) {
			System.out.println(i);
		}
		

	}

	public static void initialTable (String[] deckTI, String[] deckAC, int J) {

		int counter = 0;

		for(int i = 0;i<deckTI.length;i++) {
			deckTI[i] = "-";
		}

		for(int i = 0;i<4;i++) {
			if(deckTI[i] == "-") {
				counter++;
			}
		}

		

		if(counter == 4) {
		
			for(int i = 0;i<4;i++) {
				deckTI[i] = deckAC[J];
				J--;
			}
			
		}
		
		for (String a : deckTI) {
			System.out.println(a);
		}
	}



	public static void info (String[] deckUS, String[] deckPC, String[] deckTI, int J) {			topCard obj1 = new topCard(deckTI, deckPC, deckUS);
		System.out.println();
		System.out.println("the card at the top of deck ->" + obj1.showTop());

		System.out.println();
	
		System.out.println("turn on computer: ");

		System.out.println();
		
		PC_turn obj2 = new PC_turn(deckPC, deckTI);
		obj2.showPC();

		System.out.println();
		System.out.println("user's deck: ");
	
		US_turn obj3 = new US_turn(deckUS);
		obj3.showUS();

			
	}

	public static void fight (String[] deckUS, String[] deckPC, String[] deckTI, int J) {
		PC_turn obj4 = new PC_turn(deckPC, deckTI);
		obj4.play();

		topCard obj5 = new topCard(deckTI, deckPC, deckUS);
		obj5.getCounter();


		for(int i = 0;i<5;i++) {
			System.out.println(deckTI[i]);
		}
	}
	
     
}






















