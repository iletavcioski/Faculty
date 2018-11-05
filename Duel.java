import java.util.*;
import java.util.Random;

class Duel {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int d = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		Random generator = new Random(s);
		int counta = 0;
		int countb = 0;
		while (counta < d && countb < d) {
			int nak = generator.nextInt(100);
			if (nak < a) {
				counta++;
				System.out.print("A");
			}
			else if (nak >= a && nak < a + b) {
				countb++;
				System.out.print("B");
			}
			else
				System.out.print("-");

		}
	}
}