import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
public class game {
	public static void main(String[] args) {
		Random ran = new Random(System.currentTimeMillis());
		Scanner sc = new Scanner(System.in);

		HighScoreTable table = new HighScoreTable();

		String[][] arr = {{"SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ","SK"}, {"CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK"}, {"HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "HK"}, {"DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK"}}; // i did multidimensional array cause there are 4 units which are: clubs hearts spades, diamonds 	
	
		int k, n;

		String[] deckBC = new String[52]; // before cutted
		String[] deckAC = new String[52]; // after cutted

		String[] deckPC = new String[4]; // deck of computer
		String[] deckUS = new String[4]; // deck of user

		String[] deckTI = new String[52]; // table which provides four cards firstly;

		String[] deckUS_W = new String[52];// cards of user which he/she has won;
		String[] deckPC_W = new String[52]; // cards of computer which it has won;

		String[] deckPC_P = new String[52]; // pishti cards which Computer won
		String[] deckUS_P = new String[52]; // pishti cards which User won
 
		String playerName;
		String computerName = new String("COMPUTER");

		int score = 0;
		int A = 0;

		
		System.out.println("-----Welcome to the PISTI game, if you want to play please press 1, if you want to see high scores please press 2:");

		try {
  			A = sc.nextInt();
		} catch (InputMismatchException e) {
 			System.err.println("Entered value is not an integer");
		}

		if (A == 2) {
			
			try {
				table.printTable();
			} catch(IOException e) {
				e.printStackTrace();
			} 


			System.out.println("---- What do want to next if you want to quit please press 3, if you want to play PRESS 1 !!----");
			
			try {
				A = sc.nextInt(); //
			} catch (InputMismatchException e) {
				System.out.println("please enter valid number!, try again later!!");
				System.exit(0);

 		
			}
			
			if(A == 3) {
				System.out.println(" --- Quitting ... --- ");
				System.exit(0);
			}	
		
		}

		if(A != 1) {
			System.out.println(" --- You cannot enter that value, quitting... ---");
			System.exit(0);
		}

		String trash = sc.nextLine();

		
		
		System.out.println("Please Enter Your NAME! ");
		playerName = sc.nextLine();

		int cut;

		for (int i = 0;i < 52; i++) { // this is for randoming
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
		
		/*
	
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

		*/


		//--------------------------------

		for(int i = 0;i<deckUS.length;i++) {
			deckUS[i] = null;
			deckPC[i] = null;		
		}


	  	
		int J = deckAC.length - 1; //last value of deckAC


		System.out.println();

		//-------------------------------

		int counter2 = 0;

		for(int i = 0;i<deckTI.length;i++) { // these steps filling the table with null
			deckTI[i] = null;
		}

		for(int i = 0;i<4;i++) { // if the table null counter2 would be plus 1;
			if(deckTI[i] == null) {
				counter2++;
			}
		}

		

		if(counter2 == 4) {  // and counter has just been 4 and first four cards going to the table form deckAC which is after cut array and ı made null deckAC[] which cards went to the table
		
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

		for(int u = 0;u<24;u++) { // this loop for the main game part it loop for 24 time because there would be 6 fames which 48 / 8 = 6,   48 is length of deckAC[] after four cards and each player has an 4 caurds thus game have to loop for 24 times		

			printTop(deckTI);

			for(int i = 0;i<deckUS.length;i++) {
				if(deckUS[i] == null) {
					counter++;
				}
			}

			if(counter == 4) { // these if statement is for filling the user and computers hand if the counter 4 that means they whole hands are null (there are 4 null);
				for(int i = 0;i<deckUS.length;i++) {
					deckPC[i] = deckAC[J];
					deckAC[J] = null;
					J--;
					deckUS[i] = deckAC[J];
					deckAC[J] =null;
					J--;
				}
				showTop(deckTI); // these method is whowing the top card of table;
			counter = 0;
			} else {
				counter = 0;
			}
			
			// infoPC(deckUS, deckPC, deckTI, J); // giving info about computer's hand it would be in the comment because we don't want to it can be seen;

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

		int totalCardsUS = countUS_W(deckUS_W) + countUS_P(deckUS_P); // these two int for the calculating the totalcards for both computer and user wnad thus we can see who has more cards and give the cards which abide at the table 
		int totalCardsPC = countPC_W(deckUS_W) + countPC_P(deckUS_W);	

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
		

		point obj1 = new point(deckPC_P, deckPC_W, deckUS_P, deckUS_W); // this object for calculating the points copmuter and user's cards which they won;
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


		if(obj1.pointsPC() > obj1.pointsUS()) {
			System.out.println("-------- COMPUTER WON !! --------");
			score = obj1.pointsPC();
			table.addScore("COMPUTER", score);
			
		}
		
		if(obj1.pointsUS() > obj1.pointsPC()) {
			System.out.println("-------- YOU WON CONGRATULATİONS!! --------");
			score = obj1.pointsUS();
			table.addScore(playerName, score);

		}
		
		if(obj1.pointsPC() == obj1.pointsUS()) {
			score = obj1.pointsUS();
			System.out.println("--------- DRAW !! --------");
			table.addScore(playerName, score);
			System.out.println("DONT YOU WANNA PLAY AGAİN OR YOU JUST SCARED HUH ?!");
			
		}


		

		/*try {
			saveHighScore(highScore);
		} catch (IOException e) {
			e.printStackTrace();
		}*/



		
		
		
	}
	// -------------------- 0000000000000000

	
	
	public static void getHighScore(String highScore) throws IOException {
		File file = new File ("highScores.txt");

		if(!file.exists()) {
			file.createNewFile();
		}

		FileReader fReader = new FileReader(file);
		String line;

		BufferedReader bReader = new BufferedReader(fReader);
		
		while ((line = bReader.readLine()) != null) {
			System.out.println(line);
		}
		bReader.close();
		
	}

	/*public static void saveHighScore(String highScore)  throws IOException {
		File file = new File ("highScores.txt");

		if(!file.exists()) {
			file.createNewFile();
		}

		FileWriter fWriter = new FileWriter(file);
		BufferedWriter bWriter = new BufferedWriter(fWriter);
		if(hi) }
			bWriter.write(highScore);
			bWriter.close();
		}
		
	}*/



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
					System.out.println(" ---- Computer played -> " + deckPC[i]);
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

					System.out.println(" ---- Computer played -> " + deckPC[i]);
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
			System.out.println(" ---- Computer played -> " + deckPC[r]); 
			deckTI[counter] = deckPC[r];
			deckPC[r] = null;
		}

	}
	
	public static void playUS(String[] deckUS, String[] deckTI, String[] deckUS_W, String[] deckUS_P) {
		int test = 0;
		String[] str = new String[1]; 
		String deneme = new String("AJ");	
		Scanner sc = new Scanner(System.in);
		System.out.println("which card do you want to play? ");
		String cardUS = sc.nextLine();

		if(cardUS.equals("quit") || cardUS.equals("QUIT")) {
			System.out.println(" ----- quiting ... ----- ");
			System.exit(0);
		}
			
		for(int i = 0;i<deckUS.length;i++) {
			str[0] = cardUS;
			if (str[0].equals(deckUS[i])) {
				test++;
				break;
			}
		}

		while(test == 0 ) {
			System.out.println("you have entered invalid value PLEASE Try again!!");
			cardUS = sc.nextLine();

			if(cardUS.equals("quit") || cardUS.equals("QUIT")) {
				System.out.println(" ----- quiting ... ----- ");
				System.exit(0);
			}

			for(int i = 0;i<deckUS.length;i++) {
				str[0] = cardUS;
				if (str[0].equals(deckUS[i])) {
					test++;
					break;
				}
			}
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

	public static void printTop(String[] deckTI) {
		int c = 0;

		for(int i = 0;i<deckTI.length;i++) {
			if(deckTI[i] != null) {c++;}
		}
		if(c == 0) {
			System.out.println("The card at the top of deck -->> " + deckTI[0]);
		}
		if(c != 0) {
			System.out.println("The card at the top of deck -->> " + deckTI[c-1]);
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






















