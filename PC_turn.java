import java.util.Random;
import java.util.Scanner;
public class PC_turn {
	String[] deckPC = new String[4];
	String[] deckTI = new String[52];
	String[] deckUS = new String[]
	Scanner sc = new Scanner(System.in);
	Random ran = new Random(System.currentTimeMillis());
	
	public PC_turn (String[] deckPC, String[] deckTI) {
		for(int i = 0;i<this.deckPC.length;i++) { // copying
			this.deckPC[i] = deckPC[i]; 
		}
		for(int i = 0;i<this.deckTI.length;i++) {
			this.deckTI[i] = deckTI[i];
		}	
	} 

	public void showPC() {
		System.out.println("computer's deck: ");
		for(String i : this.deckPC) {
			System.out.println(i);
		} 
	}

	public void play() {
		topCard obj1 = new topCard(deckTI, deckPC, deckUS);
		obj1.showTop();
		for(int i = 0;i<this.deckPC.length;i++) {
			if(deckPC[i].charAt(1) == obj1.showTop().charAt(1)) {
				System.out.println("ı play -> " + deckPC[i]);
				deckTI[obj1.getCounter()] = deckPC[i];
				break;
			}
			else {
				int r = ran.nextInt(4);
				System.out.println("ı play -> " + deckPC[r]); 
				deckTI[obj1.getCounter()] = deckPC[r];
				break;
			}
			
		}
		
	}
}