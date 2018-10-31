import java.util.*;


class Main {
	public static void main (String[] args)  {
	    Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		
		for (int i = 1; i <= 9 ; i += 2) {
		    for (int j = a + 1; j <= 9; j++) {
		        for (int k = 0; k <= 9; k += b) {
		            System.out.println(i + "-" + j + "-" + k);
		        }
		    }
		}
	}
}