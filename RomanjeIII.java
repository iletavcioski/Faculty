import java.util.Scanner;
import java.lang.Math;

public class RomanjeIII {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n,m,z;
		n = sc.nextInt();
		m = sc.nextInt();
		z = sc.nextInt();

		int i = 1;
		while (n > 0 && m > 0) {
			System.out.println(i+". "+"dan: "+n+" -> "+Math.max((n-m), 0)+(" (prethodil ")+n-(Math.max(n-m,0))+")");
			n-=m;
			m-=z;
			i++;
		}
	}
}