public class US_turn {
	private String[] deckUS = new String[4];
	
	public US_turn (String[] deckUS) {
		for(int i = 0;i<this.deckUS.length;i++) {
			this.deckUS[i] = deckUS[i];
		}
	}

	public void showUS () {
		for(String i : this.deckUS) {
			System.out.println(i);
		}
	}

}
