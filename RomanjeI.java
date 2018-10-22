import java.util.Scanner;

public class RomanjeI {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n,m;
		n = sc.nextInt();
		m = sc.nextInt();

		while (n > 0) {
			System.out.println(n);
			n-=m;
		}
	}
}