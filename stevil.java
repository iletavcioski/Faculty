import java.util.*;

public class stevil {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a = in.nextInt();
		if (n > 0) {
			int b = in.nextInt();
			if (n == 1) {
				int po = 10;
				int num = b;
				while (a > 0) {
					num += po*(a%10);
					a /= 10;
					po *= 10;
				}
				System.out.println(num);
			}
			else
			{
				int p = a;
				int co = 1;
				while (a > 0)
				{
					a /= 10;
					co*=10;
				}
				System.out.println(p + co*b);
			}
		}
		else {
			if (n == -1) 
				System.out.println(a/10);
			else {
				int po = 1;
				int num = 0;
				while (a > 10) {
					num += po*(a%10);
					a /= 10;
					po *= 10;
				}
				System.out.println(num);
			}
		}
	}
}