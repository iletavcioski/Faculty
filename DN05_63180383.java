import java.io.*;
import java.util.*;

public class DN05_63180383 {

	static int v1[] = new int[1000004];
	static int v2[] = new int[1000004];
	static int it=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long counter = 0;
		v1[0] = 1000000004;
		v2[0] = 0;
		for (int i = 0;i < n; i++) {
			int a = sc.nextInt();

			while (v1[it] <= a) {
				it--;
			}
			if (it == 0) {
				counter += (long)(i + 1);
			}
			else {
				counter += (long)((i + 1)-v2[it]);
			}
			it++;
			v1[it] = a;
			v2[it] = i + 1;
		}
		System.out.println(counter);
	}
}