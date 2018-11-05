import java.util.*;

public class club {
	
	static int gcd (int a, int b) {
		if (a == 0)
				return b;
		return gcd (b % a, a);
	}
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		int counter = 1;
		for (int i = k; i <= n; i += k) {
			for (int j = k; j <= m; j += k) {
				if (gcd(i, j) == k) {
					System.out.println("["+counter+"] "+i+" + "+j);
					counter ++;
				}
			}
		}
	}
}