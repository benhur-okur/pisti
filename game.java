import java.util.Scanner;
import java.util.Random;
public class game {
	public static void main(String[] args) {
		Random ran = new Random(System.currentTimeMillis());
		Scanner sc = new Scanner(System.in);

		String[][] arr = {{"SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "SX", "SJ", "SQ","SK"}, {"CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CX", "CJ", "CQ", "CK"}, {"HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "HX", "HJ", "HQ", "HK"}, {"DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DX", "DJ", "DQ", "DK"}}; // i did multidimensional array cause there are 4 units which are: clubs hearts spades, diamonds 	
	
		int k, n;

		String[] deckBC = new String[52]; // before cutted
		String[] deckAC = new String[52]; // after cutted

		String[] deckPC = new String[4]; // deck of computer
		String[] deckUS = new String[4]; // deck of user

		String[] deckTI = new String[52]; // initial deck of table which provides four cards;

		String[] deckUS_W = new String[52];// cards of user which he/she has won;
		String[] deckPC_W = new String[52]; // cards of computer which it has won;

		String[] deckPC_P = new String[52]; // these two arrays for pişti cards
		String[] deckUS_P = new String[52];
 
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
				if(arr[k][n] == null) {
					found = false;
					continue;
				}
				deckBC[i] = arr[k][n];
				arr[k][n] = null;
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

		for(int i = 0;i<deckUS.length;i++) {
			deckUS[i] = null;
			deckPC[i] = null;		
		}


	  	
		int J = deckAC.length - 1; //last value of deckAC


		System.out.println();

		//-------------------------------

		int counter2 = 0;

		for(int i = 0;i<deckTI.length;i++) {
			deckTI[i] = null;
		}

		for(int i = 0;i<4;i++) {
			if(deckTI[i] == null) {
				counter2++;
			}
		}

		

		if(counter2 == 4) {
		
			for(int i = 0;i<4;i++) {
				deckTI[i] = deckAC[J];
				deckAC[J] = null;
				J--;
			}
			
		}

		System.out.println();
	
		System.out.println("first four card of table: ");
		
		for (String a : deckTI) {
			System.out.println(a);
		}
			
		System.out.println(J);

		int counter = 0;		

		for(int u = 0;u<24;u++) {

			// take it into a method ***
		
			for(int i = 0;i<deckUS.length;i++) {
				if(deckUS[i] == null) {
					counter++;
				}
			}

			if(counter == 4) {
				for(int i = 0;i<deckUS.length;i++) {
					deckPC[i] = deckAC[J];
					deckAC[J] = null;
					J--;
					deckUS[i] = deckAC[J];
					deckAC[J] =null;
					J--;
				}
				showTop(deckTI);
			counter = 0;
			} else {
				counter = 0;
			}
			
			infoPC(deckUS, deckPC, deckTI, J);

			playPC(deckPC, deckTI, deckPC_W, deckPC_P);

			for(int i = 0;i<deckUS.length;i++) {
				if(deckUS[i] == null) {
					counter++;
				}
			}

			if(counter == 4) {
					for(int i = 0;i<deckUS.length;i++) {
						deckPC[i] = deckAC[J];
						deckAC[J] = null;
						J--;
						deckUS[i] = deckAC[J];
						deckAC[J] = null;
						J--;
					}
				
			counter = 0;
			} else {
				counter = 0;
			}

			showTop(deckTI);

			infoUS(deckUS, deckTI, J);

			playUS(deckUS, deckTI, deckUS_W, deckUS_P);
	
		}

		int totalCardsUS = countUS_W(deckUS_W) + countUS_P(deckUS_P);
		int totalCardsPC = countPC_W(deckUS_W) + countPC_P(deckUS_W);	

		System.out.println(totalCardsUS + " - " + totalCardsPC + " US - PC ");	

		int countAfter = 0;

		for(int i = 0;i<deckTI.length;i++) {
			if(deckTI[i] != null) {countAfter++; }
		}

		if(countAfter > 0 && totalCardsUS > totalCardsPC ) {
			for(int i = 0;i<countAfter;i++) {
				deckUS_W[countUS_W(deckUS_W)] = deckTI[i];
				deckTI[i] = null;
			}
		}

		if(countAfter > 0 && totalCardsPC > totalCardsUS ) {
			for(int i = 0;i<countAfter;i++) {
				deckPC_W[countPC_W(deckPC_W)] = deckTI[i];
				deckTI[i] = null;
			}
		}
		

		point obj1 = new point(deckPC_P, deckPC_W, deckUS_P, deckUS_W);
		System.out.println("computers point -> " + obj1.pointsPC() + "\n" + "users point -> " + obj1.pointsUS());

		//System.out.println("users point -> " + obj1.pointsUS());


		System.out.println();
		System.out.println("cards which are won by user: " + countUS_W(deckUS_W));


		for(int i = 0;i<countUS_W(deckUS_W);i++) {
			System.out.println(deckUS_W[i]);
		}

		System.out.println();
		System.out.println("pişti cards which are won by user: "+ countUS_P(deckUS_P));
		for(int i = 0;i<countUS_P(deckUS_P);i++) {
			System.out.println(deckUS_P[i]);
		}

		System.out.println();
		System.out.println("pişti cards which are won by computer: " + countPC_P(deckPC_P));
		for(int i = 0;i<countPC_P(deckPC_P);i++) {
			System.out.println(deckPC_P[i]);
		}

		System.out.println();
		System.out.println("cards which are won by computer: " + countPC_W(deckPC_W));

		for(int i = 0;i<countPC_W(deckPC_W);i++) {
			System.out.println(deckPC_W[i]);
		}

	}


	
	



