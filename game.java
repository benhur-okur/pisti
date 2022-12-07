import java.util.Random;
public class game {
	public static void main(String[] args) {
		Random ran = new Random(System.currentTimeMillis);

		String[] arrSpades = {"SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ", "SK"}; 
		String[] arrClubes = {"CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK"}; 
		String[] arrHearts = {"HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "DK"}; 
		String[] arrDiamonds = {"DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK"}; 

		int c1 = 0, c2 = 0, c3 = 0, c4 = 0;

		int k;

		if (c1 < 4 & c2 < 4 & c3 < 4 & c4 < 4) {
			k = ran.nextInt(4) + 1;
			switch(k) {
				case 1:
					c1++;
					break;
				case 2:
					c2++;
					break;
				case 3: 
					c3++;
					break;
				case 4: 
					c4++;
					break;			
		}


		
		for (int i = 0;arrNums.length * arrSuits.length;i++) {
		
		

	}	
	public static void shuffle()
     
}
