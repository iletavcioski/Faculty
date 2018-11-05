import java.util.*;
import java.util.Random;

public class berac {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
		int seme = in.nextInt();
		int f = in.nextInt();
		int d = in.nextInt();
		int k = in.nextInt();
		int m = in.nextInt();
		Random generator = new Random(seme);
		int count = 0;
		System.out.println("    Darilo          Klobuk");
		while (count < m) {
			int nak = generator.nextInt(k);
			int nk = generator.nextInt(3);
			String ss = "";
			int pp = nak;
			int brr =0; 
			if (nak == 0)
				brr=1;
			while (pp>0) {
				pp/=10;
				brr++;
			}
			for (int i = 0; i<6-brr;i++)
				ss+=" ";
			if (nk == 0) {
				count += nak * 1000;
				ss += nak+" EUR";
			}
			else if (nk == 1) {
				count += nak*f;
				ss += nak+" GBP";
			}
			else {
				count += nak*d;
				ss += nak+" USD";
			}
			int br = 0;
			if (count == 0)
				br++;
			int p = count;
			while (p > 0) {
				p /= 10;
				br++;
			}
			for (int i = 0; i < 10 - (br-1);i++)
				ss+=" ";
			ss+=count+" mEUR";
			System.out.println(ss);
		}
	}
}