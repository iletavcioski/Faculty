import java.util.*;

class Main {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
		    String ss="";
		    for (int j = 0; j < n - i - 1; j++) {
		        ss += ' ';
		    }
		    for (int j = 0; j < 2 * i + 1; j++) {
		        ss += '*';
		    }
		    System.out.println(ss);
		}
	}
}