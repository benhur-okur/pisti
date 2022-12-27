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

			playPC(deckPC, deckTI, deckPC_W);

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

			playUS(deckUS, deckTI, deckUS_W);
		


			
		}

		for(String l : deckPC_W) {
			System.out.println(l);
		}

		for(String l : deckUS_W) {
			System.out.println(l);
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

	public static int countUS_W (String[] deckUS_W) {
		int counter = 0;
		for(int i = 0;i<deckUS_W.length;i++) {
			if(deckUS_W[i] != null) { counter++; }	
		}
		return counter;
	}

	public static void playPC(String[] deckPC, String[] deckTI, String[] deckPC_W) {
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
				if(deckPC[i].charAt(1) == showTop(deckTI).charAt(1)) { //charAT null oluyo
					System.out.println("ı play -> " + deckPC[i]);
					for(int j = 0;j<counter;j++) {
						deckTI[j] = null;
					} // for ile butun masayı al aynısını user için de yap!!
					for(int k = 0;k<counter;k++) {
						int L = counter-1;
						deckPC_W[countPC_W(deckPC_W) + k] = deckTI[L]; // errror
						L--;
					}
					deckPC_W[countPC_W(deckPC_W) + counter ] = deckPC[i];
					deckPC[i] = null;
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
	
	public static void playUS(String[] deckUS, String[] deckTI, String[] deckUS_W) {
		Scanner sc = new Scanner(System.in);
		System.out.println("which card do you want to play? ");
		String cardUS = sc.nextLine();

		int counter = 0;

		for(int i = 0;i<deckTI.length;i++) {
			if(deckTI[i] != null) { counter++; }
		}

		for(int i = 0;i<deckUS.length;i++) {
			if(cardUS.equals(deckUS[i])) { 
				System.out.println("ı play -> " + deckUS[i]);
				if(showTop(deckTI) == null) {
					deckTI[counter] = deckUS[i];
						deckUS[i] = null;
						break;
				}
				if(cardUS.charAt(1) == showTop(deckTI).charAt(1)) {
					for(int k = 0;k<counter;k++) {
						int L = counter-1;
						deckUS_W[countUS_W(deckUS_W) + k] = deckTI[L]; // 312.satır
						L--;

					}
					deckUS_W[countUS_W(deckUS_W) + counter ] = deckUS[i];
					for(int j = 0;j<counter;j++) {
						deckTI[j] = null;
					}
					deckUS[i] = null;
					break; // buradan deckTI' a geçmemesi lazım eger pisti saglıyorsa;
				} else {
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
			System.out.println("somebody got whole cards!! ");
			return deckTI[counter];
		}
		return deckTI[counter-1];
	}
	
     
}






















