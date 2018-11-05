import java.util.*;

class spruce {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int n = 1; n <= t; n++) {
			for (int i = 0; i < n; i++) {
				String ss="";
				for (int j = 0; j < t - i - 1; j++) {
					ss += ' ';
				}
				for (int j = 0; j < 2 * i + 1; j++) {
					ss += '*';
				}
				System.out.println(ss);
			}
		}
	}
}