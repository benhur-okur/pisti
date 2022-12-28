public class point{
	private int point_PC = 0;
	private int point_US = 0;
	private int counterPC_P = 0; // 5
	private int counterPC_T = 0; // 1
	private int counterPC_D = 0; // 3
	private int counterPC_C = 0; // 2

	private int counterUS_P = 0; // 5
	private int counterUS_T = 0; // 1
	private int counterUS_D = 0; // 3
	private int counterUS_C = 0; // 2
	private int cPC = 0;
	private int cUS = 0;


	point(String[] deckPC_P, String[] deckPC_W, String[] deckUS_P, String[] deckUS_W) {
		for(int i = 0;i<deckPC_W.length;i++) {
			if(deckPC_W[i] != null) { cPC++; }	
		}
		for(int i = 0;i<deckPC_P.length;i++) {
			if(deckPC_P[i] != null) {counterPC_P++;	}
		}
		for(int i = 0;i<cPC;i++) {
			if(deckPC_W[i].equals("DX")) {counterPC_D++; }
			else if(deckPC_W[i].equals("C2")) {counterPC_C++; } 
			else {
				counterPC_T++;
			}
		}

		for(int i = 0;i<deckUS_W.length;i++) {
			if(deckUS_W[i] != null) { cUS++; }	
		}
		for(int i = 0;i<deckUS_P.length;i++) {
			if(deckUS_P[i] != null) {counterUS_P++;	}
		}
		for(int i = 0;i<cUS;i++) {
			if(deckUS_W[i].equals("DX")) {counterUS_D++; }
			else if(deckUS_W[i].equals("C2")) {counterUS_C++; } 
			else {
				counterUS_T++;
			}
		}

	}
	public int pointsPC() {
		for(int i = 0;i<counterPC_P;i++) {
			point_PC += 5;
		}
		for(int i = 0;i<counterPC_D;i++) {
			point_PC += 3;
		}
		for(int i = 0;i<counterPC_C;i++) {
			point_PC += 2;
		}
		for(int i = 0;i<counterPC_T;i++) {
			point_PC += 1;
		}
		return point_PC;
	}

	public int pointsUS() {
		for(int i = 0;i<counterUS_P;i++) {
			point_US += 5;
		}
		for(int i = 0;i<counterUS_D;i++) {
			point_US += 3;
		}
		for(int i = 0;i<counterUS_C;i++) {
			point_US += 2;
		}
		for(int i = 0;i<counterUS_T;i++) {
			point_US += 1;
		}
		return point_US;
	}



}