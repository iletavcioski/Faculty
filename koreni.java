import java.util.*;

public class koreni {
	public static double koren (double x, double epsilon) {
		int fakt = 1;
		int stiri = 1;
		int minus = 1;
		int fakt2 = 2;
		int n = 0;
		int a = 1, b = 2;
		double xx = 1;
		double korene=0;
		double suma = minus*fakt2/(1-2*n)/fakt/fakt/stiri;
		if (suma > epsilon)
			korene += suma;
		else
			return 0;
		while (1==1) {
			n++;
			minus*=-1;
			stiri*=4;
			fakt2*=(a*b);
			a+=2;
			b+=2;
			fakt*=n;
			xx*=(x-1);
			suma = minus*fakt2/(1-2*n)/fakt/fakt/stiri;
			if (suma>epsilon) {
				korene+=suma;
			}
			else
			{
				break;
			}
			
		}
		return korene;
	}
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		double n = in.nextDouble();
		double a = in.nextDouble();
		double kor = koren(n, a);
		System.out.println(kor);
	}
}