public class game_2 {
	public static void main(String[] args) {
		String[] cards = new String[52];
		String[] jokers = new String[4];
		String[] cardsNums = new String[52];

		createCardsUnits(cards);

		for(int i = 0;i<cards.length;i++) {
			System.out.println(cards[i]);
		}
	}
	public static void createCardsUnits(String cardsUnits[]) {
		for(int i = 0;i<52;i++) {
			if(0 <= i && i < 13) {
					cardsUnits[i] = "Spades" ;	
			}
			else if(13 <= i && i < 26) {
					cardsUnits[i] = "Clubs" 	;
			}
			else if(26 <= i && i < 39) {
					cardsUnits[i] = "Hearts" ;	
			}
			else if(39 <= i && i < 52) {
					cardsUnits[i] = "Diamonds" ;	
			}
		}
	} 

	public static void createCardsNums(String cardsNums[]) {
		for(int i = 0;i<52;i++) {
			if(0 <= i && i < 13) {
					cardsNums[i] = "( i%13 ) + 1" ;	
			}
			else if(13 <= i && i < 26) {
					cardsNums[i] = "( i%13 ) + 1";
			}
			else if(26 <= i && i < 39) {
					cardsNums[i] =  "( i%13 ) + 1" ;
			}
			else if(39 <= i && i < 52) {
					cardsNums[i] =  "( i%13 ) + 1" ;	
			}
		}
	} 
	
}