	public static void infoPC (String[] deckUS, String[] deckPC, String[] deckTI, int J) {			
		System.out.println();
		System.out.println("the card at the top of deck ->" + showTop(deckTI));

		System.out.println();

		System.out.println("computers deck: ");
		System.out.println();

		for(String i : deckPC) {
			System.out.println(i);
		}

			
	}

	public static void infoUS (String[] deckUS, String[] deckTI, int J) {			
		System.out.println();
		System.out.println("the card at the top of deck ->" + showTop(deckTI));
	
		System.out.println();
		System.out.println("user's deck: ");
		System.out.println();
	
		for(String i : deckUS) {
			System.out.println(i);
		}
			
	}

	public static int countPC_W (String[] deckPC_W) { // these two methods for gathering the cards which have won;
		int counter = 0;
		for(int i = 0;i<deckPC_W.length;i++) {
			if(deckPC_W[i] != null) { counter++; }	
		}
		return counter;
	}
	
	public static int countPC_P (String[] deckPC_P) { // these two methods for gathering the cards which have won;
		int counter = 0;
		for(int i = 0;i<deckPC_P.length;i++) {
			if(deckPC_P[i] != null) { counter++; }	
		}
		return counter;
	}

	public static int countUS_W (String[] deckUS_W) {
		int counter = 0;
		for(int i = 0;i<deckUS_W.length;i++) {
			if(deckUS_W[i] != null) { counter++; }	
		}
		return counter;
	}
	public static int countUS_P (String[] deckUS_P) {
		int counter = 0;
		for(int i = 0;i<deckUS_P.length;i++) {
			if(deckUS_P[i] != null) { counter++; }	
		}
		return counter;
	}

