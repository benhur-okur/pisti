public class topCard {
	private String[] deckTI = new String[52];
	private String[] deckPC = new String[52];
	private String[] deckUS = new String[52];

	

	public topCard(String[] deckTI, String[] dekcPC, String[] deckUS) {
		for(int i = 0;i<52;i++) { // copying
			this.deckTI[i] = deckTI[i]; 
		}
		for(int i = 0;i<52;i++) { // copying
			this.deckPC[i] = deckPC[i]; 
		}for(int i = 0;i<52;i++) { // copying
			this.deckUS[i] = deckUS[i]; 
		}
	}				

	public String showTop () { // there will be error if counter would be 0 **
		int counter = 0;
		for(int i = 0;i<this.deckTI.length;i++) {
			if(!deckTI[i].equals("-")) {
				counter++;
			}
		}
		return this.deckTI[counter-1]; 
	}

	public int getCounter() {
		PC_turn obj1 = new PC_turn(deckPC, deckTI);
		obj1.play();
		int counter = 0;
		for(int i = 0;i<this.deckTI.length;i++) {
			if(!deckTI[i].equals("-")) {
				counter++;
			}
		}
		return counter;	
	}
}