	public static void playPC(String[] deckPC, String[] deckTI, String[] deckPC_W, String[] deckPC_P) {
		String deneme = new String("AJ");	
		boolean pass = true;
		Random ran = new Random(System.currentTimeMillis());
		int counter = 0;

		for(int i = 0;i<deckTI.length;i++) {
			if(deckTI[i] != null) { counter++; }
		}
	
		for(int i = 0;i<deckPC.length;i++) { // 256. satır
			if(deckPC[i] != null) { // urdan sonra null olursayı ekle
				if(showTop(deckTI) == null) {
						break;
				}
				
				if(deckPC[i].charAt(1) == showTop(deckTI).charAt(1) && counter == 1) { 
					System.out.println("ı play -> " + deckPC[i]);
					deckTI[counter] = deckPC[i];
					counter++;
					deckPC[i] = null;
					System.out.println("computer has just made a pişttiii!!!");
					for(int a = 0;a<counter;a++) {
						deckPC_P[countPC_P(deckPC_P)] = deckTI[a];
						deckTI[a] = null;
					}
					pass = false;
					break;
				} else if(deckPC[i].charAt(1) == showTop(deckTI).charAt(1) || deckPC[i].charAt(1) == deneme.charAt(1)) {

					System.out.println("ı play -> " + deckPC[i]);
					deckTI[counter] = deckPC[i];
					counter++;
					deckPC[i] = null;
					System.out.println("computer won the whole cards at the board!!");
					for(int a = 0;a<counter;a++) {
						deckPC_W[countPC_W(deckPC_W)] = deckTI[a];
						deckTI[a] = null;
					}
					pass = false;
					break;
				} 
			
			} 
		}
	
		if(pass) {
			int r = ran.nextInt(4);
			while(deckPC[r] == null) {
				r = ran.nextInt(4);
			}
			System.out.println("ı play -> " + deckPC[r]); 
			deckTI[counter] = deckPC[r];
			deckPC[r] = null;
		}

	}
	
	public static void playUS(String[] deckUS, String[] deckTI, String[] deckUS_W, String[] deckUS_P) {
		int test = 0;
		String deneme = new String("AJ");	
		Scanner sc = new Scanner(System.in);
		System.out.println("which card do you want to play? ");
		String cardUS = sc.nextLine();
			
		for(int i = 0;i<deckUS.length;i++) {
			if(deckUS[i] == cardUS) {test++; }
		}	

		while(test != 1) {
			System.out.println("Why don't you USE one of your CARDS!?, Try Again ");
			System.out.println("which card do you want to play? ");
			cardUS = sc.nextLine();
		}

		
		int counter = 0;

		for(int i = 0;i<deckTI.length;i++) {
			if(deckTI[i] != null) { counter++; }
		}

		for(int i = 0;i<deckUS.length;i++) {
			if(cardUS.equals(deckUS[i])) { 
				System.out.println("ı play -> " + deckUS[i]);
				if(showTop(deckTI) == null) { // top card null ise zaten kazanma şansı olmuyor dikkat !!
					deckTI[counter] = deckUS[i];
						deckUS[i] = null;
						break;
				}

				if(cardUS.charAt(1) == showTop(deckTI).charAt(1) && counter == 1) {
					System.out.println("user has won the whole cards at the board!!");
					deckTI[counter] = deckUS[i];
					counter++;
					for(int b = 0;b<counter;b++) {
						deckUS_P[countUS_P(deckUS_P)] = deckTI[b];
						deckTI[b] = null;

					}
					deckUS[i] = null;
					
					break; // buradan deckTI' a geçmemesi lazım eger pisti saglıyorsa;
				} else if (cardUS.charAt(1) == showTop(deckTI).charAt(1) || deckUS[i].charAt(1) == deneme.charAt(1)) {
					System.out.println("user has won the whole cards at the board!!");
					deckTI[counter] = deckUS[i];
					counter++;
					deckUS[i] = null;
					for(int a = 0;a<counter;a++) {
						deckUS_W[countUS_W(deckUS_W)] = deckTI[a];
						deckTI[a] = null;
					}
					break; // buradan deckTI' a geçmemesi lazım eger pisti saglıyorsa;
	
				} 
	
				 else {
					deckTI[counter] = deckUS[i];
					deckUS[i] = null;
					break;
				}
			} 
		}
		
	}

	public static String showTop(String[] deckTI) { //  it would be -1 it is error 327.satır
		int counter = 0;
		for(int i = 0;i<deckTI.length;i++) {
			if(deckTI[i] != null) { counter++; }
		}
		if(counter == 0) { 
			return deckTI[counter];
		}
		return deckTI[counter-1];
	}
	
     
}






















